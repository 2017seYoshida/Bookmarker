package jp.co.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import enums.LogEnum;
import lombok.extern.slf4j.Slf4j;
import util.Util;

@Slf4j
@SpringBootApplication
public class BookmarkerApplication {

	public static void main(String[] args) {
		log.info(Util.getMethodName() + LogEnum.START.getLogValue());
		SpringApplication.run(BookmarkerApplication.class, args);
		log.info(Util.getMethodName() + LogEnum.END.getLogValue());
	}
}
