package com.samsundot.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samsundot.invoice.bean.WebDto;

public interface WebdtoRepository extends JpaRepository<WebDto, String>{

}
