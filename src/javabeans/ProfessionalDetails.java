package javabeans;

import java.io.Serializable;

public class ProfessionalDetails implements Serializable {

  private static final long serialVersionUID = 88L;

  private int userId;
  private String highestEducation;
  private String employedIn;
  private String occupation;
  private int annualIncome;
  private String workLocation;
  private String state;
  private String city;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getHighestEducation() {
    return highestEducation;
  }

  public void setHighestEducation(String highestEducation) {
    this.highestEducation = highestEducation;
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

  public String getWorkLocation() {
    return workLocation;
  }

  public void setWorkLocation(String workLocation) {
    this.workLocation = workLocation;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

}
