package javabeans;

import java.io.Serializable;

public class ExtraInfo implements Serializable {

  private static final long serialVersionUID = 88L;

  private int userId;
  private String hobbiesAndInterest;
  private String favouriteMusic;
  private String sportsFitness;
  private String spokenLanguage;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getHobbiesAndInterest() {
    return hobbiesAndInterest;
  }

  public void setHobbiesAndInterset(String hobbiesAndInterest) {
    this.hobbiesAndInterest = hobbiesAndInterest;
  }

  public String getFavouriteMusic() {
    return favouriteMusic;
  }

  public void setFavouriteMusic(String favouriteMusic) {
    this.favouriteMusic = favouriteMusic;
  }

  public String getSportsFitness() {
    return sportsFitness;
  }

  public void setSportsFitness(String sportsFitness) {
    this.sportsFitness = sportsFitness;
  }

  public String getSpokenLanguage() {
    return spokenLanguage;
  }

  public void setSpokenLanguage(String spokenLanguage) {
    this.spokenLanguage = spokenLanguage;
  }

}