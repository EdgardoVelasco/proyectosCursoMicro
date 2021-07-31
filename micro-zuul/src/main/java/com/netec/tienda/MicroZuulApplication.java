package com.netec.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
/*@EnableZuulProxy: activamos el API gateway en nuestro
 * microservicio*/

/*@EnableEurekaClient: Le indicamos a Spring que zuul
 * trabajara en conjunto con eureka
 * */

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class MicroZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroZuulApplication.class, args);
	}

}
