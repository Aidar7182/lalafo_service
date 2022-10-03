package kg.lalfo.lalafoservice.controllers;

import kg.lalfo.lalafoservice.endpoints.ProductEndPoint;
import kg.lalfo.lalafoservice.models.base.RestResponse;
import kg.lalfo.lalafoservice.models.request.ProductRequest;
import kg.lalfo.lalafoservice.models.request.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/product")
public class ProductController {
    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductEndPoint productEndPoint;

    @PostMapping(value = "/create")
    public ResponseEntity<RestResponse> create(@Valid @RequestBody ProductRequest request) {
        logger.info("-===> URL: /product/create <===-");
        return productEndPoint.create(request);
    }

    @PostMapping(path = "delete")
    public ResponseEntity<RestResponse> delete(@RequestParam Long productId) {
        logger.info("-===> URL: /product/delete <===-");
        return productEndPoint.delete(productId);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<RestResponse> update(@Valid @RequestBody ProductUpdateRequest request) {
        logger.info("-===> URL: /product/update <===-");
        return productEndPoint.update(request);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<RestResponse> getAll(String external) {
        logger.info("-===> URL: /product/list <===-");
        return productEndPoint.getAll();
    }

    @GetMapping(value = "/get/type")
    public ResponseEntity<RestResponse> getByName(@RequestParam String type, @RequestParam String name) {
        logger.info("-===> URL: /product/get/type <===-");
        return productEndPoint.getByName(type,name);
    }
}
