
package javabeans;

import java.io.Serializable;

public class BasicPreference implements Serializable {

  private static final long serialVersionUID = 88L;

  private int userId;
  private int age;
  private int height;
  private String eatingHabit;
  private String martialStatus;
  private String physicalStatus;
  private String drinkingHabit;
  private String smokingHabit;
  private String about;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public String getEatingHabit() {
    return eatingHabit;
  }

  public void setEatingHabit(String eatingHabit) {
    this.eatingHabit = eatingHabit;
  }

  public String getMartialStatus() {
    return martialStatus;
  }

  public void setMartialStatus(String martialStatus) {
    this.martialStatus = martialStatus;
  }

  public String getPhysicalStatus() {
    return physicalStatus;
  }

  public void setPhysicalStatus(String physicalStatus) {
    this.physicalStatus = physicalStatus;
  }

  public String getDrinkingHabit() {
    return drinkingHabit;
  }

  public void setDrinkingHabit(String drinkingHabit) {
    this.drinkingHabit = drinkingHabit;
  }

  public String getSmokingHabits() {
    return smokingHabit;
  }

  public void setSmokingHabit(String smokingHabit) {
    this.smokingHabit = smokingHabit;
  }

  public String getAbout() {
    return about;
  }

  public void setAbout(String about) {
    this.about = about;
  }
}
