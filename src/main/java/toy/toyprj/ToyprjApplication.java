package toy.toyprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import toy.toyprj.domain.serial.Serial;

@SpringBootApplication
public class ToyprjApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToyprjApplication.class, args);

		try {

			(new Serial()).connect("COM6");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
