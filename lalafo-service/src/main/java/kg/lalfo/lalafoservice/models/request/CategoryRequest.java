package kg.lalfo.lalafoservice.models.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryRequest {
    private final static String MESSAGE_EMPTY ="must not be empty";
    private final static String MESSAGE_NULL ="must not be null";

    @NotEmpty(message = "categoryName " + MESSAGE_EMPTY)
    @NotNull(message = "categoryName " + MESSAGE_NULL)
    @JsonProperty(value = "categoryName")
    private String categoryName;

    @NotEmpty(message = "description " + MESSAGE_EMPTY)
    @NotNull(message = "description " + MESSAGE_NULL)
    @JsonProperty(value = "description")
    private String description;
}
