package client.java.ui;

import java.awt.*;
import javax.swing.*;

import javax.swing.border.MatteBorder;
import client.java.Client;
import javabeans.UserDetails;
import javabeans.ProfileInfo;
import javabeans.Profiles;
import java.awt.Dimension;

import java.awt.Toolkit;

public class MatchesUI {
  private static JPanel matchesLeftPanel, matchesRightPanel;


  private JButton homeButton, searchButton, matchesButton, acceptedButton, declinedButton, requestedButton;

  private UserDetails userInfo;
  int width, height;
  JPanel mainPanel;

  public MatchesUI(JPanel mainPanel,JPanel leftPanel, JPanel rightPanel, UserDetails userInfo) {

    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    width = (int) dimension.getWidth();
    height = (int) dimension.getHeight();
    this.mainPanel = mainPanel;
    this.userInfo = userInfo;

    homeButton = new JButton("HOME");
    searchButton = new JButton("search");
    matchesButton = new JButton("Matches");

    homeButton.setBounds(0, 100, 100, 20);
    searchButton.setBounds(0, 200, 100, 20);
    matchesButton.setBounds(0, 300, 100, 20);

    // matchesTopPanel = new JPanel();
    matchesLeftPanel = leftPanel;
    matchesRightPanel = rightPanel;

    // matchesLeftPanel.setBorder(new MatteBorder(0, 0, 0, 3, Color.LIGHT_GRAY));

    acceptedButton = new JButton("Accepted");
    declinedButton = new JButton("Requested");
    requestedButton = new JButton("Requests");

    acceptedButton.setFont(new java.awt.Font("Arial Black", 1, 18));
    declinedButton.setFont(new java.awt.Font("Arial Black", 1, 18));
    requestedButton.setFont(new java.awt.Font("Arial Black", 1, 18));

    acceptedButton.setBounds(0, 360, width / 4, 30);
    declinedButton.setBounds(0, 400, width / 4, 30);
    requestedButton.setBounds(0, 440, width / 4, 30);

    acceptedButton.setBorder(null);
    declinedButton.setBorder(null);
    requestedButton.setBorder(null);

    acceptedButton.setBackground(null);
    declinedButton.setBackground(null);
    requestedButton.setBackground(null);

    matchesLeftPanel.add(acceptedButton);
    matchesLeftPanel.add(declinedButton);
    matchesLeftPanel.add(requestedButton);

    acceptedButton.addActionListener((e) -> {
      matchesRightPanel.removeAll();
      matchesLeftPanel.removeAll();
      // mainPanel.add(homeTopPanel);
      new MatchesUI(mainPanel, matchesLeftPanel, matchesRightPanel, userInfo);
      matchesLeftPanel.revalidate();
      matchesRightPanel.revalidate();
      matchesLeftPanel.repaint();
      matchesRightPanel.repaint();
    });

    declinedButton.addActionListener((e) -> {
      // mainPanel.removeAll();
      // mainPanel.add(homeTopPanel);
      // new matchesLayout(mainPanel);
      matchesRightPanel.removeAll();
      new declined(mainPanel, matchesRightPanel, userInfo);

      matchesRightPanel.revalidate();
      matchesRightPanel.repaint();
    });

    requestedButton.addActionListener((e) -> {
      // mainPanel.removeAll();
      // mainPanel.add(homeTopPanel);
      matchesRightPanel.removeAll();
      new requested(mainPanel, matchesRightPanel, userInfo);
      matchesRightPanel.revalidate();
      matchesRightPanel.repaint();
    });

    JPanel search = new JPanel();
    matchesRightPanel.setLayout(new BorderLayout());
    search.setLayout(new BoxLayout(search, BoxLayout.Y_AXIS));
    search.setAutoscrolls(true);
    search.setBackground(Color.WHITE);
    rightPanelCompoent(matchesRightPanel);

    /*
     * JScrollPane scr = new JScrollPane(search); JScrollBar horizontalScrollBar =
     * new JScrollBar(JScrollBar.VERTICAL) {
     * 
     * @Override public boolean isVisible() { return true; } };
     * search.setBackground(Color.WHITE);
     * horizontalScrollBar.putClientProperty("JScrollBar.fastWheelScrolling",
     * Boolean.TRUE); scr.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
     * scr.setBounds(0, 0, (width * 3 / 4) - 60, height * 4 / 5);
     * scr.setWheelScrollingEnabled(true);
     * scr.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.
     * HORIZONTAL_SCROLLBAR_NEVER); scr.setBackground(Color.white); for (int i = 0;
     * i < 10; i++) { search.add(profileTemplate()); }
     * 
     * JPanel content = new JPanel(null); content.setPreferredSize(new
     * Dimension(200, 300)); content.add(scr); matchesRightPanel.add(content); //
     * matchesLeftPanel.setBounds(0, 70, 300, height);
     * matchesLeftPanel.setBackground(Color.WHITE);
     * matchesLeftPanel.setLayout(null);
     * 
     * // matchesRightPanel.setBounds(300, 70, width, height);
     * matchesRightPanel.setBackground(Color.WHITE);
     */

  }

