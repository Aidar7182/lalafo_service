package kg.lalfo.lalafoservice.entities;

import kg.lalfo.lalafoservice.entities.base.TimedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "products")
public class Product extends TimedEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryId;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "type")
    private String type;

    @Column(name = "updated")
    private LocalDateTime update;

    @Column(name = "userId")
    private Long user;


    public Product(String name, String description, Category category, Long amount, String type, Long user, LocalDateTime createdAt){
        super(createdAt);
        this.name = name;
        this.description = description;
        this.categoryId = category;
        this.amount = amount;
        this.type = type;
        this.user = user;
    }
}
