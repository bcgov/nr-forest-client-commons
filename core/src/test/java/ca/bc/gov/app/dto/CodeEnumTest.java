package ca.bc.gov.app.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ca.bc.gov.app.dto.ches.ChesMailBodyType;
import ca.bc.gov.app.dto.ches.ChesMailEncoding;
import ca.bc.gov.app.dto.ches.ChesMailPriority;
import ca.bc.gov.app.dto.client.BusinessTypeEnum;
import ca.bc.gov.app.dto.client.ClientTypeEnum;
import ca.bc.gov.app.dto.client.IdentificationTypeEnum;
import ca.bc.gov.app.dto.client.LegalTypeEnum;
import ca.bc.gov.app.dto.client.StepMatchEnum;
import ca.bc.gov.app.dto.client.SubmissionStatusEnum;
import ca.bc.gov.app.dto.client.SubmissionTypeCodeEnum;
import ca.bc.gov.app.dto.client.ValidationSourceEnum;
import ca.bc.gov.app.dto.legacy.ClientStatusCodeEnum;
import ca.bc.gov.app.dto.legacy.ClientTypeCodeEnum;
import ca.bc.gov.app.dto.submissions.SubmissionProcessKindEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@DisplayName("Unit Test | Code enums")
class CodeEnumTest {

  private static final String UNKNOWN = "not-a-code";

  @ParameterizedTest
  @EnumSource(ChesMailBodyType.class)
  @DisplayName("CHES body type round-trips through its JSON value")
  void chesMailBodyType(ChesMailBodyType type) {
    assertThat(ChesMailBodyType.fromValue(type.value())).isSameAs(type);
  }

  @ParameterizedTest
  @EnumSource(ChesMailEncoding.class)
  @DisplayName("CHES encoding round-trips through its JSON value")
  void chesMailEncoding(ChesMailEncoding encoding) {
    assertThat(ChesMailEncoding.fromValue(encoding.value())).isSameAs(encoding);
  }

  @ParameterizedTest
  @EnumSource(ChesMailPriority.class)
  @DisplayName("CHES priority round-trips through its JSON value")
  void chesMailPriority(ChesMailPriority priority) {
    assertThat(ChesMailPriority.fromValue(priority.value())).isSameAs(priority);
  }

  @ParameterizedTest
  @EnumSource(SubmissionStatusEnum.class)
  @DisplayName("submission status round-trips through its description")
  void submissionStatus(SubmissionStatusEnum status) {
    assertThat(SubmissionStatusEnum.fromValue(status.value())).isSameAs(status);
  }

  @ParameterizedTest
  @EnumSource(SubmissionTypeCodeEnum.class)
  @DisplayName("submission type round-trips through its description")
  void submissionTypeCode(SubmissionTypeCodeEnum type) {
    assertThat(SubmissionTypeCodeEnum.fromValue(type.value())).isSameAs(type);
  }

  @ParameterizedTest
  @EnumSource(ClientStatusCodeEnum.class)
  @DisplayName("legacy client status is looked up by description")
  void clientStatusCode(ClientStatusCodeEnum status) {
    assertThat(ClientStatusCodeEnum.fromValue(status.getDescription())).isSameAs(status);
  }

  @ParameterizedTest
  @EnumSource(ClientTypeCodeEnum.class)
  @DisplayName("legacy client type is looked up by description")
  void clientTypeCode(ClientTypeCodeEnum type) {
    assertThat(ClientTypeCodeEnum.fromValue(type.getDescription())).isSameAs(type);
  }

