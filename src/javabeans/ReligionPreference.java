
package javabeans;

import java.io.Serializable;

public class ReligionPreference implements Serializable {

  private static final long serialVersionUID = 88L;

  private int userId;
  private String religion;
  private String motherTongue;
  private String caste;
  private String star;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getReligion() {
    return religion;
  }

  public void setReligion(String religion) {
    this.religion = religion;
  }

  public String getMotherTongue() {
    return motherTongue;
  }

  public void setMotherTongue(String motherTongue) {
    this.motherTongue = motherTongue;
  }

  public String getCaste() {
    return caste;
  }

  public void setCaste(String caste) {
    this.caste = caste;
  }

  public String getStar() {
    return star;
  }

  public void setStar(String star) {
    this.star = star;
  }
}
