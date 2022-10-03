package kg.lalfo.lalafoservice.controllers;

import kg.lalfo.lalafoservice.endpoints.CategoryEndPoint;
import kg.lalfo.lalafoservice.endpoints.UserEndPoint;
import kg.lalfo.lalafoservice.models.base.RestResponse;
import kg.lalfo.lalafoservice.models.request.CategoryRequest;
import kg.lalfo.lalafoservice.models.request.CategoryUpdateRequest;
import kg.lalfo.lalafoservice.models.request.UserRequest;
import kg.lalfo.lalafoservice.models.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/category")
public class CategoryController {
    private final static Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryEndPoint categoryEndPoint;

    @PostMapping(value = "/create")
    public ResponseEntity<RestResponse> create(@Valid @RequestBody CategoryRequest request) {
        logger.info("-===> URL: /user/create <===-");
        return categoryEndPoint.create(request);
    }

    @PostMapping(path = "delete")
    public ResponseEntity<RestResponse> delete(@RequestParam Long categoryId) {
        logger.info("-===> URL: /user/delete <===-");
        return categoryEndPoint.delete(categoryId);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<RestResponse> update(@Valid @RequestBody CategoryUpdateRequest request) {
        logger.info("-===> URL: /user/update <===-");
        return categoryEndPoint.update(request);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<RestResponse> getAll(String external) {
        logger.info("-===> URL: /user/list <===-");
        return categoryEndPoint.getAll();
    }
}
