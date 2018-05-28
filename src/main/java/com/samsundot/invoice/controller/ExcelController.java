//
//package com.samsundot.invoice.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFCellStyle;
//import org.apache.poi.hssf.usermodel.HSSFFont;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.samsundot.invoice.bean.Answer;
//import com.samsundot.invoice.bean.Newanswer;
//import com.samsundot.invoice.repository.AnswerRepository;
//import com.samsundot.invoice.repository.NewAnswerRepository;
//import com.samsundot.invoice.repository.UserRepository;
//import com.samsundot.invoice.utils.ResultMsg;
//import com.samsundot.invoice.utils.StorageConfig;
//
//import sun.misc.BASE64Decoder;
//
//@RestController
//public class ExcelController {
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	   @Autowired  
//	    private StorageConfig storageConfig; 
//	   @Autowired
//	   private AnswerRepository answerRepository;
//	   @Autowired
//	   private NewAnswerRepository newAnswerRepository;
//	
//	 /*** 
//     * 创建表头 
//     * @param workbook 
//     * @param sheet 
//     */  
//    private void createTitle(HSSFWorkbook workbook, HSSFSheet sheet)  
//    {  
//        HSSFRow row = sheet.createRow(0);  
//        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度  
//        sheet.setColumnWidth(2, 12*256);  
//        sheet.setColumnWidth(3, 17*256);  
//          
//        //设置为居中加粗  
//        HSSFCellStyle style = workbook.createCellStyle();  
//        HSSFFont font = workbook.createFont();  
//        font.setBold(true);  
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
//        style.setFont(font);  
//          
//        HSSFCell cell;  
//        cell = row.createCell(0);  
//        cell.setCellValue("序号");  
//        cell.setCellStyle(style);  
//          
//        cell = row.createCell(1);  
//        cell.setCellValue("内容");  
//        cell.setCellStyle(style);  
//          
//        cell = row.createCell(2);  
//        cell.setCellValue("描述");  
//        cell.setCellStyle(style);  
//          
//        cell = row.createCell(3);  
//        cell.setCellValue("日期");  
//        cell.setCellStyle(style);  
//    }  
//    
//    
//    /*** 
//     * 获取excel数据 
//     * @return 返回文件名称及excel文件的URL 
//     * @throws IOException 
//     */  
//    @SuppressWarnings({ "unchecked", "rawtypes" })  
//    @RequestMapping("getExcel")  
//    public Object getExcel() throws IOException 
//    {  
////        HSSFWorkbook workbook = new HSSFWorkbook();  
////        HSSFSheet sheet = workbook.createSheet("回答表");  
////        createTitle(workbook, sheet);  
//        List<Answer> entities = (List<Answer>) answerRepository.findAll();  
//          
//        //设置日期格式  
////        HSSFCellStyle style=workbook.createCellStyle();  
////        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));  
//          
//        //新增数据行，并且设置单元格数据
//        
//        
//        
////        int rowNum = 1;  
//        for (Answer answer:entities) {  
//        	Newanswer newanswer=new Newanswer();
////        	newanswer.setDbid(answer.getDbid());
////        	newanswer.setAgreeNum(answer.getAgreeNum());
//        	BeanUtils.copyProperties(answer, newanswer);
//        	newanswer.setContent(decodeBase64(answer.getContent().toString()));
//        	
//        	newAnswerRepository.save(newanswer);
////            HSSFRow row = sheet.createRow(rowNum);  
////            row.createCell(0).setCellValue(answer.getDbid());  
////            row.createCell(1).setCellValue(decodeBase64(answer.getContent().toString())); 
////            rowNum++;  
//        }  
//          
////        //拼装blobName  
////        String fileName = "回答表.xlsx";  
////        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");  
////        String dateTime = dateFormat.format(new Date());  
////        String blobName =  dateTime + "/" + UUID.randomUUID().toString().replaceAll("-", "") + "/" + fileName;  
////          
////        //获取或创建container  
////        CloudBlobContainer blobContainer = BlobHelper.getBlobContainer("temp", storageConfig);  
////        //设置文件类型，并且上传到azure blob  
////        try {  
////            CloudBlockBlob blob = blobContainer.getBlockBlobReference(blobName);  
////            ByteArrayOutputStream out = new ByteArrayOutputStream();  
////            workbook.write(out);  
////            ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());  
////              
////            blob.upload(in, out.toByteArray().length);  
////            Map map = new HashMap();  
////            map.put("fileName", fileName);  
////            map.put("excelUrl", blob.getUri().toString());  
////              
////            ResultMsg resultMsg = new ResultMsg(ResultStatusCode.OK.getErrcode(),  
////                    ResultStatusCode.OK.getErrmsg(), map);  
////            return resultMsg;  
////              
////        } catch (Exception e)  
////        {  
////            ResultMsg resultMsg = new ResultMsg(ResultStatusCode.SYSTEM_ERR.getErrcode(),  
////                    ResultStatusCode.SYSTEM_ERR.getErrmsg(), null);  
////            return resultMsg;  
////        }
//        return null;
//    } 
//    
//    public static String decodeBase64(String str) throws IOException {
//        BASE64Decoder encoder = new BASE64Decoder();
//        return new String(encoder.decodeBuffer(str));
//    }
//
//}
