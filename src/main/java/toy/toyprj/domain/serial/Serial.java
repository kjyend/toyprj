package toy.toyprj.domain.serial;

import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class Serial {

    private String tempCheck;

    public Serial() {
    }

    public Serial(String tempCheck) { //온도 값을 저장한다.
        this.tempCheck = tempCheck;
    }
}
