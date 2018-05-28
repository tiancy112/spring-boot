package com.samsundot.invoice.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.samsundot.invoice.bean.SysConfig;

public interface SysConfigService {
	 boolean Import(String fileName, MultipartFile file) throws IOException; 
	 
	 List<SysConfig> list();
}
