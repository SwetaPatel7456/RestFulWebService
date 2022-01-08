package com.RestWeb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeflloWorldController {
    @Autowired
	private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
	public String getWorld(
			//@RequestHeader(name ="Accept-Language" ,required = false) Locale locale
			) {
		//return messageSource.getMessage("good.morning.message", null,"DefaultMessage",locale);
		return "AA";
		
//
	}/*to accept data in xml format at client side we need to add this dependency
	<dependency>
	<groupId>com.fasterxml.jackson.dataformat</groupId>
	<artifactId>jackson-dataformat-xml</artifactId>
    </dependency>*/
}
