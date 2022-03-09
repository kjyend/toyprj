package toy.toyprj.domain.serial;


import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Slf4j
public class SerialRead implements Runnable {

    private final InputStream in;
    public Boolean dataReceive=false;
    public Boolean DataReceiveComplete=false;

    SerialRead(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[1024];
        int len = -1;
        String s="";
        try {
            String receivedData="";
            while ((len = this.in.read(buffer)) >-1 ) {
                s += new String(buffer, 0, len);
                log.info("len1={}",len);
                log.info("s={}",s);
                if (s.length()>=18) {
                    if(s.charAt(0)!='*' || s.length()>=25){//문자열자르기 생각
                        s="";
                    }
                    log.info("len2={}", s);
                    s="";
                    try {
                        //
                    } catch (Exception e) {}
                }
/*                if(s.length()>18){
                    log.info("len55");
                    s="";
                }*/
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}