package javabeans;

import java.io.Serializable;

public class ReligionInformation implements Serializable {

  private static final long serialVersionUID = 88L;

  private int userId;
  private String star;
  private String raasi;
  private String timeOfBirth;
  private String placeOfBirth;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getStar() {
    return star;
  }

  public void setStar(String star) {
    this.star = star;
  }

  public String getRaasi() {
    return raasi;
  }

  public void setRaasi(String raasi) {
    this.raasi = raasi;
  }

  public String getTimeOfBirth() {
    return timeOfBirth;
  }

  public void setTimeOfBirth(String timeOfBirth) {
    this.timeOfBirth = timeOfBirth;
  }

  public String getPlaceOfBirth() {
    return placeOfBirth;
  }

  public void setPlaceOfBirth(String placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
  }

}