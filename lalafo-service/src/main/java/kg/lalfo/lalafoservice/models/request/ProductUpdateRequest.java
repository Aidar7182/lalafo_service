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
public class ProductUpdateRequest extends ProductRequest{
    private final static String MESSAGE_EMPTY ="must not be empty";
    private final static String MESSAGE_NULL ="must not be null";
   // @NotEmpty(message = "productId " + MESSAGE_EMPTY)
    @NotNull(message = "productId " + MESSAGE_NULL)
    @JsonProperty(value = "productId")
    private Long productId;
}
