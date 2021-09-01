package javabeans;

import java.io.Serializable;

public class UserDetails implements Serializable {

  private static final long serialVersionUID = 88L;

  private BasicDetails basicDetails = null;
  private BasicInformation basicInformation = null;
  private BasicPreference basicPreference = null;
  private ExtraInfo extraInfo = null;
  private FamilyInformation familyInformation = null;
  private LifeStyleInfo lifeStyleInfo = null;
  private Login login = null;
  private LocationPreferences locationPreferences = null;
  private PersonalDetails personalDetails = null;
  private ProfessionPreference professionPreference = null;
  private ProfessionalDetails professionalDetails = null;
  private ReligionInformation religionInformation = null;
  private ReligionPreference religionPreference = null;
  private ProfileInfo profileInfo = null;

  public BasicPreference getBasicPreference() {
    return this.basicPreference;
  }

  public ProfileInfo getProfileInfo() {
    return this.profileInfo;
  }

  public void setProfileInfo(ProfileInfo profileInfo) {
    this.profileInfo = profileInfo;
  }

  public BasicDetails getBasicDetails() {
    return this.basicDetails;
  }

  public void setBasicDetails(BasicDetails basicDetails) {
    this.basicDetails = basicDetails;
  }

  public BasicInformation getBasicInformation() {
    return this.basicInformation;
  }

  public void setBasicInformation(BasicInformation basicInformation) {
    this.basicInformation = basicInformation;
  }

  public BasicPreference getBasicPreferance() {
    return this.basicPreference;
  }

  public void setBasicPreference(BasicPreference basicPreference) {
    this.basicPreference = basicPreference;
  }

  public ExtraInfo getExtraInfo() {
    return this.extraInfo;
  }

  public void setExtraInfo(ExtraInfo extraInfo) {
    this.extraInfo = extraInfo;
  }

  public FamilyInformation getFamilyInformation() {
    return this.familyInformation;
  }

  public void setFamilyInformation(FamilyInformation familyInformation) {
    this.familyInformation = familyInformation;
  }

  public LifeStyleInfo getLifeStyleInfo() {
    return this.lifeStyleInfo;
  }

  public void setLifeStyleInfo(LifeStyleInfo lifeStyleInfo) {
    this.lifeStyleInfo = lifeStyleInfo;
  }

  public Login getLogin() {
    return this.login;
  }

  public void setLogin(Login login) {
    this.login = login;
  }

  public LocationPreferences getLocationPreferences() {
    return this.locationPreferences;
  }

  public void setLocationPreferences(LocationPreferences locationPreferences) {
    this.locationPreferences = locationPreferences;
  }

  public PersonalDetails getPersonalDetails() {
    return this.personalDetails;
  }

  public void setPersonalDetails(PersonalDetails personalDetails) {
    this.personalDetails = personalDetails;
  }

  public ProfessionPreference getProfessionPreference() {
    return this.professionPreference;
  }

  public void setProfessionPreference(ProfessionPreference professionPreference) {
    this.professionPreference = professionPreference;
  }

  public ProfessionalDetails getProfessionalDetails() {
    return this.professionalDetails;
  }

  public void setProfessionalDetails(ProfessionalDetails professionalDetails) {
    this.professionalDetails = professionalDetails;
  }

  public ReligionInformation getReligionInformation() {
    return this.religionInformation;
  }

  public void setReligionInformation(ReligionInformation religionInformation) {
    this.religionInformation = religionInformation;
  }

  public ReligionPreference getReligionPreference() {
    return this.religionPreference;
  }

  public void setReligionPreference(ReligionPreference religionPreference) {
    this.religionPreference = religionPreference;
  }
}
