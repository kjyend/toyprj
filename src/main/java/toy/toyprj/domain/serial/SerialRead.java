package toy.toyprj.domain.serial;



import java.io.IOException;
import java.io.InputStream;


public class SerialRead implements Runnable {

    private final InputStream in;
    private final SerialRepository serialRepository;
    
    public SerialRead(InputStream in) { //시리얼값 읽기
        this.in = in;
        serialRepository = new SerialRepository();
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
                    if(s.charAt(0)!='*' || s.length()>=25){//측정 온도를 받는다. 3개를 연속으로 받기에 맨앞에 *로 처음인지, 문자 크기가 너무큰지 판단한다.
                        s=""; // 값을 다시 받기 위해서 s를 초기화한다.
                        continue;
                    }
                    serialRepository.save(s); //아두이노로 측정한 온도 값을 따로 저정한다.
                    serialRepository.receive(); // 저장한 온도값을 받는다.
                    try {
                        s="";//온도 값을 받았기에 s값을 다시 받기위해 초기화한다.
                    } catch (Exception e) {}
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}