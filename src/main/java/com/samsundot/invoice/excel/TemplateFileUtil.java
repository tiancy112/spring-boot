package com.samsundot.invoice.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.util.ResourceUtils;

/**   
* 
* @ClassName: TemplateFileUtil.java
* @Description: 获取模板文件的工具类
* @author: tiancy
* @date: 2018年4月18日 下午3:40:13 
*
*/
public class TemplateFileUtil {

	public static FileInputStream getTemplates(String tempName) throws FileNotFoundException {
        return new FileInputStream(ResourceUtils.getFile("classpath:excel-templates/"+tempName));
    }
}
