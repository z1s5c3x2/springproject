package example.day03.mapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController @RequestMapping("/day03/delete")
public class DeleteMappingController {

    @DeleteMapping("/1")
    public boolean m1(@RequestParam String param1)
    {
        System.out.println("parma1 = " + param1);
        return true;
    }
    @DeleteMapping("/2")
    public boolean m2(@RequestParam Map<String,String> mp)
    {
        System.out.println("mp = " + mp);
        return false;
    }

}
