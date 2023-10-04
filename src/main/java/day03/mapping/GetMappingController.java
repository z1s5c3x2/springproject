package day03.mapping;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/day03/get") // 메소드들의 공통 url
public class GetMappingController {
    @GetMapping("/method1")
    public String method1(HttpServletRequest req)
    {
        String param1 = req.getParameter("param1");
        System.out.println("param1 = " + param1);
        System.out.println("GetMappingController.method1");
        return "정상응답";

    }
    @GetMapping("/method2")
    public String method2(@RequestParam String param1)
    {
        System.out.println("GetMappingController.method2");
        System.out.println("param1 = " + param1);

        return "정상응답";

    }
    @GetMapping("/m3")
    public String method3(@RequestParam String param1,@RequestParam int param2)
    {
        System.out.println("GetMappingController.method3");



        return "정상";
    }
    @GetMapping("/m4")
    public ParamDto m4(ParamDto dto)
    {
        System.out.println("m4");
        System.out.println("dto = " + dto);
        return dto;
    }
    @GetMapping("/m5")
    public ParamDto m5(@ModelAttribute ParamDto dto)
    {
        System.out.println("m5");
        System.out.println("dto = " + dto);
        return dto;
    }
    @GetMapping("/m6/{param1}/{param2}")
    public String m6(@PathVariable("param1") String param1, @PathVariable("param2") int param2)
    {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        return " 정상";
    }
    @GetMapping("/m7/{param1}/{param2}")
    public String m7(ParamDto dto)
    {
        System.out.println(dto);
        return " 정상";
    }
    @GetMapping("/m8/{param1}/{param2}")
    public String m8(@ModelAttribute ParamDto dto)
    {
        System.out.println("dto = " + dto);
        return " 정상";
    }

}
