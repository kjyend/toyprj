package toy.toyprj.domain.serial;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;



@Repository
@RequiredArgsConstructor
@Slf4j
public class SerialRepository {

    public static String s="";

    public String save(String temp){
        s= String.valueOf(new Serial(temp));
        return temp;
    }

    public String receive(){
        return s;
    }
}
