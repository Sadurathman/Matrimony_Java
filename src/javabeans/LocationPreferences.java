
package javabeans;

import java.io.Serializable;

public class LocationPreferences implements Serializable {

  private static final long serialVersionUID = 88L;

  private int userId;
  private String country;
  private String residingState;
  private String district;
  private String city;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getResidingState() {
    return residingState;
  }

  public void setResidingState(String residingState) {
    this.residingState = residingState;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
