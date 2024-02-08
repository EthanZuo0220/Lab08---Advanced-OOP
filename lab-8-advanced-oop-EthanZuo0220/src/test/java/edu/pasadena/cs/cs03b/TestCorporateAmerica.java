package edu.pasadena.cs.cs03b;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

// TODO: implement additional Test Classes for each class in the project
public class TestCorporateAmerica {

  @Test
  public void testCompanyName() {
    // create an instance of the class
    CorporateAmerica c = new CorporateAmerica();

    // action
    c.setCompanyName("Dummy Company");
    String strResult = c.getCompanyName();
    // assertion
    assertEquals("Dummy Company", strResult);

    // TODO: add more test cases for all public instance methods
    c.employer = new Employer("Dummy Employer");
    strResult = c.employer.getName();
    // assertion
    assertEquals("Dummy Employer", strResult);
    c.employer.setName("New Employer");
    strResult = c.employer.getName();
    // assertion
    assertEquals("New Employer", strResult);
    c.employer.displayInfo();
    c.displayAllPersonnel();
    c.setCompanyName("New Company");
    strResult = c.getCompanyName();
    // assertion
    assertEquals("New Company", strResult);
    c.setEmployer(c.employer);
    assertEquals(c.getEmployer(), c.employer);
    c.employer.displayEmployerInfo();
  }
}
