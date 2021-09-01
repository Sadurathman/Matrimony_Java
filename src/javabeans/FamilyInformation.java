package javabeans;

import java.io.Serializable;

public class FamilyInformation implements Serializable {

  private static final long serialVersionUID = 88L;

  private int userId;
  private String fatherStatus;
  private String motherStatus;
  private String siblings;
  private String location;
  private String contactNo;

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public void setFatherStatus(String fatherStatus) {
    this.fatherStatus = fatherStatus;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserID(int userId) {
    this.userId = userId;
  }

  public String getFatherStatus() {
    return fatherStatus;
  }

  public void set(String fatherStatus) {
    this.fatherStatus = fatherStatus;
  }

  public String getMotherStatus() {
    return motherStatus;
  }

  public void setMotherStatus(String motherStatus) {
    this.motherStatus = motherStatus;
  }

  public String getSiblings() {
    return siblings;
  }

  public void setSiblings(String siblings) {
    this.siblings = siblings;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getContactNo() {
    return contactNo;
  }

  public void setContactNo(String contactNo) {
    this.contactNo = contactNo;
  }

}