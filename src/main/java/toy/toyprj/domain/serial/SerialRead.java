package toy.toyprj.domain.serial;

import lombok.RequiredArgsConstructor;

import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@RequiredArgsConstructor
public class SerialRead implements Runnable {

    private final InputStream in;

    @Override
    public void run()
    {
        byte[] buffer = new byte[1024];
        int len = -1;
        try
        {
            //	buffer에 저장하고나서, 그 길이를 반환한다.
            while ((len = this.in.read(buffer)) > -1)
            {
                String s = new String(buffer,0,len);
                HttpURLConnection conn = null;

                //	들어온 데이터가 있는 경우에만 동작을 한다.
                if (len != 0)
                {
                    //	데이터를 url 형태로 변형시킨다. s가 데이터이다.
                    String targetURL = "http://localhost:9090/serialdata?data="+s;
                    URL url = new URL(targetURL);	//	URL은 String클래스와 비슷하나, 파싱까지 해준다.

                    try
                    {
                        //	http에 접속
                        conn = (HttpURLConnection) url.openConnection();	//	소켓을 열겠다는 요청
                        //	스트림을 통해 데이터를 받는다.
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String temp = null;

                        while ((temp = br.readLine()) != null) {}

                        br.close();
                        conn.disconnect();
                    }
                    catch(Exception e) {}
                }
            }
        }
        catch (IOException e) {e.printStackTrace();}
    }
}
