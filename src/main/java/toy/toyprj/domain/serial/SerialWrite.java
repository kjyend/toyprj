package toy.toyprj.domain.serial;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.OutputStream;

@RequiredArgsConstructor
public class SerialWrite implements Runnable {

    private final OutputStream out;

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
