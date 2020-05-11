package taf.service;

import taf.model.User;

public class UserFactory {
  public static final  String VALID_LOGIN = "testdata.user.validlogin";
  public static final  String VALID_PASSWORD = "testdata.user.validpassword";

  public static final  String INVALID_LOGIN = "testdata.user.invalidlogin";
  public static final  String INVALID_PASSWORD = "testdata.user.invalidpassword";

  public static User withValidCredentialsFromProperty() {
    return new User(TestDataReader.getTestData(VALID_LOGIN),
        TestDataReader.getTestData(VALID_PASSWORD));
  }

  public static User withInvalidCredentialsFromProperty() {
    return new User(TestDataReader.getTestData(INVALID_LOGIN),
        TestDataReader.getTestData(INVALID_PASSWORD));
  }
}
