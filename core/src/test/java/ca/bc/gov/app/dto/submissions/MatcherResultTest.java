package ca.bc.gov.app.dto.submissions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit Test | MatcherResult")
class MatcherResultTest {

  @Test
  @DisplayName("collects non-blank values and joins them")
  void collectsValues() {
    MatcherResult result = new MatcherResult("clientName", new LinkedHashSet<>());
    assertThat(result.hasMatch()).isFalse();

    result.addValue("00000001");
    result.addValue(" ");
    result.addValue(null);
    result.addValue("00000002");
    result.addValue("00000001");

    assertThat(result.hasMatch()).isTrue();
    assertThat(result.values()).containsExactly("00000001", "00000002");
    assertThat(result.value()).isEqualTo("00000001,00000002");
  }

  @Test
  @DisplayName("a null value set never matches and ignores additions")
  void nullValues() {
    MatcherResult result = new MatcherResult("clientName", null);
    result.addValue("00000001");
    assertThat(result.hasMatch()).isFalse();
  }
}
