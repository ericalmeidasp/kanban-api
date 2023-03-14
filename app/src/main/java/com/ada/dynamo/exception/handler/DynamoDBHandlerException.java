package com.ada.dynamo.exception.handler;

import com.ada.dynamo.exception.ItemNaoEncontradoException;
import com.ada.dynamo.exception.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class DynamoDBHandlerException {

    @ExceptionHandler(ItemNaoEncontradoException.class)
    public ResponseEntity<StandardError> itemNaoEncontrado(ItemNaoEncontradoException e, HttpServletRequest request) {
        String error = "Item não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
