package kg.lalfo.lalafoservice.entities;

import kg.lalfo.lalafoservice.entities.base.BaseEntity;
import kg.lalfo.lalafoservice.entities.base.TimedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "users")
public class User extends TimedEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    public User(String email, String phoneNumber, LocalDateTime createdAt){
        super(createdAt);
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
