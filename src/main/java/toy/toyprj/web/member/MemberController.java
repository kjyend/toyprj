package toy.toyprj.web.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import toy.toyprj.domain.member.Member;
import toy.toyprj.domain.member.MemberRepository;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping
    public String signupForm(@ModelAttribute("member") Member member){
        return "member/signup";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute Member member, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
        return "member/signup";
        }
        memberRepository.save(member);
        return "redirect:/";
    }
}