  /*
   * JPanel profileTemplate() {
   * 
   * Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); int width
   * = (int) dimension.getWidth(); int height = (int) dimension.getHeight();
   * JPanel matchPanel = new JPanel(); matchPanel.setBounds(0, 0, width, height);
   * 
   * name = new JLabel(); agelabel = new JLabel(); religion = new JLabel(); Annual
   * = new JLabel(); occupationtemp = new JLabel(); statetemp = new JLabel();
   * educationTemp = new JLabel();
   * 
   * name.setText("Pika"); agelabel.setText("24 Yrs |");
   * religion.setText("Hindu |"); Annual.setText("1,20,000/per Year,");
   * occupationtemp.setText("Teacher |"); statetemp.setText("Tamil Nadu |");
   * educationTemp.setText("B.E ");
   * 
   * name.setBounds(300, 0, 70, 30); agelabel.setBounds(250, 50, 70, 30);
   * religion.setBounds(310, 50, 70, 30); Annual.setBounds(370, 50, 190, 30);
   * occupationtemp.setBounds(250, 80, 70, 30); statetemp.setBounds(320, 80, 100,
   * 30); educationTemp.setBounds(430, 80, 70, 30);
   * 
   * name.setFont(new Font("Times New Roman", Font.BOLD, 28));
   * agelabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
   * religion.setFont(new Font("Times New Roman", Font.BOLD, 18));
   * Annual.setFont(new Font("Times New Roman", Font.BOLD, 18));
   * occupationtemp.setFont(new Font("Times New Roman", Font.BOLD, 18));
   * statetemp.setFont(new Font("Times New Roman", Font.BOLD, 18));
   * educationTemp.setFont(new Font("Times New Roman", Font.BOLD, 18));
   * 
   * userIcon = new JLabel(new ImageIcon(new
   * ImageIcon("C:\\Users\\Thani\\Desktop\\mukil\\maxresdefault.jpg").getImage()
   * .getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
   * 
   * matchPanel.setLayout(new FlowLayout()); matchPanel.add(userIcon);
   * matchPanel.add(name); matchPanel.add(agelabel); matchPanel.add(religion);
   * matchPanel.add(Annual); matchPanel.add(statetemp);
   * matchPanel.add(occupationtemp); matchPanel.add(educationTemp);
   * 
   * matchPanel.setBackground(Color.WHITE); userIcon.setPreferredSize(new
   * Dimension(200, 200)); return matchPanel; }
   */
  public JPanel scrollList(ProfileInfo profileInfo, int type) {
    JPanel userPanel = new JPanel();
    JPanel infoPanel = new JPanel();
    userPanel.setLayout(new FlowLayout());
    infoPanel.setLayout(null);

    userPanel.setPreferredSize(new Dimension((width * 3 / 4) - 80, 200));
    infoPanel.setPreferredSize(new Dimension((width * 3 / 4) - 290, 200));

    JLabel dp = new JLabel();
    JLabel name = new JLabel(profileInfo.getName());
    JLabel age = new JLabel(profileInfo.getAge() + "");
    JLabel religion = new JLabel(profileInfo.getReligion());
    JLabel income = new JLabel("10000");
    JLabel occupation = new JLabel(profileInfo.getOccupation());
    JLabel state = new JLabel(profileInfo.getState());
    JLabel education = new JLabel(profileInfo.getHighestEducation());
    JButton button = new JButton();
    JButton view = new JButton("View Profile");

    dp.setIcon(
        new ImageIcon(profileInfo.getProfileImageIcon().getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT)));
    dp.setHorizontalAlignment(SwingConstants.CENTER);
    dp.setPreferredSize(new Dimension(200, 200));
    userPanel.add(dp);

    name.setBounds(20, 50 + 5, 200, 25);
    infoPanel.add(name);

