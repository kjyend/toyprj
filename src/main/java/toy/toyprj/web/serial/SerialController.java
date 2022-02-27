package toy.toyprj.web.serial;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import toy.toyprj.domain.serial.Serial;
import toy.toyprj.domain.serial.SerialRepository;
import toy.toyprj.domain.serial.SerialService;


import java.util.Map;


@Controller
@RequiredArgsConstructor
public class SerialController{

    private final SerialRepository serialRepository;
    private final SerialService serialService;
    
    public String process(@ModelAttribute("Serial") Serial serial) {
        return serialRepository.serialReceive("일단 값이 필요");
    }

/*

    public String processData(Map<String, String> paramMap) {
        return serialRepository.serialPass("/checkTemp");
    }
*/

}