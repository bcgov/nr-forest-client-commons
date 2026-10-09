package ca.bc.gov.app.dto.client;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit Test | ClientAddressDto and ClientContactDto")
class ClientLocationAndContactDtoTest {

  private static final ClientValueTextDto CANADA = new ClientValueTextDto("CA", "Canada");
  private static final ClientValueTextDto BC = new ClientValueTextDto("BC", "British Columbia");

  private static final ClientAddressDto ADDRESS = new ClientAddressDto(
      "1 Main St", null, null, CANADA, BC, "Victoria", "V8V1V1",
      "2505550100", null, null, "office@example.com", null, 0, "Head office"
  );

  private static final ClientContactDto CONTACT = new ClientContactDto(
      new ClientValueTextDto("BL", "Billing"), "Jane", "Doe", "2505550100", null, null,
      "jane@example.com", 0, List.of(new ClientValueTextDto("0", "Head office"))
  );

  @Test
  @DisplayName("address is valid only with street, country, province, city, postal code and name")
  void addressValidity() {
    assertThat(ADDRESS.isValid()).isTrue();
    assertThat(ADDRESS.withStreetAddress(" ").isValid()).isFalse();
    assertThat(ADDRESS.withCountry(null).isValid()).isFalse();
    assertThat(ADDRESS.withCountry(new ClientValueTextDto("", "Canada")).isValid()).isFalse();
    assertThat(ADDRESS.withProvince(null).isValid()).isFalse();
    assertThat(ADDRESS.withCity(null).isValid()).isFalse();
    assertThat(ADDRESS.withPostalCode("").isValid()).isFalse();
    assertThat(ADDRESS.withLocationName(null).isValid()).isFalse();
  }

  @Test
  @DisplayName("address description is keyed by index and uses display text")
  @SuppressWarnings("unchecked")
  void addressDescription() {
    Map<String, Object> description = ADDRESS.withIndexed(2).description();
    assertThat(description).containsOnlyKeys("address.[2]");
    Map<String, Object> fields = (Map<String, Object>) description.get("address.[2]");
    assertThat(fields)
        .containsEntry("name", "Head office")
        .containsEntry("country", "Canada")
        .containsEntry("province", "British Columbia")
        .containsEntry("complementaryAddressOne", "")
        .doesNotContainValue(null);
  }

  @Test
  @DisplayName("withIndexed keeps the same instance when the index is unchanged")
  void withIndexed() {
    assertThat(ADDRESS.withIndexed(0)).isSameAs(ADDRESS);
    assertThat(ADDRESS.withIndexed(3).index()).isEqualTo(3);
    assertThat(CONTACT.withIndexed(0)).isSameAs(CONTACT);
    assertThat(CONTACT.withIndexed(1).index()).isEqualTo(1);
  }

  @Test
  @DisplayName("contact is valid only with names, phone and email")
  void contactValidity() {
    assertThat(CONTACT.isValid()).isTrue();
    assertThat(CONTACT.withFirstName("").isValid()).isFalse();
    assertThat(CONTACT.withLastName(null).isValid()).isFalse();
    assertThat(CONTACT.withPhoneNumber(" ").isValid()).isFalse();
    assertThat(CONTACT.withEmail(null).isValid()).isFalse();
    assertThat(CONTACT.withFaxNumber(null).withSecondaryPhoneNumber(null).isValid()).isTrue();
  }

  @Test
  @DisplayName("contact description is keyed by index and joins the name")
  @SuppressWarnings("unchecked")
  void contactDescription() {
    Map<String, Object> description = CONTACT.withIndexed(1).description();
    assertThat(description).containsOnlyKeys("contact.[1]");
    assertThat((Map<String, Object>) description.get("contact.[1]"))
        .containsEntry("name", "Jane Doe")
        .containsEntry("phone", "2505550100")
        .containsEntry("faxNumber", "")
        .containsEntry("email", "jane@example.com");
  }
}