    age.setBounds(20, 50 + 35, 150, 25);
    infoPanel.add(age);

    religion.setBounds(160, 50 + 35, 150, 25);
    infoPanel.add(religion);

    income.setBounds(310, 50 + 35, 150, 25);
    infoPanel.add(income);

    occupation.setBounds(20, 50 + 65, 150, 25);
    infoPanel.add(occupation);

    state.setBounds(160, 50 + 65, 150, 25);
    infoPanel.add(state);

    education.setBounds(310, 50 + 65, 100, 25);
    infoPanel.add(education);

    infoPanel.setBackground(Color.white);

    if (type == 1) {
      button.setText("UnAccept");
      button.setBorder(null);
      button.addActionListener((e) -> {
        userInfo
            .setProfileInfo(new Client().acceptRequest(userInfo.getLogin().getUserID(), profileInfo.getUserId(), 0));
        matchesRightPanel.removeAll();
        rightPanelCompoent(matchesRightPanel);
        matchesRightPanel.revalidate();
        matchesRightPanel.repaint();
      });
    } else if (type == 2) {
      // button.setText("UnRequest");
      // button.addActionListener((e) -> {
      // userInfo.setProfileInfo(new
      // Client().pairRequest(userInfo.getLogin().getUserID(),
      // profileInfo.getUserId(), 0));
      // matchesRightPanel.removeAll();
      // rightPanelCompoent(matchesRightPanel);
      // matchesRightPanel.revalidate();
      // matchesRightPanel.repaint();
      // });
    } else {
      button.setText("Accept");
      button.addActionListener((e) -> {
        userInfo
            .setProfileInfo(new Client().acceptRequest(userInfo.getLogin().getUserID(), profileInfo.getUserId(), 1));
        matchesRightPanel.removeAll();
        rightPanelCompoent(matchesRightPanel);
        matchesRightPanel.revalidate();
        matchesRightPanel.repaint();
      });
    }
    button.setBackground(null);
    button.setBounds((width / 2) - 50, 50 + 35, 150, 25);
    button.setFont(new java.awt.Font("Verdana", 1, 18));

    view.setBackground(null);
    view.setBounds((width / 2) - 50, 50 + 65, 150, 25);
    view.setFont(new java.awt.Font("Verdana", 1, 16));
    view.addActionListener((e) -> {
      mainPanel.removeAll();
      new ProfileUI(mainPanel, userInfo, profileInfo.getUserId());
      mainPanel.revalidate();
      mainPanel.repaint();
    });
    infoPanel.add(view);

    infoPanel.add(button);

    for (Component c : infoPanel.getComponents()) {
      if (c instanceof JLabel) {
        ((JLabel) c).setFont(new java.awt.Font("Verdana", 1, 18));
      }
    }

    userPanel.add(infoPanel);
    userPanel.setBackground(Color.white);
    return userPanel;
  }

  public void rightPanelCompoent(JPanel panel) {

    // String gender = userInfo.getBasicDetails().getGender();
    // String filter = (gender.equals("MALE") ? "FEMALE " : "MALE ");
    // Profiles suggestions = new Client().filter(filter);
    Profiles suggestions = new Client().idToProfiles(userInfo.getProfileInfo().getAcceptedPair());

    panel.setLayout(new BorderLayout());

    // List Panel Starts
    JPanel listPanel = new JPanel();
    listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
    listPanel.setAutoscrolls(true);
    listPanel.setBackground(Color.white);

    JScrollPane scrollPane1 = new JScrollPane(listPanel);
    scrollPane1.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
    scrollPane1.setBounds(40, 30, (width * 3 / 4) - 120, height * 3 / 4);
    scrollPane1.setWheelScrollingEnabled(true);
    scrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane1.setBackground(Color.white);

//    ProfileInfo profileInfo = new ProfileInfo();
//    profileInfo.setAge(24);
//    profileInfo.setOccupation("Youtuber");
//    profileInfo.setName("Akshaya");
//    profileInfo.setState("Tamilnadu");
//    profileInfo.setHighestEducation("B.Tech");
//    profileInfo.setReligion("Hindu");
//    profileInfo.setProfileImageIcon(new ImageIcon("src/client/resource/images/dp.jpg"));
    // suggestions.getProfiles().add(userInfo.getProfileInfo());
     for (ProfileInfo profileInfo : suggestions.getProfiles()) {
//    for (int i = 0; i < 10; i++) {
      listPanel.add(scrollList(profileInfo, 1));
    }

    // Content Panel Starts
    JPanel contentPane = new JPanel(null);

    JLabel matchLabel = new JLabel("Accpeted Matches💖");
    matchLabel.setForeground(Color.orange);
    matchLabel.setBounds(20, 0, 300, 30);
    matchLabel.setFont(new java.awt.Font("Arial Black", 1, 24));

    contentPane.setPreferredSize(new Dimension(200, 200));
    contentPane.add(matchLabel);
    contentPane.add(scrollPane1);
    contentPane.setBackground(Color.white);

    // adding to right panel
    panel.add(contentPane, BorderLayout.CENTER);
  }
}

