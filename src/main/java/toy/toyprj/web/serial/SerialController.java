package toy.toyprj.web.serial;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import toy.toyprj.domain.serial.Serial;
import toy.toyprj.domain.serial.SerialRepository;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SerialController{

    private final SerialRepository serialRepository;

    @PostMapping("/result")
    public String result(@ModelAttribute("serial") Serial serial) throws Exception{
        serial.setTempCheck(serialRepository.receive());
        return "result";
    }
    @GetMapping("/result")
    public String result1(@ModelAttribute("serial") Serial serial) throws Exception,IllegalStateException{
        serial.setTempCheck(serialRepository.receive());
        return "result";
    }

}