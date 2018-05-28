package com.samsundot.invoice.utils;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//import io.lenovo.localsales.shipto.repository.lmsshipto.LMSshiptoRepository;
//@Component
public class MysqlConnectTask {
//	@Autowired
//	private LMSshiptoRepository LMSshiptoRepository;
	private final static Logger logger = LoggerFactory.getLogger(MysqlConnectTask.class);
	@Scheduled(cron = "0 0 * * * ?")
	public boolean task(){
		 UUID uuid = UUID.randomUUID();
		logger.info("连接数据库定时任务开始");
//		LMSshiptoRepository.findOne(uuid.toString());
		logger.info("连接数据库定时任务结束");
		return true;
	}

}