class declined {
  // private JButton acceptedButton, declinedButton, requestedButton;
  private JLabel name, agelabel, religion, Annual, occupationtemp, statetemp, educationTemp, userIcon;
  UserDetails userInfo;
  int width, height;
  JPanel matchesRightPanel, mainPanel;
  public declined(JPanel mainPanel, JPanel matchesRightPanel, UserDetails userInfo) {
    // acceptedButton = new JButton("Accepted");
    // declinedButton = new JButton("Declined");
    // requestedButton = new JButton("Requested");
this.mainPanel = mainPanel;
    // acceptedButton.setBounds(80, 50, 100, 20);
    // declinedButton.setBounds(80, 100, 100,20);
    // requestedButton.setBounds(80, 150, 100, 20);
    this.userInfo = userInfo;
    this.matchesRightPanel = matchesRightPanel;
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    width = (int) dimension.getWidth();
    height = (int) dimension.getHeight();
    JPanel search = new JPanel();
    matchesRightPanel.setLayout(new BorderLayout());
    search.setLayout(new BoxLayout(search, BoxLayout.Y_AXIS));
    search.setAutoscrolls(true);
    search.setBackground(Color.WHITE);
    rightPanelCompoent(matchesRightPanel);

    /*
     * JScrollPane scr = new JScrollPane(search); JScrollBar horizontalScrollBar =
     * new JScrollBar(JScrollBar.VERTICAL) {
     * 
     * @Override public boolean isVisible() { return true; } };
     * search.setBackground(Color.WHITE);
     * horizontalScrollBar.putClientProperty("JScrollBar.fastWheelScrolling",
     * Boolean.TRUE); scr.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
     * scr.setBounds(0, 0, (width * 3 / 4) - 60, height * 4 / 5);
     * scr.setWheelScrollingEnabled(true);
     * scr.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.
     * HORIZONTAL_SCROLLBAR_NEVER); scr.setBackground(Color.white); for (int i = 0;
     * i < 10; i++) { search.add(profileTemplate()); }
     * 
     * JPanel content = new JPanel(null); content.setPreferredSize(new
     * Dimension(200, 300)); content.add(scr); matchesRightPanel.add(content);
     */

  }

  public JPanel scrollList(ProfileInfo profileInfo, int type) {
    JPanel userPanel = new JPanel();
    JPanel infoPanel = new JPanel();
    userPanel.setLayout(new FlowLayout());
    infoPanel.setLayout(null);

    userPanel.setPreferredSize(new Dimension((width * 3 / 4) - 80, 200));
    infoPanel.setPreferredSize(new Dimension((width * 3 / 4) - 290, 200));

    JLabel dp = new JLabel();
    JLabel name = new JLabel(profileInfo.getName());
    JLabel age = new JLabel(profileInfo.getAge() + "");
    JLabel religion = new JLabel(profileInfo.getReligion());
    JLabel income = new JLabel("10000");
    JLabel occupation = new JLabel(profileInfo.getOccupation());
    JLabel state = new JLabel(profileInfo.getState());
    JLabel education = new JLabel(profileInfo.getHighestEducation());
    JButton button = new JButton();
    JButton view = new JButton("View Profile");

    dp.setIcon(
        new ImageIcon(profileInfo.getProfileImageIcon().getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT)));
    dp.setHorizontalAlignment(SwingConstants.CENTER);
    dp.setPreferredSize(new Dimension(200, 200));
    userPanel.add(dp);

    name.setBounds(20, 50 + 5, 200, 25);
    infoPanel.add(name);

    age.setBounds(20, 50 + 35, 150, 25);
    infoPanel.add(age);

    religion.setBounds(160, 50 + 35, 150, 25);
    infoPanel.add(religion);

    income.setBounds(310, 50 + 35, 150, 25);
    infoPanel.add(income);

