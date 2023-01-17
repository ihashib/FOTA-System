package com.fota.fotaserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FotaServerApplication {
	private static Logger LOG = LoggerFactory.getLogger(FotaServerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(FotaServerApplication.class, args);
	}

}
