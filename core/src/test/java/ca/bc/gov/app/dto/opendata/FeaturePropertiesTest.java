package ca.bc.gov.app.dto.opendata;

import static org.assertj.core.api.Assertions.assertThat;

import ca.bc.gov.app.dto.legacy.ClientTypeCodeEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit Test | FeatureProperties")
class FeaturePropertiesTest {

  private static FeatureProperties feature(
      String bcName, String bandName, String tribeName,
      int federalId, int bandNumber, int tribeNumber
  ) {
    return new FeatureProperties(
        "gml", 1, bandNumber, tribeNumber, bandName, tribeName, 0, bcName, null, federalId,
        null, null, null, null, null, null, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null
    );
  }

  @Test
  @DisplayName("nation name prefers BC name, then band, then tribal council")
  void nationName() {
    assertThat(feature("BC Name", "Band", "Tribe", 0, 0, 0).getNationName()).isEqualTo("BC Name");
    assertThat(feature(" ", "Band", "Tribe", 0, 0, 0).getNationName()).isEqualTo("Band");
    assertThat(feature(null, null, "Tribe", 0, 0, 0).getNationName()).isEqualTo("Tribe");
    assertThat(feature(null, null, null, 0, 0, 0).getNationName()).isEmpty();
  }

  @Test
  @DisplayName("nation id prefers federal id, then band, then tribal council, skipping zeros")
  void nationId() {
    assertThat(feature(null, null, null, 600, 601, 602).getNationId()).isEqualTo(600);
    assertThat(feature(null, null, null, 0, 601, 602).getNationId()).isEqualTo(601);
    assertThat(feature(null, null, null, -1, 0, 602).getNationId()).isEqualTo(602);
    assertThat(feature(null, null, null, 0, 0, 0).getNationId()).isZero();
  }

  @Test
  @DisplayName("a named tribal council is type T, otherwise a band (B)")
  void firstNationType() {
    assertThat(feature(null, "Band", "Tribe", 0, 0, 0).getFirstNationType())
        .isEqualTo(ClientTypeCodeEnum.T);
    assertThat(feature(null, "Band", " ", 0, 0, 0).getFirstNationType())
        .isEqualTo(ClientTypeCodeEnum.B);
    assertThat(feature(null, "Band", null, 0, 0, 0).getFirstNationType())
        .isEqualTo(ClientTypeCodeEnum.B);
  }
}
