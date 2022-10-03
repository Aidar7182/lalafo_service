package kg.lalfo.lalafoservice.controllers;

import kg.lalfo.lalafoservice.endpoints.UserEndPoint;
import kg.lalfo.lalafoservice.models.base.RestResponse;
import kg.lalfo.lalafoservice.models.request.ProductRequest;
import kg.lalfo.lalafoservice.models.request.ProductUpdateRequest;
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
@RequestMapping(path = "/user")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserEndPoint userEndPoint;

    @PostMapping(value = "/create")
    public ResponseEntity<RestResponse> create(@Valid @RequestBody UserRequest request) {
        logger.info("-===> URL: /user/create <===-");
        return userEndPoint.create(request);
    }

    @PostMapping(path = "delete")
    public ResponseEntity<RestResponse> delete(@RequestParam Long userId) {
        logger.info("-===> URL: /user/delete <===-");
        return userEndPoint.delete(userId);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<RestResponse> update(@Valid @RequestBody UserUpdateRequest request) {
        logger.info("-===> URL: /user/update <===-");
        return userEndPoint.update(request);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<RestResponse> getAll(String external) {
        logger.info("-===> URL: /user/list <===-");
        return userEndPoint.getAll();
    }
}
