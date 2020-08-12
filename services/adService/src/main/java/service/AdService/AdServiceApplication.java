package service.AdService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AdServiceApplication {

	@RequestMapping("/health")
	public String home() {
		return "Hello from ad service!";
	}

	public static void main(String[] args) {
		SpringApplication.run(AdServiceApplication.class, args);
	}

}
