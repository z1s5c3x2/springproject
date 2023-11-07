package ezenweb.service;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.dto.MemberDto;
import ezenweb.model.dto.PageDto;
import ezenweb.model.entity.BoardEntity;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.repository.BoardEntityRepository;
import ezenweb.model.repository.MemberEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
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

        return boardEntity.getBno() >=1;
    }

    @Transactional
    public PageDto getAll(int page)
    {
        /*
        *  Page repository가 페이징 처리할때 사용하는 인터페이스
        *
        * */
        Pageable pageable = PageRequest.of(page-1, 2);
        Page<BoardEntity> entities = boardEntityRepository.findAll(pageable);
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
            return optionalBoardEntity.get().allToDto();
        }

        return null;

    }

}