    occupation.setBounds(20, 50 + 65, 150, 25);
    infoPanel.add(occupation);

    state.setBounds(160, 50 + 65, 150, 25);
    infoPanel.add(state);

    education.setBounds(310, 50 + 65, 100, 25);
    infoPanel.add(education);

    infoPanel.setBackground(Color.white);

    if (type == 1) {
      button.setText("UnAccept");
      button.setBorder(null);
      button.addActionListener((e) -> {
        userInfo
            .setProfileInfo(new Client().acceptRequest(userInfo.getLogin().getUserID(), profileInfo.getUserId(), 0));
        matchesRightPanel.removeAll();
        rightPanelCompoent(matchesRightPanel);
        matchesRightPanel.revalidate();
        matchesRightPanel.repaint();
      });
    } else if (type == 2) {
       button.setText("UnRequest");
       button.addActionListener((e) -> {
       userInfo.setProfileInfo(new
       Client().pairRequest(userInfo.getLogin().getUserID(),
       profileInfo.getUserId(), 0));
       matchesRightPanel.removeAll();
       rightPanelCompoent(matchesRightPanel);
       matchesRightPanel.revalidate();
       matchesRightPanel.repaint();
       });
    } else {
      button.setText("Accept");
      button.addActionListener((e) -> {
        userInfo
            .setProfileInfo(new Client().acceptRequest(userInfo.getLogin().getUserID(), profileInfo.getUserId(), 1));
        matchesRightPanel.removeAll();
        rightPanelCompoent(matchesRightPanel);
        matchesRightPanel.revalidate();
        matchesRightPanel.repaint();
      });
    }
    button.setBackground(null);
    button.setBounds((width / 2) - 50, 50 + 35, 150, 25);
    button.setFont(new java.awt.Font("Verdana", 1, 18));

    view.setBackground(null);
    view.setBounds((width / 2) - 50, 50 + 65, 150, 25);
    view.setFont(new java.awt.Font("Verdana", 1, 16));
    view.addActionListener((e) -> {
      mainPanel.removeAll();
      new ProfileUI(mainPanel, userInfo, profileInfo.getUserId());
      mainPanel.revalidate();
      mainPanel.repaint();
    });
    infoPanel.add(view);

    infoPanel.add(button);

    for (Component c : infoPanel.getComponents()) {
      if (c instanceof JLabel) {
        ((JLabel) c).setFont(new java.awt.Font("Verdana", 1, 18));
      }
    }

