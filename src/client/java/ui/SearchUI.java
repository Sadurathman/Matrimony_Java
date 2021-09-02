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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SearchUI {
  JPanel searchLeftPanel, searchRightPanel, searchPanel, extraPanel, suggestionPanel, mainPanel;
  JLabel ageJlabel, occupationJLabel, annunalincomeJLabel, educationJLabel, statelabel, userIcon, to, religionJLabel,
      name, agelabel, religion, Annual, occupationtemp, statetemp, educationTemp;
  JButton homeButton, searchButton, matchesButton, friendRequest;
  int width, height;
  UserDetails userInfo;
  int minAge, maxAge;
  String degree, loc, mt, rel, chosen;

  public SearchUI(JPanel mainPanel, JPanel leftPanel, JPanel rightPanel, UserDetails userInfo) {

    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    width = (int) dimension.getWidth();
    height = (int) dimension.getHeight();

    this.userInfo = userInfo;
    this.mainPanel = mainPanel;
    searchLeftPanel = leftPanel;
    searchRightPanel = rightPanel;
    suggestionPanel = new JPanel();

    String age[] = new String[30];
    for (int i = 0; i < 30; i++) {
      age[i] = (18 + i) + "";

    }
    String age3[] = new String[30];
    for (int i = 0; i < 30; i++) {
      age3[i] = (19 + i) + "";

    }

    JComboBox<String> age1 = new JComboBox<>(age);
    JComboBox<String> age2 = new JComboBox<>(age3);

    minAge = userInfo.getBasicDetails().getGender().equals("MALE")?18:userInfo.getProfileInfo().getAge();
    maxAge = userInfo.getBasicDetails().getGender().equals("MALE")?userInfo.getProfileInfo().getAge():45;
    age1.setSelectedItem(minAge+"");
    age2.setSelectedItem(maxAge+"");

    age1.addItemListener((e)->{
      minAge = Integer.parseInt(age1.getSelectedItem().toString());
      refresh(rightPanel);
    });

    age2.addItemListener((e)->{
      maxAge = Integer.parseInt(age2.getSelectedItem().toString());
      refresh(rightPanel);
    });

    String inc[] = new String[10];
    for (int i = 0; i < 10; i++) {
      inc[i] = (100000 * i) + "";
    }
    JComboBox<String> incomeList = new JComboBox<String>(inc);

    String education[] = { "Select", "BE / B.Tech.", "Aeronautical Engineering", "B.Arch", "BCA", "B.Tech.",
            "B.S.(Engineering)", "Other Bachelor Degree in Engineering / Computers", "MCA / PGDCA",
            "ME / M.Tech.", "M.Arch.", "MCA", "ME", "M.Sc. IT / Computer Science", "M.S. (Engg.)",
            "M.Tech.", "Other Masters Degree in Engineering /", "Computers", "Commerce / Others",
            "Aviation Degree", "B.A.", "B.Com.", "B.Ed.", "BFA", "BFT", "BLIS", "B.M.M.", "B.Sc.",
            "B.S.W", "B.Phil.", "Other Bachelor Degree in Arts / Science Commerce", "M.A.",
            "M.Com.", "M.Ed.", "MFA", "MLIS", "M.Sc.", "MSW", "M.Phil.",
            "Other Master Degree in Arts / Science / Commerce", "BBA", "BFM (Financial Management)",
            "BHM (Hotel Management)", "BHA BHM (Hospital Administration)",
            "Other Bachelor Degree in Management", "MBA", " MFM (Financial Management)",
            "MHM (Hotel Management)", "MHRM (Human Resource Management)", "PGDM", "MBA / PGDM",
            "MHA / MHM (Hospital Administration)", " Other Master Degree in Management", "B.A.M.S.",
            "BDS", "BHMS", "BSMS", "BPharm", "BPT", "BUMS", "BVSC", "MBBS", "B.Sc. Nursing",
            "Other Bachelor Degree in Medicine", "MDS", "MD/MS (Medical)", "M.Pharm", "MPT", "MVSc",
            "Other Master Degree in Medicine", "BGL", "LL.B.", "BGL/B.L./ LL.B.",
            "Other Bachelor Degree in Legal", "LL.M.", "M.L.", "M.L./ LL.M.",
            "Other Master Degree in Legal", "Finance - ICWAI/CA/CS/ CFA /", "Others", "CA",
            "CFA (Chartered Financial Analyst)", "CS", "CWA", "Other Degree in Finance", "Ph.D.",
            "Ph.D.", "Diploma / Others", "Diploma", "Polytechnic", "Trade School", "Others",
            "Higher Secondary / Secondary" };
    JComboBox<String> eduList = new JComboBox<String>(education);

    degree = eduList.getSelectedItem().toString();
    eduList.addItemListener((e)->{
      degree = eduList.getSelectedItem().toString();
      refresh(rightPanel);
    });

    String state[] = { "Select", "Tamilnadu", "Kerala", "U.P", "Andhra", "Gujarat", "Jammu" };
    JComboBox<String> stateList = new JComboBox<String>(state);
    loc = stateList.getSelectedItem().toString();
    stateList.addItemListener((e)->{
      loc = stateList.getSelectedItem().toString();
      refresh(rightPanel);
    });

    String work[] = { "Select", "Bengali", "Gujarati", "Hindi", "Kannada", "Malayalam", "Marathi",
            "Marwari", "Oriya", "Sindhi", "Tamil", "Telugu", "Urdu" };
    JComboBox<String> workList = new JComboBox<String>(work);
    mt = workList.getSelectedItem().toString();
    workList.addItemListener((e)->{
      mt = workList.getSelectedItem().toString();
      refresh(rightPanel);
    });

    String religion1[] = {"Select", "Hindu", "Muslim",
            "Christain", "Sikh", "Jain", "Buddhist", "Inter-Religion" };
    JComboBox<String> religionList = new JComboBox<String>(religion1);
    rel = religionList.getSelectedItem().toString();
    religionList.addItemListener((e)->{
      rel = religionList.getSelectedItem().toString();
      refresh(rightPanel);
    });

    String sorting[] = {"Select", "age", "height"};
    JComboBox<String> sortList = new JComboBox<String>(sorting);
    chosen = sortList.getSelectedItem().toString();
    sortList.addItemListener((e)->{
      chosen = sortList.getSelectedItem().toString();
      refresh(rightPanel);
    });

    ageJlabel = new JLabel("Age");
    to = new JLabel("TO");
    annunalincomeJLabel = new JLabel("Annual Income");
    educationJLabel = new JLabel("Education");
    statelabel = new JLabel("State");
    occupationJLabel = new JLabel("Mother Tongue");
    religionJLabel = new JLabel("Religion");
    JLabel title = new JLabel("Filter");
    JLabel sort = new JLabel("Sort By ");

    ageJlabel.setBounds(50, 100 + 0, 60, 20);
//    annunalincomeJLabel.setBounds(50, 100 + 60, 120, 30);
    educationJLabel.setBounds(50, 100 + 90, 120, 30);
//    statelabel.setBounds(50, 100 + 140, 70, 20);
    occupationJLabel.setBounds(50, 100 + 190, 80, 20);
    religionJLabel.setBounds(50, 100 + 240, 80, 20);

    sort.setBounds(50, 50, 100, 20);
    sort.setFont(new java.awt.Font("Arial Black", 1, 18));
    sortList.setBounds(150, 50, 100, 20);
    title.setBounds(50, 80, 200, 20);
    title.setFont(new java.awt.Font("Arial Black", 1, 18));
    age1.setBounds(50, 100 + 30, 60, 20);
    to.setBounds(120, 100 + 30, 20, 20);
    age2.setBounds(180, 100 + 30, 60, 20);
//    incomeList.setBounds(150, 100 + 60, 100, 20);
    eduList.setBounds(150, 100 + 100, 100, 20);
//    stateList.setBounds(150, 100 + 140, 100, 20);
    workList.setBounds(150, 100 + 190, 100, 20);
    religionList.setBounds(150, 100 + 240, 100, 20);

    searchLeftPanel.add(sort);
    searchLeftPanel.add(sortList);
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

  private void refresh(JPanel rightPanel) {
    rightPanel.removeAll();
    rightPanelCompoent(rightPanel);
    rightPanel.revalidate();
    rightPanel.repaint();
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
    JLabel income = new JLabel(profileInfo.getHeight()+" ft");
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
     Profiles suggestions = HomeUI.profiles;



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
    scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane1.setBackground(Color.white);

    ArrayList<ProfileInfo> prof = new ArrayList<>(suggestions.getProfiles());
    Comparator<ProfileInfo> ageSort = Comparator.comparingInt(ProfileInfo::getAge);
    Comparator<ProfileInfo> heightSort = Comparator.comparingDouble(ProfileInfo::getHeight);

    switch(chosen) {
      case "height": Collections.sort(prof, heightSort);
        break;
      case "age":Collections.sort(prof, ageSort);
        break;
      default: Collections.sort(prof, ProfileInfo::compareTo);
    }
     for (ProfileInfo profileInfo : prof) {
       JPanel insert = scrollList(profileInfo);
       if(insert!=null && profileInfo.getAge() >= minAge && profileInfo.getAge() <= maxAge && (degree.equals("Select")||degree.equals(profileInfo.getHighestEducation())) &&
               (mt.equals("Select") || mt.equalsIgnoreCase(profileInfo.getMotherTongue())) && (rel.equals("Select") || rel.equalsIgnoreCase(profileInfo.getReligion())) &&
               (loc.equals("Select") || loc.equalsIgnoreCase(profileInfo.getState())))listPanel.add(insert);
    }

    // Content Panel Starts
    JPanel contentPane = new JPanel(null);

    JLabel matchLabel = new JLabel("Search Matches");
    matchLabel.setForeground(Color.orange);
    matchLabel.setBounds(20, 0, 300, 30);
    matchLabel.setFont(new Font("Arial Black", 1, 24));

    contentPane.setPreferredSize(new Dimension(200, 200));
    contentPane.add(matchLabel);
    contentPane.add(scrollPane1);
    contentPane.setBackground(Color.white);

    // adding to right panel
    panel.add(contentPane, BorderLayout.CENTER);
  }
}
