package com.netec.tienda;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*Esta clase nos ayudara a utilizar RestTemplete en cualquier
 * parte de mi código*/



@Configuration
public class AppConfig {
	
	@Bean
	public RestTemplate createRestTemplete() {
		return new RestTemplate();
	}

}
