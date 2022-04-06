package info.fingo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class Wyklad {

	public static void main(String[] args) {
		SpringApplication.run(Wyklad.class, args);
	}

}
