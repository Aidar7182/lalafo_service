package kg.lalfo.lalafoservice.endpoints.impl;

import kg.lalfo.lalafoservice.endpoints.UserEndPoint;
import kg.lalfo.lalafoservice.entities.User;
import kg.lalfo.lalafoservice.enums.RestStatus;
import kg.lalfo.lalafoservice.mappers.RestMapper;
import kg.lalfo.lalafoservice.models.base.RestResponse;
import kg.lalfo.lalafoservice.models.request.UserRequest;
import kg.lalfo.lalafoservice.models.request.UserUpdateRequest;
import kg.lalfo.lalafoservice.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserEndPointImpl implements UserEndPoint {
    private final static Logger logger = LoggerFactory.getLogger(UserEndPointImpl.class);
    private final UserService service;
    private final RestMapper restMapper;

    public UserEndPointImpl(UserService service,RestMapper restMapper){
        this.service = service;
        this.restMapper = restMapper;
    }

    @Override
    public ResponseEntity<RestResponse> create(UserRequest request) {
        logger.info("REQUEST: ===> get params {}", request.toString());
        try {
            service.create(new User(request.getEmail(), request.getPhoneNumber(), LocalDateTime.now()));
            logger.info("RESPONSE: --> USER ADDED");
            return new ResponseEntity<>(restMapper.toRestResponse("Пользователь успешно добавлен", true, RestStatus.SUCCESS), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(restMapper.toRestResponse("Невозможно добавить пользователя. Проверьте корректность данных", false, RestStatus.ERROR), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<RestResponse> delete(Long productId) {
        logger.info("REQUEST: ===> get params{}", productId);
        try {
            service.delete(productId);
            return new ResponseEntity<>(restMapper.toRestResponse("Success",true,RestStatus.SUCCESS),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(restMapper.toRestResponse(null, "Невозможно удалить пользователя. Проверьте корректность данных", RestStatus.ERROR), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<RestResponse> update(UserUpdateRequest request) {
        logger.info("REQUEST: ===> get params{}", request.toString());
        try {
            service.update(request.getUserId(), request.getPhoneNumber(),request.getEmail());
            return new ResponseEntity<>(restMapper.toRestResponse("Success",true,RestStatus.SUCCESS),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(restMapper.toRestResponse(null, "Невозможно обновить пользователя. Проверьте корректность данных", RestStatus.ERROR), HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<RestResponse> getAll() {
        try {
         List<User> list= service.getAll();
            return new ResponseEntity<>(restMapper.toRestResponse("Success",list,RestStatus.SUCCESS),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(restMapper.toRestResponse(null, "Ошибка", RestStatus.ERROR), HttpStatus.OK);
        }

    }
}
