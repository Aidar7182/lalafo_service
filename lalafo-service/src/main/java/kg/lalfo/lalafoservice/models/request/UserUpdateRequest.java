package kg.lalfo.lalafoservice.models.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserUpdateRequest extends UserRequest{
    private final static String MESSAGE_EMPTY ="must not be empty";
    private final static String MESSAGE_NULL ="must not be null";
    @NotNull(message = "userId " + MESSAGE_NULL)
    @JsonProperty(value = "userId")
    private Long userId;
}
