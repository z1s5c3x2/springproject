package day01.consoleMvc;

import java.time.LocalDate;
import java.util.List;

public class ConsoleController {
    public List<ConsoleDto> doGet()
    {
        return new ConsoleDao().doGet();
    }
    public boolean doPost(String _title)
    {
        return new ConsoleDao().doPost(new ConsoleDto(0,_title, LocalDate.now(),true));
    }
}
