package toy.toyprj.domain.serial;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


@Service
@RequiredArgsConstructor
public class SerialService {

    public void serialReceive(@ModelAttribute Model model) {
        try {
            model.addAttribute((new SerialRepository()).connect("COM6"));
            //port받고 실행하는것 - temp로 받아야할듯, 쏠때 고민
        } catch (Exception e) {
            e.printStackTrace();
        }
/*        String data = request.("data");
        ServletContext app = request.getServletContext();
        app.setAttribute("data", data);*/
    }
//    public String serialPass(@RequestBody String messageBody) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("checkTemp");
//       dispatcher.forward(request, response);
//        return messageBody;
//    }

}
