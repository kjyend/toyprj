package toy.toyprj.web.serial;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SerialDataView {

    private String viewPath;

    public SerialDataView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = request.getParameter(viewPath);//data였음
        ServletContext app = request.getServletContext();
        app.setAttribute("data", data);
    }
}
