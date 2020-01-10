package br.com.danilomr.timesheet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionResponseHandler {

    private static final String INTERNAL_SERVER_ERROR = "Internal server error";
    private static final String INVALID_REQUEST_BODY = "Invalid request body";

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<DefaultErrorResponse> handleMethodArgumentNotValidException(final Exception ex) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, INVALID_REQUEST_BODY);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<DefaultErrorResponse> handleException(final Exception ex) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR);
    }


    protected ResponseEntity<DefaultErrorResponse> buildErrorResponse(final HttpStatus status, final String message) {

        return ResponseEntity.status(status).body(DefaultErrorResponse.builder()
                .statusCode(status.value())
                .message(message)
                .build());
    }
}
