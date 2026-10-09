package ca.bc.gov.app.dto.bcregistry;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit Test | BC Registry DTOs")
class BcRegistryDtoTest {

  private static final BcRegistryAddressDto MAILING = new BcRegistryAddressDto(
      "Victoria", "CA", "BC", "Leave at door", "V8V1V1", "1 Main St", "Unit 2", null
  );
  private static final BcRegistryAddressDto DELIVERY = new BcRegistryAddressDto(
      "Vancouver", "CA", "BC", null, "V6B1A1", "2 Main St", null, null
  );
  private static final BcRegistryOfficerDto PERSON = new BcRegistryOfficerDto(
      "jane@example.com", "Jane", "Doe", null, null, null, "person"
  );
  private static final BcRegistryOfficerDto ORGANIZATION = new BcRegistryOfficerDto(
      null, null, null, null, "FM0000001", "Acme Ltd", "organization"
  );

  private static BcRegistryRoleDto role(String type, LocalDate cessation) {
    return new BcRegistryRoleDto(LocalDate.of(2020, 1, 1), cessation, type);
  }

  private static BcRegistryPartyDto party(BcRegistryOfficerDto officer, BcRegistryRoleDto... roles) {
    return new BcRegistryPartyDto(DELIVERY, MAILING, officer, List.of(roles));
  }

  @Test
  @DisplayName("address equality ignores delivery instructions, extra street line and type")
  void addressEquality() {
    BcRegistryAddressDto sameLocation = MAILING
        .withDeliveryInstructions(null)
        .withStreetAddressAdditional("Suite 9")
        .withAddressType("delivery");
    assertThat(sameLocation).isEqualTo(MAILING).hasSameHashCodeAs(MAILING);
    assertThat(MAILING.withPostalCode("V8V2V2")).isNotEqualTo(MAILING);
    assertThat(MAILING).isNotEqualTo(null).isNotEqualTo("1 Main St");
  }

  @Test
  @DisplayName("address needs a street and a postal code")
  void addressValidity() {
    assertThat(MAILING.isValid()).isTrue();
    assertThat(MAILING.withStreetAddress(null).isValid()).isFalse();
    assertThat(MAILING.withPostalCode(null).isValid()).isFalse();
  }

  @Test
  @DisplayName("business addresses are typed as mailing and delivery")
  void businessAddresses() {
    BcRegistryBusinessAdressesDto office = new BcRegistryBusinessAdressesDto(MAILING, DELIVERY);
    assertThat(office.isValid()).isTrue();
    assertThat(office.addresses())
        .extracting(BcRegistryAddressDto::addressType)
        .containsExactlyInAnyOrder("mailing", "delivery");

    BcRegistryBusinessAdressesDto mailingOnly = new BcRegistryBusinessAdressesDto(MAILING, null);
    assertThat(mailingOnly.addresses())
        .singleElement()
        .extracting(BcRegistryAddressDto::addressType)
        .isEqualTo("mailing");
    assertThat(new BcRegistryBusinessAdressesDto(null, null).isValid()).isFalse();
  }

  @Test
  @DisplayName("offices without a valid business office have no addresses")
  void offices() {
    assertThat(new BcRegistryOfficesDto(null).addresses()).isEmpty();
    assertThat(new BcRegistryOfficesDto(null).isValid()).isFalse();
    assertThat(new BcRegistryOfficesDto(new BcRegistryBusinessAdressesDto(null, null)).addresses())
        .isEmpty();
    assertThat(new BcRegistryOfficesDto(new BcRegistryBusinessAdressesDto(MAILING, DELIVERY))
        .addresses()).hasSize(2);
  }

  @Test
  @DisplayName("officer is a person only when party type is Person, any case")
  void officerIsPerson() {
    assertThat(PERSON.isPerson()).isTrue();
    assertThat(ORGANIZATION.isPerson()).isFalse();
    assertThat(new BcRegistryOfficerDto(null, null, null, null, null, null, null).isPerson())
        .isFalse();
  }

