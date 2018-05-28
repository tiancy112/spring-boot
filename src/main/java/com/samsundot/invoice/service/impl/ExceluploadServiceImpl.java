package com.samsundot.invoice.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.samsundot.invoice.bean.ExcelUpload;
import com.samsundot.invoice.exception.MyException;
import com.samsundot.invoice.repository.ExceluploadRepository;
import com.samsundot.invoice.service.ExceluploadService;
@Service
public class ExceluploadServiceImpl implements ExceluploadService{
	

	
	@Autowired
	private ExceluploadRepository exceluploadRepository;

	@Transactional(readOnly = false)
	@Override
	public boolean Import(String fileName, MultipartFile file) throws IOException {
		exceluploadRepository.deleteAll();

		boolean notNull = false;

		List<ExcelUpload> list = new ArrayList<ExcelUpload>();
		if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
			throw new MyException("上传文件格式不正确");
		}
		boolean isExcel2003 = true;
		if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
			isExcel2003 = false;
		}
		InputStream is = file.getInputStream();
		Workbook wb = null;
		if (isExcel2003) {
			wb = new HSSFWorkbook(is);
		} else {
			wb = new XSSFWorkbook(is);
		}
		Sheet sheet = wb.getSheetAt(0);
		if (sheet != null) {
			notNull = true;
		}

		// 第一行为标题，从第二行开始录入
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			// 标题行，用来对比方便得到数据
			Row titleRow = sheet.getRow(0);
			// 数据行
			Row row = sheet.getRow(i);
			// 获得值
			String name = this.getCellFormatValue((Cell) row.getCell(0));
			String valueValue = this.getCellFormatValue((Cell) row.getCell(1));
			String desc = this.getCellFormatValue((Cell) row.getCell(2));
			String status = this.getCellFormatValue((Cell) row.getCell(3));
		
			ExcelUpload excel = new ExcelUpload();
			excel.setName(name);
			excel.setValueValue(new BigDecimal(valueValue));
			excel.setDescription(desc);
			excel.setStatus(Integer.parseInt(status));
			excel.setCreateTime(new Date());
			excel.setCreateBy("admin");// TODO 当前登录人
			excel.setUpdateBy("admin");
			excel.setUpdateTime(new Date());
			list.add(excel);
		}
		exceluploadRepository.save(list);
		
		return notNull;
	}

	// 获取单元格各类型值，返回字符串类型
	/**
	 * 根据Cell类型设置数据
	 * 
	 * @param cell
	 * @return Object
	 */
	private String getCellFormatValue(Cell cell) {
		String cellvalue = "";
		if (cell != null) {

			// 判断当前Cell的Type
			switch (cell.getCellType()) {
			// case Cell.CELL_TYPE_NUMERIC:// 如果当前Cell的Type为NUMERIC
			case Cell.CELL_TYPE_NUMERIC: {
				// 判断当前的cell是否为Date
				if (DateUtil.isCellDateFormatted(cell)) {
					Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					cellvalue = format.format(date);
				} else {
					// 如果是纯数字
					BigDecimal big = new BigDecimal(cell.getNumericCellValue());
					cellvalue = big.toString();
					// 解决1234.0 去掉后面的.0
					if (null != cellvalue && !"".equals(cellvalue.trim())) {
						String[] item = cellvalue.split("[.]");
						if (1 < item.length && "0".equals(item[1])) {
							cellvalue = item[0];
						}
					}
				}
				break;
			}
			case Cell.CELL_TYPE_STRING:// 如果当前Cell的Type为STRING
				// 取得当前的Cell字符串
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			// 公式类型
			case Cell.CELL_TYPE_FORMULA:
				// 读公式计算值
				cellvalue = String.valueOf(cell.getNumericCellValue());
				if (cellvalue.equals("NaN")) {// 如果获取的数据值为非法值,则转换为获取字符串
					cellvalue = cell.getStringCellValue().toString();
				}
				break;
			// 布尔类型
			case Cell.CELL_TYPE_BOOLEAN:
				cellvalue = " " + cell.getBooleanCellValue();
				break;
			// 空值
			case Cell.CELL_TYPE_BLANK:
				cellvalue = "";
				// LogUtil.getLogger().error("excel出现空值");
				break;
			default:// 默认的Cell值
				cellvalue = cell.getStringCellValue().toString();
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;
	}

}
