
package javabeans;

import java.io.Serializable;

public class ProfessionPreference implements Serializable {

  private static final long serialVersionUID = 88L;

  private int userId;
  private String education;
  private String employedIn;
  private String occupation;
  private int annualIncome;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public String getEmployedIn() {
    return employedIn;
  }

  public void setEmployedIn(String employedIn) {
    this.employedIn = employedIn;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public int getAnnualIncome() {
    return annualIncome;
  }

  public void setAnnualIncome(int annualIncome) {
    this.annualIncome = annualIncome;
  }
}
