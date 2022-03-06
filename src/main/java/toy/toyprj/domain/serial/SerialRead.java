package toy.toyprj.domain.serial;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class SerialRead implements Runnable {

    private final InputStream in;
    private static Map<Long, Serial> tempcheck=new ConcurrentHashMap<>();

    SerialRead(InputStream in) {
        this.in = in;
    }



    @Override
    public void run() {
        byte[] buffer = new byte[1024];
        int len = -1;
        try {
            while ((len = this.in.read(buffer)) >-1 ) {

                    String s = new String(buffer, 0, len);
                    HttpURLConnection conn = null;
                    if (len != 0) {
                        //	데이터를 url 형태로 변형시킨다. s가 데이터이다.
                        String targetURL = "http://localhost:8080/result?data=" + s;
                        URL url = new URL(targetURL);
                        try {
                            //	http에 접속
                            conn = (HttpURLConnection) url.openConnection();    //	소켓을 열겠다는 요청

                            //	스트림을 통해 데이터를 받는다.
                            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                            String temp = null;

                            while ((temp = br.readLine()) != null) {
                            }
                            br.close();
                            conn.disconnect();
                        } catch (Exception e) {}
                    }
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}