  @Test
  @DisplayName("role is active until its cessation date")
  void roleActive() {
    assertThat(role("Proprietor", null).active()).isTrue();
    assertThat(role("Proprietor", LocalDate.now().plusDays(1)).active()).isTrue();
    assertThat(role("Proprietor", LocalDate.now()).active()).isFalse();
    assertThat(role("Proprietor", LocalDate.now().minusDays(1)).active()).isFalse();
  }

  @Test
  @DisplayName("party is a proprietor only with an active Proprietor role")
  void partyIsProprietor() {
    assertThat(party(PERSON, role("proprietor", null)).isProprietor()).isTrue();
    assertThat(party(PERSON, role("Partner", null)).isProprietor()).isFalse();
    assertThat(party(PERSON, role("Proprietor", LocalDate.now().minusDays(1))).isProprietor())
        .isFalse();
    assertThat(party(PERSON).withRoles(null).isProprietor()).isFalse();
  }

  @Test
  @DisplayName("party validity, person and address matching")
  void partyMatching() {
    BcRegistryPartyDto party = party(PERSON);
    assertThat(party.isValid()).isTrue();
    assertThat(party.withOfficer(null).isValid()).isFalse();
    assertThat(party.withMailingAddress(null).withDeliveryAddress(null).isValid()).isFalse();
    assertThat(party.isPerson()).isTrue();
    assertThat(party.withOfficer(ORGANIZATION).isPerson()).isFalse();
    assertThat(party.addresses()).containsExactlyInAnyOrder(MAILING, DELIVERY);
    assertThat(party.isMatch("Victoria", "CA", "BC", "V8V1V1", "1 Main St")).isTrue();
    assertThat(party.isMatch("Victoria", "CA", "BC", "V8V1V1", "9 Other St")).isFalse();
  }

  @Test
  @DisplayName("document finds the first active proprietor and person ownership")
  void document() {
    BcRegistryPartyDto partner = party(ORGANIZATION, role("Partner", null));
    BcRegistryPartyDto proprietor = party(PERSON, role("Proprietor", null));
    BcRegistryDocumentDto document =
        new BcRegistryDocumentDto(null, null, List.of(partner, proprietor));
    assertThat(document.getProprietor()).isSameAs(proprietor);
    assertThat(document.isOwnedByPerson()).isTrue();

    BcRegistryDocumentDto companyOnly = document.withParties(List.of(partner));
    assertThat(companyOnly.getProprietor()).isNull();
    assertThat(companyOnly.isOwnedByPerson()).isFalse();

    BcRegistryDocumentDto noParties = document.withParties(null);
    assertThat(noParties.getProprietor()).isNull();
    assertThat(noParties.isOwnedByPerson()).isFalse();
  }

  @Test
  @DisplayName("resolved legal name prefers the earliest registered alternate name")
  void resolvedLegalName() {
    BcRegistryBusinessDto business = new BcRegistryBusinessDto(
        null, true, false, false, false, "FM0000001", "DOE, JANE", "SP", "ACTIVE"
    );
    assertThat(business.getResolvedLegalName()).isEqualTo("DOE, JANE");
    assertThat(business.withAlternateNames(List.of()).getResolvedLegalName())
        .isEqualTo("DOE, JANE");

    BcRegistryBusinessDto withNames = business.withAlternateNames(List.of(
        alternateName("Later Name", 2022),
        alternateName("Earliest Name", 2019),
        alternateName("Middle Name", 2020)
    ));
    assertThat(withNames.getResolvedLegalName()).isEqualTo("Earliest Name");
  }

  private static BcRegistryAlternateNameDto alternateName(String name, int year) {
    return new BcRegistryAlternateNameDto(
        "SP", "FM0000001", name,
        ZonedDateTime.of(year, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC), LocalDate.of(year, 1, 1)
    );
  }
}
