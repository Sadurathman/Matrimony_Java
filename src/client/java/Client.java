package client.java;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Set;

import javax.swing.JOptionPane;

import javabeans.Login;
import javabeans.ProfileInfo;
import javabeans.Profiles;
import javabeans.UserDetails;

public class Client {
  private Socket socket;
  private ObjectInputStream response;
  private ObjectOutputStream request;
  private DataOutputStream type;
  private Login login;
  private static String host = "localHost";
  private static int port=3000;
  public Client() {
    try {
      socket = new Socket(host, port);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Server Not Found -->" + e);
    }
  }

  public static void setHost(String url){
    host = url;
  }

  public static void setPort(int portNumber){
    port = portNumber;
  }

  public Login login(String username, String password) {
    login = new Login();
    login.setUserName(username);
    login.setPassword(password);
    try {
      type = new DataOutputStream(socket.getOutputStream());
      type.writeUTF("LOGIN");
      request = new ObjectOutputStream(socket.getOutputStream());
      request.writeObject(login);
      response = new ObjectInputStream(socket.getInputStream());
      return (Login) response.readObject();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Login Request Failed   --> " + e);
    }
    return null;
  }

  public Login register(UserDetails userDetails) {
    try {
      System.out.println(userDetails.getProfileInfo().getProfileImageIcon());
      type = new DataOutputStream(socket.getOutputStream());
      type.writeUTF("REGISTER");
      request = new ObjectOutputStream(socket.getOutputStream());
      request.writeObject(userDetails);
      response = new ObjectInputStream(socket.getInputStream());
      return (Login) response.readObject();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Register Request Failed   --> " + e);
    }
    return null;
  }

  public Login update(UserDetails userDetails) {
    try {
      type = new DataOutputStream(socket.getOutputStream());
      type.writeUTF("UPDATE");
      request = new ObjectOutputStream(socket.getOutputStream());
      request.writeObject(userDetails);
      response = new ObjectInputStream(socket.getInputStream());
      return (Login) response.readObject();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Update Request Failed   --> " + e);
    }
    return null;
  }

  public Login delete(Login login) {
    try {
      type = new DataOutputStream(socket.getOutputStream());
      type.writeUTF("DELETE");
      request = new ObjectOutputStream(socket.getOutputStream());
      request.writeObject(login);
      response = new ObjectInputStream(socket.getInputStream());
      return (Login) response.readObject();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Delete Request Failed   --> " + e);
    }
    return null;
  }

  public boolean isUsernameExsist(String username) {
    try {
      type = new DataOutputStream(socket.getOutputStream());
      type.writeUTF("USERNAME");
      type.writeUTF(username);
      DataInputStream isExsist = new DataInputStream(socket.getInputStream());
      return isExsist.readUTF().equals("true");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Username Request Failed   --> " + e);
    }
    return true;
  }

  public UserDetails profileDetails(int userId) {
    try {
      type = new DataOutputStream(socket.getOutputStream());
      type.writeUTF("DETAIL");
      type.writeUTF(userId + "");
      response = new ObjectInputStream(socket.getInputStream());
      return (UserDetails) response.readObject();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Detail Request Failed   --> " + e);
    }
    return null;
  }

  public Profiles filter(String filter) {
    try {
      type = new DataOutputStream(socket.getOutputStream());
      type.writeUTF("FILTER");
      type.writeUTF(filter);
      response = new ObjectInputStream(socket.getInputStream());
      return (Profiles) response.readObject();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Filter Request Failed   --> " + e);
    }
    return null;
  }

  // req = 1 for Send Request and req = 0 for Unsend Request
  public ProfileInfo pairRequest(int userId, int targetId, int req) {
    try {
      type = new DataOutputStream(socket.getOutputStream());
      type.writeUTF("PAIR_REQUEST");
      type.writeUTF(userId + " " + targetId + " " + req);
      response = new ObjectInputStream(socket.getInputStream());
      return (ProfileInfo) response.readObject();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Pair Request Failed   --> " + e);
    }
    return null;
  }

  // req = 1 for Accept Request and req = 0 for Decline Accepted Request
  public ProfileInfo acceptRequest(int userId, int targetId, int req) {
    try {
      type = new DataOutputStream(socket.getOutputStream());
      type.writeUTF("ACCEPT_PAIR");
      type.writeUTF(userId + " " + targetId + " " + req);
      response = new ObjectInputStream(socket.getInputStream());
      return (ProfileInfo) response.readObject();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Accept Request Failed   --> " + e);
    }
    return null;
  }

  // Declined the request Received
  public ProfileInfo declineRequest(int userId, int targetId) {
    try {
      type = new DataOutputStream(socket.getOutputStream());
      type.writeUTF("DECLINE_PAIR");
      type.writeUTF(userId + " " + targetId + " ");
      response = new ObjectInputStream(socket.getInputStream());
      return (ProfileInfo) response.readObject();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Decline Request Failed   --> " + e);
    }
    return null;
  }

  public Profiles idToProfiles(Set<Integer> profileSet) {
    try {
      Profiles profiles = new Profiles();
      profiles.setIds(profileSet);
      type = new DataOutputStream(socket.getOutputStream());
      type.writeUTF("ID_SET_TO_PROFILES");
      request = new ObjectOutputStream(socket.getOutputStream());
      request.writeObject(profiles);
      response = new ObjectInputStream(socket.getInputStream());
      return (Profiles) response.readObject();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "ID to PROFILE Request Failed   --> " + e);
    }
    return null;
  }

}
