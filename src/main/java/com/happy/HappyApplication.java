package com.happy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class HappyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyApplication.class, args);
	}

@RequestMapping("/")
	public String landingPage(){
		return "landingPage";
}

}
