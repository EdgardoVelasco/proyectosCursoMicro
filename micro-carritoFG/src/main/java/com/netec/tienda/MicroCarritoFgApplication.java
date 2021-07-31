package com.netec.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
/*
 * @EnableFeignClients: Le indicamos a Spring 
 * que usaremos Feign en nuestro proyecto
*/

/*@RibbonClient: Nos permite configurar
 * el balanceo de cargas de nuestros microservicios
 * */

//@RibbonClient(name="micro-articulo")
@EnableFeignClients
@SpringBootApplication
public class MicroCarritoFgApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroCarritoFgApplication.class, args);
	}

}
