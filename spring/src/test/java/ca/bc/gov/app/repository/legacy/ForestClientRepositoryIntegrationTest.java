package ca.bc.gov.app.repository.legacy;

import static org.assertj.core.api.Assertions.assertThat;

import ca.bc.gov.app.entity.legacy.ForestClientEntity;
import ca.bc.gov.app.extensions.AbstractTestContainerIntegrationTest;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.test.StepVerifier;

@Slf4j
@DisplayName("Integrated Test | Forest Client Repository")
public class ForestClientRepositoryIntegrationTest extends AbstractTestContainerIntegrationTest {
  @Autowired
  protected ForestClientRepository forestClientRepository;

  @Test
  @DisplayName("Should Return One First Nation Band Client")
  void shouldReturnAllFirstNationBandClients() {
    StepVerifier
        .create(forestClientRepository.findAllFirstNationBandClients())
        .assertNext(forestClientEntity ->
            assertThat(forestClientEntity)
                .isNotNull()
                .hasFieldOrPropertyWithValue("clientNumber", "00000004")
                .hasFieldOrPropertyWithValue("clientName", "SAMPLE INDIAN BAND COUNCIL"))
        .verifyComplete();
  }

  @Test
  @DisplayName("Should Return Two Clients based on Incorporation Number or Name")
  void shouldReturnClientByIncorporationNumberOrName() {
    StepVerifier
        .create(forestClientRepository
            .findClientByIncorporationOrName("00000002", "BAXTER"))
        .assertNext(forestClientEntity ->
            assertThat(forestClientEntity)
                .isNotNull()
                .hasFieldOrPropertyWithValue("clientNumber", "00000001")
                .hasFieldOrPropertyWithValue("clientName", "BAXTER"))
        .assertNext(forestClientEntity ->
            assertThat(forestClientEntity)
                .isNotNull()
                .hasFieldOrPropertyWithValue("clientNumber", "00000002")
                .hasFieldOrPropertyWithValue("clientName", "FUNNY"))
        .verifyComplete();
  }

  @Test
  @DisplayName("Should Return One Client based on similar name")
  void shouldReturnSimilarCompanyNames() {
    StepVerifier
        .create(forestClientRepository
            .matchBy("bond"))
        .assertNext(forestClientEntity ->
            assertThat(forestClientEntity)
                .isNotNull()
                .hasFieldOrPropertyWithValue("clientNumber", "00000007")
                .hasFieldOrPropertyWithValue("clientName", "bond"))
        .assertNext(forestClientEntity ->
            assertThat(forestClientEntity)
                .isNotNull()
                .hasFieldOrPropertyWithValue("clientNumber", "00000010")
                .hasFieldOrPropertyWithValue("clientName", "bbondd"))
        .verifyComplete();
  }

  @Test
  @DisplayName("Should Return One Client based on Incorporation Number")
  void shouldReturnClientByIncorporationNumber() {
    StepVerifier
        .create(forestClientRepository
            .findByIncorporationNumber("00000001"))
        .assertNext(forestClientEntity ->
            assertThat(forestClientEntity)
                .isNotNull()
                .hasFieldOrPropertyWithValue("clientNumber", "00000001")
                .hasFieldOrPropertyWithValue("clientName", "BAXTER"))
        .verifyComplete();
  }
}
