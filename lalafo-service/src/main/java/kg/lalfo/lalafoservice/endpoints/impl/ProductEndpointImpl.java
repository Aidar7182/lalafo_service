package kg.lalfo.lalafoservice.endpoints.impl;

import kg.lalfo.lalafoservice.endpoints.ProductEndPoint;
import kg.lalfo.lalafoservice.entities.Category;
import kg.lalfo.lalafoservice.entities.Product;
import kg.lalfo.lalafoservice.entities.RequestLogs;
import kg.lalfo.lalafoservice.enums.RestStatus;
import kg.lalfo.lalafoservice.mappers.RestMapper;
import kg.lalfo.lalafoservice.models.base.RestResponse;
import kg.lalfo.lalafoservice.models.request.ProductRequest;
import kg.lalfo.lalafoservice.models.request.ProductUpdateRequest;
import kg.lalfo.lalafoservice.services.CategoryService;
import kg.lalfo.lalafoservice.services.ProductService;
import kg.lalfo.lalafoservice.services.RequestLogsService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductEndpointImpl implements ProductEndPoint {
    private final static Logger logger = LoggerFactory.getLogger(ProductEndpointImpl.class);

    private final RestMapper restMapper;
    private final RequestLogsService requestLogsService;
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductEndpointImpl(ProductService productService, RestMapper restMapper, RequestLogsService requestLogs,CategoryService categoryService){
        this.productService = productService;
        this.restMapper = restMapper;
        this.requestLogsService = requestLogs;
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<RestResponse> create(ProductRequest request) {
        logger.info("REQUEST: ===> get params {}", request.toString());
        try {
            Category category = categoryService.getById(request.getCategoryId());
            if (category == null){
                logger.error("RESPONSE: --> CATEGORY WITH ID: {} NOT FOUND", request.getCategoryId());
                return new ResponseEntity<>(restMapper.toRestResponse(null, "Невозможно добавить продукт. Проверьте корректность данных", RestStatus.ERROR), HttpStatus.OK);
            }

            productService.create(new Product(request.getProductName(), request.getDescription(), category, request.getAmount(), request.getType(), request.getUserId(), LocalDateTime.now()));
            logger.info("RESPONSE: --> PRODUCT ADDED");
            return new ResponseEntity<>(restMapper.toRestResponse(null, "Продукт успешно добавлен", RestStatus.SUCCESS), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(restMapper.toRestResponse(null, "Невозможно добавить продукт. Проверьте корректность данных", RestStatus.ERROR), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<RestResponse> delete(@NonNull Long productId) {
        logger.info("REQUEST: ===> get params{}", productId);
        try {
            productService.delete(productId);
            return new ResponseEntity<>(restMapper.toRestResponse("Success",true,RestStatus.SUCCESS),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(restMapper.toRestResponse(null, "Невозможно удалить продукт. Проверьте корректность данных", RestStatus.ERROR), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<RestResponse> update(ProductUpdateRequest request) {
        logger.info("REQUEST: ===> get params{}", request.toString());
        try {
            Category category = categoryService.getById(request.getCategoryId());
            if (category == null){
                logger.error("RESPONSE: --> CATEGORY WITH ID: {} NOT FOUND", request.getCategoryId());
                return new ResponseEntity<>(restMapper.toRestResponse(null, "Невозможно добавить продукт. Проверьте корректность данных", RestStatus.ERROR), HttpStatus.OK);
            }
            productService.update(request.getProductId(), request.getProductName(), request.getDescription(), category, request.getAmount(), request.getType(), request.getUserId());
            return new ResponseEntity<>(restMapper.toRestResponse("Success",true,RestStatus.SUCCESS),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(restMapper.toRestResponse(null, "Невозможно обновить продукт. Проверьте корректность данных", RestStatus.ERROR), HttpStatus.OK);
        }
    }
    @Override
    public ResponseEntity<RestResponse> getAll(){
        logger.info("REQUEST: ===> getAll{}");
        try {
            List<Product> products = productService.getAll();
            return new ResponseEntity<>(restMapper.toRestResponse("SUCCESS",products , RestStatus.SUCCESS), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(restMapper.toRestResponse("Ошибка", "Не удалось выполнить запрос", RestStatus.ERROR), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<RestResponse> getByName(String type, String name) {
        logger.info("REQUEST: ===> getByType{}");
        try {
            List<Product> products = productService.getByName(type, name);
            System.out.println(products);
            if(products.isEmpty()){
                return new ResponseEntity<>(restMapper.toRestResponse("Данные не найдены",false,RestStatus.SUCCESS),HttpStatus.OK);
            }
            return new ResponseEntity<>(restMapper.toRestResponse("Success", products,RestStatus.SUCCESS),HttpStatus.OK);
        }catch (Exception e){

        }
        return new ResponseEntity<>(restMapper.toRestResponse("Ошибка", "Не удалось выполнить запрос", RestStatus.ERROR), HttpStatus.OK);
    }

}