  @Test
  @DisplayName("label-keyed enums reject unknown values")
  void labelKeyedEnumsRejectUnknownValues() {
    assertThatThrownBy(() -> ChesMailBodyType.fromValue(UNKNOWN))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(UNKNOWN);
    assertThatThrownBy(() -> ChesMailEncoding.fromValue(UNKNOWN))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> ChesMailPriority.fromValue(UNKNOWN))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> SubmissionStatusEnum.fromValue(UNKNOWN))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> SubmissionTypeCodeEnum.fromValue(UNKNOWN))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> ClientStatusCodeEnum.fromValue("ACT"))
        .isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> ClientTypeCodeEnum.fromValue("C"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("legacy codes resolve to their descriptions")
  void legacyCodeDescriptions() {
    assertThat(ClientTypeCodeEnum.fromValue("Corporation")).isEqualTo(ClientTypeCodeEnum.C);
    assertThat(ClientTypeCodeEnum.fromValue("First Nation Tribal Council"))
        .isEqualTo(ClientTypeCodeEnum.T);
    assertThat(ClientStatusCodeEnum.fromValue("Active")).isEqualTo(ClientStatusCodeEnum.ACT);
    assertThat(SubmissionStatusEnum.fromValue("Approved")).isEqualTo(SubmissionStatusEnum.A);
  }

  @ParameterizedTest
  @EnumSource(IdentificationTypeEnum.class)
  @DisplayName("identification type is looked up by name")
  void identificationType(IdentificationTypeEnum type) {
    assertThat(IdentificationTypeEnum.fromValue(type.name())).isSameAs(type);
  }

  @ParameterizedTest
  @EnumSource(StepMatchEnum.class)
  @DisplayName("step match is looked up by name")
  void stepMatch(StepMatchEnum step) {
    assertThat(StepMatchEnum.fromValue(step.name())).isSameAs(step);
  }

  @ParameterizedTest
  @EnumSource(ClientTypeEnum.class)
  @DisplayName("client type is looked up by name")
  void clientType(ClientTypeEnum type) {
    assertThat(ClientTypeEnum.fromValue(type.name())).isSameAs(type);
  }

  @ParameterizedTest
  @EnumSource(LegalTypeEnum.class)
  @DisplayName("legal type is looked up by name")
  void legalType(LegalTypeEnum type) {
    assertThat(LegalTypeEnum.fromValue(type.name())).isSameAs(type);
  }

  @ParameterizedTest
  @EnumSource(ValidationSourceEnum.class)
  @DisplayName("validation source is looked up by name")
  void validationSource(ValidationSourceEnum source) {
    assertThat(ValidationSourceEnum.fromValue(source.name())).isSameAs(source);
  }

  @ParameterizedTest
  @EnumSource(BusinessTypeEnum.class)
  @DisplayName("business type is looked up by name")
  void businessType(BusinessTypeEnum type) {
    assertThat(BusinessTypeEnum.fromValue(type.name())).isSameAs(type);
  }

  @Test
  @DisplayName("name-keyed enums return null for unknown values")
  void nameKeyedEnumsReturnNullForUnknownValues() {
    assertThat(IdentificationTypeEnum.fromValue(UNKNOWN)).isNull();
    assertThat(StepMatchEnum.fromValue(UNKNOWN)).isNull();
    assertThat(ClientTypeEnum.fromValue(UNKNOWN)).isNull();
    assertThat(LegalTypeEnum.fromValue(UNKNOWN)).isNull();
    assertThat(ValidationSourceEnum.fromValue(UNKNOWN)).isNull();
    assertThat(BusinessTypeEnum.fromValue(UNKNOWN)).isNull();
  }

  @Test
  @DisplayName("submission process kind defaults to COLD")
  void submissionProcessKindDefaultsToCold() {
    assertThat(SubmissionProcessKindEnum.fromValue("HOT")).isEqualTo(SubmissionProcessKindEnum.HOT);
    assertThat(SubmissionProcessKindEnum.fromValue("COLD"))
        .isEqualTo(SubmissionProcessKindEnum.COLD);
    assertThat(SubmissionProcessKindEnum.fromValue(UNKNOWN))
        .isEqualTo(SubmissionProcessKindEnum.COLD);
    assertThat(SubmissionProcessKindEnum.fromValue(null))
        .isEqualTo(SubmissionProcessKindEnum.COLD);
  }
}
