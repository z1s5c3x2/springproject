package example.day06;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping("/do")
    public boolean boardWrite(@RequestBody NoteDto noteDto)
    {
        boolean result = noteService.boardWrite(noteDto);
        return result;
    }
    @GetMapping("/do")
    public List<NoteDto> boardList()
    {
        List<NoteDto> result = noteService.boardList();
        return result;
    }
    @PutMapping("/do")
    public boolean boardUpdate(@RequestBody NoteDto noteDto)
    {
        boolean result = noteService.boardUpdate(noteDto);
        return result;
    }
    @DeleteMapping("/do")
    public boolean boardDelete(@RequestParam int no)
    {
        boolean boardDelete = noteService.boardDelete(no);
        return false;
    }

}
