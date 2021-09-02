package javabeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.ImageIcon;

public class ProfileInfo implements Serializable, Comparable<ProfileInfo>{
  private static final long serialVersionUID = 88L;

  private int userId;
  private ImageIcon profileImageIcon;
  private String name;
  private int age;
  private float height;
  private String motherTongue;
  private String state;
  private String city;
  private String religion;
  private String highestEducation;
  private String occupation;
  private String employedIn;
  private HashSet<Integer> pairRequest;
  private HashSet<Integer> acceptedPair;
  private HashSet<Integer> pairDeclined;
  private HashMap<Integer, Integer> chatHistoryIds;
  private HashSet<Integer> requestedPair;

  public int getUserId() {
    return this.userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public ImageIcon getProfileImageIcon() {
    return this.profileImageIcon;
  }

  public void setProfileImageIcon(ImageIcon profileImageIcon) {
    this.profileImageIcon = profileImageIcon;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public float getHeight() {
    return this.height;
  }

  public void setHeight(float height) {
    this.height = height;
  }

  public String getMotherTongue() {
    return this.motherTongue;
  }

  public void setMotherTongue(String motherTongue) {
    this.motherTongue = motherTongue;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getReligion() {
    return this.religion;
  }

  public void setReligion(String religion) {
    this.religion = religion;
  }

  public String getHighestEducation() {
    return this.highestEducation;
  }

  public void setHighestEducation(String highestEducation) {
    this.highestEducation = highestEducation;
  }

  public String getOccupation() {
    return this.occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public String getEmployedIn() {
    return this.employedIn;
  }

  public void setEmployedIn(String employedIn) {
    this.employedIn = employedIn;
  }

  public HashSet<Integer> getPairRequest() {
    return this.pairRequest;
  }

  public void setPairRequest(HashSet<Integer> pairRequest) {
    this.pairRequest = pairRequest;
  }

  public HashSet<Integer> getAcceptedPair() {
    return this.acceptedPair;
  }

  public void setAcceptedPair(HashSet<Integer> acceptedPair) {
    this.acceptedPair = acceptedPair;
  }

  public HashSet<Integer> getPairDeclined() {
    return this.pairDeclined;
  }

  public void setPairDeclined(HashSet<Integer> pairDeclined) {
    this.pairDeclined = pairDeclined;
  }

  public HashMap<Integer, Integer> getChatHistoryIds() {
    return this.chatHistoryIds;
  }

  public void setChatHistoryIds(HashMap<Integer, Integer> chatHistoryIds) {
    this.chatHistoryIds = chatHistoryIds;
  }

  public HashSet<Integer> getRequestedPair() {
    return this.requestedPair;
  }

  public void setRequestedPair(HashSet<Integer> requestedPair) {
    this.requestedPair = requestedPair;
  }

  public boolean compareTo(int id){
    return userId > id;
  }

  @Override
  public int compareTo(ProfileInfo o) {
    return this.getUserId()-(o.getUserId());
  }
}