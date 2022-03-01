package toy.toyprj.domain.serial;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Serial {

    @NotEmpty
    private String name;//소켓이름
}
