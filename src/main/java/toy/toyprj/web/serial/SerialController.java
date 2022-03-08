package toy.toyprj.web.serial;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import toy.toyprj.domain.serial.Serial;
import toy.toyprj.domain.serial.SerialRead;
import toy.toyprj.domain.serial.SerialService;

@Slf4j
@Controller
public class SerialController{


    @PostMapping("/result")
    public String result(@ModelAttribute("serial") Serial serial) throws Exception{
        return "result";
    }
    @GetMapping("/result")
    public String result1(@ModelAttribute("serial") Serial serial) throws Exception{
        return "result";
    }

}