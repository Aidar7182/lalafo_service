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

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "categories")
public class Category extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Category(String name, String description){
        this.name = name;
        this.description = description;
    }
}