    userPanel.add(infoPanel);
    userPanel.setBackground(Color.white);
    return userPanel;
  }

  public void rightPanelCompoent(JPanel panel) {

    // String gender = userInfo.getBasicDetails().getGender();
    // String filter = (gender.equals("MALE") ? "FEMALE " : "MALE ");
    // Profiles suggestions = new Client().filter(filter);
    Profiles suggestions = new Client().idToProfiles(userInfo.getProfileInfo().getRequestedPair());

    panel.setLayout(new BorderLayout());

    // List Panel Starts
    JPanel listPanel = new JPanel();
    listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
    listPanel.setAutoscrolls(true);
    listPanel.setBackground(Color.white);

    JScrollPane scrollPane1 = new JScrollPane(listPanel);
    scrollPane1.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
    scrollPane1.setBounds(40, 30, (width * 3 / 4) - 120, height * 3 / 4);
    scrollPane1.setWheelScrollingEnabled(true);
    scrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane1.setBackground(Color.white);

//    ProfileInfo profileInfo = new ProfileInfo();
//    profileInfo.setAge(24);
//    profileInfo.setOccupation("Youtuber");
//    profileInfo.setName("Akshaya");
//    profileInfo.setState("Tamilnadu");
//    profileInfo.setHighestEducation("B.Tech");
//    profileInfo.setReligion("Hindu");
//    profileInfo.setProfileImageIcon(new ImageIcon("src/client/resource/images/dp.jpg"));
    // suggestions.getProfiles().add(userInfo.getProfileInfo());
     for (ProfileInfo profileInfo : suggestions.getProfiles()) {
//    for (int i = 0; i < 10; i++) {
      listPanel.add(scrollList(profileInfo, 2));
    }

    // Content Panel Starts
    JPanel contentPane = new JPanel(null);

    JLabel matchLabel = new JLabel("Requested Matches🙄");
    matchLabel.setForeground(Color.orange);
    matchLabel.setBounds(20, 0, 300, 30);
    matchLabel.setFont(new java.awt.Font("Arial Black", 1, 24));

    contentPane.setPreferredSize(new Dimension(200, 200));
    contentPane.add(matchLabel);
    contentPane.add(scrollPane1);
    contentPane.setBackground(Color.white);

    // adding to right panel
    panel.add(contentPane, BorderLayout.CENTER);
  }

  /*
   * JPanel profileTemplate() {
   * 
   * Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); int width
   * = (int) dimension.getWidth(); int height = (int) dimension.getHeight();
   * JPanel matchPanel = new JPanel(); matchPanel.setBounds(0, 0, width, height);
   * 
   * name = new JLabel(); agelabel = new JLabel(); religion = new JLabel(); Annual
   * = new JLabel(); occupationtemp = new JLabel(); statetemp = new JLabel();
   * educationTemp = new JLabel();
   * 
   * name.setText("Priya"); agelabel.setText("24 Yrs |");
   * religion.setText("Hindu |"); Annual.setText("1,20,000/per Year,");
   * occupationtemp.setText("Teacher |"); statetemp.setText("Tamil Nadu |");
   * educationTemp.setText("B.E ");
   * 
   * name.setBounds(300, 0, 70, 30); agelabel.setBounds(250, 50, 70, 30);
   * religion.setBounds(310, 50, 70, 30); Annual.setBounds(370, 50, 190, 30);
   * occupationtemp.setBounds(250, 80, 70, 30); statetemp.setBounds(320, 80, 100,
   * 30); educationTemp.setBounds(430, 80, 70, 30);
   * 
   * name.setFont(new Font("Times New Roman", Font.BOLD, 28));
   * agelabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
   * religion.setFont(new Font("Times New Roman", Font.BOLD, 18));
   * Annual.setFont(new Font("Times New Roman", Font.BOLD, 18));
   * occupationtemp.setFont(new Font("Times New Roman", Font.BOLD, 18));
   * statetemp.setFont(new Font("Times New Roman", Font.BOLD, 18));
   * educationTemp.setFont(new Font("Times New Roman", Font.BOLD, 18));
   * 
   * userIcon = new JLabel(new ImageIcon(new
   * ImageIcon("C:\\Users\\Thani\\Desktop\\mukil\\E4TU9esUcAU2llJ.jpg")
   * .getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
   * 
   * matchPanel.setLayout(new FlowLayout()); matchPanel.add(userIcon);
   * matchPanel.add(name); matchPanel.add(agelabel); matchPanel.add(religion);
   * matchPanel.add(Annual); matchPanel.add(statetemp);
   * matchPanel.add(occupationtemp); matchPanel.add(educationTemp);
   * 
   * matchPanel.setBackground(Color.WHITE); userIcon.setPreferredSize(new
   * Dimension(200, 200)); return matchPanel; }
   */

}

class requested {
  private JLabel name, agelabel, religion, Annual, occupationtemp, statetemp, educationTemp, userIcon;

  UserDetails userInfo;
  private JPanel matchesRightPanel;
JPanel mainPanel;
  int width, height;

  public requested(JPanel mainPanel, JPanel matchesRightPanel, UserDetails userInfo) {

    this.mainPanel = mainPanel;
    this.userInfo = userInfo;
    this.matchesRightPanel = matchesRightPanel;
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    width = (int) dimension.getWidth();
    height = (int) dimension.getHeight();
    JPanel search = new JPanel();
    matchesRightPanel.setLayout(new BorderLayout());
    search.setLayout(new BoxLayout(search, BoxLayout.Y_AXIS));
    search.setAutoscrolls(true);
    search.setBackground(Color.WHITE);
    rightPanelCompoent(matchesRightPanel);
    /*
     * JScrollPane scr = new JScrollPane(search); JScrollBar horizontalScrollBar =
     * new JScrollBar(JScrollBar.VERTICAL) {
     * 
     * @Override public boolean isVisible() { return true; } };
     * search.setBackground(Color.WHITE);
     * horizontalScrollBar.putClientProperty("JScrollBar.fastWheelScrolling",
     * Boolean.TRUE); scr.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
     * scr.setBounds(0, 0, (width * 3 / 4) - 60, height * 4 / 5);
     * scr.setWheelScrollingEnabled(true);
     * scr.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.
     * HORIZONTAL_SCROLLBAR_NEVER); scr.setBackground(Color.white); for (int i = 0;
     * i < 10; i++) { search.add(profileTemplate()); }
     * 
     * JPanel content = new JPanel(null); content.setPreferredSize(new
     * Dimension(200, 300)); content.add(scr); matchesRightPanel.add(content);
     */

  }

