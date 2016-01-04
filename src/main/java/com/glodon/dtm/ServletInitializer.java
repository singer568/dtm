/**
 * Copyright By Grandsoft Company Limited.  
 * 2015年12月30日 上午10:23:03
 */
package com.glodon.dtm;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}
