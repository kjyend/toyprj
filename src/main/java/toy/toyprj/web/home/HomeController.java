package toy.toyprj.web.home;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import toy.toyprj.domain.member.Member;
import toy.toyprj.domain.serial.Serial;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String home(@SessionAttribute(name="loginMember",required = false) Member loginMember, Model model) {
        if(loginMember==null){
            return "home";
        }
        model.addAttribute("member",loginMember);
        return "checkTemp";
    }
}
