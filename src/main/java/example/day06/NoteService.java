package example.day06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService{
    @Autowired
    NoteEntityRepository nr;
    @Transactional
    public boolean boardWrite(NoteDto noteDto)
    {
        nr.save(noteDto.toEntity());
        return false;
    }
    public List<NoteDto> boardList()
    {
        List<NoteEntity> entities = nr.findAll();
        List<NoteDto> noteDtos = new ArrayList<>();
        entities.forEach( e->{
            noteDtos.add(e.toDto());
        });
        return noteDtos;
    }
    @Transactional
    public boolean boardUpdate(NoteDto noteDto)
    {
        System.out.println("noteDto = " + noteDto);
        Optional<NoteEntity> optionalNoteEntity =  nr.findById(noteDto.getNo());
        if(optionalNoteEntity.isPresent()) {
            System.out.println("asd");
            NoteEntity noteEntity = optionalNoteEntity.get();
            noteEntity.setTitle(noteDto.getTitle());
            noteEntity.setWriter(noteDto.getWriter());
        }

        return false;
    }
    public boolean boardDelete(int no)
    {
        nr.deleteById(no);
        return false;
    }
}
