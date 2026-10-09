package ca.bc.gov.app.dto.legacy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Unit Test | ForestClientDto")
class ForestClientDtoTest {

  private static final ForestClientDto CLIENT = new ForestClientDto(
      "00000001", "Doe", "Jane", "Q", "ACT", "I",
      LocalDate.of(1980, 1, 1), "BCDL", "1234567", "BC", "0123456",
      null, "creator", "updater", 70L, null, null, null
  );

  @Test
  @DisplayName("individual legal name joins first, middle and last names")
  void individualLegalName() {
    assertThat(CLIENT.legalName()).isEqualTo("Jane Q Doe");
  }

  @Test
  @DisplayName("individual legal name skips blank parts")
  void individualLegalNameSkipsBlanks() {
    assertThat(CLIENT.withLegalMiddleName(null).legalName()).isEqualTo("Jane Doe");
    assertThat(CLIENT.withLegalMiddleName("  ").legalName()).isEqualTo("Jane Doe");
  }

  @ParameterizedTest
  @CsvSource({"C", "S", "i"})
  @DisplayName("only type I is treated as an individual, case-insensitively")
  void legalNameByType(String type) {
    String expected = "i".equals(type) ? "Jane Q Doe" : "Doe";
    assertThat(CLIENT.withClientTypeCode(type).legalName()).isEqualTo(expected);
  }

  @Test
  @DisplayName("non-individual legal name is the client name, never null")
  void nonIndividualLegalName() {
    ForestClientDto corporation = CLIENT.withClientTypeCode("C").withClientName(null);
    assertThat(corporation.legalName()).isEmpty();
    assertThat(CLIENT.withClientTypeCode(null).withClientName("Acme").legalName())
        .isEqualTo("Acme");
  }

  @Test
  @DisplayName("description maps codes to enums and builds the identifier")
  void description() {
    assertThat(CLIENT.description("someone"))
        .containsOnly(
            entry("userName", "someone"),
            entry("number", "00000001"),
            entry("name", "Jane Q Doe"),
            entry("status", ClientStatusCodeEnum.ACT),
            entry("type", ClientTypeCodeEnum.I),
            entry("identifier", "BC0123456")
        );
  }

  @Test
  @DisplayName("description identifier tolerates missing registry parts")
  void descriptionWithoutRegistry() {
    ForestClientDto noRegistry = CLIENT
        .withRegistryCompanyTypeCode(null)
        .withCorpRegnNmbr(null);
    assertThat(noRegistry.description("someone")).containsEntry("identifier", "");
  }
}
