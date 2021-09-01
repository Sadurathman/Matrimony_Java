package client.java.ui;

import java.awt.*;
import javax.swing.*;

import javax.swing.border.MatteBorder;

import client.java.Client;
import javabeans.ProfileInfo;
import javabeans.Profiles;
import javabeans.UserDetails;

import java.awt.Dimension;
import javax.swing.JComboBox;
import java.awt.Toolkit;

public class SearchUI {
  JPanel searchLeftPanel, searchRightPanel, searchPanel, extraPanel, suggestionPanel, mainPanel;
  JLabel ageJlabel, occupationJLabel, annunalincomeJLabel, educationJLabel, statelabel, userIcon, to, religionJLabel,
      name, agelabel, religion, Annual, occupationtemp, statetemp, educationTemp;
  JButton homeButton, searchButton, matchesButton, friendRequest;
  int width, height;
  UserDetails userInfo;

  public SearchUI(JPanel mainPanel, JPanel leftPanel, JPanel rightPanel, UserDetails userInfo) {

    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    width = (int) dimension.getWidth();
    height = (int) dimension.getHeight();

    this.userInfo = userInfo;
    this.mainPanel = mainPanel;
    searchLeftPanel = leftPanel;
    searchRightPanel = rightPanel;
    suggestionPanel = new JPanel();

    String age[] = new String[23];
    for (int i = 0; i < 23; i++) {
      age[i] = (18 + i) + "";

    }
    String age3[] = new String[23];
    for (int i = 0; i < 23; i++) {
      age3[i] = (19 + i) + "";

    }

    JComboBox<String> age1 = new JComboBox<>(age);
    JComboBox<String> age2 = new JComboBox<>(age3);

    String inc[] = new String[10];
    for (int i = 1; i < 10; i++) {
      inc[i] = (100000 * i) + "";
    }
    JComboBox<String> incomeList = new JComboBox<String>(inc);

    String education[] = { "B.E", "B.Tech", "M.E", "M.Tech", "B.Arch", "M.B.B.S" };
    JComboBox<String> eduList = new JComboBox<String>(education);

    String state[] = { "TamilNadu", "Kerala", "U.P", "Andhra", "Gujarat", "Jammu" };
    JComboBox<String> stateList = new JComboBox<String>(state);

    String work[] = { "Teacher", "IT Employee", "Self-Employeed", "Finance" };
    JComboBox<String> workList = new JComboBox<String>(work);

    String religion1[] = { "Hindu", "Muslim", "Christain", "Jain" };
    JComboBox<String> religionList = new JComboBox<String>(religion1);

    ageJlabel = new JLabel("Age");
    to = new JLabel("TO");
    annunalincomeJLabel = new JLabel("Annual Income");
    educationJLabel = new JLabel("Education");
    statelabel = new JLabel("State");
    occupationJLabel = new JLabel("Occupation");
    religionJLabel = new JLabel("Religion");
    JLabel title = new JLabel("Filter");

    ageJlabel.setBounds(50, 100 + 0, 60, 20);
    annunalincomeJLabel.setBounds(50, 100 + 60, 120, 30);
    educationJLabel.setBounds(50, 100 + 90, 120, 30);
    statelabel.setBounds(50, 100 + 140, 70, 20);
    occupationJLabel.setBounds(50, 100 + 190, 80, 20);
    religionJLabel.setBounds(50, 100 + 240, 80, 20);

    title.setBounds(50, 50, 200, 20);
    title.setFont(new java.awt.Font("Arial Black", 1, 18));
    age1.setBounds(50, 100 + 30, 60, 20);
    to.setBounds(120, 100 + 30, 20, 20);
    age2.setBounds(180, 100 + 30, 60, 20);
    incomeList.setBounds(150, 100 + 60, 100, 20);
    eduList.setBounds(150, 100 + 100, 100, 20);
    stateList.setBounds(150, 100 + 140, 100, 20);
    workList.setBounds(150, 100 + 190, 100, 20);
    religionList.setBounds(150, 100 + 240, 100, 20);

    searchLeftPanel.add(ageJlabel);
    searchLeftPanel.add(title);
    searchLeftPanel.add(annunalincomeJLabel);
    searchLeftPanel.add(educationJLabel);
    searchLeftPanel.add(statelabel);
    searchLeftPanel.add(occupationJLabel);
    searchLeftPanel.add(religionJLabel);

    searchLeftPanel.add(age1);
    searchLeftPanel.add(to);
    searchLeftPanel.add(age2);
    searchLeftPanel.add(incomeList);
    searchLeftPanel.add(eduList);
    searchLeftPanel.add(stateList);
    searchLeftPanel.add(workList);
    searchLeftPanel.add(religionList);

    searchLeftPanel.setBackground(Color.white);
    searchLeftPanel.setLayout(null);
    searchLeftPanel.setBorder(new MatteBorder(0, 0, 0, 3, Color.WHITE));

    JPanel search = new JPanel();
    search.setLayout(new BoxLayout(search, BoxLayout.Y_AXIS));
    search.setAutoscrolls(true);
    search.setBackground(Color.WHITE);
    rightPanelCompoent(rightPanel);
  }

