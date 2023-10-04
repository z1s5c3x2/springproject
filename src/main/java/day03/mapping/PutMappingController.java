package day03.mapping;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController @RequestMapping("/day03/put")
public class PutMappingController {
    @PutMapping("/1")
    public ParamDto m1(@RequestBody ParamDto dto)
    {
        return dto;
    }
    @PutMapping("/2")
    public Map<String, String> m2(@RequestBody Map<String,String> mp)
    {
        return mp;
    }
    @PutMapping("/3")
    public ParamDto m3(@RequestBody ParamDto dto)
    {
        return dto;
    }
    @PutMapping("/4")
    public ParamDto m4(@RequestBody ParamDto dto)
    {
        return dto;
    }
}
