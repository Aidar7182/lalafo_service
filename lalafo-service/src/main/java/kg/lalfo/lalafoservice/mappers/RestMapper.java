package kg.lalfo.lalafoservice.mappers;

import kg.lalfo.lalafoservice.enums.RestStatus;
import kg.lalfo.lalafoservice.models.base.RestResponse;
import org.springframework.stereotype.Component;

@Component
public class RestMapper {
    public RestResponse toRestResponse(String message, Object data, RestStatus status) {
        return RestResponse.builder()
                .message(message)
                .data(data)
                .status(status)
                .build();
    }
}
