package DailyRecipe.DailyRecipe_study.User.domain;


import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;

@Entity
@Getter
public class UserDAO {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @ColumnDefault("random_uuid()")
    @Column(name = "id", updatable = false, nullable = false)
    /**
     * 이렇게 어노테이션 처리로도 UUID 설정이 가능하다.
     * 하지만 스프링 코드 내에서 직접 UUID를 생성하고 직접 로그를 확인 할 수 있
     */
    private UUID id;
    private String name;
    private String password;
    public void setName(String name){this.name = name;}
    public void setPassword(String password){this.password = password;}
}
