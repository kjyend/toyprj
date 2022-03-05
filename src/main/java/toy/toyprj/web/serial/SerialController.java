package toy.toyprj.web.serial;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import toy.toyprj.domain.serial.SerialService;


@Controller
@RequiredArgsConstructor
public class SerialController{

/*    private final SerialService serialService; //사용*/

    @PostMapping("/result")
    public String result(@ModelAttribute("model") Model model) throws Exception{
        return "result";
    }
    @GetMapping("/result")
    public String result1(@ModelAttribute("model") Model model) throws Exception{
        return "result";
    }

}