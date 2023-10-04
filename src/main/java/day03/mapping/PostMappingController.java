package day03.mapping;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController @RequestMapping("/day03/post")
public class PostMappingController {
    @PostMapping("/1")
    public String m1(@RequestBody String param1)
    {
        System.out.println("PostMappingController.m1");
        System.out.println("param1 = " + param1);
        return "정상";
    }
    @PostMapping("/2")
    public String m2(@RequestBody Map<String,Integer> pm)
    {
        System.out.println("PostMappingController.m2");
        System.out.println("pm = " + pm);
        return "정상";
    }
    @PostMapping("/3")
    public String m3(@RequestBody ParamDto dto){
        System.out.println("PostMappingController.m3");
        System.out.println("dto = " + dto);
        return "정상";
    }
}
