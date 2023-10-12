package example.day03.restful;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class RestController3 {
    @RequestMapping(value = "/day03/red",method = RequestMethod.GET)
    public ArrayList<String> getOrange(HttpServletRequest req) throws IOException{
        String param1 = req.getParameter("param1");
        System.out.println("param1 = " + param1);
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("하나");
        list1.add("둘");
        list1.add("셋");
        list1.add("넷!");
        return list1;

    }
    @RequestMapping(value = "/day03/red",method = RequestMethod.POST)

    public String postOragne(HttpServletRequest req) throws IOException{
        String param1 = req.getParameter("param1");
        System.out.println("param1 = " + param1);
        return "응답";

    }
    @RequestMapping(value = "/day03/red",method = RequestMethod.PUT)

    public String putOragne(HttpServletRequest req) throws IOException{
        String param1 = req.getParameter("param1");
        System.out.println("param1 = " + param1);
        return "응답";
    }
    @RequestMapping(value = "/day03/red",method = RequestMethod.DELETE)

    public String deleteOragne(HttpServletRequest req) throws IOException{
        String param1 = req.getParameter("param1");
        System.out.println("param1 = " + param1);
        return "응답";

    }

}
