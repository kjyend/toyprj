package toy.toyprj.domain.serial;


import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;



@Slf4j

public class SerialRead implements Runnable {

    private final InputStream in;

    public SerialRead(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[1024];
        int len = -1;
        String s="";
        try {
            while ((len = this.in.read(buffer)) >-1 ) {
                s += new String(buffer, 0, len);

                if (s.length()>=18) {
                    if(s.charAt(0)!='*' || s.length()>=25){//문자열자르기 생각
                        s="";
                    }
                    log.info("1234=4321");
                    try {
                        log.info("1234=1234");
                        s="";
                    } catch (Exception e) {}
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}