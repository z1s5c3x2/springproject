package day01.webMvc;

import day01.consoleMvc.ConsoleDao;
import day01.consoleMvc.ConsoleDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class WebController {
    @GetMapping("/day01/doget")
    public List<ConsoleDto> doGet()
    {
        return new ConsoleDao().doGet();
    }
    @PostMapping("/day01/dopost")
    public boolean doPost(String title)
    {

        return new ConsoleDao().doPost(new ConsoleDto(0,title, LocalDate.now(),true));
    }

}
