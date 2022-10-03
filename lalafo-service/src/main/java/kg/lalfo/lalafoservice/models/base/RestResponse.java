package kg.lalfo.lalafoservice.models.base;

import kg.lalfo.lalafoservice.enums.RestStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class RestResponse {
    private String message;
    private Object data;
    private RestStatus status;
}
