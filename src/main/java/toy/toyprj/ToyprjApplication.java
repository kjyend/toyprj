package toy.toyprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import toy.toyprj.domain.serial.SerialRepository;

@SpringBootApplication
public class ToyprjApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToyprjApplication.class, args);
		//아두이노 연동
		try {
			(new SerialRepository()).connect("COM6");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