  public JPanel scrollList(ProfileInfo profileInfo, int type) {
    JPanel userPanel = new JPanel();
    JPanel infoPanel = new JPanel();
    userPanel.setLayout(new FlowLayout());
    infoPanel.setLayout(null);

    userPanel.setPreferredSize(new Dimension((width * 3 / 4) - 80, 200));
    infoPanel.setPreferredSize(new Dimension((width * 3 / 4) - 290, 200));

    JLabel dp = new JLabel();
    JLabel name = new JLabel(profileInfo.getName());
    JLabel age = new JLabel(profileInfo.getAge() + "");
    JLabel religion = new JLabel(profileInfo.getReligion());
    JLabel income = new JLabel("10000");
    JLabel occupation = new JLabel(profileInfo.getOccupation());
    JLabel state = new JLabel(profileInfo.getState());
    JLabel education = new JLabel(profileInfo.getHighestEducation());
    JButton button = new JButton();
    JButton view = new JButton("View Profile");

    dp.setIcon(
        new ImageIcon(profileInfo.getProfileImageIcon().getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT)));
    dp.setHorizontalAlignment(SwingConstants.CENTER);
    dp.setPreferredSize(new Dimension(200, 200));
    userPanel.add(dp);

    name.setBounds(20, 50 + 5, 200, 25);
    infoPanel.add(name);

    age.setBounds(20, 50 + 35, 150, 25);
    infoPanel.add(age);

    religion.setBounds(160, 50 + 35, 150, 25);
    infoPanel.add(religion);

    income.setBounds(310, 50 + 35, 150, 25);
    infoPanel.add(income);

    occupation.setBounds(20, 50 + 65, 150, 25);
    infoPanel.add(occupation);

    state.setBounds(160, 50 + 65, 150, 25);
    infoPanel.add(state);

    education.setBounds(310, 50 + 65, 100, 25);
    infoPanel.add(education);

    infoPanel.setBackground(Color.white);

    if (type == 1) {
      button.setText("UnAccept");
      button.setBorder(null);
      button.addActionListener((e) -> {
        userInfo
            .setProfileInfo(new Client().acceptRequest(userInfo.getLogin().getUserID(), profileInfo.getUserId(), 0));
        matchesRightPanel.removeAll();
        rightPanelCompoent(matchesRightPanel);
        matchesRightPanel.revalidate();
        matchesRightPanel.repaint();
      });
    } else if (type == 2) {
      // button.setText("UnRequest");
      // button.addActionListener((e) -> {
      // userInfo.setProfileInfo(new
      // Client().pairRequest(userInfo.getLogin().getUserID(),
      // profileInfo.getUserId(), 0));
      // matchesRightPanel.removeAll();
      // rightPanelCompoent(matchesRightPanel);
      // matchesRightPanel.revalidate();
      // matchesRightPanel.repaint();
      // });
    } else {
      button.setText("Accept");
      button.addActionListener((e) -> {
        userInfo
            .setProfileInfo(new Client().acceptRequest(userInfo.getLogin().getUserID(), profileInfo.getUserId(), 1));
        matchesRightPanel.removeAll();
        rightPanelCompoent(matchesRightPanel);
        matchesRightPanel.revalidate();
        matchesRightPanel.repaint();
      });
    }
    button.setBackground(null);
    button.setBounds((width / 2) - 50, 50 + 35, 150, 25);
    button.setFont(new java.awt.Font("Verdana", 1, 18));

    view.setBackground(null);
    view.setBounds((width / 2) - 50, 50 + 65, 150, 25);
    view.setFont(new java.awt.Font("Verdana", 1, 16));
    view.addActionListener((e) -> {
      mainPanel.removeAll();
      new ProfileUI(mainPanel, userInfo, profileInfo.getUserId());
      mainPanel.revalidate();
      mainPanel.repaint();
    });
    infoPanel.add(view);

    infoPanel.add(button);

    for (Component c : infoPanel.getComponents()) {
      if (c instanceof JLabel) {
        ((JLabel) c).setFont(new java.awt.Font("Verdana", 1, 18));
      }
    }

