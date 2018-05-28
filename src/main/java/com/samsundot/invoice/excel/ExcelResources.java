package com.samsundot.invoice.excel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**   
* 
* @ClassName: ExcelResources.java
* @Description: 表头信息的Annotation
* @author: tiancy
* @date: 2018年4月18日 下午3:40:31 
*
*/
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelResources {
    /**
     * 属性的标题名称
     * @return
     */
    String title();
    /**
     * 在excel的顺序
     * @return
     */
    int order() default 9999;
}
