package ezenweb.service;

import ezenweb.model.dto.BoardDto;
import ezenweb.model.entity.BoardEntity;
import ezenweb.model.entity.MemberEntity;
import ezenweb.model.repository.BoardEntityRepository;
import ezenweb.model.repository.MemberEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<BoardDto> getAll()
    {
        List<BoardEntity> entities = boardEntityRepository.findAll();
        List<BoardDto> dots = new ArrayList<>();
        entities.forEach(e ->{
            dots.add(e.allToDto());
        });

        return dots;
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


}
