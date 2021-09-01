package client.java.ui;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.sql.*;
import javax.swing.JOptionPane;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import client.java.Client;
import client.java.forms.LoginForm;

import javabeans.ProfileInfo;
import javabeans.Profiles;
import javabeans.UserDetails;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Component;

public class HomeUI {
  JPanel mainPanel, headerPanel, leftPanel, rightPanel, suggestionPanel;
  int width, height, count = 0;
  UserDetails userInfo;

  public HomeUI(JPanel mainPanel, UserDetails userInfo) {
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    width = (int) dimension.getWidth();
    height = (int) dimension.getHeight();
    this.userInfo = userInfo;
    this.mainPanel = mainPanel;
    suggestionPanel = new JPanel();
    leftPanel = new JPanel();
    rightPanel = new JPanel();
    headerPanel = new JPanel();
    headerPanel.setBounds(0, 0, width, height / 5);
    leftPanel.setBounds(0, height / 5, width / 4, height * 4 / 5);
    rightPanel.setBounds(width / 4, height / 5, width * 3 / 4, height * 4 / 5);

    mainPanel.setBounds(0, 0, width, height);

    leftPanel.setLayout(null);

    headerPanelComponent(headerPanel);
    leftPanelComponent(leftPanel);
    rightPanelCompoent(rightPanel);

    headerPanel.setBackground(Color.WHITE);
    rightPanel.setBackground(Color.white);

    mainPanel.add(headerPanel);
    mainPanel.add(leftPanel);
    mainPanel.add(rightPanel);
  }

  public JPanel profileList(ProfileInfo profileInfo) {
    JPanel userPanel = new JPanel();
    userPanel.setLayout(new FlowLayout());
    userPanel.setPreferredSize(new Dimension(200, 200));

    JLabel dp = new JLabel();
    JLabel name = new JLabel(profileInfo.getName());

    dp.setIcon(
        new ImageIcon(profileInfo.getProfileImageIcon().getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT)));
    dp.setHorizontalAlignment(SwingConstants.CENTER);
    dp.setPreferredSize(new Dimension(200, 150));
    userPanel.add(dp);

