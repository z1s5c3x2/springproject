package example.day03.restful;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/day03")
public class RestController5 {
    @GetMapping("/2")
    public ArrayList<String> getOrange(HttpServletRequest req) throws IOException{
        String param1 = req.getParameter("param1");
        System.out.println("param1 = " + param1);
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("2하나");
        list1.add("둘");
        list1.add("셋");
        list1.add("넷!");
        list1.add("다섯!");
        return list1;

    }
    @PostMapping("/2")

    public String postOragne(HttpServletRequest req) throws IOException{
        String param1 = req.getParameter("param1");
        System.out.println("param1 = " + param1);
        return "응답";

    }
    @PutMapping("/2")

    public String putOragne(HttpServletRequest req) throws IOException{
        String param1 = req.getParameter("param1");
        System.out.println("param1 = " + param1);
        return "응답";
    }
    @DeleteMapping("/2")

    public String deleteOragne(HttpServletRequest req) throws IOException{
        String param1 = req.getParameter("param1");
        System.out.println("param1 = " + param1);
        return "응답";

    }

}
