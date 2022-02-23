package toy.toyprj.web.login;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Data;


@Data
public class LoginForm {

    @NotNull
    private String loginId;

    @NotNull
    private String password;

}
