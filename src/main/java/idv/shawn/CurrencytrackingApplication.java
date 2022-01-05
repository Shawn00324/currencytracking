package idv.shawn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = { "idv.shawn.controller, idv.shawn.aop, idv.shawn.configuration, idv.shawn.service" })
@MapperScan(basePackages = "idv.shawn.dao")
public class CurrencytrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencytrackingApplication.class, args);
	}

}
