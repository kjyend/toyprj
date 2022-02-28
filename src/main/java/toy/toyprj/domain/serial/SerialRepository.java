package toy.toyprj.domain.serial;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Repository
public class SerialRepository {
    public void connect(String port)
    {
        CommPort commPort = null;
        SerialPort serialPort = null;

        try
        {
            CommPortIdentifier com = CommPortIdentifier.getPortIdentifier(port);
            //	com포트를 확인하는 작업
            if (com.isCurrentlyOwned())
                System.out.println("Error : "+port +"포트를 사용중입니다.");
                //	포트가 열려있으면
            else
            {
                commPort = com.open(this.getClass().getName(),2000);
                //	획득한 포트를 객체가 사용할 수 있는지 여부 확인
                if (commPort instanceof SerialPort)	//	commPort가 SerialPort로 사용할 수 있는지 확인
                {
                    serialPort = (SerialPort)commPort;

                    //	정상적으로 포트를 사용할 수 있을 경우
                    //	포트에 필요한 정보를 입력해 준다.
                    serialPort.setSerialPortParams(
                            9600,						//	바운드레이트
                            SerialPort.DATABITS_8,
                            SerialPort.STOPBITS_1,
                            SerialPort.PARITY_NONE);	//	오류제어 비트
                }
                System.out.println("comport성공");

                InputStream in = serialPort.getInputStream();
                OutputStream out = serialPort.getOutputStream();

                (new Thread(new SerialRead(in))).start();
                new Thread(new SerialWrite(out)).start();
            }
        }	//	end try
        catch(Exception e) {}
    }

    public class SerialRead implements Runnable {

        private final InputStream in;

        private SerialRead(InputStream in) {
            this.in = in;
        }

        @Override
        public void run() {
            byte[] buffer = new byte[1024];
            int len = -1;
            try {
                //	buffer에 저장하고나서, 그 길이를 반환한다.
                while ((len = this.in.read(buffer)) > -1) {
                    String s = new String(buffer, 0, len);
                    HttpURLConnection conn = null;

                    //	들어온 데이터가 있는 경우에만 동작을 한다.
                    if (len != 0) {
                        //	데이터를 url 형태로 변형시킨다. s가 데이터이다.
                        String targetURL = "http://localhost:9090/serialdata?data=" + s;
                        URL url = new URL(targetURL);    //	URL은 String클래스와 비슷하나, 파싱까지 해준다.

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
                        } catch (Exception e) {
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class SerialWrite implements Runnable {

        private final OutputStream out;

        public SerialWrite(OutputStream out) {
            this.out = out;
        }

        @Override
        public void run()
        {
            int c = 0;
            try
            {
                while ((c = System.in.read()) > -1)
                {
                    out.write(c);
                }
            } catch (IOException e) {e.printStackTrace();}
        }
    }
}
