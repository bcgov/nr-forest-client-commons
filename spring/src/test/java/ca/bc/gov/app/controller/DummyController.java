package ca.bc.gov.app.controller;

import ca.bc.gov.app.dto.ValidationError;
import ca.bc.gov.app.exception.ValidationException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/dummy", produces = MediaType.APPLICATION_JSON_VALUE)
public class DummyController {
  @GetMapping("/ok")
  public void returnOk(ServerHttpResponse serverResponse) {
    serverResponse.setStatusCode(HttpStatus.OK);
  }

  @GetMapping("/validationException")
  public void returnValidationException() {
    throw new ValidationException(
        List.of(
            new ValidationError("name", "name is null"),
            new ValidationError("id", "id is null")
        )
    );
  }

  @GetMapping("/responseStatusException")
  public void returnResponseStatusException() {
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "resource not found");
  }

  @GetMapping("/nullPointerException")
  public void returnNullPointerException() {
    throw new NullPointerException("something is null");
  }
}
