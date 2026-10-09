package ca.bc.gov.app.dto.processor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit Test | MessagingWrapper")
class MessagingWrapperTest {

  @Test
  @DisplayName("copies the parameters it is given")
  void copiesParameters() {
    Map<String, Object> source = new HashMap<>(Map.of("id", 1));
    MessagingWrapper<String> wrapper = new MessagingWrapper<>("payload", source);
    source.put("id", 2);
    wrapper.withParameter("extra", "value");

    assertThat(wrapper.getParameter("id", Integer.class)).isEqualTo(1);
    assertThat(source).doesNotContainKey("extra");
  }

  @Test
  @DisplayName("works with immutable parameter maps")
  void immutableParameters() {
    MessagingWrapper<String> wrapper =
        new MessagingWrapper<>("payload", Map.of()).withParameter("id", 7L);
    assertThat(wrapper.payload()).isEqualTo("payload");
    assertThat(wrapper.getParameter("id", Long.class)).isEqualTo(7L);
    assertThat(wrapper.getParameter("missing", Long.class)).isNull();
  }

  @Test
  @DisplayName("reads nested info parameters")
  void infoParameters() {
    MessagingWrapper<String> wrapper = new MessagingWrapper<>("payload", Map.of());
    assertThat(wrapper.getInfoParameter("name", String.class)).isNull();

    wrapper.withParameter("info", Map.of("name", "Jane"));
    assertThat(wrapper.getInfoParameter("name", String.class)).isEqualTo("Jane");
    assertThat(wrapper.getInfoParameter("missing", String.class)).isNull();
  }
}
