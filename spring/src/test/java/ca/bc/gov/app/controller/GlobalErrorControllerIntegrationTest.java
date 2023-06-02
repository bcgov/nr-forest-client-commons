package ca.bc.gov.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ca.bc.gov.app.dto.ValidationError;
import ca.bc.gov.app.extensions.AbstractTestContainerIntegrationTest;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.web.reactive.server.WebTestClient;

@Slf4j
@DisplayName("Integrated Test | Forest Client Repository")
public class GlobalErrorControllerIntegrationTest extends AbstractTestContainerIntegrationTest {
  @Autowired
  protected WebTestClient client;

  @Test
  void shouldDoNothing() {
    client
        .get()
        .uri("/dummy/ok")
        .exchange()
        .expectStatus()
        .isOk();
  }

  @Test
  void shouldReturnValidationException() {
    List<ValidationError> validationErrors =
        client
            .get()
            .uri("/dummy/validationException")
            .exchange()
            .expectStatus()
            .isBadRequest()
            .expectBody(new ParameterizedTypeReference<List<ValidationError>>() {})
            .returnResult()
            .getResponseBody();

    assertThat(validationErrors)
        .isNotNull()
        .isNotEmpty()
        .hasSize(2);
  }

  @Test
  void shouldReturnResponseStatusException() {
    client
        .get()
        .uri("/dummy/responseStatusException")
        .exchange()
        .expectStatus()
        .isNotFound()
        .expectBody(String.class)
        .isEqualTo("resource not found");
  }

  @Test
  void shouldReturnNullPointerException() {
    client
        .get()
        .uri("/dummy/nullPointerException")
        .exchange()
        .expectStatus()
        .is5xxServerError()
        .expectBody(String.class)
        .isEqualTo("something is null");
  }
}
