package toy.toyprj.domain.serial;



import java.io.IOException;
import java.io.InputStream;




public class SerialRead implements Runnable {

    private final InputStream in;
    private final SerialRepository serialRepository;
    private static Serial temp;
    public SerialRead(InputStream in) {
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
                    if(s.charAt(0)!='*' || s.length()>=25){//문자열자르기 생각
                        s="";
                        continue;
                    }
                    serialRepository.save(s);
                    serialRepository.receive();
                    try {
                        s="";
                    } catch (Exception e) {}
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}