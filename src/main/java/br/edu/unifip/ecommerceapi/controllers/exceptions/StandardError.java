package br.edu.unifip.ecommerceapi.controllers.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StandardError {
    LocalDateTime timestamp;
    Integer status;
    String error;
    String path;
}
