package toy.toyprj.web.serial;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import toy.toyprj.domain.serial.Serial;
import toy.toyprj.domain.serial.SerialService;
import toy.toyprj.domain.serial.SerialRepository;


@Controller
@RequiredArgsConstructor
public class SerialController{

    private final SerialService serialRepository;
    private final SerialRepository serialService;


    @PostMapping("/checkTemp")
    public String process(@ModelAttribute("Serial") Serial serial) {
        return serialRepository.serialReceive(serial);
    }

/*

    public String processData(Map<String, String> paramMap) {
        return serialRepository.serialPass("/checkTemp");
    }
*/

}