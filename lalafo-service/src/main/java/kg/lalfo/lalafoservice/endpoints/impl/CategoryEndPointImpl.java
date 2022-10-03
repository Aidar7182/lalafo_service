package kg.lalfo.lalafoservice.endpoints.impl;

import kg.lalfo.lalafoservice.endpoints.CategoryEndPoint;
import kg.lalfo.lalafoservice.entities.Category;
import kg.lalfo.lalafoservice.enums.RestStatus;
import kg.lalfo.lalafoservice.mappers.RestMapper;
import kg.lalfo.lalafoservice.models.base.RestResponse;
import kg.lalfo.lalafoservice.models.request.CategoryRequest;
import kg.lalfo.lalafoservice.models.request.CategoryUpdateRequest;
import kg.lalfo.lalafoservice.models.request.ProductRequest;
import kg.lalfo.lalafoservice.services.CategoryService;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryEndPointImpl implements CategoryEndPoint {
    private final static Logger logger = LoggerFactory.getLogger(CategoryEndPointImpl.class);
    private final CategoryService categoryService;
    private final RestMapper restMapper;

    public CategoryEndPointImpl(CategoryService categoryService, RestMapper restMapper) {
        this.categoryService = categoryService;
        this.restMapper = restMapper;
    }

    @Override
    public ResponseEntity<RestResponse> create(CategoryRequest request) {
        logger.info("REQUEST: ===> get params {}", request.toString());
        try {
            categoryService.create(new Category(request.getCategoryName(), request.getDescription()));
            logger.info("RESPONSE: --> CATEGORY ADDED");
            return new ResponseEntity<>(restMapper.toRestResponse("Категория успешно добавлена", true, RestStatus.SUCCESS), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(restMapper.toRestResponse("Невозможно добавить продукт. Проверьте корректность данных", false, RestStatus.ERROR), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<RestResponse> delete(@NonNull Long productId) {
        logger.info("REQUEST: ===> get params{}", productId);
        try {
            categoryService.delete(productId);
            return new ResponseEntity<>(restMapper.toRestResponse("Success", true, RestStatus.SUCCESS), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(restMapper.toRestResponse("Невозможно удалить категорию. Проверьте корректность данных", false, RestStatus.ERROR), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<RestResponse> update(CategoryUpdateRequest request) {
        logger.info("REQUEST: ===> get params{}", request.toString());
        try {
            categoryService.update(request.getCategoryId(), request.getCategoryName(), request.getDescription());
            return new ResponseEntity<>(restMapper.toRestResponse("Success", true, RestStatus.SUCCESS), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(restMapper.toRestResponse(null, "Невозможно обновить категорию. Проверьте корректность данных", RestStatus.ERROR), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<RestResponse> getAll() {
        List<Category> categoryList = categoryService.getAll();
        return new ResponseEntity<>(restMapper.toRestResponse("SUCCESS", categoryList, RestStatus.SUCCESS), HttpStatus.OK);
    }
}
