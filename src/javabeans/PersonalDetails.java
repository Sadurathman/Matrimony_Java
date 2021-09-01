package javabeans;

import java.io.Serializable;

public class PersonalDetails implements Serializable {

  private static final long serialVersionUID = 88L;

  private int userId;
  private String martialStatus;
  private float height;
  private String familyStatus;
  private String familyType;
  private String familyValues;
  private String anyDisAbility;
  private String about;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getMartialStatus() {
    return martialStatus;
  }

  public void setMartialStatus(String martialStatus) {
    this.martialStatus = martialStatus;
  }

  public float getHeight() {
    return height;
  }

  public void setHeight(float height) {
    this.height = height;
  }

  public String getFamilyStatus() {
    return familyStatus;
  }

  public void setFamilyStatus(String familyStatus) {
    this.familyStatus = familyStatus;
  }

  public String getFamilyType() {
    return familyType;
  }

  public void setFamilyType(String familyType) {
    this.familyType = familyType;
  }

  public String getFamilyValues() {
    return familyValues;
  }

  public void setFamilyValues(String familyValues) {
    this.familyValues = familyValues;
  }

  public String getAnyDisability() {
    return anyDisAbility;
  }

  public void setAnyDisAbility(String anyDisAbility) {
    this.anyDisAbility = anyDisAbility;
  }

  public String getAbout() {
    return about;
  }

  public void setAbout(String about) {
    this.about = about;
  }

}