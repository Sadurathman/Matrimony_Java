
/*
select owner, table_name from all_tables where owner='MATRIMONY';

create sequence id start with 995 increment by 1 nocache nocycle;

delete login;
delete profileinfo;
delete basicdetails;
delete professionaldetails;
delete lifestyle;
delete basicinformation;
delete ProfessionPreferences;
delete LocationPreferences;
delete Religionpreferences;
delete Basicpreferences;
delete Religioninformation;
delete ExtraInfo;
delete Familyinformation;
delete Personaldetails;

create table Login 
(
  username varchar(50),
  password varchar(20),
  isAdmin number,
  userId number primary key
); 

create table ProfileInfo
(
  profileImageIcon Blob,
  name varchar(40),
  age number,
  height float,
  pairRequest varchar(1000),
  acceptedPair varchar(1000),
  pairDeclined varchar(1000),
  requestedPair varchar(1000),
  chatHistoryId varchar(2000),
  userId number primary key
);

create table BasicDetails
(
  phone varchar(10),
  gender varchar(10),
  dateofbirth date,
  mothertongue varchar(30),
  email varchar(50),
  religion varchar(30),
  userId number primary key
); 

create table ProfessionalDetails
(
  highesteducation varchar(40),
  employedIn varchar(50),
  occupation varchar(50),
  annualIncome number,
  workLocation varchar(50),
  city varchar(50),
  state varchar(30),
  userId number primary key
);

create table Lifestyleinfo
(
  eatinghabit varchar(50),
  drinkinghabit varchar(50),
  smokinghabit varchar(50),
  userId number primary key
);

create table BasicInformation
(
  bodyType varchar(50),
  weight number,
  college varchar(50),
  organization varchar(50),
  userId number primary key
);

Create table ProfessionPreferences
(
  education varchar(50),
  employedin varchar(50),
  occupation varchar(50 ),
  annualincome number,
  userId number primary key
);

Create table LocationPreferences
(
  country varchar(50),
  residingstate varchar(50),
  district varchar(50),
  city varchar(50),
  userId number primary key
);

Create table Religionpreferences
(
  religion varchar(50),
  motherTongue varchar(50),
  Caste varchar(50),
  Star varchar(50),
  userId number primary key
);

Create table Basicpreferences
(
   age number,
   height Float,
   eatinghabit varchar(50),
   martialstatus varchar(50),
   physicalstatus varchar(50),
   drinkinghabits varchar(50),
   smokinghabits varchar(50),
   about varchar(1000),
   userId number primary key
  );

  create table Religioninformation
  (
    star varchar(50),
    raasi varchar(50),
    timeofbirth date,
    placeofbirth varchar(50),
    userId number primary key
  );

  create table ExtraInfo
  (
    hobbiesandinterest varchar(50),
    favouritemusic varchar(50),
    sportsfitness varchar(50),
    spokenlanguage varchar(50),
    userId number primary key
  );

  create table Familyinformation
  (
    fatherstatus varchar(15),
    motherstatus varchar(15),
    siblings varchar(15),
    location varchar(50),
    contactno number(10),
    userId number primary key
  );


   create table Personaldetails 
   (
     maritalstatus varchar(20),
     height float,
     familystatus varchar(50),
     familytype varchar(50),
     familyvalues varchar(50),
     anydisability varchar(50),
     about varchar(400),
     userId number primary key
  );

*/
package server.java;

import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

import java.io.File;
import java.sql.*;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.HashSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javabeans.BasicDetails;
import javabeans.BasicInformation;
import javabeans.BasicPreference;
import javabeans.ExtraInfo;
import javabeans.FamilyInformation;
import javabeans.LifeStyleInfo;
import javabeans.LocationPreferences;
import javabeans.Login;
import javabeans.PersonalDetails;
import javabeans.ProfessionPreference;
import javabeans.ProfessionalDetails;
import javabeans.ProfileInfo;
import javabeans.Profiles;
import javabeans.ReligionInformation;
import javabeans.ReligionPreference;
import javabeans.UserDetails;

