package toy.toyprj.web.serial;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import toy.toyprj.domain.serial.SerialRepository;


import java.util.Map;


@Controller
@RequiredArgsConstructor
public class SerialController{
    private static final long serialVersionUID = 1L;


    public String process(Map<String, String> paramMap) {
//        new SerialRepository.("checkTemp");
        return "checkTemp";
    }


    public String processData(Map<String, String> paramMap) {
        return "checkTemp";
    }

}