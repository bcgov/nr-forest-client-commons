package ca.bc.gov.app.dto.legacy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Unit Test | Legacy search DTOs")
class LegacySearchDtoTest {

  @Test
  @DisplayName("address search needs every field")
  void addressSearchValidity() {
    assertThat(new AddressSearchDto("1 Main St", "Victoria", "BC", "V8V1V1", "Canada").isValid())
        .isTrue();
    assertThat(new AddressSearchDto("1 Main St", "Victoria", "BC", " ", "Canada").isValid())
        .isFalse();
    assertThat(new AddressSearchDto(null, "Victoria", "BC", "V8V1V1", "Canada").isValid())
        .isFalse();
  }

  @Test
  @DisplayName("contact search needs names, email and phone but not phone2 or fax")
  void contactSearchValidity() {
    assertThat(
        new ContactSearchDto("Jane", null, "Doe", "jane@example.com", "2505550100", null, null)
            .isValid()
    ).isTrue();
    assertThat(
        new ContactSearchDto("Jane", null, "Doe", "", "2505550100", "2505550101", "2505550102")
            .isValid()
    ).isFalse();
    assertThat(
        new ContactSearchDto("Jane", "Q", null, "jane@example.com", "2505550100", null, null)
            .isValid()
    ).isFalse();
  }

  @ParameterizedTest(name = "{0}|{1}|{2}|{3} -> {4}")
  @CsvSource(
      value = {
          "Jane|Q|Doe||Jane Q Doe",
          "' Jane '||' Doe '||Jane Doe",
          "||Acme Ltd||Acme Ltd",
          "||Acme Ltd|Acme|Acme Ltd (Acme)",
          "|||' '|''",
      },
      delimiter = '|'
  )
  @DisplayName("predictive search full name trims parts and appends doing-business-as")
  void clientFullName(
      String first, String middle, String last, String doingBusinessAs, String expected
  ) {
    PredictiveSearchResultDto dto = new PredictiveSearchResultDto(
        "00000001", null, last, first, doingBusinessAs, null, middle,
        "Victoria", "C", "ACT", 1L
    );
    assertThat(dto.clientFullName()).isEqualTo(expected == null ? "" : expected);
  }
}