    name.setPreferredSize(new Dimension(200, 50));
    name.setHorizontalAlignment(SwingConstants.CENTER);
    userPanel.setBackground(Color.white);
    userPanel.add(name);
    count++;
    return userPanel;
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
        rightPanel.removeAll();
        rightPanelCompoent(rightPanel);
        rightPanel.revalidate();
        rightPanel.repaint();
      });
      return null;
    } else if (userInfo.getProfileInfo().getRequestedPair().contains(profileInfo.getUserId())) {
      button.setText("UnRequest");
      button.addActionListener((e) -> {
        userInfo.setProfileInfo(new Client().pairRequest(userInfo.getLogin().getUserID(), profileInfo.getUserId(), 0));
        rightPanel.removeAll();
        rightPanelCompoent(rightPanel);
        rightPanel.revalidate();
        rightPanel.repaint();
      });
    } else if (userInfo.getProfileInfo().getPairRequest().contains(profileInfo.getUserId())) {
      button.setText("Accept");

      button.addActionListener((e) -> {
        userInfo
            .setProfileInfo(new Client().acceptRequest(userInfo.getLogin().getUserID(), profileInfo.getUserId(), 1));
        rightPanel.removeAll();
        rightPanelCompoent(rightPanel);
        rightPanel.revalidate();
        rightPanel.repaint();
      });
    } else {
      button.setText("Request");
      button.addActionListener((e) -> {
        userInfo.setProfileInfo(new Client().pairRequest(userInfo.getLogin().getUserID(), profileInfo.getUserId(), 1));
        rightPanel.removeAll();
        rightPanelCompoent(rightPanel);
        rightPanel.revalidate();
        rightPanel.repaint();
        mainPanel.revalidate();
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

  private void headerPanelComponent(JPanel panel) {
    panel.setLayout(new FlowLayout());
    JButton home = new JButton("Home");
    JButton search = new JButton("Search");
    JButton pair = new JButton("Pair Status");
    JButton logout = new JButton("LOG OUT");

    home.setPreferredSize(new Dimension(200, 50));
    search.setPreferredSize(new Dimension(200, 50));
    pair.setPreferredSize(new Dimension(200, 50));
    logout.setPreferredSize(new Dimension(200, 50));

    home.setFont(new java.awt.Font("Verdana", 1, 24));
    search.setFont(new java.awt.Font("Verdana", 1, 24));
    pair.setFont(new java.awt.Font("Verdana", 1, 24));
    logout.setFont(new java.awt.Font("Verdana", 1, 24));

    home.setBorder(null);
    search.setBorder(null);
    pair.setBorder(null);
    logout.setBorder(null);

    home.setBackground(null);
    search.setBackground(null);
    pair.setBackground(null);
    logout.setBackground(null);

    home.addActionListener((e) -> {
      mainPanel.removeAll();
      new HomeUI(mainPanel, userInfo);
      mainPanel.revalidate();
      mainPanel.repaint();
    });

    search.addActionListener((e) -> {
      leftPanel.removeAll();
      rightPanel.removeAll();
      new SearchUI(mainPanel, leftPanel, rightPanel, userInfo);
      mainPanel.revalidate();
      mainPanel.repaint();
    });

    pair.addActionListener((e) -> {
      leftPanel.removeAll();
      rightPanel.removeAll();
      new MatchesUI(mainPanel, leftPanel, rightPanel, userInfo);
      mainPanel.revalidate();
      mainPanel.repaint();
    });

    logout.addActionListener((e) -> {
      mainPanel.removeAll();
      new LoginForm(mainPanel);
      mainPanel.revalidate();
      mainPanel.repaint();
    });

    panel.add(home);
    panel.add(search);
    panel.add(pair);
    panel.add(logout);
  }

  public Image toImage(BufferedImage bufferedImage) {
    return Toolkit.getDefaultToolkit().createImage(bufferedImage.getSource());
  }

  private static BufferedImage resizeImage(BufferedImage originalImage, int type) {
    BufferedImage resizedImage = new BufferedImage(300, 300, type);
    Graphics2D g = resizedImage.createGraphics();
    g.drawImage(originalImage, 0, 0, 300, 300, null);
    g.dispose();

    return resizedImage;
  }

  private void leftPanelComponent(JPanel panel) {
    JLabel name = new JLabel(userInfo.getProfileInfo().getName());
    JLabel dp = new JLabel();
    JButton editProfile = new JButton("Edit Profile");
    JButton editPreferance = new JButton("Edit Preferance");
    JButton verifyAcoount = new JButton("Verify Account");

    name.setFont(new java.awt.Font("Arial Black", 1, 24));
    editProfile.setFont(new java.awt.Font("Arial Black", 1, 18));
    editPreferance.setFont(new java.awt.Font("Arial Black", 1, 18));
    verifyAcoount.setFont(new java.awt.Font("Arial Black", 1, 18));

    dp.setBounds(0, 10, width / 4, 310);
    name.setBounds(0, 330, width / 4, 25);
    editProfile.setBounds(0, 50 + 360, width / 4, 30);
    editPreferance.setBounds(0, 50 + 400, width / 4, 30);
    verifyAcoount.setBounds(0, 50 + 440, width / 4, 30);

    verifyAcoount.setBorder(null);
    verifyAcoount.setBackground(null);
    editPreferance.setBorder(null);
    editPreferance.setBackground(null);
    editProfile.setBorder(null);
    editProfile.setBackground(null);

    ImageIcon img = userInfo.getProfileInfo() != null ? userInfo.getProfileInfo().getProfileImageIcon()
        : new ImageIcon("src/client/resource/images/sadu.jpg");
    dp.setIcon(new ImageIcon(img.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));

    dp.setHorizontalAlignment(SwingConstants.CENTER);

    name.setHorizontalAlignment(SwingConstants.CENTER);
    editPreferance.setHorizontalAlignment(SwingConstants.CENTER);
    editProfile.setHorizontalAlignment(SwingConstants.CENTER);
    verifyAcoount.setHorizontalAlignment(SwingConstants.CENTER);

    editProfile.addActionListener((e) -> {
      JFileChooser chooser;
      ImageIcon photo = new ImageIcon("src/client/resource/images/default.jpg");
      File image = null;
      FileNameExtensionFilter filter;
      chooser = new JFileChooser();
      chooser.setCurrentDirectory(image);
      filter = new FileNameExtensionFilter("jpeg, gif and png files", "jpg", "gif", "png");
      chooser.addChoosableFileFilter(filter);

      int i = chooser.showOpenDialog(leftPanel);
      if (i == JFileChooser.APPROVE_OPTION) {
        image = chooser.getSelectedFile();
        try {
          BufferedImage originalImage = ImageIO.read(image);
          int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

          BufferedImage resizeImageJpg = resizeImage(originalImage, type);
          photo = new ImageIcon(toImage(resizeImageJpg));

        } catch (IOException ex) {
          System.out.println(ex.getMessage());
        }

        userInfo.getProfileInfo().setProfileImageIcon(photo);

        new Client().update(userInfo);

        leftPanel.removeAll();
        leftPanelComponent(leftPanel);
        leftPanel.revalidate();
        leftPanel.repaint();
        chooser.setCurrentDirectory(image);
      }
    });

    panel.setBackground(Color.white);

    panel.add(name);
    panel.add(dp);
    panel.add(editProfile);
    panel.add(editPreferance);
    panel.add(verifyAcoount);
  }

  public void rightPanelCompoent(JPanel panel) {

    String gender = userInfo.getBasicDetails().getGender();
    String filter = (gender.equals("MALE") ? "FEMALE" : "MALE");
    Profiles suggestions = new Client().filter(filter);

    System.out.println(suggestions.getProfiles().size());

    panel.setLayout(new BorderLayout());

    // Suggestion Panel
//    suggestionPanel = new JPanel();
    suggestionPanel.setLayout(new BoxLayout(suggestionPanel, BoxLayout.X_AXIS));
    suggestionPanel.setAutoscrolls(true);
    suggestionPanel.setBackground(Color.white);

    JScrollPane scrollPane = new JScrollPane(suggestionPanel);
    JScrollBar horizontalScrollBar = new JScrollBar(JScrollBar.VERTICAL) {

      @Override
      public boolean isVisible() {
        return true;
      }
    };

    panel.setBackground(Color.white);
    horizontalScrollBar.putClientProperty("JScrollBar.fastWheelScrolling", Boolean.TRUE);
    scrollPane.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));

    scrollPane.setBounds(40, 30, (width * 3 / 4) - 80, 220);
    scrollPane.setWheelScrollingEnabled(true);
    scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setHorizontalScrollBar(horizontalScrollBar);
    scrollPane.setBackground(Color.white);

    // for (int i = 0; i < 10; i++) {
    // suggestionPanel.add(profileList(i));
    // }

    // List Panel Starts
    JPanel listPanel = new JPanel();
    listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
    listPanel.setAutoscrolls(true);
    listPanel.setBackground(Color.white);

    JScrollPane scrollPane1 = new JScrollPane(listPanel);
    scrollPane1.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
    scrollPane1.setBounds(40, 300, (width * 3 / 4) - 120, height / 2 - 15);
    scrollPane1.setWheelScrollingEnabled(true);
    scrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane1.setBackground(Color.white);

    // ProfileInfo profileInfo = new ProfileInfo();
    // profileInfo.setAge(24);
    // profileInfo.setOccupation("Youtuber");
    // profileInfo.setName("Akshaya");
    // profileInfo.setState("Tamilnadu");
    // profileInfo.setHighestEducation("B.Tech");
    // profileInfo.setReligion("Hindu");
    // profileInfo.setProfileImageIcon(new
    // ImageIcon("src/client/resource/images/dp.jpg"));
    // suggestions.getProfiles().add(userInfo.getProfileInfo());
    for (ProfileInfo profileInfo : suggestions.getProfiles()) {
      if (count > 8) {
        JPanel insert = scrollList(profileInfo);
        if(insert!=null)
        listPanel.add(insert);
      }
        else {
        JPanel insert = profileList(profileInfo);
        if(insert!=null)
          suggestionPanel.add(insert);
      }
    }

    // Content Panel Starts
    JPanel contentPane = new JPanel(null);
    JLabel suggestionLabel = new JLabel("Today's Suggestion");
    suggestionLabel.setBounds(20, 0, 300, 30);
    suggestionLabel.setForeground(Color.orange);
    suggestionLabel.setFont(new java.awt.Font("Arial Black", 1, 24));

    JLabel matchLabel = new JLabel("New Matches");
    matchLabel.setForeground(Color.orange);
    matchLabel.setBounds(20, 260, 200, 30);
    matchLabel.setFont(new java.awt.Font("Arial Black", 1, 24));

    contentPane.setPreferredSize(new Dimension(200, 200));
    contentPane.add(suggestionLabel);
    contentPane.add(matchLabel);
    contentPane.add(scrollPane);
    contentPane.add(scrollPane1);
    contentPane.setBackground(Color.white);

    // adding to right panel
    panel.add(contentPane, BorderLayout.CENTER);
  }
}