package com.samsundot.invoice.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.ServerEndpoint;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.microsoft.azure.storage.DoesServiceRequest;
import com.samsundot.invoice.bean.PaiMing;
import com.samsundot.invoice.bean.WuGong;
import com.samsundot.invoice.bean.WuLinUser;
import com.samsundot.invoice.exception.MyException;
import com.samsundot.invoice.mapper.PaiMingMapper;
import com.samsundot.invoice.mapper.WuGongMapper;
import com.samsundot.invoice.mapper.WuLinUserMapper;
import com.samsundot.invoice.service.IWuLinUserService;
@Service
public class WuLinUserService implements IWuLinUserService{
	@Autowired  
    private WuLinUserMapper wuLinUserMapper;  
  
    @Autowired  
    private WuGongMapper wuGongMapper;  
  
    @Autowired  
    private PaiMingMapper paiMingMapper;  
  
    @Transactional(readOnly = false)  
    @Override  
    public boolean Import(String fileName, MultipartFile file) throws IOException {  
    // 字典表信息，已经封装在两个map中  
    Map<String, Integer> wuGongMap = findWuGong();  
    Map<String, Integer> paiMingMap = findPaiMing();  
    boolean notNull = false;  
    List<WuLinUser> userList = new ArrayList<WuLinUser>();  
    if(!fileName.matches("^.+\\.(?i)(xls)$")&&!fileName.matches("^.+\\.(?i)(xlsx)$"))  
    {  
        throw new MyException("上传文件格式不正确");  
    }  
    boolean isExcel2003 = true;if(fileName.matches("^.+\\.(?i)(xlsx)$"))  
    {  
        isExcel2003 = false;  
    }  
    InputStream is = file.getInputStream();  
    Workbook wb = null;if(isExcel2003)  
    {  
        wb = new HSSFWorkbook(is);  
    }else  
    {  
        wb = new XSSFWorkbook(is);  
    }  
    Sheet sheet = wb.getSheetAt(0);if(sheet!=null)  
    {  
        notNull = true;  
    }  
    WuLinUser wuLinUser;
    for(int r = 1;r<=sheet.getLastRowNum();r++)  
    {  
        Row row = sheet.getRow(r);  
        if (row == null)  
            continue;  
        wuLinUser = new WuLinUser();  
//  Integer id=(int) row.getCell(0).getNumericCellValue();
        String name = row.getCell(1).getStringCellValue();  
        String wuGong = row.getCell(2).getStringCellValue();  
        String paiMing = row.getCell(3).getStringCellValue();  
        Date birthDate = row.getCell(4).getDateCellValue();  
        wuLinUser.setId(r);
        wuLinUser.setName(name);  
        wuLinUser.setWugongId(wuGongMap.get(wuGong));  
        wuLinUser.setPaimingId(paiMingMap.get(paiMing));  
        wuLinUser.setBirthDate(birthDate);  
        userList.add(wuLinUser);  
    }  
  
    for(WuLinUser wuLinUser1:userList)  
    {  
        Integer id = wuLinUser1.getId();  
        WuLinUser user1 = wuLinUserMapper.findOne(id);  
        if (user1 == null) { 
        	
            wuLinUserMapper.save(wuLinUser1);  
        } else {  
            wuLinUserMapper.save(wuLinUser1);  
        }  
    }return notNull;  
}  
  
        public Map<String, Integer> findWuGong() {  
    //从数据库中查找字典表全部内容，查找字典表的业务逻辑代码在最后  
    List<WuGong> wuGongList = wuGongMapper.findAll();  
    Map<String, Integer> wuGongMap = new HashMap<String, Integer>();  
    for (WuGong a: wuGongList) {  
        wuGongMap.put(a.getWugong(), a.getId());  
    }  
    return wuGongMap;  
}  
  
    public Map<String, Integer> findPaiMing() {  
        // 从数据库中查找字典表全部内容，查找字典表的业务代码在最后  
        List<PaiMing> paiMingList = paiMingMapper.findAll();  
        Map<String, Integer> paiMingMap = new HashMap<String, Integer>();  
        for (PaiMing a : paiMingList) {  
            paiMingMap.put(a.getPaiming(), a.getId());  
        }  
        return paiMingMap;  
    } 
}
