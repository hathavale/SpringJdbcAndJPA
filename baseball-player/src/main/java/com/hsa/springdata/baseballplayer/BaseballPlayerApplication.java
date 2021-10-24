package com.hsa.springdata.baseballplayer;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class BaseballPlayerApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	
	@Autowired
	PlayerDao dao;

	public static void main(String[] args) {
		SpringApplication.run(BaseballPlayerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	   logger.info("Inserting Player 4: {}", dao.insertPlayer(new Player( 4, "Thiem", "Austria", new Date(System.currentTimeMillis()), 17 )));
		
		logger.info("All Players Data: {}", dao.getAllPlayers());
		logger.info("Player with Id 3: {}", dao.getPlayerById(3));
		
	}

}
