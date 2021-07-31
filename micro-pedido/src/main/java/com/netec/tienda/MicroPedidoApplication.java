package com.netec.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name="micro-cliente")
@EnableFeignClients
@SpringBootApplication
public class MicroPedidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroPedidoApplication.class, args);
	}

}
