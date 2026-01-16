package com.product.exception;

import com.product.dto.ExceptionResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(CategoryAlreadyExistException.class)
  public ResponseEntity<ExceptionResponseDto> HandleCategoryAlreadyExistException(CategoryAlreadyExistException e, WebRequest webRequest)
  {
      ExceptionResponseDto exceptionResponseDto =  new ExceptionResponseDto
              (
          webRequest.getDescription(false),
              HttpStatus.CONFLICT,
              e.getMessage(),
              LocalDateTime.now()
              );
          return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponseDto);
  }

  @ExceptionHandler(CategoryNotFoundException.class)
  public ResponseEntity<ExceptionResponseDto>  HandleCategoryNotFound(CategoryNotFoundException e,WebRequest webRequest)
    {
        ExceptionResponseDto exceptionResponseDto =  new ExceptionResponseDto
                (
                        webRequest.getDescription(false),
                        HttpStatus.CONFLICT,
                        e.getMessage(),
                        LocalDateTime.now()
                );
          return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponseDto);

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto>  GlobalException(Exception ex,WebRequest webRequest)
    {
        ExceptionResponseDto exceptionResponseDto =  new ExceptionResponseDto
                (
                        webRequest.getDescription(false),
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        ex.getMessage(),
                        LocalDateTime.now()
                );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponseDto);

    }

}
