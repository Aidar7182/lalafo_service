package kg.lalfo.lalafoservice.entities;

import kg.lalfo.lalafoservice.entities.base.TimedEntity;
import kg.lalfo.lalafoservice.enums.ServiceType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "request_logs")
public class RequestLogs extends TimedEntity {

    @Column(name = "request", columnDefinition = "text")
    private String request;

    @Column(name = "response", columnDefinition = "text")
    private String response;

    @Enumerated(EnumType.STRING)
    @Column(name = "service_type")
    private ServiceType serviceType;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private User user;

    public RequestLogs(String request, String response, String type,ServiceType serviceType, User user, LocalDateTime createdAt) {
        super(createdAt);
        this.request = request;
        this.response = response;
        this.type = type;
        this.serviceType = serviceType;
        this.user = user;
    }

}