  public JPanel scrollList(ProfileInfo profileInfo) {
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

    if (userInfo.getProfileInfo().getAcceptedPair().contains(profileInfo.getUserId())) {
      button.setText("UnAccept");
      button.setBorder(null);
      button.addActionListener((e) -> {
        userInfo
            .setProfileInfo(new Client().acceptRequest(userInfo.getLogin().getUserID(), profileInfo.getUserId(), 0));
        searchRightPanel.removeAll();
        rightPanelCompoent(searchRightPanel);
        searchRightPanel.revalidate();
        searchRightPanel.repaint();
      });
      return null;
    } else if (userInfo.getProfileInfo().getRequestedPair().contains(profileInfo.getUserId())) {
      button.setText("UnRequest");
      button.addActionListener((e) -> {
        userInfo.setProfileInfo(new Client().pairRequest(userInfo.getLogin().getUserID(), profileInfo.getUserId(), 0));
        searchRightPanel.removeAll();
        rightPanelCompoent(searchRightPanel);
        searchRightPanel.revalidate();
        searchRightPanel.repaint();
      });
    } else if (userInfo.getProfileInfo().getPairRequest().contains(profileInfo.getUserId())) {
      button.setText("Accept");
      button.addActionListener((e) -> {
        userInfo
            .setProfileInfo(new Client().acceptRequest(userInfo.getLogin().getUserID(), profileInfo.getUserId(), 1));
        searchRightPanel.removeAll();
        rightPanelCompoent(searchRightPanel);
        searchRightPanel.revalidate();
        searchRightPanel.repaint();
      });
    } else {
      button.setText("Request");
      button.addActionListener((e) -> {
        userInfo.setProfileInfo(new Client().pairRequest(userInfo.getLogin().getUserID(), profileInfo.getUserId(), 1));
        searchRightPanel.removeAll();
        rightPanelCompoent(searchRightPanel);
        searchRightPanel.revalidate();
        searchRightPanel.repaint();
      });
    }
    button.setBackground(null);
    button.setBounds((width / 2) - 50, 50 + 35, 150, 25);
    button.setFont(new java.awt.Font("Verdana", 1, 18));

    view.setBackground(null);
    view.setBounds((width / 2) - 50, 50 + 65, 150, 25);
    view.setFont(new java.awt.Font("Verdana", 1, 16));
    view.addActionListener((e)->{
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

     String gender = userInfo.getBasicDetails().getGender();
     String filter = (gender.equals("MALE") ? "FEMALE" : "MALE");
     Profiles suggestions = new Client().filter(filter);

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
       JPanel insert = scrollList(profileInfo);
       if(insert!=null)listPanel.add(insert);
    }

    // Content Panel Starts
    JPanel contentPane = new JPanel(null);

    JLabel matchLabel = new JLabel("Search Matches");
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
