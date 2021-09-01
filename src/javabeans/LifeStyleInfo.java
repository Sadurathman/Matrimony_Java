
package javabeans;

import java.io.Serializable;

public class LifeStyleInfo implements Serializable {

  private static final long serialVersionUID = 88L;

  private int userId;
  private String eatingHabit;
  private String drinkingHabit;
  private String smokingHabit;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getEatingHabit() {
    return eatingHabit;
  }

  public void setEatingHabit(String eatingHabit) {
    this.eatingHabit = eatingHabit;
  }

  public String getDrinkingHabit() {
    return drinkingHabit;
  }

  public void setDrinkingHabit(String drinkingHabit) {
    this.drinkingHabit = drinkingHabit;
  }

  public String getSmokingHabit() {
    return smokingHabit;
  }

  public void setSmokingHabit(String smokingHabit) {
    this.smokingHabit = smokingHabit;
  }
}
