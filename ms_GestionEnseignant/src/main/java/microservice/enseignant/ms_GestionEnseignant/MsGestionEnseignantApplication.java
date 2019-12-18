package microservice.enseignant.ms_GestionEnseignant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"microservice.enseignant"})
public class MsGestionEnseignantApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGestionEnseignantApplication.class, args);
	}

}
