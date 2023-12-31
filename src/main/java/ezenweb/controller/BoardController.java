package ezenweb.controller;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.dto.PageDto;
import ezenweb.service.BoardService;
import ezenweb.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private FileService fileService;

    @PostMapping("")
    public boolean write(BoardDto boardDto) {
        System.out.println("boardDto = " + boardDto);

        return boardService.write(boardDto);

    }

    @GetMapping
    public PageDto getAll(@RequestParam int page ,@RequestParam String key,@RequestParam String keyword,@RequestParam int view) {
        System.out.println("page = " + page + ", key = " + key + ", keyword = " + keyword + ", pageSize = " + view);
        return boardService.getAll(page,key,keyword,view);
    }

    @PutMapping
    public boolean update(BoardDto boardDto) {
        return boardService.update(boardDto);
    }

    @DeleteMapping
    public boolean delete(@RequestParam int bno) {
        return boardService.delete(bno);
    }

    /* 게시글 가져오기 */
    @GetMapping("/doGet")
    public BoardDto doGet(@RequestParam int bno)
    {
        return boardService.doGet(bno);
    }

    @GetMapping("/filedownload")
    public void fileDownload(@RequestParam String uuidFile)
    {
        System.out.println(uuidFile);
        fileService.fileDownload(uuidFile);
    }
}
