package toy.toyprj.domain.serial;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;


@Service
@RequiredArgsConstructor
public class SerialService {

    public String serialReceive(@ModelAttribute Serial serial) {
/*        String data = request.("data");
        ServletContext app = request.getServletContext();
        app.setAttribute("data", data);*/
        return "serial";
    }
//    public String serialPass(@RequestBody String messageBody) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("checkTemp");
//       dispatcher.forward(request, response);
//        return messageBody;
//    }

}
