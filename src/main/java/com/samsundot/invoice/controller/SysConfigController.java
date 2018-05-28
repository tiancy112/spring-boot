package com.samsundot.invoice.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.samsundot.invoice.bean.SysConfig;
import com.samsundot.invoice.service.SysConfigService;

@RestController
public class SysConfigController {

	@Autowired
	private SysConfigService sysConfigService;

	@PostMapping("/importconfig")
	public boolean addsysconfig(@RequestParam("file") MultipartFile file) throws IOException {
		String fileName = file.getOriginalFilename();
		return sysConfigService.Import(fileName, file);
	}

	@GetMapping("/list")
	public List<SysConfig> addsysconfig() {
		return sysConfigService.list();
	}
}
