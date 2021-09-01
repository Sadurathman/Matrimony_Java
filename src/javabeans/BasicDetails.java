package javabeans;

import java.io.Serializable;
import java.util.Date;

public class BasicDetails implements Serializable {

  private static final long serialVersionUID = 88L;

  private int userId;
  private String phone;
  private String gender;
  private Date dateOfBirth;
  private String motherTongue;
  private String email;
  private String religion;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getMotherTongue() {
    return motherTongue;
  }

  public void setMotherTongue(String motherTongue) {
    this.motherTongue = motherTongue;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getReligion() {
    return religion;
  }

  public void setReligion(String religion) {
    this.religion = religion;
  }
}
