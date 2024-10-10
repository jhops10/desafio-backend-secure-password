package com.jhops10.secure_password.controller;

import com.jhops10.secure_password.model.BodyRequest;
import com.jhops10.secure_password.model.FailureResponse;
import com.jhops10.secure_password.service.PasswordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private final PasswordService passwordService;

    public ApiController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }


    @PostMapping("/validate-password")
    public ResponseEntity<FailureResponse> validatePassword(@RequestBody BodyRequest request) {

        var failures = passwordService.validatePassword(request.password());

        if (failures.isEmpty()) {
            return ResponseEntity.noContent().build();

        }

        return ResponseEntity.badRequest().body(new FailureResponse(failures));
    }
}
