package DailyRecipe.DailyRecipe_study.User.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserDAO {
    /**
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @ColumnDefault("random_uuid()")
    @Column(name = "id", updatable = false, nullable = false)
     * 이렇게 어노테이션 처리로도 UUID 설정이 가능하다.
     * 하지만 스프링 코드 내에서 직접 UUID를 생성하고 직접 로그를 확인 할 수 있게 해 두는 것이 후에 체크 하기 편하다.
     */

    @Id
    @Column(updatable = false, nullable = false)
    private UUID id;
    private String userName;
    private String password;
}
