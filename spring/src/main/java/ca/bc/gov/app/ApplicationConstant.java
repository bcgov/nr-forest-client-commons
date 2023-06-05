package ca.bc.gov.app;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * This class contains constants used throughout the application.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ApplicationConstant {
  public static final String ORACLE_ATTRIBUTE_SCHEMA = "THE";
  public static final String POSTGRES_ATTRIBUTE_SCHEMA = "nrfc";

  public static final String USERID_HEADER = "x-user-id";
  public static final String USERMAIL_HEADER = "x-user-email";
}
