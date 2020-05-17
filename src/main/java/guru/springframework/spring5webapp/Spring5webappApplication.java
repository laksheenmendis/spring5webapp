package guru.springframework.spring5webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring5webappApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5webappApplication.class, args);

		// Below code segment could be used to change the starting port from 8080 to another custom port
		// otherwise, set the server.port=9090 in application.properties
		/*SpringApplication application = new SpringApplication(Spring5webappApplication.class);
		application.setDefaultProperties(Collections.singletonMap("server.port", "9090"));
		application.run(args);*/
	}
}
