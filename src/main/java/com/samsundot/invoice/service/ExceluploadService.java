package com.samsundot.invoice.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ExceluploadService {
	public boolean Import(String fileName, MultipartFile file) throws IOException;

}
