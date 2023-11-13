package ezenweb.service;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.dto.MemberDto;
import ezenweb.model.dto.PageDto;
import ezenweb.model.entity.BoardEntity;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.repository.BoardEntityRepository;
import ezenweb.model.repository.MemberEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardEntityRepository boardEntityRepository;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberEntityRepository memberEntityRepository;
    @Autowired
    private FileService fileService;

    @Transactional
    public boolean write(BoardDto boardDto)
    {
        MemberDto loginDto = memberService.getMember();
        if(loginDto == null){return false;}
        Optional<MemberEntity> optionalMemberEntity =  memberEntityRepository.findById(memberService.getMember().getMno());
        if(!optionalMemberEntity.isPresent())
        {
            return false;
        }
        BoardEntity boardEntity = boardEntityRepository.save(boardDto.saveToEntity());

        boardEntity.setMemberEntity(optionalMemberEntity.get());

        optionalMemberEntity.get().getBoardEntityList().add(boardEntity);
        if(boardEntity.getBno() >=1)
        {

            String filename = fileService.fileUpload(boardDto.getFile());
            if (filename != null)
            {
                boardEntity.setBfile(filename);
            }
            return true;
        }
        return false;
    }

    @Transactional
    public PageDto getAll(int page,String key,String keyword,int pageSize)
    {
        /*
        *  Page repository가 페이징 처리할때 사용하는 인터페이스
        *
        * */
        System.out.println("page = " + page + ", key = " + key + ", keyword = " + keyword);
        Pageable pageable = PageRequest.of(page-1, pageSize);
        //Page<BoardEntity> entities = boardEntityRepository.findAll(pageable);
        Page<BoardEntity> entities = boardEntityRepository.findBySearch(key,keyword, pageable );
        List<BoardDto> dtos = new ArrayList<>();
        entities.forEach(e ->{
            dtos.add(e.allToDto());
        });
        int totalPages = entities.getTotalPages();
        long totalElement = entities.getTotalElements();
        PageDto pageDto = PageDto.builder()
                .boardDtos(dtos)
                .totalElement(totalElement)
                .totalPages(totalPages).build();
        return pageDto;
    }

    @Transactional
    public boolean update(BoardDto boardDto)
    {
        Optional<BoardEntity> entity = boardEntityRepository.findById(boardDto.getBno()) ;
        if(entity.isPresent())
        {
            entity.get().setBcontent(boardDto.getBcontent());
            entity.get().setBtitle(boardDto.getBtitle());
            entity.get().setBfile(boardDto.getBfile());
            return true;
        }
        return false;
    }
    @Transactional
    public boolean delete(int bno)
    {
        if(boardEntityRepository.findById(bno).isPresent())
        {
            boardEntityRepository.deleteById(bno);
            return true;
        }
        return false;
    }
    @Transactional
    public BoardDto doGet(int bno)
    {

        Optional<BoardEntity> optionalBoardEntity = boardEntityRepository.findById(bno);
        if(optionalBoardEntity.isPresent())
        {
            //optionalBoardEntity.get().setBview(optionalBoardEntity.get().getBview()+1);
            optionalBoardEntity.get().setBview( optionalBoardEntity.get().getBview() );
            return optionalBoardEntity.get().allToDto();
        }

        return null;

    }

}
