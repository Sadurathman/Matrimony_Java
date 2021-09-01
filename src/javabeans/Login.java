package javabeans;

import java.io.Serializable;

public class Login implements Serializable {

  private static final long serialVersionUID = 88L;

  private int userId;
  private String userName;
  private String Password;
  private boolean isAdmin;

  public int getUserID() {
    return userId;
  }

  public void setUserID(int userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return Password;
  }

  public void setPassword(String Password) {
    this.Password = Password;
  }

  public boolean getIsAdmin() {
    return isAdmin;
  }

  public void setIsAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  }

}
