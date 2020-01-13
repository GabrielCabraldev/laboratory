package br.com.danilomr.guiadogs.exceptions;

import br.com.danilomr.guiadogs.enums.ExceptionEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BreedNotFoundException.class)
    protected ResponseEntity<DefaultExceptionResponseDTO> handleBreedNotFoundException(final BreedNotFoundException ex) {
        DefaultExceptionResponseDTO response = buildResponse(ex.getError().getMessage(), ex.getError().getCode(), null);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<DefaultExceptionResponseDTO> handleHttpMessageNotReadableException(final HttpMessageNotReadableException ex) {
        DefaultExceptionResponseDTO response = buildResponse(ExceptionEnum.INVALID_BODY_REQUEST.getMessage(),
                ExceptionEnum.INVALID_BODY_REQUEST.getCode(), null);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<DefaultExceptionResponseDTO> handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {
        DefaultExceptionResponseDTO response = buildResponse(ExceptionEnum.NULL_OR_EMPTY_FIELDS.getMessage(),
                ExceptionEnum.NULL_OR_EMPTY_FIELDS.getCode(), ex.getBindingResult().getFieldErrors());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
/*
    @ResponseBody
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<DefaultExceptionResponseDTO> handleIOException(final Exception ex) {
        DefaultExceptionResponseDTO response = buildResponse(ExceptionEnum.INTERNAL_SERVER_ERROR.getMessage(), ExceptionEnum.INTERNAL_SERVER_ERROR.getCode());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

 */

    private DefaultExceptionResponseDTO buildResponse(final String message, final int code, final List<FieldError> fields) {

        return DefaultExceptionResponseDTO.builder()
                .code(code)
                .message(message)
                .fields(fields == null ? null : fields.stream()
                .map(fieldError -> Field.builder()
                        .field(fieldError.getField())
                        .build())
                .collect(Collectors.toList()))
                .build();
    }
}
