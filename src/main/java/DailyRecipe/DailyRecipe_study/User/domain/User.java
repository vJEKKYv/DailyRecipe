package DailyRecipe.DailyRecipe_study.User.domain;


import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @ColumnDefault("random_uuid()")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private String name;
    private String password;
    public void setName(String name){this.name = name;}
    public void setPassword(String password){this.password = password;}
}