import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class Database {
  Color error;
  private Connection con;
  private String query;
  private PreparedStatement ps;
  private ResultSet rs;

  public Database() {
    error = Color.RED;
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "matrimony", "lifejourney");
    } catch (Exception e) {
      Server.logWriter(" Database Connection Error   -->" + e, error);
    }
  }

  public void close() {
    try {
      if (con != null)
        con.close();
    } catch (Exception e) {
      Server.logWriter(" Database Connection Close Error -->" + e, error);
    }
  }

  public Login login(String username, String password) {
    query = "select * from login where username = ? and password = ?";
    try {
      ps = con.prepareStatement(query);
      ps.setString(1, username);
      ps.setString(2, password);
      rs = ps.executeQuery();
      if (rs.next()) {
        Login data = new Login();
        data.setUserName(rs.getString(1));
        data.setPassword(rs.getString(2));
        data.setIsAdmin(rs.getInt(3) == 1);
        data.setUserID(rs.getInt(4));
        return data;
      }
    } catch (Exception e) {

      Server.logWriter(" Login Error   -->" + e, error);
    }
    return null;
  }

  public Login register(UserDetails userDetails) {
    if (isUsernameExsist(userDetails.getLogin().getUserName()))
      return null;
    try {
      con.setAutoCommit(false);
      login(userDetails.getLogin(), false);
      basicDetails(userDetails.getBasicDetails(), false);
      basicInformation(userDetails.getBasicInformation(), false);
      basicPreference(userDetails.getBasicPreferance(), false);
      extraInfo(userDetails.getExtraInfo(), false);
      familyInformation(userDetails.getFamilyInformation(), false);
      lifeStyleInfo(userDetails.getLifeStyleInfo(), false);
      locationPreference(userDetails.getLocationPreferences(), false);
      personalDetails(userDetails.getPersonalDetails(), false);
      professionalDetails(userDetails.getProfessionalDetails(), false);
      professionPreference(userDetails.getProfessionPreference(), false);
      religionInformation(userDetails.getReligionInformation(), false);
      religionPreference(userDetails.getReligionPreference(), false);
      profileInfo(userDetails.getProfileInfo(), false);
      con.commit();
      return login(userDetails.getLogin().getUserName(), userDetails.getLogin().getPassword());
    } catch (Exception exception) {
      Server.logWriter(exception.toString(), error);
    }
    return null;
  }

  public Login update(UserDetails userDetails) {
    try {
      con.setAutoCommit(false);
//      login(userDetails.getLogin(), true);
//      basicDetails(userDetails.getBasicDetails(), true);
//      basicInformation(userDetails.getBasicInformation(), true);
//      basicPreference(userDetails.getBasicPreferance(), true);
//      extraInfo(userDetails.getExtraInfo(), true);
//      familyInformation(userDetails.getFamilyInformation(), true);
//      lifeStyleInfo(userDetails.getLifeStyleInfo(), true);
//      locationPreference(userDetails.getLocationPreferences(), true);
//      personalDetails(userDetails.getPersonalDetails(), true);
//      professionalDetails(userDetails.getProfessionalDetails(), true);
//      professionPreference(userDetails.getProfessionPreference(), true);
//      religionInformation(userDetails.getReligionInformation(), true);
//      religionPreference(userDetails.getReligionPreference(), true);
      profileInfo(userDetails.getProfileInfo(), true);
      con.commit();
      return userDetails.getLogin();
    } catch (Exception exception) {
      Server.logWriter(exception.toString(), error);
    }
    return null;
  }

  public boolean delete(int userID) {
    String[] tables = { "Login", "BasicDetails", "BasicInformation", "BasicPreference", "ExtraInfo",
        "FamilyInformation", "LifeStyleInfo", "LocationPreference", "PersonalDetails", "ProfessionalDetails",
        "ProfessionPreferance", "ReligionInformation", "ReligionPreference" };
    try {
      con.setAutoCommit(false);
      for (String table : tables) {
        query = "delete from ? where userId = ?";
        ps = con.prepareStatement(query);
        ps.setString(1, table);
        ps.setInt(2, userID);
        ps.executeUpdate();
      }
      con.commit();
      return true;
    } catch (Exception e) {
      Server.logWriter("Deletion Error  ---> " + e, error);
    }
    return false;
  }

  public UserDetails getUserDetails(int userId) {
    UserDetails userDetails = new UserDetails();
    userDetails.setLogin(login(userId));
    userDetails.setProfileInfo(profileInfo(userId));
    userDetails.setBasicDetails(basicDetails(userId));
    userDetails.setBasicInformation(basicInformation(userId));
    userDetails.setBasicPreference(basicPreference(userId));
    userDetails.setExtraInfo(extraInfo(userId));
    userDetails.setFamilyInformation(familyInformation(userId));
    userDetails.setLifeStyleInfo(lifeStyleInfo(userId));
    userDetails.setLocationPreferences(locationPreference(userId));
    userDetails.setPersonalDetails(personalDetails(userId));
    userDetails.setProfessionPreference(professionPreference(userId));
    userDetails.setProfessionalDetails(professionalDetails(userId));
    userDetails.setReligionInformation(religionInformation(userId));
    userDetails.setReligionPreference(religionPreference(userId));
    return userDetails;
  }

  public boolean isUsernameExsist(String username) {
    query = "select * from Login where username = ?";
    try {
      ps = con.prepareStatement(query);
      ps.setString(1, username);
      rs = ps.executeQuery();
      if (rs.next()) {
        return true;
      }
    } catch (Exception e) {

      Server.logWriter(" Login Error   -->" + e, error);
    }
    return false;
  }

  public Profiles filter(String filter) {
    String query = "select userId from basicDetails where gender = ?";
    Profiles profiles = new Profiles();
    HashSet<ProfileInfo> profileSet = new HashSet<ProfileInfo>();
    try {
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, filter);
      ResultSet rs = ps.executeQuery();
      while (rs!=null && rs.next()) {
        int id = rs.getInt(1);
        ProfileInfo pi = profileInfo(id);
        if(pi!=null) profileSet.add(pi);
//        System.out.println(pi.getName());
      }
    } catch (Exception e) {
      Server.logWriter("Error Applying Filter  ---> " + e, error);
    }finally {
      profiles.setProfiles(profileSet);
      return profiles;
    }
  }

  private Login login(int userId) {
    query = "select * from login where userId = ?";
    try {
      ps = con.prepareStatement(query);
      ps.setInt(1, userId);
      rs = ps.executeQuery();
      if (rs.next()) {
        Login data = new Login();
        data.setUserID(rs.getInt(4));
        data.setUserName(rs.getString(1));
        data.setPassword(rs.getString(2));
        data.setIsAdmin(rs.getInt(3) == 1);
        return data;
      }
    } catch (Exception e) {
      Server.logWriter(" Login Fetch Error   -->" + e, error);
    }
    return null;
  }

  public ProfileInfo profileInfo(int userId) {
    query = "select * from profileInfo where userId = ?";
    try {
      ps = con.prepareStatement(query);
      ps.setInt(1, userId);
      rs = ps.executeQuery();
      if (rs.next()) {
        ProfileInfo data = new ProfileInfo();
//        byte[] img = rs.getBytes(1);

    try {
//      BufferedImage image = ImageIO.read(new ByteArrayInputStream(img));
      BufferedImage img1 = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);
      img1 = ImageIO.read(new File("src/server/resource/"+userId+".jpg"));
      data.setProfileImageIcon(new ImageIcon(img1));
    }catch(Exception e) {
          data.setProfileImageIcon(new ImageIcon("src/server/resource/default.jpg"));
    }
        data.setName(rs.getString(2));
        data.setAge(rs.getInt(3));
        data.setHeight(rs.getFloat(4));
        HashSet<Integer> set = new HashSet<>();
        String string = rs.getString(5);
        if (string != null && string.length() > 3) {
          for (String id : string.substring(1, string.length() - 1).split(", ")) {
            set.add(Integer.parseInt(id));
          }
        }
        data.setPairRequest(set);

        set = new HashSet<>();
        string = rs.getString(6);
        if (string != null && string.length() > 3) {
          for (String id : string.substring(1, string.length() - 1).split(", ")) {
            set.add(Integer.parseInt(id));
          }
        }
        data.setAcceptedPair(set);

        set = new HashSet<>();
        string = rs.getString(7);
        if (string != null && string.length() > 3) {
          for (String id : string.substring(1, string.length() - 1).split(", ")) {
            set.add(Integer.parseInt(id));
          }
        }
        data.setPairDeclined(set);

        set = new HashSet<>();
        string = rs.getString(8);
        if (string != null && string.length() > 3) {
          for (String id : string.substring(1, string.length() - 1).split(", ")) {
            set.add(Integer.parseInt(id));
          }
        }
        data.setRequestedPair(set);

        HashMap<Integer, Integer> map = new HashMap<>();
        string = rs.getString(9);
        if (string != null && string.length() > 3) {
          for (String id : string.substring(1, string.length() - 1).split(", ")) {
            String[] keypair = id.split("=");
            map.put(Integer.parseInt(keypair[0]), Integer.parseInt(keypair[1]));
          }
        }
        data.setChatHistoryIds(map);

        data.setUserId(userId);

        BasicDetails bs = basicDetails(userId);
        if (bs != null) {
          data.setMotherTongue(bs.getMotherTongue());
          data.setReligion(bs.getReligion());
        }

        ProfessionalDetails pd = professionalDetails(userId);
        if (pd != null) {
          data.setState(pd.getState());
          data.setCity(pd.getCity());
          data.setHighestEducation(pd.getHighestEducation());
          data.setEmployedIn(pd.getEmployedIn());
          data.setOccupation(pd.getOccupation());
        }

        return data;
      }
    } catch (Exception e) {
      Server.logWriter(" Profile Info Fetch Error   -->" + e, error);
    }
    return null;
  }

  private BasicDetails basicDetails(int userId) {
    query = "select * from basicDetails where userId =?";
    try {
      ps = con.prepareStatement(query);
      ps.setInt(1, userId);
      rs = ps.executeQuery();
      if (rs.next()) {
        BasicDetails data = new BasicDetails();
        data.setPhone(rs.getString(1));
        data.setGender(rs.getString(2));
        data.setDateOfBirth(rs.getDate(3));
        data.setMotherTongue(rs.getString(4));
        data.setEmail(rs.getString(5));
        data.setReligion(rs.getString(6));
        data.setUserId(rs.getInt(7));
        return data;
      }
    } catch (Exception e) {
      Server.logWriter(" BasicDetail Fetch Error   -->" + e, error);
    }
    return null;
  }

  private BasicInformation basicInformation(int userId) {
    query = "select * from basicInformation where userId =?";
    try {
      ps = con.prepareStatement(query);
      ps.setInt(1, userId);
      rs = ps.executeQuery();
      if (rs.next()) {
        BasicInformation data = new BasicInformation();
        data.setBodyType(rs.getString(1));
        data.setWeight(rs.getInt(2));
        data.setCollege(rs.getString(3));
        data.setOrganization(rs.getString(4));
        data.setUserId(rs.getInt(5));
        return data;
      }
    } catch (Exception e) {
      Server.logWriter(" BasicInformation Fetch Error   -->" + e, error);
    }
    return null;
  }

  private BasicPreference basicPreference(int userId) {
    query = "select * from basicpreferences where userId =?";
    try {
      ps = con.prepareStatement(query);
      ps.setInt(1, userId);
      rs = ps.executeQuery();
      if (rs.next()) {
        BasicPreference data = new BasicPreference();
        data.setAge(rs.getInt(1));
        data.setHeight(rs.getInt(2));
        data.setEatingHabit(rs.getString(3));
        data.setMartialStatus(rs.getString(4));
        data.setPhysicalStatus(rs.getString(5));
        data.setDrinkingHabit(rs.getString(6));
        data.setSmokingHabit(rs.getString(7));
        data.setAbout(rs.getString(8));
        data.setUserId(rs.getInt(9));
        return data;
      }
    } catch (Exception e) {
      Server.logWriter(" BasicPreference Fetch Error   -->" + e, error);
    }
    return null;
  }

  private ExtraInfo extraInfo(int userId) {
    query = "select * from ExtraInfo where userId =?";
    try {
      ps = con.prepareStatement(query);
      ps.setInt(1, userId);
      rs = ps.executeQuery();
      if (rs.next()) {
        ExtraInfo data = new ExtraInfo();
        data.setHobbiesAndInterset(rs.getString(1));
        data.setFavouriteMusic(rs.getString(2));
        data.setSportsFitness(rs.getString(3));
        data.setSpokenLanguage(rs.getString(4));
        data.setUserId(rs.getInt(5));
        return data;
      }
    } catch (Exception e) {
      Server.logWriter(" ExtraInfo Fetch Error   -->" + e, error);
    }
    return null;
  }

  private FamilyInformation familyInformation(int userId) {
    query = "select * from familyInformation where userId =?";
    try {
      ps = con.prepareStatement(query);
      ps.setInt(1, userId);
      rs = ps.executeQuery();
      if (rs.next()) {
        FamilyInformation data = new FamilyInformation();
        data.setFatherStatus(rs.getString(1));
        data.setMotherStatus(rs.getString(2));
        data.setSiblings(rs.getString(3));
        data.setLocation(rs.getString(4));
        data.setContactNo(rs.getString(5));
        data.setUserId(rs.getInt(6));
        return data;
      }
    } catch (Exception e) {
      Server.logWriter(" FamilyInformation Fetch Error   -->" + e, error);
    }
    return null;
  }

  private LifeStyleInfo lifeStyleInfo(int userId) {
    query = "select * from LifeStyleInfo where userId =?";
    try {
      ps = con.prepareStatement(query);
      ps.setInt(1, userId);
      rs = ps.executeQuery();
      if (rs.next()) {
        LifeStyleInfo data = new LifeStyleInfo();
        data.setEatingHabit(rs.getString(1));
        data.setDrinkingHabit(rs.getString(2));
        data.setSmokingHabit(rs.getString(3));
        data.setUserId(rs.getInt(4));

        return data;
      }
    } catch (Exception e) {
      Server.logWriter(" LifeStyleInfo Fetch Error   -->" + e, error);
    }
    return null;
  }

  private LocationPreferences locationPreference(int userId) {
    query = "select * from LocationPreferences  where userId =?";
    try {
      ps = con.prepareStatement(query);
      ps.setInt(1, userId);
      rs = ps.executeQuery();
      if (rs.next()) {
        LocationPreferences data = new LocationPreferences();
        data.setCountry(rs.getString(1));
        data.setResidingState(rs.getString(2));
        data.setDistrict(rs.getString(3));
        data.setCity(rs.getString(4));
        data.setUserId(rs.getInt(5));
        return data;
      }
    } catch (Exception e) {
      Server.logWriter("LocationPreferences  Fetch Error   -->" + e, error);
    }
    return null;
  }

  private PersonalDetails personalDetails(int userId) {
    query = "select * from personalDetails where userId =?";
    try {
      ps = con.prepareStatement(query);
      ps.setInt(1, userId);
      rs = ps.executeQuery();
      if (rs.next()) {
        PersonalDetails data = new PersonalDetails();
        data.setMartialStatus(rs.getString(1));
        data.setHeight(rs.getFloat(2));
        data.setFamilyStatus(rs.getString(3));
        data.setFamilyType(rs.getString(4));
        data.setFamilyValues(rs.getString(5));
        data.setAnyDisAbility(rs.getString(6));
        data.setAbout(rs.getString(7));
        data.setUserId(rs.getInt(8));
        return data;
      }
    } catch (Exception e) {
      Server.logWriter(" PersonalDetails Fetch Error   -->" + e, error);
    }
    return null;
  }

  private ProfessionalDetails professionalDetails(int userId) {
    query = "select * from professionalDetails where userId =?";
    try {
      ps = con.prepareStatement(query);
      ps.setInt(1, userId);
      rs = ps.executeQuery();
      if (rs.next()) {
        ProfessionalDetails data = new ProfessionalDetails();
        data.setHighestEducation(rs.getString(1));
        data.setEmployedIn(rs.getString(2));
        data.setOccupation(rs.getString(3));
        data.setAnnualIncome(rs.getInt(4));
        data.setWorkLocation(rs.getString(5));
        data.setState(rs.getString(6));
        data.setCity(rs.getString(7));
        data.setUserId(rs.getInt(8));
        return data;
      }
    } catch (Exception e) {
      Server.logWriter(" ProfessionalDetails Fetch Error   -->" + e, error);
    }
    return null;
  }

  private ProfessionPreference professionPreference(int userId) {
    query = "select * from ProfessionPreferences  where userId =?";
    try {
      ps = con.prepareStatement(query);
      ps.setInt(1, userId);
      rs = ps.executeQuery();
      if (rs.next()) {
        ProfessionPreference data = new ProfessionPreference();
        data.setEducation(rs.getString(1));
        data.setEmployedIn(rs.getString(2));
        data.setOccupation(rs.getString(3));
        data.setAnnualIncome(rs.getInt(4));
        data.setUserId(rs.getInt(5));
        return data;
      }
    } catch (Exception e) {
      Server.logWriter("ProfessionPreference  Fetch Error   -->" + e, error);
    }
    return null;
  }

  private ReligionInformation religionInformation(int userId) {
    query = "select * from ReligionInformation where userId =?";
    try {
      ps = con.prepareStatement(query);
      ps.setInt(1, userId);
      rs = ps.executeQuery();
      if (rs.next()) {
        ReligionInformation data = new ReligionInformation();
        data.setStar(rs.getString(1));
        data.setRaasi(rs.getString(2));
        data.setTimeOfBirth(rs.getString(3));
        data.setPlaceOfBirth(rs.getString(4));
        data.setUserId(rs.getInt(5));
        return data;
      }
    } catch (Exception e) {
      Server.logWriter(" ReligionInformation Fetch Error   -->" + e, error);
    }
    return null;
  }

  private ReligionPreference religionPreference(int userId) {
    query = "select * from ReligionPreferences where userId =?";
    try {
      ps = con.prepareStatement(query);
      ps.setInt(1, userId);
      rs = ps.executeQuery();
      if (rs.next()) {
        ReligionPreference data = new ReligionPreference();
        data.setReligion(rs.getString(1));
        data.setMotherTongue(rs.getString(2));
        data.setCaste(rs.getString(3));
        data.setStar(rs.getString(4));
        data.setUserId(rs.getInt(5));
        return data;
      }
    } catch (Exception e) {
      Server.logWriter(" ReligionPreference Fetch Error   -->" + e, error);
    }
    return null;
  }

  private void login(Login login, boolean isUpdate) throws Exception {
    query = isUpdate ? "update Login set username=? , password=?, isAdmin=? where userId = ?"
        : "insert into Login (username, password, isAdmin, userId) values(?, ?, ?, id.nextval)";
    try {
      ps = con.prepareStatement(query);
      ps.setString(1, login.getUserName());
      ps.setString(2, login.getPassword());
      ps.setInt(3, login.getIsAdmin() ? 1 : 0);
      if (isUpdate)
        ps.setInt(4, login.getUserID());
      ps.executeUpdate();
    } catch (Exception e) {
      Server.logWriter(" Login Creation error   --> " + e, error);
    }
  }

  public void profileInfo(ProfileInfo profileInfo, boolean isUpdate) throws Exception {
    query = isUpdate
        ? "update ProfileInfo set profileImageIcon = ?, name = ?, age = ?,height = ?,pairRequest = ?,acceptedPair = ?,pairDeclined = ?,requestedPair = ?, chatHistoryId = ? where userId = ?"
        : "insert into ProfileInfo values(?,?,?,?,?,?,?,?,?, id.currval)";
    try {
      ps = con.prepareStatement(query);
      BufferedImage img = getBufferedImage(profileInfo.getProfileImageIcon().getImage());
      if(isUpdate) {
        ImageIO.write(img, "jpg",new File("src/server/resource/"+profileInfo.getUserId()+".jpg"));
        ps.setBytes(1, null);
      }else {
        // converting buffered image to byte array
        WritableRaster raster = img.getRaster();
        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
        byte[] extractBytes = data.getData();
        ps.setBytes(1, null);
      }
      ps.setString(2, profileInfo.getName());
      ps.setInt(3, profileInfo.getAge());
      ps.setFloat(4, profileInfo.getHeight());
      ps.setString(5, profileInfo.getPairRequest().toString());
      ps.setString(6, profileInfo.getAcceptedPair().toString());
      ps.setString(7, profileInfo.getPairDeclined().toString());
      ps.setString(8, profileInfo.getRequestedPair().toString());
      ps.setString(9, profileInfo.getChatHistoryIds().toString());
      if (isUpdate)
        ps.setInt(10, profileInfo.getUserId());
      ps.executeUpdate();
    } catch (Exception e) {
      throw new Exception(" Profile Information error --> " + e);
    }
  }

  public Image toImage(BufferedImage bufferedImage) {
    return Toolkit.getDefaultToolkit().createImage(bufferedImage.getSource());
  }

  private static BufferedImage getBufferedImage(Image img) {
    if (img instanceof BufferedImage) {
      return (BufferedImage) img;
    }

    BufferedImage bimage = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);

    Graphics2D bGr = bimage.createGraphics();
    bGr.drawImage(img, 0, 0, 300, 300, null);
    bGr.dispose();

    // Return the buffered image
    return bimage;
  }

  private void basicDetails(BasicDetails basicDetails, boolean isUpdate) throws Exception {
    query = isUpdate
        ? "update BasicDetails set phone = ?, gender=?, dateofbirth=?, mothertoungue=?, email = ?, religion=? where userId = ?"
        : "insert into BasicDetails values(?,?,?,?,?,?,id.currval)";
    try {
      ps = con.prepareStatement(query);
      ps.setString(1, basicDetails.getPhone());
      ps.setString(2, basicDetails.getGender());
      ps.setDate(3,
          Date.valueOf((basicDetails.getDateOfBirth().toInstant().atZone(ZoneId.of("Asia/Kolkata")).toLocalDate())));
      ps.setString(4, basicDetails.getMotherTongue());
      ps.setString(5, basicDetails.getEmail());
      ps.setString(6, basicDetails.getReligion());
      if (isUpdate)
        ps.setInt(7, basicDetails.getUserId());
      ps.executeUpdate();
    } catch (Exception e) {
      throw new Exception(" BasicDetail error --> " + e);
    }

  }

  private void professionalDetails(ProfessionalDetails professionalDetails, boolean isUpdate) throws Exception {
    query = isUpdate
        ? "update ProfessionalDetails set highestEducation = ?, employedIn = ?, occupation = ?,annualIncome = ?,workLocation = ?, city = ?, state = ? where userID =? "
        : "insert into ProfessionalDetails values(?,?,?,?,?,?,?,id.currval)";
    try {

      ps = con.prepareStatement(query);
      ps.setString(1, professionalDetails.getHighestEducation());
      ps.setString(2, professionalDetails.getEmployedIn());
      ps.setString(3, professionalDetails.getOccupation());
      ps.setInt(4, professionalDetails.getAnnualIncome());
      ps.setString(5, professionalDetails.getWorkLocation());
      ps.setString(6, professionalDetails.getCity());
      ps.setString(7, professionalDetails.getState());
      if (isUpdate)
        ps.setInt(8, professionalDetails.getUserId());
      ps.executeUpdate();
    } catch (Exception e) {
      throw new Exception(" ProfessionalDetail error   --> " + e);
    }

  }

  private void lifeStyleInfo(LifeStyleInfo lifeStyleInfo, boolean isUpdate) throws Exception {
    query = isUpdate ? "update LifeStyleInfo set eatingHabit = ?, drinkingHabit = ?,smokingHabit = ? where userId = ?"
        : "insert into LifeStyleInfo values(?,?,?,id.currval)";
    try {

      ps = con.prepareStatement(query);
      ps.setString(1, lifeStyleInfo.getEatingHabit());
      ps.setString(2, lifeStyleInfo.getDrinkingHabit());
      ps.setString(3, lifeStyleInfo.getSmokingHabit());
      if (isUpdate)
        ps.setInt(4, lifeStyleInfo.getUserId());

      ps.executeUpdate();

    } catch (Exception e) {
      throw new Exception(" LifeStyleInfo ProfessionalDetail error   --> " + e);
    }

  }

  private void basicInformation(BasicInformation basicInformation, boolean isUpdate) throws Exception {
    query = isUpdate
        ? "update BasicInformation set bodyType =?,weight = ? ,college = ?,organization = ? where userId = ?"
        : "insert into BasicInformation values(?,?,?,?,id.currval)";
    try {
      ps = con.prepareStatement(query);
      ps.setString(1, basicInformation.getBodyType());
      ps.setInt(2, basicInformation.getWeight());
      ps.setString(3, basicInformation.getCollege());
      ps.setString(4, basicInformation.getOrganization());
      if (isUpdate)
        ps.setInt(5, basicInformation.getUserId());
      ps.executeUpdate();

    } catch (Exception e) {
      throw new Exception(" BasicInformation  error   --> " + e);
    }
  }

  private void professionPreference(ProfessionPreference professionPreference, boolean isUpdate) throws Exception {
    query = isUpdate
        ? "update ProfessionPreferences set education = ?,employedIn = ?,occupation = ?,annualIncome = ? where userID =?"
        : "insert into ProfessionPreferences  values(?,?,?,?,id.currval)";
    try {
      ps = con.prepareStatement(query);
      ps.setString(1, professionPreference.getEducation());
      ps.setString(2, professionPreference.getEmployedIn());
      ps.setString(3, professionPreference.getOccupation());
      ps.setInt(4, professionPreference.getAnnualIncome());
      if (isUpdate)
        ps.setInt(5, professionPreference.getUserId());
      ps.executeUpdate();

    } catch (Exception e) {
      throw new Exception(" Professionalpreference error   --> " + e);
    }

  }

  private void locationPreference(LocationPreferences locationPreference, boolean isUpdate) throws Exception {
    query = isUpdate
        ? "update LocationPreferences set country = ?,residingState = ?,district = ?,city = ? where userID = ?"
        : "insert into LocationPreferences  values(?,?,?,?,id.currval)";
    try {
      ps = con.prepareStatement(query);
      ps.setString(1, locationPreference.getCountry());
      ps.setString(2, locationPreference.getResidingState());
      ps.setString(3, locationPreference.getDistrict());
      ps.setString(4, locationPreference.getCity());
      if (isUpdate)
        ps.setInt(5, locationPreference.getUserId());
      ps.executeUpdate();

    } catch (Exception e) {
      throw new Exception(" Locationpreference error   --> " + e);
    }

  }

  private void religionPreference(ReligionPreference religionPreference, boolean isUpdate) throws Exception {
    query = isUpdate ? "update ReligionPreferences set religion = ?,motherTongue = ?,caste = ?,star = ? where useID =? "
        : "insert into ReligionPreferences  values(?,?,?,?,id.currval)";
    try {
      ps = con.prepareStatement(query);
      ps.setString(1, religionPreference.getReligion());
      ps.setString(2, religionPreference.getMotherTongue());
      ps.setString(3, religionPreference.getCaste());
      ps.setString(4, religionPreference.getStar());
      if (isUpdate)
        ps.setInt(5, religionPreference.getUserId());
      ps.executeUpdate();

    } catch (Exception e) {
      throw new Exception(" Religionpreference error   --> " + e);
    }

  }

  private void basicPreference(BasicPreference basicPreference, boolean isUpdate) throws Exception {
    query = isUpdate
        ? "update BasicPreferences set age = ?,height = ?,eatingHabit = ?,martialStatus = ?,physicalStatus = ?,drinkingHabit = ?,smokingHabit =?,about = ? where userId = ? "
        : "insert into basicPreferences values(?,?,?,?,?,?,?,?,id.currval)";
    try {

      ps = con.prepareStatement(query);
      ps.setInt(1, basicPreference.getAge());
      ps.setInt(2, basicPreference.getHeight());
      ps.setString(3, basicPreference.getEatingHabit());
      ps.setString(4, basicPreference.getMartialStatus());
      ps.setString(5, basicPreference.getPhysicalStatus());
      ps.setString(6, basicPreference.getDrinkingHabit());
      ps.setString(7, basicPreference.getSmokingHabits());
      ps.setString(8, basicPreference.getAbout());
      if (isUpdate)
        ps.setInt(9, basicPreference.getUserId());
      ps.executeUpdate();

    } catch (Exception e) {
      throw new Exception(" BasicPreference error   -->" + e);
    }

  }

  private void religionInformation(ReligionInformation religionInformation, boolean isUpdate) throws Exception {
    query = isUpdate
        ? "update ReligionInformation set star = ?,raasi = ?,timeOfBirth =?,placeOfBirth = ? where userId = ?"
        : "insert into religionInformation  values(?,?,?,?,id.currval)";
    try {
      ps = con.prepareStatement(query);
      ps.setString(1, religionInformation.getStar());
      ps.setString(2, religionInformation.getRaasi());
      ps.setString(3, religionInformation.getTimeOfBirth());
      ps.setString(4, religionInformation.getPlaceOfBirth());
      if (isUpdate)
        ps.setInt(5, religionInformation.getUserId());
      ps.executeUpdate();

    } catch (Exception e) {
      throw new Exception(" ReligionInformation error   -->" + e);
    }

  }

  private void extraInfo(ExtraInfo extraInfo, boolean isUpdate) throws Exception {
    query = isUpdate
        ? "update extraInfo set hobbiesandinterest=?,favouritemusic=?,sportsfines=?,spokenlanguage=? where userId=?"
        : "insert into extraInfo  values(?,?,?,?,id.currval)";
    try {
      ps = con.prepareStatement(query);
      ps.setString(1, extraInfo.getHobbiesAndInterest());
      ps.setString(2, extraInfo.getFavouriteMusic());
      ps.setString(3, extraInfo.getSportsFitness());
      ps.setString(4, extraInfo.getSpokenLanguage());
      if (isUpdate)
        ps.setInt(5, extraInfo.getUserId());
      ps.executeUpdate();

    } catch (Exception e) {
      throw new Exception(" ExtraInfo error   -->" + e);
    }

  }

  private void familyInformation(FamilyInformation familyInformation, boolean isUpdate) throws Exception {
    query = isUpdate
        ? "update familyInformation set fatherstatus=?, motherstatus=? sibilings=?,location=?,contactno=? where userId=?"
        : "insert into familyInformation  values(?,?,?,?,?,id.currval)";

    try {
      ps = con.prepareStatement(query);
      ps.setString(1, familyInformation.getFatherStatus());
      ps.setString(2, familyInformation.getMotherStatus());
      ps.setString(3, familyInformation.getSiblings());
      ps.setString(4, familyInformation.getLocation());
      ps.setString(5, familyInformation.getContactNo());
      if (isUpdate)
        ps.setInt(6, familyInformation.getUserId());
      ps.executeUpdate();

    } catch (Exception e) {
      throw new Exception(" FamilyInformation error   -->" + e);
    }

  }

  private void personalDetails(PersonalDetails personalDetails, boolean isUpdate) throws Exception {
    query = isUpdate
        ? "update PersonalDetails set martialstatus=?, height=?, familystatus=?, familytype=?, familyvalues=?, anydisabilit?, about=? where userId=?"
        : "insert into personalDetails values(?,?,?,?,?,?,?,id.currval)";
    try {

      ps = con.prepareStatement(query);
      ps.setString(1, personalDetails.getMartialStatus());
      ps.setFloat(2, personalDetails.getHeight());
      ps.setString(3, personalDetails.getFamilyStatus());
      ps.setString(4, personalDetails.getFamilyType());
      ps.setString(5, personalDetails.getFamilyValues());
      ps.setString(6, personalDetails.getAnyDisability());
      ps.setString(7, personalDetails.getAbout());
      if (isUpdate)
        ps.setInt(8, personalDetails.getUserId());
      ps.executeUpdate();

    } catch (Exception e) {
      throw new Exception(" PersonalDetail error   -->" + e);
    }

  }
}
