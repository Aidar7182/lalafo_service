package kg.lalfo.lalafoservice.endpoints;

import kg.lalfo.lalafoservice.models.base.RestResponse;
import kg.lalfo.lalafoservice.models.request.CategoryRequest;
import kg.lalfo.lalafoservice.models.request.CategoryUpdateRequest;
import kg.lalfo.lalafoservice.models.request.ProductRequest;
import org.springframework.http.ResponseEntity;

public interface CategoryEndPoint {
    ResponseEntity<RestResponse> create(CategoryRequest request);
    ResponseEntity<RestResponse> delete(Long productId);
    ResponseEntity<RestResponse> update(CategoryUpdateRequest request);
    ResponseEntity<RestResponse> getAll();
}
