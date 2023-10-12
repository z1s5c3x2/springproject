package example.day03.restful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller // 해당 클래스를 스프링 MVC중 컨트롤러 객체로 사용
public class RestController1 {
    @RequestMapping(value = "/day03/black",method = RequestMethod.GET)
    public void getBlack(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String param1 = req.getParameter("param1");
        System.out.println("param1 = " + param1);

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().print("응답");
    }
    @RequestMapping(value = "/day03/black",method = RequestMethod.POST)
    public void postBlack(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String param1 = req.getParameter("param1");
        System.out.println("param1 = " + param1);

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().print("응답");
    }
    @RequestMapping(value = "/day03/black",method = RequestMethod.PUT)
    public void putBlack(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String param1 = req.getParameter("param1");
        System.out.println("param1 = " + param1);

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().print("응답");
    }
    @RequestMapping(value = "/day03/black",method = RequestMethod.DELETE)
    public void deleteBlack(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String param1 = req.getParameter("param1");
        System.out.println("param1 = " + param1);

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().print("응답");
    }

}