    userPanel.add(infoPanel);
    userPanel.setBackground(Color.white);
    return userPanel;
  }

  public void rightPanelCompoent(JPanel panel) {

    // String gender = userInfo.getBasicDetails().getGender();
    // String filter = (gender.equals("MALE") ? "FEMALE " : "MALE ");
     Profiles suggestions = new Client().idToProfiles(userInfo.getProfileInfo().getPairRequest());

    panel.setLayout(new BorderLayout());

    // List Panel Starts
    JPanel listPanel = new JPanel();
    listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
    listPanel.setAutoscrolls(true);
    listPanel.setBackground(Color.white);

    JScrollPane scrollPane1 = new JScrollPane(listPanel);
    scrollPane1.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
    scrollPane1.setBounds(40, 30, (width * 3 / 4) - 120, height * 3 / 4);
    scrollPane1.setWheelScrollingEnabled(true);
    scrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane1.setBackground(Color.white);

//    ProfileInfo profileInfo = new ProfileInfo();
//    profileInfo.setAge(24);
//    profileInfo.setOccupation("Youtuber");
//    profileInfo.setName("Akshaya");
//    profileInfo.setState("Tamilnadu");
//    profileInfo.setHighestEducation("B.Tech");
//    profileInfo.setReligion("Hindu");
//    profileInfo.setProfileImageIcon(new ImageIcon("src/client/resource/images/dp.jpg"));
    // suggestions.getProfiles().add(userInfo.getProfileInfo());
     for (ProfileInfo profileInfo : suggestions.getProfiles()) {
//    for (int i = 0; i < 10; i++) {
      listPanel.add(scrollList(profileInfo, 3));
    }

    // Content Panel Starts
    JPanel contentPane = new JPanel(null);

    JLabel matchLabel = new JLabel("Match Requests😍");
    matchLabel.setForeground(Color.orange);
    matchLabel.setBounds(20, 0, 300, 30);
    matchLabel.setFont(new java.awt.Font("Arial Black", 1, 24));

    contentPane.setPreferredSize(new Dimension(200, 200));
    contentPane.add(matchLabel);
    contentPane.add(scrollPane1);
    contentPane.setBackground(Color.white);

    // adding to right panel
    panel.add(contentPane, BorderLayout.CENTER);
  }
  /*
   * JPanel profileTemplate() {
   * 
   * Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); int width
   * = (int) dimension.getWidth(); int height = (int) dimension.getHeight();
   * JPanel matchPanel = new JPanel(); matchPanel.setBounds(0, 0, width, height);
   * 
   * name = new JLabel(); agelabel = new JLabel(); religion = new JLabel(); Annual
   * = new JLabel(); occupationtemp = new JLabel(); statetemp = new JLabel();
   * educationTemp = new JLabel();
   * 
   * name.setText("PS"); agelabel.setText("24 Yrs |");
   * religion.setText("Hindu |"); Annual.setText("1,20,000/per Year,");
   * occupationtemp.setText("Teacher |"); statetemp.setText("Tamil Nadu |");
   * educationTemp.setText("B.E ");
   * 
   * name.setBounds(300, 0, 70, 30); agelabel.setBounds(250, 50, 70, 30);
   * religion.setBounds(310, 50, 70, 30); Annual.setBounds(370, 50, 190, 30);
   * occupationtemp.setBounds(250, 80, 70, 30); statetemp.setBounds(320, 80, 100,
   * 30); educationTemp.setBounds(430, 80, 70, 30);
   * 
   * name.setFont(new Font("Times New Roman", Font.BOLD, 28));
   * agelabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
   * religion.setFont(new Font("Times New Roman", Font.BOLD, 18));
   * Annual.setFont(new Font("Times New Roman", Font.BOLD, 18));
   * occupationtemp.setFont(new Font("Times New Roman", Font.BOLD, 18));
   * statetemp.setFont(new Font("Times New Roman", Font.BOLD, 18));
   * educationTemp.setFont(new Font("Times New Roman", Font.BOLD, 18));
   * 
   * userIcon = new JLabel(new ImageIcon(new
   * ImageIcon("src/client/resource/images/E4TU9esUcAU2llJ.jpg").getImage()
   * .getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
   * 
   * matchPanel.setLayout(new FlowLayout()); matchPanel.add(userIcon);
   * matchPanel.add(name); matchPanel.add(agelabel); matchPanel.add(religion);
   * matchPanel.add(Annual); matchPanel.add(statetemp);
   * matchPanel.add(occupationtemp); matchPanel.add(educationTemp);
   * 
   * matchPanel.setBackground(Color.WHITE); userIcon.setPreferredSize(new
   * Dimension(200, 200)); return matchPanel;
   * 
   * }
   */

}