package kg.lalfo.lalafoservice.models.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import kg.lalfo.lalafoservice.entities.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequest {
    private final static String MESSAGE_EMPTY ="must not be empty";
    private final static String MESSAGE_NULL ="must not be null";

    @NotEmpty(message = "productName " + MESSAGE_EMPTY)
    @NotNull(message = "productName " + MESSAGE_NULL)
    @JsonProperty(value = "productName")
    private String productName;


    @JsonProperty(value = "description")
    @NotEmpty(message = "description " + MESSAGE_EMPTY)
    @NotNull(message = "description " + MESSAGE_NULL)
    private String description;

    @JsonProperty(value = "categoryId")
   // @NotEmpty(message = "categoryId " + MESSAGE_EMPTY)
    @NotNull(message = "categoryId " + MESSAGE_NULL)
    private Long categoryId;

    @JsonProperty(value = "amount")
    //@NotEmpty(message = "amount " + MESSAGE_EMPTY)
    @NotNull(message = "amount " + MESSAGE_NULL)
    private Long amount;

    @JsonProperty(value = "type")
    @NotEmpty(message = "type " + MESSAGE_EMPTY)
    @NotNull(message = "type " + MESSAGE_NULL)
    private String type;

    @JsonProperty(value = "userId")
   // @NotEmpty(message = "userId " + MESSAGE_EMPTY)
    @NotNull(message = "userId " + MESSAGE_NULL)
    private Long userId;
}
