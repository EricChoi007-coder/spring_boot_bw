package net.demoproject.venetian;

import net.demoproject.venetian.aop.AnnotationAppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoProjectApplication {

	public static void main(String[] args) {


		SpringApplication.run(DemoProjectApplication.class, args);
		//Active AOP Function
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationAppConfig.class);
	}

}
