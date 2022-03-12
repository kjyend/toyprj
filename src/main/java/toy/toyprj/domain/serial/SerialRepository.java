package toy.toyprj.domain.serial;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;



@Repository
@RequiredArgsConstructor
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
