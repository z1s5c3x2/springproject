package day03.restful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Controller // 해당 클래스를 스프링 MVC중 컨트롤러 객체로 사용
public class RestController2 {
    @RequestMapping(value = "/day03/orange",method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<String> getOrange(HttpServletRequest req) throws IOException{
        String param1 = req.getParameter("param1");
        System.out.println("param1 = " + param1);
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("하나");
        list1.add("둘");
        list1.add("셋");
        return list1;


    }
    @RequestMapping(value = "/day03/orange",method = RequestMethod.POST)
    @ResponseBody
    public String postOragne(HttpServletRequest req) throws IOException{
        String param1 = req.getParameter("param1");
        System.out.println("param1 = " + param1);
        return "응답";

    }
    @RequestMapping(value = "/day03/orange",method = RequestMethod.PUT)
    @ResponseBody
    public String putOragne(HttpServletRequest req) throws IOException{
        String param1 = req.getParameter("param1");
        System.out.println("param1 = " + param1);
        return "응답";
    }
    @RequestMapping(value = "/day03/orange",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteOragne(HttpServletRequest req) throws IOException{
        String param1 = req.getParameter("param1");
        System.out.println("param1 = " + param1);
        return "응답";

    }

}
