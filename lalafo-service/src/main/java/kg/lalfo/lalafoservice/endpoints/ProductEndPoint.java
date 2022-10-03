package kg.lalfo.lalafoservice.endpoints;

import kg.lalfo.lalafoservice.models.base.RestResponse;
import kg.lalfo.lalafoservice.models.request.ProductRequest;
import kg.lalfo.lalafoservice.models.request.ProductUpdateRequest;
import org.springframework.http.ResponseEntity;

public interface ProductEndPoint {
    ResponseEntity<RestResponse> create(ProductRequest request);
    ResponseEntity<RestResponse> delete(Long productId);
    ResponseEntity<RestResponse> update(ProductUpdateRequest request);
    ResponseEntity<RestResponse> getAll();
    ResponseEntity<RestResponse> getByName(String type, String name);
}
