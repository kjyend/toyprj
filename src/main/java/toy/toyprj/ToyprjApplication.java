package toy.toyprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import toy.toyprj.domain.serial.SerialRepository;

@SpringBootApplication
public class ToyprjApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToyprjApplication.class, args);
	}

}
