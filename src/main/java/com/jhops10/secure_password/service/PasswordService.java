package com.jhops10.secure_password.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PasswordService {

    public List<String> validatePassword(String password) {
        List<String> failures = new ArrayList<>();

        validateLength(password, failures);
        validateUpperCase(password, failures);
        validateLowerCase(password, failures);
        validateNumber(password, failures);
        validateEspecialChar(password, failures);

        return failures;
    }


    private void validateLength(String password, List<String> failures) {

        if (password != null && password.length() < 8) {
            failures.add("A sua senha deve ter no mínimo 8 caracteres.");
        }
    }

    private void validateUpperCase(String password, List<String> failures) {

        if (!Pattern.matches(".*[A-Z].*", password)) {
            failures.add("A sua senha deve ter no mínimo uma letra maiúscula.");
        }
    }

    private void validateLowerCase(String password, List<String> failures) {

        if (!Pattern.matches(".*[a-z].*", password)) {
            failures.add("A sua senha deve ter no mínimo uma letra maiúscula.");
        }
    }

    private void validateNumber(String password, List<String> failures) {

        if (!Pattern.matches(".*[0-9].*", password)) {
            failures.add("A sua senha deve ter no mínimo um caractere numérico.");
        }
    }

    private void validateEspecialChar(String password, List<String> failures) {

        if (!Pattern.matches(".*[\\W].*", password)) {
            failures.add("A sua senha deve ter no mínimo um caractere especial (e.g, !@#$%).");
        }
    }

}
