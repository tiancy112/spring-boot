package com.samsundot.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samsundot.invoice.bean.ExcelUpload;

public interface ExceluploadRepository extends JpaRepository<ExcelUpload, Integer>{

}
