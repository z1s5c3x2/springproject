package assignment.assignment1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;
    @GetMapping("index")
    public Resource getIndex()
    {
        return new ClassPathResource("templates/phone.html");
    }
    @GetMapping("")
    public List<PhoneDto> doGet()
    {
        System.out.println("PhoneController.doGet");
        return phoneService.doGet();

    }
    @PostMapping("")
    public boolean doPost(@RequestBody PhoneDto _dto)
    {
        phoneService.doPost(_dto);
        return false;
    }
    @PutMapping("")
    public boolean doPut(@RequestBody PhoneDto _dto)
    {
        phoneService.doPut(_dto);
        return false;
    }
    @DeleteMapping("")
    public boolean doDelete(@RequestParam int pno)
    {
        phoneService.doDelete(pno);
        return false;
    }
}
