package toy.toyprj.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class Member {

    private Long id;


    @NotEmpty
    private String loginId;//아이디
    @NotEmpty
    private String name;//이름
    @NotEmpty
    private String password;

}
