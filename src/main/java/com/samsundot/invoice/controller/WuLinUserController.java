package com.samsundot.invoice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.samsundot.invoice.service.IWuLinUserService;

@RestController
public class WuLinUserController {
	
    @Autowired  
    private IWuLinUserService wuLinUserService;  
  
    @PostMapping("/import")  
    public boolean addWuLinUser(@RequestParam("file") MultipartFile file) throws IOException {  
        String fileName = file.getOriginalFilename();  
        return wuLinUserService.Import(fileName, file);  
    } 

}
