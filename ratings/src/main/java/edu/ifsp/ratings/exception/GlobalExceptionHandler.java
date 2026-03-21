package edu.ifsp.ratings.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<ErrorResponse> handleResourceAccess(ResourceAccessException e) {
        String mensagem = e.getMessage() != null ? e.getMessage().toLowerCase() : "";

        if (mensagem.contains("timeout") || mensagem.contains("timed out")) {
            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new ErrorResponse(504, "Serviço movies demorou para responder."));
        }

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new ErrorResponse(502, "Serviço movies indisponível no momento."));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneral(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(500, "Erro interno."));
    }

	@ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NoResourceFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(404, "Rota não encontrada: " + e.getResourcePath()));
    }
}
