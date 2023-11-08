package ezenweb.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@MappedSuperclass //엔티티 X 여러 엔티티가 공통으로 사용하는 필드에 대해 구성 할 때
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseTime {
    @CreatedDate //엔티티 생성시 시간이 자동 저장/주입
    private LocalDateTime cdate;
    @LastModifiedDate // 엔티티가 변경될때 시간이 자동 저장/주입
    private LocalDateTime udate;

    public String toTimeOrDate( LocalDateTime dateTime ){
        // 만약에 매개변수로 들어온 날짜가 현재 시간 날짜와 같으면
        return
                dateTime.toLocalDate().toString().equals( LocalDateTime.now().toLocalDate().toString()  ) ?
                        dateTime.toLocalTime().format(DateTimeFormatter.ofPattern( "HH:mm:ss" ) ) :
                        dateTime.toLocalDate().format( DateTimeFormatter.ofPattern("yyyy-MM-dd") );
    }

}
