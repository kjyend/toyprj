package toy.toyprj.domain.serial;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SerialRepository {

    public static String s="";

    public String save(String temp){ //아두이누 온도 측정 정보 저장
        s= String.valueOf(new Serial(temp));
        return temp;
    }

    public String receive(){ //아두이노 온도 측정 정보 받기
        return s;
    }
}
