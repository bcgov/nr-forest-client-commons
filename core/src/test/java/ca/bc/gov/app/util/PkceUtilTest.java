package ca.bc.gov.app.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit Test | PkceUtil")
class PkceUtilTest {

  private static final String URL_SAFE_43 = "^[A-Za-z0-9_-]{43}$";

  @Test
  @DisplayName("should generate code verifier")
  void shouldGenerateCodeVerifier() {
    assertThat(PkceUtil.generateCodeVerifier())
        .isNotNull()
        .isNotEmpty()
        .hasSize(43)
        .matches(URL_SAFE_43);
  }

  @Test
  @DisplayName("should generate a different code verifier each time")
  void shouldGenerateUniqueCodeVerifiers() {
    Set<String> verifiers = new HashSet<>();
    for (int i = 0; i < 100; i++) {
      verifiers.add(PkceUtil.generateCodeVerifier());
    }
    assertThat(verifiers).hasSize(100);
  }

  @Test
  @DisplayName("should generate code challenge")
  void shouldGenerateCodeChallenge() throws NoSuchAlgorithmException {
    assertThat(PkceUtil.generateCodeChallenge(PkceUtil.generateCodeVerifier()))
        .isNotNull()
        .isNotEmpty()
        .hasSize(43)
        .matches(URL_SAFE_43);
  }

  @Test
  @DisplayName("should match the RFC 7636 S256 example")
  void shouldMatchRfc7636Example() throws NoSuchAlgorithmException {
    // RFC 7636, Appendix B
    assertThat(PkceUtil.generateCodeChallenge("dBjftJeZ4CVP-mB92K27uhbUJU1p1r_wW1gFWFOEjXk"))
        .isEqualTo("E9Melhoa2OwvFrEMTJguCHaoeK1t8URWbuGJSstw-cM");
  }
}
