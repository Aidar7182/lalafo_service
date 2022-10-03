package kg.lalfo.lalafoservice.models.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserRequest {
    private final static String MESSAGE_EMPTY ="must not be empty";
    private final static String MESSAGE_NULL ="must not be null";

    @NotEmpty(message = "email " + MESSAGE_EMPTY)
    @NotNull(message = "email " + MESSAGE_NULL)
    @JsonProperty(value = "email")
    private String email;

    @NotEmpty(message = "phoneNumber " + MESSAGE_EMPTY)
    @NotNull(message = "phoneNumber " + MESSAGE_NULL)
    @JsonProperty(value = "phoneNumber")
    private String phoneNumber;
}
