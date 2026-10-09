package ca.bc.gov.app.dto.client;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Unit Test | ClientBusinessInformationDto")
class ClientBusinessInformationDtoTest {

  private static final ClientBusinessInformationDto EMPTY = new ClientBusinessInformationDto(
      null, null, null, null, null, null, null, null, null, null,
      null, null, null, null, null, null, null, null, null
  );

  private static ClientBusinessInformationDto withId(String type, String province) {
    return EMPTY
        .withIdentificationType(new ClientValueTextDto(type, "text"))
        .withIdentificationProvince(province);
  }

  @ParameterizedTest(name = "{0} in {1} -> {2}")
  @CsvSource(
      value = {
          "CDDL|BC|BCDL",
          "USDL|WA|WADL",
          "CDDL||CDDL",
          "USDL|' '|USDL",
          "PASS|BC|PASS",
          "BRTH||BRTH",
      },
      delimiter = '|'
  )
  @DisplayName("driver's licences are qualified by province, other types are not")
  void idType(String type, String province, String expected) {
    assertThat(withId(type, province).idType()).isEqualTo(expected);
  }

  @Test
  @DisplayName("missing, blank or unknown identification type gives no id type")
  void idTypeWithoutKnownType() {
    assertThat(EMPTY.idType()).isNull();
    assertThat(withId(" ", "BC").idType()).isNull();
    assertThat(withId("XXXX", "BC").idType()).isNull();
  }

  @Test
  @DisplayName("description never contains nulls and defaults the birthdate")
  void descriptionDefaults() {
    var description = EMPTY.description();
    assertThat(description).hasSize(19).doesNotContainValue(null);
    assertThat(description).containsEntry("birthdate", LocalDate.of(1975, 1, 31));
    assertThat(description).containsEntry("identificationType", "");
    assertThat(description).containsEntry("name", "");
  }

  @Test
  @DisplayName("description carries values through")
  void descriptionValues() {
    var dto = withId("CDDL", "AB")
        .withBusinessName("Acme Ltd")
        .withBirthdate(LocalDate.of(1990, 5, 6))
        .withRegistrationNumber("FM0000001");
    assertThat(dto.description())
        .containsEntry("name", "Acme Ltd")
        .containsEntry("registrationNumber", "FM0000001")
        .containsEntry("birthdate", LocalDate.of(1990, 5, 6))
        .containsEntry("identificationType", "ABDL")
        .containsEntry("identificationProvince", "AB");
  }
}
