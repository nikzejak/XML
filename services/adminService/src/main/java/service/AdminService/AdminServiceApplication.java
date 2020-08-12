package service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.AdminService.model.GetCarBrandRequest;
import service.AdminService.model.GetCarBrandResponse;
import service.AdminService.model.GetMessageRequest;
import service.AdminService.model.GetMessageResponse;

@SpringBootApplication
@RestController
public class AdminServiceApplication {

	@RequestMapping("/health")
	public String home() {
		return "Hello from admin service!";
	}

	@Autowired
	private SoapClient client;

	@PostMapping("/getMessageStatus")
	public GetMessageResponse invokeSoapClientToGetMessageStatus(@RequestBody GetMessageRequest request) {
		return client.getMessageStatus(request);
	}

	@PostMapping("/getCarBrandStatus")
	public GetCarBrandResponse invokeSoapClientToGetMessageStatus(@RequestBody GetCarBrandRequest request) {
		return client.getCarBrandStatus(request);
	}

	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);
	}

}
