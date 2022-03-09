package toy.toyprj.domain.serial;

import gnu.io.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class SerialService {

    private static Map<Long, Serial> temp=new ConcurrentHashMap<>();

    public void connect(String port) throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException, IOException {
        CommPort commPort = null;
        SerialPort serialPort = null;
        CommPortIdentifier com = CommPortIdentifier.getPortIdentifier(port);
        if (com.isCurrentlyOwned()) {
            System.out.println("Error : " + port + "포트를 사용중입니다.");
        }
        else {
            commPort = com.open(this.getClass().getName(), 2000);
            //	획득한 포트를 객체가 사용할 수 있는지 여부 확인
            if (commPort instanceof SerialPort)    //	commPort가 SerialPort로 사용할 수 있는지 확인
            {
                serialPort = (SerialPort) commPort;

                //	정상적으로 포트를 사용할 수 있을 경우
                //	포트에 필요한 정보를 입력해 준다.
                serialPort.setSerialPortParams(
                        9600,                        //	바운드레이트
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE);    //	오류제어 비트
            }

            InputStream in = serialPort.getInputStream();
            OutputStream out = serialPort.getOutputStream();
            (new Thread(new SerialRead(in))).start();
            new Thread(new SerialWrite(out)).start();

        }
    }
}
