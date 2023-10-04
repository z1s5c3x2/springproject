package day02.servlet;

import javax.jws.WebService;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="helloServlet",value="/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    @Override
    public void init() throws ServletException {
        System.out.println("HelloServlet.init");
        message = "asdasd";
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        System.out.println("HelloServlet.doGet");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet.destroy");
    }
}
