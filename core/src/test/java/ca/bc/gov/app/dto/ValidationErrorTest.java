package ca.bc.gov.app.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit Test | ValidationError")
class ValidationErrorTest {

  @Test
  @DisplayName("is valid when either the field or the message is present")
  void validity() {
    ValidationError error = new ValidationError("person.name", "Name is required");
    assertThat(error.isValid()).isTrue();
    assertThat(error.withFieldId(null).isValid()).isTrue();
    assertThat(error.withErrorMsg(" ").isValid()).isTrue();
    assertThat(error.withFieldId(" ").withErrorMsg(null).isValid()).isFalse();
  }
}
