package kg.lalfo.lalafoservice.endpoints;

import kg.lalfo.lalafoservice.models.base.RestResponse;
import kg.lalfo.lalafoservice.models.request.CategoryUpdateRequest;
import kg.lalfo.lalafoservice.models.request.ProductRequest;
import kg.lalfo.lalafoservice.models.request.UserRequest;
import kg.lalfo.lalafoservice.models.request.UserUpdateRequest;
import org.springframework.http.ResponseEntity;

public interface UserEndPoint {
    ResponseEntity<RestResponse> create(UserRequest request);
    ResponseEntity<RestResponse> delete(Long productId);
    ResponseEntity<RestResponse> update(UserUpdateRequest request);
    ResponseEntity<RestResponse> getAll();
}
