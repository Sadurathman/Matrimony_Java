package client.java.forms;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import client.java.Client;
import client.java.ui.HomeUI;
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
import javabeans.ReligionInformation;
import javabeans.ReligionPreference;
import javabeans.UserDetails;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import javax.swing.JLabel;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class RegisterForm {

        private UserDetails userDetails;
        private BasicDetails basicDetails;
        private BasicInformation basicInformation;
        private BasicPreference basicPreference;
        private ExtraInfo extraInfo;
        private FamilyInformation familyInformation;
        private LifeStyleInfo lifeStyleInfo;
        private Login login;
        private LocationPreferences locationPreferences;
        private PersonalDetails personalDetails;
        private ProfessionPreference professionPreference;
        private ProfessionalDetails professionalDetails;
        private ReligionInformation religionInformation;
        private ReligionPreference religionPreference;
        private ProfileInfo profileInfo;

        private JButton loginButton, registerButton;
        private JLabel numerror, nameerror;
        private javax.swing.JComboBox<String> jComboBox1;
        private javax.swing.JComboBox<String> jComboBox2;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JTextField jTextField1;
        private javax.swing.JTextField jTextField2;
        private javax.swing.JButton jButton1;
        private javax.swing.JComboBox<String> jComboBox3;
        private javax.swing.JComboBox<String> jComboBox4;
        private javax.swing.JComboBox<String> jComboBox5;
        private javax.swing.JPasswordField jPasswordField1;
        private int height, width;
        // private boolean valid = true;
        Border border = new LineBorder(Color.red, 2, true);

        public RegisterForm() {
                userDetails = new UserDetails();
                basicDetails = new BasicDetails();
                basicInformation = new BasicInformation();
                basicPreference = new BasicPreference();
                extraInfo = new ExtraInfo();
                familyInformation = new FamilyInformation();
                lifeStyleInfo = new LifeStyleInfo();
                login = new Login();
                locationPreferences = new LocationPreferences();
                personalDetails = new PersonalDetails();
                professionPreference = new ProfessionPreference();
                professionalDetails = new ProfessionalDetails();
                religionInformation = new ReligionInformation();
                religionPreference = new ReligionPreference();
                profileInfo = new ProfileInfo();

                userDetails.setBasicDetails(basicDetails);
                userDetails.setBasicInformation(basicInformation);
                userDetails.setBasicPreference(basicPreference);
                userDetails.setExtraInfo(extraInfo);
                userDetails.setFamilyInformation(familyInformation);
                userDetails.setLifeStyleInfo(lifeStyleInfo);
                userDetails.setLocationPreferences(locationPreferences);
                userDetails.setLogin(login);
                userDetails.setPersonalDetails(personalDetails);
                userDetails.setProfessionPreference(professionPreference);
                userDetails.setProfessionalDetails(professionalDetails);
                userDetails.setProfileInfo(profileInfo);
                userDetails.setReligionInformation(religionInformation);
                userDetails.setReligionPreference(religionPreference);
        }

        public void createHomeUI(JPanel mainPanel) {
                Border border = BorderFactory.createLineBorder(Color.RED);
                Border border1 = BorderFactory.createLineBorder(Color.GREEN);

                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                width = (int) dimension.getWidth();
                height = (int) dimension.getHeight();

                jTextField2 = new javax.swing.JTextField();

                jTextField2.setBounds(width / 2 + 300, height - 168, 200, 40);
                jTextField2.addKeyListener(new KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent e) {

                        }

                        @Override
                        public void keyPressed(KeyEvent e) {

                        }

                        @Override
                        public void keyReleased(KeyEvent e) {
                                String str = jTextField2.getText();
                                if (str.length() == 10 && Pattern.matches("^[6-9][0-9]{9}", str)) {

                                        numerror.setVisible(false);
                                        jTextField2.setBorder(border1);

                                }

                                else {

                                        numerror.setText("! Invalid Number");
                                        jTextField2.setBorder(border);

                                        numerror.setVisible(true);
                                }
                        }

                });

                jComboBox1 = new javax.swing.JComboBox<>();
                jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+91", "+01" }));
                jComboBox1.setBounds(width / 2 + 230, height - 168, 70, 40);

                jComboBox2 = new javax.swing.JComboBox<>();
                jComboBox2.setEditable(true);
                jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "Myself-Male", "Myself-Female" }));
                jComboBox2.setBounds(width / 2 - 300, height - 168, 200, 40);

                mainPanel.setBounds(0, 0, width, height);
                loginButton = new JButton("Log IN");
                registerButton = new JButton("Register Free");
                loginButton.setForeground(Color.orange);
                loginButton.setBackground(new java.awt.Color(255, 255, 255));
                loginButton.setFont(new java.awt.Font("Arial Black", 1, 12));
                loginButton.setBounds(width - 120, 45, 90, 30);

                registerButton.setBounds(width - 326, height - 200, 180, 80);
                registerButton.setBackground(new java.awt.Color(255, 153, 0));
                registerButton.setFont(new java.awt.Font("Arial Black", 1, 14));
                registerButton.setForeground(new java.awt.Color(255, 255, 255));
                registerButton.addActionListener((e) -> {
                        if (jTextField1.getText().equals("") || jTextField2.getText().equals("")) {

                                if (jTextField1.getText().equals("")) {
                                        jTextField1.setBorder(border);
                                        // jTextField1.setBorder(border1);
                                } else if (jTextField2.getText().equals("")) {
                                        jTextField2.setBorder(border);
                                        // jTextField2.setBorder(border1);
                                }
                        } else {
                                basicDetails.setGender(jComboBox2.getSelectedIndex() == 0 ? "MALE" : "FEMALE");
                                userDetails.getProfileInfo().setName(jTextField1.getText());
                                basicDetails.setPhone(jTextField2.getText());
                                jTextField2.setBorder(border);
                                mainPanel.removeAll();
                                createForm1UI(mainPanel);
                                mainPanel.revalidate();
                                mainPanel.repaint();
                        }
                });

                jLabel2 = new javax.swing.JLabel();
                jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 2, 22));
                jLabel2.setForeground(Color.orange);
                jLabel2.setText("Matrimonial Profile For");
                jLabel2.setBounds(width / 2 - 300, height - 218, 220, 27);

                jLabel3 = new javax.swing.JLabel();
                jLabel3.setFont(new java.awt.Font("Monotype Corsiva", 1, 32));
                jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                jLabel3.setText("Lakhs of Peoples found their perfect match here! ");
                jLabel3.setBounds(width / 2 - 300, height - 318, 680, 30);
                jLabel3.setForeground(Color.orange);

                jLabel4 = new javax.swing.JLabel();
                jLabel4.setFont(new java.awt.Font("Monotype Corsiva", 2, 22));
                jLabel4.setForeground(Color.orange);
                jLabel4.setText("Name");
                jLabel4.setBounds(width / 2, height - 218, 110, 30);

                jLabel5 = new javax.swing.JLabel();
                jLabel5.setFont(new java.awt.Font("Monotype Corsiva", 2, 22));
                jLabel5.setForeground(Color.orange);
                jLabel5.setText("Mobile Number");
                jLabel5.setBounds(width / 2 + 300, height - 218, 160, 30);

                jLabel6 = new javax.swing.JLabel();
                jLabel6.setFont(new java.awt.Font("Monotype Corsiva", 1, 24));
                jLabel6.setForeground(Color.orange);
                jLabel6.setText(" You too can find a life partner");
                jLabel6.setBounds(width / 2 - 300, height - 288, 320, 30);

                jLabel7 = new javax.swing.JLabel();
                jLabel7.setFont(new java.awt.Font("Constantia", 1, 12));
                jLabel7.setForeground(new java.awt.Color(255, 255, 255));
                jLabel7.setText("Already a member?");
                jLabel7.setBounds(width - 240, 50, 120, 20);

                numerror = new JLabel();
                numerror.setBounds(width - 646, height - 200, 160, 30);
                numerror.setForeground(Color.red);

                nameerror = new JLabel();
                nameerror.setBounds(width - 966, height - 200, 110, 30);
                nameerror.setForeground(Color.red);

                jTextField1 = new javax.swing.JTextField();
                jTextField1.setFont(new java.awt.Font("Arial", 0, 14));

                jTextField1.setBounds(width - 966, height - 168, 220, 40);
                jTextField1.addKeyListener(new KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent e) {

                        }

                        @Override
                        public void keyPressed(KeyEvent e) {

                        }

                        @Override
                        public void keyReleased(KeyEvent e) {
                                String str4 = jTextField1.getText();
                                if (str4.length() > 2) {
                                        if ((str4.charAt(0) >= 'a' || str4.charAt(0) >= 'A')
                                                        && (str4.charAt(0) <= 'z' || str4.charAt(0) <= 'Z')) {
                                                nameerror.setVisible(false);
                                                jTextField1.setBorder(border1);
                                        }
                                        // nameerror.setVisible(false);
                                } else if (str4.length() <= 2) {

                                        nameerror.setText("! Invalid Name");
                                        jTextField1.setBorder(border);
                                        nameerror.setVisible(true);
                                }

                        }
                });

                jLabel9 = new javax.swing.JLabel();
                jLabel9.setIcon(new javax.swing.ImageIcon("src/client/resource/images/wedding-uk.jpg"));
                jLabel9.setText("jLabel9");
                jLabel9.setBounds(0, 0, width, height);

                if (userDetails.getBasicDetails().getPhone() != null) {

                        jComboBox2.setSelectedIndex("MALE".equals(userDetails.getBasicDetails().getGender()) ? 0 : 1);
                        jTextField1.setText(userDetails.getProfileInfo().getName());
                        jTextField2.setText(userDetails.getBasicDetails().getPhone());
                }

                if (userDetails.getBasicDetails().getGender() != null) {
                        jComboBox2.setBorder(border);
                        jLabel2.setBorder(border);
                        // valid = false;
                }

                loginButton.addActionListener((e) -> {
                        mainPanel.removeAll();
                        new LoginForm(mainPanel);
                        mainPanel.revalidate();
                        mainPanel.repaint();
                });

                mainPanel.setLayout(null);
                mainPanel.add(loginButton);
                mainPanel.add(registerButton);
                mainPanel.add(jLabel2);
                mainPanel.add(jLabel3);
                mainPanel.add(jLabel4);
                mainPanel.add(jLabel5);
                mainPanel.add(jLabel6);
                mainPanel.add(jLabel7);
                mainPanel.add(numerror);
                mainPanel.add(nameerror);
                mainPanel.add(jTextField1);
                mainPanel.add(jTextField2);
                mainPanel.add(jComboBox2);
                mainPanel.add(jComboBox1);
                mainPanel.add(jLabel9);
        }

        public void createForm1UI(JPanel mainPanel) {
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jComboBox1 = new javax.swing.JComboBox<>();
                jComboBox2 = new javax.swing.JComboBox<>();
                jComboBox3 = new javax.swing.JComboBox<>();
                jLabel6 = new javax.swing.JLabel();
                jComboBox4 = new javax.swing.JComboBox<>();
                javax.swing.JPanel registerPanel = new javax.swing.JPanel();
                JPanel jPanel2 = new javax.swing.JPanel();
                jLabel7 = new javax.swing.JLabel();
                jComboBox5 = new javax.swing.JComboBox<>();
                jLabel8 = new javax.swing.JLabel();
                jTextField1 = new javax.swing.JTextField();
                jLabel9 = new javax.swing.JLabel();
                jPasswordField1 = new javax.swing.JPasswordField();
                jButton1 = new javax.swing.JButton();
                JButton jBackButton = new javax.swing.JButton();
                JLabel mailerror = new JLabel();

                mailerror.setForeground(Color.red);

                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                int width = (int) dimension.getWidth();
                int height = (int) dimension.getHeight();

                mainPanel.setBounds(0, 0, width, height);

                jPanel2.setLayout(null);
                registerPanel.setLayout(null);
                registerPanel.setBounds(0, 0, width / 2, height);

                jLabel4.setFont(new java.awt.Font("Monotype Corsiva", 1, 22));
                jLabel4.setText("Great! You have completed 20%");
                jLabel4.setBounds(width - 200, 50, 239, 29);
                registerPanel.add(jLabel4);

                registerPanel.setBackground(new java.awt.Color(255, 255, 255));
                registerPanel.setLayout(null);

                jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 0, 32));
                jLabel2.setText("Tell us about your basic details");
                jLabel2.setBounds(0, 100, width / 2, 50);
                jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
                registerPanel.add(jLabel2);

                jLabel3.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jLabel3.setText("Date of Birth");
                jLabel3.setBounds(50, height / 2 - 300 + 100, 154, 25);
                registerPanel.add(jLabel3);

                jComboBox1.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05",
                                "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
                                "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
                jComboBox1.setBounds(300, height / 2 - 300 + 100, 65, 25);
                registerPanel.add(jComboBox1);

                jComboBox2.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05",
                                "06", "07", "08", "09", "10", "11", "12" }));
                jComboBox2.setBounds(370, height / 2 - 300 + 100, 100, 25);
                registerPanel.add(jComboBox2);

                jComboBox3.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1981", "1982", "1983",
                                "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994",
                                "1995", "1996", "1997", "1998", "1995", "1996", "1997", "1998", "1999", "2000", "2001",
                                "2002", "2003" }));
                jComboBox3.setBounds(475, height / 2 - 300 + 100, 100, 25);
                registerPanel.add(jComboBox3);

                jLabel6.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jLabel6.setText("Religion");
                jLabel6.setBounds(50, height / 2 - 300 + 150, 100, 25);
                registerPanel.add(jLabel6);

                jComboBox4.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Hindu", "Muslim",
                                "Christain", "Sikh", "Jain", "Buddhist", "Inter-Religion" }));
                jComboBox4.setBounds(300, height / 2 - 300 + 150, 180, 25);
                registerPanel.add(jComboBox4);

                jLabel7.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jLabel7.setText("Mother Tongue");
                jLabel7.setBounds(50, height / 2 - 300 + 200, 150, 25);
                registerPanel.add(jLabel7);

                jComboBox5.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "Bengali", "Gujarati", "Hindi", "Kannada", "Malayalam", "Marathi",
                                                "Marwari", "Oriya", "Sindhi", "Tamil", "Telugu", "Urdu" }));
                jComboBox5.setSelectedIndex(9);
                jComboBox5.setBounds(300, height / 2 - 300 + 200, 180, 25);
                registerPanel.add(jComboBox5);

                jLabel8.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jLabel8.setText("Email ID");
                jLabel8.setBounds(50, height / 2 - 300 + 250, 150, 25);
                registerPanel.add(jLabel8);

                jTextField1.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jTextField1.setBounds(300, height / 2 - 300 + 250, 180, 25);
                jTextField1.addActionListener((ActionEvent e) -> {
                        String str = jTextField1.getText();
                        if (Pattern.matches("^[a-zA-Z0-9_+&-]+(?:\\." + "[a-zA-Z0-9_+&-]+)*@"
                                        + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$", str)) {
                                mailerror.setVisible(false);
                        } else {
                                registerPanel.add(mailerror);
                                mailerror.setBounds(400, 190, 150, 100);
                                mailerror.setText("Invalid E-mail");
                                mailerror.setVisible(true);
                        }
                });

                // if (userDetails.getBasicDetails().getDateOfBirth() != null) {
                // jComboBox1.setBorder(border);
                // jComboBox2.setBorder(border);
                // jComboBox3.setBorder(border);
                // }

                // if (userDetails.getBasicDetails().getReligion() != null) {
                // jComboBox4.setBorder(border);
                // jLabel6.setBorder(border);
                // // valid = false;
                // }

                // if (userDetails.getBasicDetails().getMotherTongue() != null) {
                // jComboBox5.setBorder(border);
                // jLabel7.setBorder(border);
                // // valid = false;
                // }

                // if (userDetails.getBasicDetails().getEmail() != null) {
                // jTextField1.setBorder(border);
                // // valid = false;
                // }

                registerPanel.add(jTextField1);

                jLabel9.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jLabel9.setText("New Password");
                jLabel9.setBounds(50, height / 2 - 300 + 300, 180, 25);
                registerPanel.add(jLabel9);

                jPasswordField1.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jPasswordField1.setBounds(300, height / 2 - 300 + 300, 180, 25);
                registerPanel.add(jPasswordField1);

                jButton1.setBackground(new java.awt.Color(255, 153, 0));
                jButton1.setFont(new java.awt.Font("Arial Black", 0, 15));
                jButton1.setForeground(new java.awt.Color(255, 255, 255));
                jButton1.setText("Continue");

                jButton1.setBounds(400, height / 2 + 50, 180, 40);
                jButton1.addActionListener((e) -> {
                        basicDetails.setReligion(jComboBox4.getSelectedItem().toString());
                        basicDetails.setMotherTongue(jComboBox5.getSelectedItem().toString());
                        basicDetails.setEmail(jTextField1.getText());
                        String date = jComboBox1.getSelectedItem().toString();
                        String month = jComboBox2.getSelectedItem().toString();
                        String year = jComboBox3.getSelectedItem().toString();
                        try {
                                basicDetails.setDateOfBirth((new SimpleDateFormat("MM/dd/yyyy"))
                                                .parse(month + "/" + date + "/" + year));
                        } catch (Exception exception) {

                        }
                        login.setUserName(jTextField1.getText());
                        login.setPassword(new String(jPasswordField1.getPassword()));

                        mainPanel.removeAll();
                        createForm2UI(mainPanel);
                        mainPanel.revalidate();
                        mainPanel.repaint();

                        profileInfo.setAge(Period
                                        .between(basicDetails.getDateOfBirth().toInstant()
                                                        .atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now())
                                        .getYears());
                });
                registerPanel.add(jButton1);

                jBackButton.setBackground(new java.awt.Color(255, 153, 0));
                jBackButton.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jBackButton.setForeground(new java.awt.Color(255, 255, 255));
                jBackButton.setText("Back");
                jBackButton.setBounds(10, 10, 100, 25);
                jBackButton.addActionListener((e) -> {
                        mainPanel.removeAll();
                        createHomeUI(mainPanel);
                        mainPanel.revalidate();
                        mainPanel.repaint();
                });
                registerPanel.add(jBackButton);

                if (basicDetails.getEmail() != null) {
                        // jComboBox1.setSelectedIndex(anIndex);
                }

                jPanel2.setBackground(new java.awt.Color(255, 255, 255));
                jPanel2.setLayout(null);
                jPanel2.setBounds(width / 2, 0, width / 2, height);

                jLabel1.setIcon(new javax.swing.ImageIcon("src/client/resource/images/mImage.jpg"));
                jLabel1.setBounds(0, height / 2 - 300, width / 2, height / 2);
                jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
                jPanel2.add(jLabel1);

                if (login.getUserName() != null) {
                        jComboBox4.setSelectedItem(basicDetails.getReligion());
                        jComboBox5.setSelectedItem(basicDetails.getMotherTongue());
                        jTextField1.setText(login.getUserName());
                        String[] date = new SimpleDateFormat("MM/dd/yyyy").format(basicDetails.getDateOfBirth())
                                        .split("/");
                        jComboBox1.setSelectedItem(date[1]);
                        jComboBox2.setSelectedItem(date[0]);
                        jComboBox3.setSelectedItem(date[2]);
                }

                mainPanel.add(registerPanel);
                mainPanel.add(jPanel2);

        }

        public void createForm2UI(JPanel mainPanel) {
                jImage = new javax.swing.JLabel();
                JHeading3 = new javax.swing.JLabel();
                jHeading2 = new javax.swing.JLabel();
                jHeading1 = new javax.swing.JLabel();
                jMaritalStatus = new javax.swing.JLabel();
                jHeight = new javax.swing.JLabel();
                jFamilyStatus = new javax.swing.JLabel();
                jFamilyType = new javax.swing.JLabel();
                jFamilyValues = new javax.swing.JLabel();
                jDisability = new javax.swing.JLabel();
                jContinue = new javax.swing.JButton();
                jNeverMarriedRadioButton1 = new javax.swing.JRadioButton();
                jDivorcedRadioButton2 = new javax.swing.JRadioButton();
                jWidowedRadioButton3 = new javax.swing.JRadioButton();
                jAwaitingDivorcedRadioButton4 = new javax.swing.JRadioButton();
                jHeightComboBox1 = new javax.swing.JComboBox<>();
                jMiddleClassRadioButton5 = new javax.swing.JRadioButton();
                jAffluentRadioButton6 = new javax.swing.JRadioButton();
                jUpperMiddleClassRadioButton7 = new javax.swing.JRadioButton();
                jRichRadioButton8 = new javax.swing.JRadioButton();
                jJointRadioButton9 = new javax.swing.JRadioButton();
                jNuclearRadioButton10 = new javax.swing.JRadioButton();
                jOrthodoxRadioButton11 = new javax.swing.JRadioButton();
                jTraditionalRadioButton12 = new javax.swing.JRadioButton();
                jModerateRadioButton13 = new javax.swing.JRadioButton();
                jLiberalRadioButton14 = new javax.swing.JRadioButton();
                jNoRadioButton15 = new javax.swing.JRadioButton();
                jPhysicallyChallengedRadioButton16 = new javax.swing.JRadioButton();
                JButton jBackButton = new JButton();

                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                int width = (int) dimension.getWidth();
                int height = (int) dimension.getHeight();

                mainPanel.setBounds(0, 0, width, height);

                mainPanel.setLayout(null);

                jImage.setIcon(new javax.swing.ImageIcon("src/client/resource/images/mImage.jpg"));
                jImage.setText("jLabel1");
                mainPanel.add(jImage);
                jImage.setBounds(80, 140, 520, 450);

                JHeading3.setFont(new java.awt.Font("Monotype Corsiva", 0, 36));
                JHeading3.setText("Tell us about your personal details");
                mainPanel.add(JHeading3);
                JHeading3.setBounds(690, 130, 450, 40);

                jHeading2.setFont(new java.awt.Font("Monotype Corsiva", 1, 32));
                jHeading2.setText("40%");
                mainPanel.add(jHeading2);
                jHeading2.setBounds(1200, 50, 60, 40);

                jHeading1.setFont(new java.awt.Font("Monotype Corsiva", 1, 24));
                jHeading1.setText("Great! You have completed");
                mainPanel.add(jHeading1);
                jHeading1.setBounds(940, 60, 260, 20);

                jMaritalStatus.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jMaritalStatus.setText("Marital Status");
                mainPanel.add(jMaritalStatus);
                jMaritalStatus.setBounds(710, 190, 140, 30);

                jHeight.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jHeight.setText("Height");
                mainPanel.add(jHeight);
                jHeight.setBounds(710, 250, 140, 30);

                jFamilyStatus.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jFamilyStatus.setText("Family Status");
                mainPanel.add(jFamilyStatus);
                jFamilyStatus.setBounds(710, 310, 140, 30);

                jFamilyType.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jFamilyType.setText("Family Type");
                mainPanel.add(jFamilyType);
                jFamilyType.setBounds(710, 370, 140, 30);

                jFamilyValues.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jFamilyValues.setText("Family Values");
                mainPanel.add(jFamilyValues);
                jFamilyValues.setBounds(710, 430, 140, 30);

                jDisability.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jDisability.setText("Any Disability");
                mainPanel.add(jDisability);
                jDisability.setBounds(710, 480, 140, 30);

                jContinue.setBackground(new java.awt.Color(255, 153, 0));
                jContinue.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jContinue.setForeground(new java.awt.Color(255, 255, 255));
                jContinue.setText("Continue");
                mainPanel.add(jContinue);
                jContinue.setBounds(920, 590, 160, 40);

                jContinue.addActionListener((e) -> {

                        if (jNeverMarriedRadioButton1.isSelected())
                                personalDetails.setMartialStatus("Never Married");
                        if (jDivorcedRadioButton2.isSelected())
                                personalDetails.setMartialStatus("Divorced");
                        if (jWidowedRadioButton3.isSelected())
                                personalDetails.setMartialStatus("Widowed");
                        if (jAwaitingDivorcedRadioButton4.isSelected())
                                personalDetails.setMartialStatus("Awaiting Divorce");

                        if (jMiddleClassRadioButton5.isSelected())
                                personalDetails.setFamilyStatus("Middle Class");
                        if (jAffluentRadioButton6.isSelected())
                                personalDetails.setFamilyStatus("Affluent");
                        if (jUpperMiddleClassRadioButton7.isSelected())
                                personalDetails.setFamilyStatus("Upper Middle Class");
                        if (jRichRadioButton8.isSelected())
                                personalDetails.setFamilyStatus("Rich");

                        if (jJointRadioButton9.isSelected())
                                personalDetails.setFamilyType("Joint");
                        if (jNuclearRadioButton10.isSelected())
                                personalDetails.setFamilyType("Nuclear");

                        if (jOrthodoxRadioButton11.isSelected())
                                personalDetails.setFamilyValues("Orthodox");
                        if (jTraditionalRadioButton12.isSelected())
                                personalDetails.setFamilyValues("Traditional");
                        if (jModerateRadioButton13.isSelected())
                                personalDetails.setFamilyValues("Moderate");
                        if (jLiberalRadioButton14.isSelected())
                                personalDetails.setFamilyValues("Liberal");

                        if (jNoRadioButton15.isSelected())
                                personalDetails.setAnyDisAbility("No");
                        if (jPhysicallyChallengedRadioButton16.isSelected())
                                personalDetails.setAnyDisAbility("PhysicallyChallenged");
                        personalDetails.setHeight(Float.parseFloat(jHeightComboBox1.getSelectedItem().toString()));
                        profileInfo.setHeight(Float.parseFloat(jHeightComboBox1.getSelectedItem().toString()));

                        mainPanel.removeAll();
                        createForm3UI(mainPanel);
                        mainPanel.revalidate();
                        mainPanel.repaint();
                });
                jBackButton.setBackground(new java.awt.Color(255, 153, 0));
                jBackButton.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jBackButton.setForeground(new java.awt.Color(255, 255, 255));
                jBackButton.setText("Back");
                jBackButton.setBounds(10, 10, 100, 25);
                jBackButton.addActionListener((e) -> {
                        mainPanel.removeAll();
                        createForm1UI(mainPanel);
                        mainPanel.revalidate();
                        mainPanel.repaint();
                });
                mainPanel.add(jBackButton);

                jNeverMarriedRadioButton1.setText("Never Married");
                mainPanel.add(jNeverMarriedRadioButton1);
                jNeverMarriedRadioButton1.setBounds(873, 190, 110, 23);

                jDivorcedRadioButton2.setText("Divorced");
                mainPanel.add(jDivorcedRadioButton2);
                jDivorcedRadioButton2.setBounds(990, 190, 80, 23);

                jWidowedRadioButton3.setText("Widowed");

                mainPanel.add(jWidowedRadioButton3);
                jWidowedRadioButton3.setBounds(1080, 190, 90, 23);

                jAwaitingDivorcedRadioButton4.setText("Awaiting Divorce");
                mainPanel.add(jAwaitingDivorcedRadioButton4);
                jAwaitingDivorcedRadioButton4.setBounds(1173, 190, 120, 23);

                jHeightComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "4.6", "4.7",
                                "4.8", "4.9", "5", "5.1", "5.2", "5.3", "5.4", "5.5", "5.6", "5.7", "5.8", "5.9", "6",
                                "6.1", "6.2", "6.3", "6.4", "6.5", "6.6", "6.7", "6.8", "6.9", "7" }));
                mainPanel.add(jHeightComboBox1);
                jHeightComboBox1.setBounds(900, 250, 130, 20);

                jMiddleClassRadioButton5.setText("Middle Class");
                mainPanel.add(jMiddleClassRadioButton5);
                jMiddleClassRadioButton5.setBounds(880, 310, 100, 23);

                jAffluentRadioButton6.setText("Affluent");
                mainPanel.add(jAffluentRadioButton6);
                jAffluentRadioButton6.setBounds(995, 310, 80, 23);

                jUpperMiddleClassRadioButton7.setText("Upper Middle Class");
                mainPanel.add(jUpperMiddleClassRadioButton7);
                jUpperMiddleClassRadioButton7.setBounds(1078, 310, 140, 23);

                jRichRadioButton8.setText("Rich");
                mainPanel.add(jRichRadioButton8);
                jRichRadioButton8.setBounds(1220, 310, 70, 23);

                jJointRadioButton9.setText("Joint");
                mainPanel.add(jJointRadioButton9);
                jJointRadioButton9.setBounds(889, 370, 60, 23);

                jNuclearRadioButton10.setText("Nuclear");

                mainPanel.add(jNuclearRadioButton10);
                jNuclearRadioButton10.setBounds(1010, 370, 80, 23);

                jOrthodoxRadioButton11.setText("Orthodox");
                mainPanel.add(jOrthodoxRadioButton11);
                jOrthodoxRadioButton11.setBounds(891, 430, 80, 23);

                jTraditionalRadioButton12.setText("Traditional");
                mainPanel.add(jTraditionalRadioButton12);
                jTraditionalRadioButton12.setBounds(995, 430, 90, 23);

                jModerateRadioButton13.setText("Moderate");
                mainPanel.add(jModerateRadioButton13);
                jModerateRadioButton13.setBounds(1110, 430, 90, 23);

                jLiberalRadioButton14.setText("Liberal");
                mainPanel.add(jLiberalRadioButton14);
                jLiberalRadioButton14.setBounds(1210, 430, 80, 23);

                jNoRadioButton15.setText("No");

                jNoRadioButton15.setBounds(900, 480, 45, 23);
                mainPanel.add(jNoRadioButton15);

                jPhysicallyChallengedRadioButton16.setText("Physically Challenged");

                mainPanel.add(jPhysicallyChallengedRadioButton16);
                jPhysicallyChallengedRadioButton16.setBounds(990, 480, 180, 23);
                if (personalDetails.getFamilyValues() != null) {
                        if (personalDetails.getMartialStatus().equals("Never Married"))
                                jNeverMarriedRadioButton1.setSelected(true);
                        if (personalDetails.getMartialStatus().equals("Divorced"))
                                jDivorcedRadioButton2.setSelected(true);
                        if (personalDetails.getMartialStatus().equals("Widowed"))
                                jWidowedRadioButton3.setSelected(true);
                        if (personalDetails.getMartialStatus().equals("Awaiting Divorce"))
                                jAwaitingDivorcedRadioButton4.setSelected(true);

                        if (personalDetails.getFamilyStatus().equals("Middle Class"))
                                jMiddleClassRadioButton5.setSelected(true);
                        if (personalDetails.getFamilyStatus().equals("Affluent"))
                                jAffluentRadioButton6.setSelected(true);
                        if (personalDetails.getFamilyStatus().equals("Upper Middle Class"))
                                jUpperMiddleClassRadioButton7.setSelected(true);
                        if (personalDetails.getFamilyStatus().equals("Rich"))
                                jRichRadioButton8.setSelected(true);

                        if (personalDetails.getFamilyType().equals("Joint"))
                                jJointRadioButton9.setSelected(true);
                        if (personalDetails.getFamilyType().equals("Nuclear"))
                                jNuclearRadioButton10.setSelected(true);

                        if (personalDetails.getFamilyValues().equals("Orthodox"))
                                jOrthodoxRadioButton11.setSelected(true);
                        if (personalDetails.getFamilyValues().equals("Traditional"))
                                jTraditionalRadioButton12.setSelected(true);
                        if (personalDetails.getFamilyValues().equals("Moderate"))
                                jModerateRadioButton13.setSelected(true);
                        if (personalDetails.getFamilyValues().equals("Liberal"))
                                jLiberalRadioButton14.setSelected(true);

                        if (personalDetails.getAnyDisability().equals("No"))
                                jNoRadioButton15.setSelected(true);
                        if (personalDetails.getAnyDisability().equals("PhysicallyChallenged"))
                                jPhysicallyChallengedRadioButton16.setSelected(true);
                        jHeightComboBox1.setSelectedItem(personalDetails.getHeight() + "");
                }

                mainPanel.setBounds(0, 0, 1390, 710);

        }// </editor-fold>

        // Variables declaration - do not modify
        private javax.swing.JLabel JHeading3;
        private javax.swing.JRadioButton jAffluentRadioButton6;
        private javax.swing.JRadioButton jAwaitingDivorcedRadioButton4;
        private javax.swing.JButton jContinue;
        private javax.swing.JLabel jDisability;
        private javax.swing.JRadioButton jDivorcedRadioButton2;
        private javax.swing.JLabel jFamilyStatus;
        private javax.swing.JLabel jFamilyType;
        private javax.swing.JLabel jFamilyValues;
        private javax.swing.JLabel jHeading1;
        private javax.swing.JLabel jHeading2;
        private javax.swing.JLabel jHeight;
        private javax.swing.JComboBox<String> jHeightComboBox1;
        private javax.swing.JLabel jImage;
        private javax.swing.JRadioButton jJointRadioButton9;
        private javax.swing.JRadioButton jLiberalRadioButton14;
        private javax.swing.JLabel jMaritalStatus;
        private javax.swing.JRadioButton jMiddleClassRadioButton5;
        private javax.swing.JRadioButton jModerateRadioButton13;
        private javax.swing.JRadioButton jNeverMarriedRadioButton1;
        private javax.swing.JRadioButton jNoRadioButton15;
        private javax.swing.JRadioButton jNuclearRadioButton10;
        private javax.swing.JRadioButton jOrthodoxRadioButton11;
        private javax.swing.JRadioButton jPhysicallyChallengedRadioButton16;
        private javax.swing.JRadioButton jRichRadioButton8;
        private javax.swing.JRadioButton jTraditionalRadioButton12;
        private javax.swing.JRadioButton jUpperMiddleClassRadioButton7;
        private javax.swing.JRadioButton jWidowedRadioButton3;
        // End of variables declaration

        public void createForm3UI(JPanel RegisterPanel2) {
                jImage1 = new javax.swing.JLabel();
                jHeading1Rp2Label2 = new javax.swing.JLabel();
                jHeading2Rp2Label3 = new javax.swing.JLabel();
                jHeading3Rp2Label4 = new javax.swing.JLabel();
                jHighestEduLabel5 = new javax.swing.JLabel();
                jEmplyodedInLabel6 = new javax.swing.JLabel();
                jGovernmentRadioButton1 = new javax.swing.JRadioButton();
                jEducationComboBox1 = new javax.swing.JComboBox<>();
                jPrivateRadioButton2 = new javax.swing.JRadioButton();
                jBusinessRadioButton3 = new javax.swing.JRadioButton();
                jDefenceRadioButton4 = new javax.swing.JRadioButton();
                jSelfEmployedRadioButton5 = new javax.swing.JRadioButton();
                jNotWorkingRadioButton6 = new javax.swing.JRadioButton();
                jOccupationLabel7 = new javax.swing.JLabel();
                jAnnualIncomeLabel8 = new javax.swing.JLabel();
                jAnnualIncomeTextField1 = new javax.swing.JTextField();
                jWorkLocationLabel9 = new javax.swing.JLabel();
                jStateLabel10 = new javax.swing.JLabel();
                jWorkLocationTextField2 = new javax.swing.JTextField();
                jStateTextField3 = new javax.swing.JTextField();
                jCityLabel11 = new javax.swing.JLabel();
                jCityTextField4 = new javax.swing.JTextField();
                jContinueRp2Button1 = new javax.swing.JButton();
                jOccupationTextField5 = new javax.swing.JTextField();
                jRupeesTextField6 = new javax.swing.JTextField();
                JButton jBackButton = new JButton();

                // RegisterPanel2.setBounds(0, 0, width, height);

                RegisterPanel2.setLayout(null);

                jImage1.setIcon(new javax.swing.ImageIcon("src/client/resource/images/mImage.jpg"));
                RegisterPanel2.add(jImage1);
                jImage1.setBounds(30, 100, 670, 490);

                jHeading1Rp2Label2.setFont(new java.awt.Font("Monotype Corsiva", 1, 22));
                jHeading1Rp2Label2.setText("Great! You have completed ");
                RegisterPanel2.add(jHeading1Rp2Label2);
                jHeading1Rp2Label2.setBounds(990, 30, 240, 30);

                jHeading2Rp2Label3.setFont(new java.awt.Font("Monotype Corsiva", 1, 32));
                jHeading2Rp2Label3.setText("60%");
                RegisterPanel2.add(jHeading2Rp2Label3);
                jHeading2Rp2Label3.setBounds(1230, 10, 60, 70);

                jHeading3Rp2Label4.setFont(new java.awt.Font("Monotype Corsiva", 0, 28));
                jHeading3Rp2Label4.setText("Professional details help us to find the best companion");
                RegisterPanel2.add(jHeading3Rp2Label4);
                jHeading3Rp2Label4.setBounds(750, 110, 550, 40);

                jHighestEduLabel5.setFont(new java.awt.Font("Monotype Corsiva", 0, 20));
                jHighestEduLabel5.setText("Highest Education");
                RegisterPanel2.add(jHighestEduLabel5);
                jHighestEduLabel5.setBounds(770, 170, 180, 30);

                jEmplyodedInLabel6.setFont(new java.awt.Font("Monotype Corsiva", 0, 20));
                jEmplyodedInLabel6.setText("Employed in");
                RegisterPanel2.add(jEmplyodedInLabel6);
                jEmplyodedInLabel6.setBounds(770, 220, 160, 30);

                jGovernmentRadioButton1.setText("Government");
                RegisterPanel2.add(jGovernmentRadioButton1);
                jGovernmentRadioButton1.setBounds(960, 220, 140, 23);

                jEducationComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select",
                                "BE / B.Tech.", "Aeronautical Engineering", "B.Arch", "BCA", "B.Tech.",
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
                                "Higher Secondary / Secondary" }));
                RegisterPanel2.add(jEducationComboBox1);
                jEducationComboBox1.setBounds(960, 170, 150, 20);

                jPrivateRadioButton2.setText("Private");
                RegisterPanel2.add(jPrivateRadioButton2);
                jPrivateRadioButton2.setBounds(1120, 220, 130, 23);

                jBusinessRadioButton3.setText("Business");
                RegisterPanel2.add(jBusinessRadioButton3);
                jBusinessRadioButton3.setBounds(1260, 220, 120, 23);

                jDefenceRadioButton4.setText("Defence");
                RegisterPanel2.add(jDefenceRadioButton4);
                jDefenceRadioButton4.setBounds(960, 250, 140, 23);

                jSelfEmployedRadioButton5.setText("Self Emloyed");
                RegisterPanel2.add(jSelfEmployedRadioButton5);
                jSelfEmployedRadioButton5.setBounds(1120, 250, 120, 23);

                jNotWorkingRadioButton6.setText("Not Working");
                RegisterPanel2.add(jNotWorkingRadioButton6);
                jNotWorkingRadioButton6.setBounds(1260, 250, 130, 23);

                jOccupationLabel7.setFont(new java.awt.Font("Monotype Corsiva", 0, 20));
                jOccupationLabel7.setText("Occupation");
                RegisterPanel2.add(jOccupationLabel7);
                jOccupationLabel7.setBounds(770, 300, 140, 30);

                jAnnualIncomeLabel8.setFont(new java.awt.Font("Monotype Corsiva", 0, 20));
                jAnnualIncomeLabel8.setText("Annual Income");
                RegisterPanel2.add(jAnnualIncomeLabel8);
                jAnnualIncomeLabel8.setBounds(770, 360, 150, 30);

                RegisterPanel2.add(jAnnualIncomeTextField1);
                jAnnualIncomeTextField1.setBounds(1050, 350, 180, 30);

                jWorkLocationLabel9.setFont(new java.awt.Font("Monotype Corsiva", 0, 20));
                jWorkLocationLabel9.setText("Work Location");
                RegisterPanel2.add(jWorkLocationLabel9);
                jWorkLocationLabel9.setBounds(770, 420, 140, 20);

                jStateLabel10.setFont(new java.awt.Font("Monotype Corsiva", 0, 20));
                jStateLabel10.setText("State");
                RegisterPanel2.add(jStateLabel10);
                jStateLabel10.setBounds(770, 470, 130, 20);
                RegisterPanel2.add(jWorkLocationTextField2);
                jWorkLocationTextField2.setBounds(960, 410, 180, 30);
                RegisterPanel2.add(jStateTextField3);
                jStateTextField3.setBounds(960, 460, 180, 30);

                jCityLabel11.setFont(new java.awt.Font("Monotype Corsiva", 0, 20));
                jCityLabel11.setText("City");
                RegisterPanel2.add(jCityLabel11);
                jCityLabel11.setBounds(770, 520, 140, 20);

                RegisterPanel2.add(jCityTextField4);
                jCityTextField4.setBounds(960, 510, 180, 30);

                jContinueRp2Button1.setBackground(new java.awt.Color(255, 153, 0));
                jContinueRp2Button1.setForeground(new java.awt.Color(255, 255, 255));
                jContinueRp2Button1.setText("Continue");
                jContinueRp2Button1.addActionListener((e) -> {
                        professionalDetails.setHighestEducation(jEducationComboBox1.getSelectedItem().toString());
                        if (jGovernmentRadioButton1.isSelected())
                                professionalDetails.setEmployedIn("Government");
                        if (jPrivateRadioButton2.isSelected())
                                professionalDetails.setEmployedIn("Private");
                        if (jBusinessRadioButton3.isSelected())
                                professionalDetails.setEmployedIn("Business");
                        if (jDefenceRadioButton4.isSelected())
                                professionalDetails.setEmployedIn("Defence");
                        if (jSelfEmployedRadioButton5.isSelected())
                                professionalDetails.setEmployedIn("Self Employed");
                        if (jNotWorkingRadioButton6.isSelected())
                                professionalDetails.setEmployedIn("Not Working");
                        professionalDetails.setOccupation(jOccupationTextField5.getText());
                        professionalDetails.setWorkLocation(jWorkLocationTextField2.getText());
                        professionalDetails.setState(jStateTextField3.getText());
                        professionalDetails.setCity(jCityTextField4.getText());
                        professionalDetails.setAnnualIncome(Integer.parseInt(jAnnualIncomeTextField1.getText()));
                        RegisterPanel2.removeAll();
                        createForm4UI(RegisterPanel2);
                        RegisterPanel2.revalidate();
                        RegisterPanel2.repaint();
                });
                RegisterPanel2.add(jContinueRp2Button1);
                jContinueRp2Button1.setBounds(930, 600, 170, 40);

                jBackButton.setBackground(new java.awt.Color(255, 153, 0));
                jBackButton.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jBackButton.setForeground(new java.awt.Color(255, 255, 255));
                jBackButton.setText("Back");
                jBackButton.setBounds(10, 10, 100, 25);
                jBackButton.addActionListener((e) -> {
                        RegisterPanel2.removeAll();
                        createForm2UI(RegisterPanel2);
                        RegisterPanel2.revalidate();
                        RegisterPanel2.repaint();
                });
                RegisterPanel2.add(jBackButton);

                RegisterPanel2.add(jOccupationTextField5);
                jOccupationTextField5.setBounds(960, 300, 160, 30);

                jRupeesTextField6.setText("Rs");
                jRupeesTextField6.setEnabled(false);
                RegisterPanel2.add(jRupeesTextField6);
                jRupeesTextField6.setBounds(960, 350, 70, 30);

                if (professionalDetails.getEmployedIn() != null) {
                        jEducationComboBox1.setSelectedItem(professionalDetails.getHighestEducation());

                        if (professionalDetails.getEmployedIn().equals("Government"))
                                jGovernmentRadioButton1.setSelected(true);
                        if (professionalDetails.getEmployedIn().equals("Private"))
                                jPrivateRadioButton2.setSelected(true);
                        if (professionalDetails.getEmployedIn().equals("Business"))
                                jBusinessRadioButton3.setSelected(true);
                        if (professionalDetails.getEmployedIn().equals("Defence"))
                                jDefenceRadioButton4.setSelected(true);
                        if (professionalDetails.getEmployedIn().equals("Self Employed"))
                                jSelfEmployedRadioButton5.setSelected(true);
                        if (professionalDetails.getEmployedIn().equals("Not Working"))
                                jNotWorkingRadioButton6.setSelected(true);

                        jOccupationTextField5.setText(professionalDetails.getOccupation());
                        jWorkLocationTextField2.setText(professionalDetails.getWorkLocation());
                        jStateTextField3.setText(professionalDetails.getState());
                        jCityTextField4.setText(professionalDetails.getCity());
                        jAnnualIncomeTextField1.setText(professionalDetails.getAnnualIncome() + "");
                }
                RegisterPanel2.setVisible(true);
                // mainPanel().add(RegisterPanel2);
                // RegisterPanel2.setBounds(10, 10, 1400, 690);

        }

        private javax.swing.JLabel jAnnualIncomeLabel8;
        private javax.swing.JTextField jAnnualIncomeTextField1;
        private javax.swing.JRadioButton jBusinessRadioButton3;
        private javax.swing.JLabel jCityLabel11;
        private javax.swing.JTextField jCityTextField4;
        private javax.swing.JButton jContinueRp2Button1;
        private javax.swing.JRadioButton jDefenceRadioButton4;
        private javax.swing.JComboBox<String> jEducationComboBox1;
        private javax.swing.JLabel jEmplyodedInLabel6;
        private javax.swing.JRadioButton jGovernmentRadioButton1;
        private javax.swing.JLabel jHeading1Rp2Label2;
        private javax.swing.JLabel jHeading2Rp2Label3;
        private javax.swing.JLabel jHeading3Rp2Label4;
        private javax.swing.JLabel jHighestEduLabel5;
        private javax.swing.JLabel jImage1;
        private javax.swing.JRadioButton jNotWorkingRadioButton6;
        private javax.swing.JLabel jOccupationLabel7;
        private javax.swing.JTextField jOccupationTextField5;
        private javax.swing.JRadioButton jPrivateRadioButton2;
        private javax.swing.JTextField jRupeesTextField6;
        private javax.swing.JRadioButton jSelfEmployedRadioButton5;
        private javax.swing.JLabel jStateLabel10;
        private javax.swing.JTextField jStateTextField3;
        private javax.swing.JLabel jWorkLocationLabel9;
        private javax.swing.JTextField jWorkLocationTextField2;

        public void createForm4UI(JPanel RegisterPanel3) {
                jImageRp3 = new javax.swing.JLabel();
                jHeading1Rp3Label2 = new javax.swing.JLabel();
                jHeading2Rp3Label3 = new javax.swing.JLabel();
                jHeading3Rp3Label4 = new javax.swing.JLabel();
                jAboutYouLabel5 = new javax.swing.JLabel();
                jAboutYouScrollPane1 = new javax.swing.JScrollPane();
                jAboutYouTextArea1 = new javax.swing.JTextArea();
                jContinueRp3Button1 = new javax.swing.JButton();
                JButton jBackButton = new JButton();

                Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                int width = (int) dimension.getWidth();
                int height = (int) dimension.getHeight();

                RegisterPanel3.setBounds(0, 0, width, height);
                RegisterPanel3.setLayout(null);

                jImageRp3.setIcon(new javax.swing.ImageIcon("src/client/resource/images/mImage.jpg"));
                RegisterPanel3.add(jImageRp3);
                jImageRp3.setBounds(40, 170, 650, 480);

                jHeading1Rp3Label2.setFont(new java.awt.Font("Monotype Corsiva", 1, 22));
                jHeading1Rp3Label2.setText("Great! You have completed ");
                RegisterPanel3.add(jHeading1Rp3Label2);
                jHeading1Rp3Label2.setBounds(1010, 70, 250, 30);

                jHeading2Rp3Label3.setFont(new java.awt.Font("Monotype Corsiva", 1, 36));
                jHeading2Rp3Label3.setText("80%");
                RegisterPanel3.add(jHeading2Rp3Label3);
                jHeading2Rp3Label3.setBounds(1250, 50, 70, 80);

                jHeading3Rp3Label4.setFont(new java.awt.Font("Monotype Corsiva", 0, 32));
                jHeading3Rp3Label4.setText("Let the world know about your awesomeness");
                RegisterPanel3.add(jHeading3Rp3Label4);
                jHeading3Rp3Label4.setBounds(720, 140, 530, 40);

                jAboutYouLabel5.setFont(new java.awt.Font("Monotype Corsiva", 0, 20));
                jAboutYouLabel5.setText("About You");
                RegisterPanel3.add(jAboutYouLabel5);
                jAboutYouLabel5.setBounds(750, 220, 150, 30);

                jAboutYouTextArea1.setColumns(20);
                jAboutYouTextArea1.setRows(5);
                jAboutYouScrollPane1.setViewportView(jAboutYouTextArea1);

                RegisterPanel3.add(jAboutYouScrollPane1);
                jAboutYouScrollPane1.setBounds(870, 230, 380, 310);

                jContinueRp3Button1.setBackground(new java.awt.Color(255, 153, 0));
                jContinueRp3Button1.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jContinueRp3Button1.setForeground(new java.awt.Color(255, 255, 255));
                jContinueRp3Button1.setText("Complete");
                jContinueRp3Button1.addActionListener((e) -> {
                        personalDetails.setAbout(jAboutYouTextArea1.getText());
                        RegisterPanel3.removeAll();
                        createForm5UI(RegisterPanel3);
                        RegisterPanel3.revalidate();
                        RegisterPanel3.repaint();

                });
                RegisterPanel3.add(jContinueRp3Button1);
                jContinueRp3Button1.setBounds(900, 630, 200, 50);

                jBackButton.setBackground(new java.awt.Color(255, 153, 0));
                jBackButton.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jBackButton.setForeground(new java.awt.Color(255, 255, 255));
                jBackButton.setText("Back");
                jBackButton.setBounds(10, 10, 100, 25);
                jBackButton.addActionListener((e) -> {
                        RegisterPanel3.removeAll();
                        createForm3UI(RegisterPanel3);
                        RegisterPanel3.revalidate();
                        RegisterPanel3.repaint();
                });
                if (personalDetails.getAbout() != null) {
                        jAboutYouTextArea1.setText(personalDetails.getAbout());
                }
                RegisterPanel3.add(jBackButton);

                // getContentPane().add(RegisterPanel3);
                RegisterPanel3.setBounds(10, 10, 1390, 790);

        }

        // Variables declaration - do not modify
        private javax.swing.JButton jContinueRp3Button1;
        private javax.swing.JLabel jImageRp3;
        private javax.swing.JLabel jHeading1Rp3Label2;
        private javax.swing.JLabel jHeading2Rp3Label3;
        private javax.swing.JLabel jHeading3Rp3Label4;
        private javax.swing.JLabel jAboutYouLabel5;
        private javax.swing.JScrollPane jAboutYouScrollPane1;
        private javax.swing.JTextArea jAboutYouTextArea1;
        // End of variables declaration

        public void createForm5UI(JPanel mainPanel) {
                JPanel jInformtionFormPanel1 = new JPanel();
                jInformationScrollPane1 = new javax.swing.JScrollPane();
                jHeading2Ip1Label1 = new javax.swing.JLabel();
                jHeading1Ip1Label2 = new javax.swing.JLabel();
                jBodyTypeLabel3 = new javax.swing.JLabel();
                jSlimRadioButton1 = new javax.swing.JRadioButton();
                jAverageRadioButton2 = new javax.swing.JRadioButton();
                jAtheleticRadioButton3 = new javax.swing.JRadioButton();
                jHeavyRadioButton4 = new javax.swing.JRadioButton();
                jWeightLabel4 = new javax.swing.JLabel();
                jWeightTextField1 = new javax.swing.JTextField();
                jKgsTextField2 = new javax.swing.JTextField();
                jCollegeInstitutionLabel5 = new javax.swing.JLabel();
                jCollegeInsititutionTextField3 = new javax.swing.JTextField();
                jOrganizationLabel6 = new javax.swing.JLabel();
                jOrganizationTextField4 = new javax.swing.JTextField();
                jLifeStyleInfoLabel7 = new javax.swing.JLabel();
                jEatingHabitLabel8 = new javax.swing.JLabel();
                jVegRadioButton5 = new javax.swing.JRadioButton();
                jNonVegRadioButton6 = new javax.swing.JRadioButton();
                jEggRadioButton7 = new javax.swing.JRadioButton();
                jDrinkingHabitLabel9 = new javax.swing.JLabel();
                jNoDHRadioButton8 = new javax.swing.JRadioButton();
                jDrinksSociallyRadioButton9 = new javax.swing.JRadioButton();
                jYesDHRadioButton10 = new javax.swing.JRadioButton();
                jSmokingHabitLabel10 = new javax.swing.JLabel();
                jNoSHRadioButton11 = new javax.swing.JRadioButton();
                jOccasionallyRadioButton12 = new javax.swing.JRadioButton();
                jYesSHRadioButton13 = new javax.swing.JRadioButton();
                jReligionInformationLabel11 = new javax.swing.JLabel();
                jStarLabel12 = new javax.swing.JLabel();
                jStarComboBox1 = new javax.swing.JComboBox<>();
                jRaasiLabel13 = new javax.swing.JLabel();
                jRaasiComboBox2 = new javax.swing.JComboBox<>();
                jHoroscopeDetailsLabel14 = new javax.swing.JLabel();
                jTimeofBirthLabel15 = new javax.swing.JLabel();
                jHrsComboBox3 = new javax.swing.JComboBox<>();
                jMinsComboBox4 = new javax.swing.JComboBox<>();
                jAmPmComboBox5 = new javax.swing.JComboBox<>();
                jPlaceofBirthLabel16 = new javax.swing.JLabel();
                jCountryTextField5 = new javax.swing.JTextField();
                jCountryHeadingLabel17 = new javax.swing.JLabel();
                jStateTextField6 = new javax.swing.JTextField();
                jStateHeadingTextField7 = new javax.swing.JTextField();
                jCityTextField8 = new javax.swing.JTextField();
                jCityHeadingTextField9 = new javax.swing.JTextField();
                jFamilyInformationLabel18 = new javax.swing.JLabel();
                jFatherStatusLabel19 = new javax.swing.JLabel();
                jFatherStatusComboBox6 = new javax.swing.JComboBox<>();
                jMotherStatusLabel20 = new javax.swing.JLabel();
                jMotherStatusComboBox7 = new javax.swing.JComboBox<>();
                jBrothersLabel21 = new javax.swing.JLabel();
                jNumberofBrothersComboBox8 = new javax.swing.JComboBox<>();
                jSistersLabel22 = new javax.swing.JLabel();
                jNumberofSistersComboBox10 = new javax.swing.JComboBox<>();
                jParentcontactNumberLabel23 = new javax.swing.JLabel();
                j91ParentContactNumTextField10 = new javax.swing.JTextField();
                jParentContactNumberTextField11 = new javax.swing.JTextField();
                jAncestrolPlaceLabel24 = new javax.swing.JLabel();
                jAncestrolPlaceTextField12 = new javax.swing.JTextField();
                jCompleteProfileButton1 = new javax.swing.JButton();
                JButton jBackButton = new JButton();

                // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jInformationScrollPane1.setHorizontalScrollBarPolicy(
                                javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                jHeading2Ip1Label1.setFont(new java.awt.Font("Monotype CorsivScroll", 0, 24));
                jHeading2Ip1Label1.setText("Basic Information");

                jHeading1Ip1Label2.setFont(new java.awt.Font("Monotype Corsiva", 0, 20));
                jHeading1Ip1Label2.setText("Complete your profile to get more responses");

                jBodyTypeLabel3.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jBodyTypeLabel3.setText("Body Type");

                jSlimRadioButton1.setText("Slim");

                jAverageRadioButton2.setText("Average");

                jAtheleticRadioButton3.setText("Atheletic");

                jHeavyRadioButton4.setText("Heavy");

                jWeightLabel4.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jWeightLabel4.setText("Weight");

                jKgsTextField2.setText("kgs");
                jKgsTextField2.setEnabled(false);

                jCollegeInstitutionLabel5.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jCollegeInstitutionLabel5.setText("College/Institution");

                jOrganizationLabel6.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jOrganizationLabel6.setText("Organization");

                jLifeStyleInfoLabel7.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jLifeStyleInfoLabel7.setText("Lifestyle Info");

                jEatingHabitLabel8.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jEatingHabitLabel8.setText("Eating Habit");

                jVegRadioButton5.setText("Vegetarian");

                jNonVegRadioButton6.setText("Non Vegetarian");

                jEggRadioButton7.setText("Eggetarian");

                jDrinkingHabitLabel9.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jDrinkingHabitLabel9.setText("Drinking Habit");

                jNoDHRadioButton8.setText("No");

                jDrinksSociallyRadioButton9.setText("Drinks Socially");

                jYesDHRadioButton10.setText("Yes");

                jSmokingHabitLabel10.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jSmokingHabitLabel10.setText("Smoking Habit");

                jNoSHRadioButton11.setText("No");

                jOccasionallyRadioButton12.setText("Occasionally");

                jYesSHRadioButton13.setText("Yes");

                jReligionInformationLabel11.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jReligionInformationLabel11.setText("Religion Information");

                jStarLabel12.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jStarLabel12.setText("Star");

                jStarComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Ashwini",
                                "Bharani", "krittika/Karthikai", "Rohini", "Mrigasira", "Arsra/Thiruvatharai",
                                "Punarpoosam", "Pusam", "Ayilyam", "Makam", "Puram", "Uthram", "Hastham", "Chitra",
                                "Swati", "Visakam", "Anusham", "Kettai", "Moolam", "Pooradam", "Uttarashada",
                                "Thiruvonam", "Avittam", "Sadayam", "Poorattathi", "Uthirattathi", "Revati" }));

                jRaasiLabel13.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jRaasiLabel13.setText("Raasi");

                jRaasiComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "Select", "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra",
                                                "Scorpio", "Saggitarius", "Capricorn", "Aquarius", "Pisces", " " }));

                jHoroscopeDetailsLabel14.setFont(new java.awt.Font("Monotype Corsiva", 0, 20));
                jHoroscopeDetailsLabel14.setText("Horoscope Details");

                jTimeofBirthLabel15.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jTimeofBirthLabel15.setText("Time of Birth");

                jHrsComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hrs", "01", "02", "03",
                                "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

                jMinsComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mins", "01", "02", "03",
                                "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17",
                                "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31",
                                "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45",
                                "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59",
                                "60" }));

                jAmPmComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM/PM", "AM", "PM" }));

                jPlaceofBirthLabel16.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jPlaceofBirthLabel16.setText("Place of Birth");

                jCountryHeadingLabel17.setText("Country");
                jCountryHeadingLabel17.setAutoscrolls(true);
                jCountryHeadingLabel17.setEnabled(false);

                jStateHeadingTextField7.setText("State");
                jStateHeadingTextField7.setEnabled(false);

                jCityHeadingTextField9.setText("City");
                jCityHeadingTextField9.setEnabled(false);

                jFamilyInformationLabel18.setFont(new java.awt.Font("Monotype Corsiva", 0, 24));
                jFamilyInformationLabel18.setText("Family Information");

                jFatherStatusLabel19.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jFatherStatusLabel19.setText("Father Status");

                jFatherStatusComboBox6.setModel(
                                new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Alive", "Late" }));

                jMotherStatusLabel20.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jMotherStatusLabel20.setText("Mother Status");

                jMotherStatusComboBox7.setModel(
                                new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Alive", "Late" }));

                jBrothersLabel21.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jBrothersLabel21.setText("Brothers");

                jNumberofBrothersComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "Select", "1", "2", "3", "4", "5", "6" }));

                jSistersLabel22.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jSistersLabel22.setText("Sisters");

                jNumberofSistersComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "Select", "1", "2", "3", "4", "5", "6" }));

                jParentcontactNumberLabel23.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jParentcontactNumberLabel23.setText("Parent's Contact Number");

                j91ParentContactNumTextField10.setText("+91");
                j91ParentContactNumTextField10.setEnabled(false);

                jAncestrolPlaceLabel24.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jAncestrolPlaceLabel24.setText("Ancestrol Origin");

                jCompleteProfileButton1.setBackground(new java.awt.Color(255, 153, 0));
                jCompleteProfileButton1.setFont(new java.awt.Font("Monotype Corsiva", 0, 22));
                jCompleteProfileButton1.setForeground(new java.awt.Color(255, 255, 255));
                jCompleteProfileButton1.setText("Complete Profile");

                jCompleteProfileButton1.addActionListener((e) -> {

                        if (jSlimRadioButton1.isSelected())
                                basicInformation.setBodyType("Slim");
                        if (jAverageRadioButton2.isSelected())
                                basicInformation.setBodyType("Average");
                        if (jAtheleticRadioButton3.isSelected())
                                basicInformation.setBodyType("Atheletic");
                        if (jHeavyRadioButton4.isFontSet())
                                basicInformation.setBodyType("Heavy");

                        basicInformation.setWeight(Integer.parseInt(jWeightTextField1.getText()));
                        basicInformation.setCollege(jCollegeInsititutionTextField3.getText());
                        basicInformation.setOrganization(jOrganizationTextField4.getText());

                        if (jVegRadioButton5.isSelected())
                                lifeStyleInfo.setEatingHabit("Vegetarian");
                        if (jNonVegRadioButton6.isSelected())
                                lifeStyleInfo.setEatingHabit("Non Vegetarian");
                        if (jEggRadioButton7.isSelected())
                                lifeStyleInfo.setEatingHabit("Eggetarian");

                        if (jNoDHRadioButton8.isSelected())
                                lifeStyleInfo.setDrinkingHabit("No");
                        if (jDrinksSociallyRadioButton9.isSelected())
                                lifeStyleInfo.setDrinkingHabit("Drinks Socially");
                        if (jYesDHRadioButton10.isSelected())
                                lifeStyleInfo.setDrinkingHabit("Yes");

                        if (jNoSHRadioButton11.isSelected())
                                lifeStyleInfo.setSmokingHabit("No");
                        if (jOccasionallyRadioButton12.isSelected())
                                lifeStyleInfo.setSmokingHabit("Occasionally");
                        if (jYesSHRadioButton13.isSelected())
                                lifeStyleInfo.setSmokingHabit("Yes");

                        religionInformation.setStar(jStarComboBox1.getSelectedItem().toString());
                        religionInformation.setRaasi(jRaasiComboBox2.getSelectedItem().toString());

                        familyInformation.setFatherStatus(jFatherStatusComboBox6.getSelectedItem().toString());
                        familyInformation.setMotherStatus(jMotherStatusComboBox7.getSelectedItem().toString());
                        familyInformation.setSiblings(jNumberofBrothersComboBox8.getSelectedItem().toString());
                        familyInformation.setContactNo(jParentContactNumberTextField11.getText());

                        mainPanel.removeAll();
                        createForm6UI(mainPanel);
                        mainPanel.revalidate();
                        mainPanel.repaint();
                });

                jBackButton.setBackground(new java.awt.Color(255, 153, 0));
                jBackButton.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jBackButton.setForeground(new java.awt.Color(255, 255, 255));
                jBackButton.setText("Back");
                jBackButton.setBounds(10, 10, 100, 25);
                jBackButton.addActionListener((e) -> {
                        mainPanel.removeAll();
                        createForm4UI(mainPanel);
                        mainPanel.revalidate();
                        mainPanel.repaint();
                });

                mainPanel.add(jBackButton);

                javax.swing.GroupLayout jInformtionFormPanel1Layout = new javax.swing.GroupLayout(
                                jInformtionFormPanel1);
                jInformtionFormPanel1.setLayout(jInformtionFormPanel1Layout);
                jInformtionFormPanel1Layout.setHorizontalGroup(jInformtionFormPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jInformtionFormPanel1Layout.createSequentialGroup()
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(160, 160,
                                                                                                                                160)
                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                false)
                                                                                                                                .addComponent(jOrganizationLabel6,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(jWeightLabel4,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(jBodyTypeLabel3,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                135,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(jCollegeInstitutionLabel5,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                135,
                                                                                                                                                Short.MAX_VALUE)))
                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addContainerGap()
                                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jSmokingHabitLabel10,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                152,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(jDrinkingHabitLabel9,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                152,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(jEatingHabitLabel8,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                152,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                jInformtionFormPanel1Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGap(133, 133,
                                                                                                                                                                133)
                                                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                false)
                                                                                                                                                                .addComponent(jLifeStyleInfoLabel7,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                .addComponent(jHeading2Ip1Label1,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                186,
                                                                                                                                                                                Short.MAX_VALUE))
                                                                                                                                                .addGap(15, 15, 15))))
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                jInformtionFormPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(133, 133,
                                                                                                                                133)
                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                                .addComponent(jReligionInformationLabel11,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                186,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                false)
                                                                                                                                                                .addComponent(jRaasiLabel13,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                140,
                                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                                .addComponent(jStarLabel12,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                                Short.MAX_VALUE)))
                                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGap(19, 19, 19)
                                                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                                                .addComponent(jFamilyInformationLabel18,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                201,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                                                .addComponent(jTimeofBirthLabel15,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                138,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                .addComponent(jHoroscopeDetailsLabel14,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                174,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                                                .addComponent(jPlaceofBirthLabel16,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                                138,
                                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                .createSequentialGroup()
                                                                                .addGap(175, 175, 175)
                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                .addComponent(jFatherStatusLabel19,
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                144,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                false)
                                                                                                                                .addComponent(jBrothersLabel21,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(jMotherStatusLabel20,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                144,
                                                                                                                                                Short.MAX_VALUE)))
                                                                                                .addComponent(jParentcontactNumberLabel23,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                178,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(23, 23, 23)
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                .createSequentialGroup()
                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                false)
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                jInformtionFormPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jSlimRadioButton1,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                69,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(39, 39, 39)
                                                                                                                                .addComponent(jAverageRadioButton2,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                90,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(42, 42, 42)
                                                                                                                                .addComponent(jAtheleticRadioButton3,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                88,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(18, 18, 18)
                                                                                                                                .addComponent(jHeavyRadioButton4,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                69,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addComponent(jCollegeInsititutionTextField3,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                469,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jWeightTextField1,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(jOrganizationTextField4,
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING))
                                                                                .addPreferredGap(
                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                101, Short.MAX_VALUE)
                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(jHeading1Ip1Label2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                306,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jKgsTextField2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                97,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(73, 73, 73))
                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                .createSequentialGroup()
                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jCityTextField8,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                189,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jCityHeadingTextField9,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                71,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jStateTextField6,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                189,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jStateHeadingTextField7,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                71,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                .createSequentialGroup()
                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(jRaasiComboBox2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                224,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jFatherStatusComboBox6,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                219,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(jVegRadioButton5,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                87,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(jNoDHRadioButton8,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                61,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(jDrinksSociallyRadioButton9,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                108,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(jNonVegRadioButton6,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                108,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(jOccasionallyRadioButton12,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                108,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGap(52, 52, 52)
                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(jEggRadioButton7,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                87,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                                                false)
                                                                                                                                                .addComponent(jYesSHRadioButton13,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                59,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(jYesDHRadioButton10,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                Short.MAX_VALUE))))
                                                                                                .addComponent(jNoSHRadioButton11,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                61,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jStarComboBox1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                224,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jHrsComboBox3,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                65,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(2, 2, 2)
                                                                                                                .addComponent(jMinsComboBox4,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                60,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jAmPmComboBox5,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jCountryTextField5,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                189,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jCountryHeadingLabel17,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                73,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addComponent(jMotherStatusComboBox7,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                219,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(jNumberofBrothersComboBox8,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                78,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(j91ParentContactNumTextField10,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                55,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                                .addComponent(jParentContactNumberTextField11,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                171,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                                .addGap(26, 26, 26)
                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                false)
                                                                                                                                .addComponent(jSistersLabel22,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(jAncestrolPlaceLabel24,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                144,
                                                                                                                                                Short.MAX_VALUE))
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                .addGroup(jInformtionFormPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(jNumberofSistersComboBox10,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                78,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(jAncestrolPlaceTextField12,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                201,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                                .addContainerGap(
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))))
                                .addGroup(jInformtionFormPanel1Layout.createSequentialGroup().addGap(527, 527, 527)
                                                .addComponent(jCompleteProfileButton1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 206,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)));
                jInformtionFormPanel1Layout.setVerticalGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jInformtionFormPanel1Layout.createSequentialGroup().addGap(55, 55, 55)
                                                .addComponent(jHeading1Ip1Label2,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 29,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(jHeading2Ip1Label1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jBodyTypeLabel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                25,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jSlimRadioButton1)
                                                                .addComponent(jAverageRadioButton2).addComponent(
                                                                                jAtheleticRadioButton3)
                                                                .addComponent(jHeavyRadioButton4))
                                                .addGap(26, 26, 26)
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jWeightLabel4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jWeightTextField1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                33,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jKgsTextField2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                33,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(36, 36, 36)
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jCollegeInstitutionLabel5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                27,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jCollegeInsititutionTextField3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(40, 40, 40)
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jOrganizationLabel6,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                31,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jOrganizationTextField4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                40,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(35, 35, 35)
                                                .addComponent(jLifeStyleInfoLabel7,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jEatingHabitLabel8,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                36,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jVegRadioButton5).addComponent(
                                                                                jNonVegRadioButton6)
                                                                .addComponent(jEggRadioButton7))
                                                .addGap(18, 18, 18)
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jDrinkingHabitLabel9,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jNoDHRadioButton8)
                                                                .addComponent(jDrinksSociallyRadioButton9)
                                                                .addComponent(jYesDHRadioButton10))
                                                .addGap(18, 18, 18)
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jSmokingHabitLabel10,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                32,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jNoSHRadioButton11)
                                                                .addComponent(jOccasionallyRadioButton12)
                                                                .addComponent(jYesSHRadioButton13))
                                                .addGap(50, 50, 50)
                                                .addComponent(jReligionInformationLabel11,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 48,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jStarLabel12,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                34,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jStarComboBox1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                34,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(46, 46, 46)
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jRaasiLabel13,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                33,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jRaasiComboBox2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                33,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(47, 47, 47)
                                                .addComponent(jHoroscopeDetailsLabel14,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jTimeofBirthLabel15,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                32,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jHrsComboBox3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jMinsComboBox4)
                                                                .addComponent(jAmPmComboBox5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(42, 42, 42)
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jPlaceofBirthLabel16,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                34,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jCountryTextField5,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                34,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jCountryHeadingLabel17,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jStateTextField6,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                34,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jStateHeadingTextField7,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                34,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jCityTextField8,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                34,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jCityHeadingTextField9,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                34,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(45, 45, 45)
                                                .addComponent(jFamilyInformationLabel18,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 43,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jFatherStatusLabel19,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                33,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jFatherStatusComboBox6,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                33,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jMotherStatusLabel20,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jMotherStatusComboBox7,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(25, 25, 25)
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jBrothersLabel21,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                34,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jNumberofBrothersComboBox8,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                36,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jSistersLabel22,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                36,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jNumberofSistersComboBox10,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(33, 33, 33)
                                                .addGroup(jInformtionFormPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jParentcontactNumberLabel23,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(j91ParentContactNumTextField10,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jParentContactNumberTextField11,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jAncestrolPlaceLabel24,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jAncestrolPlaceTextField12,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                31,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(31, 31, 31)
                                                .addComponent(jCompleteProfileButton1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(31, 31, 31)));

                jInformationScrollPane1.setViewportView(jInformtionFormPanel1);
                jInformationScrollPane1.setBounds(0, 0, width, height);

                if (basicInformation.getBodyType() != null) {
                        if (basicInformation.getBodyType().equals("Slim"))
                                jSlimRadioButton1.setSelected(true);
                        if (basicInformation.getBodyType().equals("Average"))
                                jAverageRadioButton2.setSelected(true);
                        if (basicInformation.getBodyType().equals("Atheletic"))
                                jAtheleticRadioButton3.setSelected(true);
                        if (basicInformation.getBodyType().equals("Heavy"))
                                jHeavyRadioButton4.setSelected(true);

                        jWeightTextField1.setText(basicInformation.getWeight() + "");
                        jCollegeInsititutionTextField3.setText(basicInformation.getCollege());
                        jOrganizationTextField4.setText(basicInformation.getOrganization());

                        if (lifeStyleInfo.getEatingHabit().equals("Vegetarian"))
                                jVegRadioButton5.setSelected(true);
                        if (lifeStyleInfo.getEatingHabit().equals("Non Vegetarian"))
                                jNonVegRadioButton6.setSelected(true);
                        if (lifeStyleInfo.getEatingHabit().equals("Eggetarian"))
                                jEggRadioButton7.setSelected(true);

                        if (lifeStyleInfo.getDrinkingHabit().equals("No"))
                                jNoDHRadioButton8.setSelected(true);
                        if (lifeStyleInfo.getDrinkingHabit().equals("Drinks Socially"))
                                jDrinksSociallyRadioButton9.setSelected(true);
                        if (lifeStyleInfo.getDrinkingHabit().equals("Yes"))
                                jYesDHRadioButton10.setSelected(true);

                        if (lifeStyleInfo.getSmokingHabit().equals("No"))
                                jNoSHRadioButton11.setSelected(true);
                        if (lifeStyleInfo.getSmokingHabit().equals("Occasionally"))
                                jOccasionallyRadioButton12.setSelected(true);
                        if (lifeStyleInfo.getSmokingHabit().equals("Yes"))
                                jYesSHRadioButton13.setSelected(true);

                        jStarComboBox1.setSelectedItem(religionInformation.getStar());
                        jRaasiComboBox2.setSelectedItem(religionInformation.getRaasi());

                        jFatherStatusComboBox6.setSelectedItem(familyInformation.getFatherStatus());
                        jMotherStatusComboBox7.setSelectedItem(familyInformation.getMotherStatus());
                        jNumberofBrothersComboBox8.setSelectedItem(familyInformation.getSiblings());
                        jParentContactNumberTextField11.setText(familyInformation.getContactNo());

                }

                jInformtionFormPanel1.setBackground(Color.white);
                jInformationScrollPane1.setBackground(Color.white);
                mainPanel.add(jInformationScrollPane1);
                mainPanel.setBackground(Color.white);

        }

        // Variables declaration - do not modify
        private javax.swing.JTextField j91ParentContactNumTextField10;
        private javax.swing.JComboBox<String> jAmPmComboBox5;
        private javax.swing.JLabel jAncestrolPlaceLabel24;
        private javax.swing.JTextField jAncestrolPlaceTextField12;
        private javax.swing.JRadioButton jAtheleticRadioButton3;
        private javax.swing.JRadioButton jAverageRadioButton2;
        private javax.swing.JLabel jBodyTypeLabel3;
        private javax.swing.JLabel jBrothersLabel21;
        private javax.swing.JTextField jCityHeadingTextField9;
        private javax.swing.JTextField jCityTextField8;
        private javax.swing.JTextField jCollegeInsititutionTextField3;
        private javax.swing.JLabel jCollegeInstitutionLabel5;
        private javax.swing.JButton jCompleteProfileButton1;
        private javax.swing.JLabel jCountryHeadingLabel17;
        private javax.swing.JTextField jCountryTextField5;
        private javax.swing.JLabel jDrinkingHabitLabel9;
        private javax.swing.JRadioButton jDrinksSociallyRadioButton9;
        private javax.swing.JLabel jEatingHabitLabel8;
        private javax.swing.JRadioButton jEggRadioButton7;
        private javax.swing.JLabel jFamilyInformationLabel18;
        private javax.swing.JComboBox<String> jFatherStatusComboBox6;
        private javax.swing.JLabel jFatherStatusLabel19;
        private javax.swing.JLabel jHeading1Ip1Label2;
        private javax.swing.JLabel jHeading2Ip1Label1;
        private javax.swing.JRadioButton jHeavyRadioButton4;
        private javax.swing.JLabel jHoroscopeDetailsLabel14;
        private javax.swing.JComboBox<String> jHrsComboBox3;
        private javax.swing.JScrollPane jInformationScrollPane1;
        private javax.swing.JTextField jKgsTextField2;
        private javax.swing.JLabel jLifeStyleInfoLabel7;
        private javax.swing.JComboBox<String> jMinsComboBox4;
        private javax.swing.JComboBox<String> jMotherStatusComboBox7;
        private javax.swing.JLabel jMotherStatusLabel20;
        private javax.swing.JRadioButton jNoDHRadioButton8;
        private javax.swing.JRadioButton jNoSHRadioButton11;
        private javax.swing.JRadioButton jNonVegRadioButton6;
        private javax.swing.JComboBox<String> jNumberofBrothersComboBox8;
        private javax.swing.JComboBox<String> jNumberofSistersComboBox10;
        private javax.swing.JRadioButton jOccasionallyRadioButton12;
        private javax.swing.JLabel jOrganizationLabel6;
        private javax.swing.JTextField jOrganizationTextField4;
        private javax.swing.JTextField jParentContactNumberTextField11;
        private javax.swing.JLabel jParentcontactNumberLabel23;
        private javax.swing.JLabel jPlaceofBirthLabel16;
        private javax.swing.JComboBox<String> jRaasiComboBox2;
        private javax.swing.JLabel jRaasiLabel13;
        private javax.swing.JLabel jReligionInformationLabel11;
        private javax.swing.JLabel jSistersLabel22;
        private javax.swing.JRadioButton jSlimRadioButton1;
        private javax.swing.JLabel jSmokingHabitLabel10;
        private javax.swing.JComboBox<String> jStarComboBox1;
        private javax.swing.JLabel jStarLabel12;
        private javax.swing.JTextField jStateHeadingTextField7;
        private javax.swing.JTextField jStateTextField6;
        private javax.swing.JLabel jTimeofBirthLabel15;
        private javax.swing.JRadioButton jVegRadioButton5;
        private javax.swing.JLabel jWeightLabel4;
        private javax.swing.JTextField jWeightTextField1;
        private javax.swing.JRadioButton jYesDHRadioButton10;
        private javax.swing.JRadioButton jYesSHRadioButton13;
        // End of variables declaration

        public void createForm6UI(JPanel mainPanel) {
                jInterestScrollPane1 = new javax.swing.JScrollPane();
                jPanel1 = new javax.swing.JPanel();
                jHeading1IntLabel1 = new javax.swing.JLabel();
                jothers1IntLabel2 = new javax.swing.JLabel();
                jothers1TextField1 = new javax.swing.JTextField();
                jHeading2IntLabel3 = new javax.swing.JLabel();
                jothers2IntLabel4 = new javax.swing.JLabel();
                jothers2TextField2 = new javax.swing.JTextField();
                jHeading3IntLabel5 = new javax.swing.JLabel();
                jothers3IntLabel6 = new javax.swing.JLabel();
                jOthers3TextField3 = new javax.swing.JTextField();
                jHeading4IntLabel7 = new javax.swing.JLabel();
                jCookingCheckBox1 = new javax.swing.JCheckBox();
                jNatureCheckBox2 = new javax.swing.JCheckBox();
                jPhotographyCheckBox3 = new javax.swing.JCheckBox();
                jDancingCheckBox4 = new javax.swing.JCheckBox();
                jPaintingCheckBox5 = new javax.swing.JCheckBox();
                jPetsCheckBox6 = new javax.swing.JCheckBox();
                jPlayingMusicalInstrmentationCheckBox7 = new javax.swing.JCheckBox();
                jPuzzlesCheckBox8 = new javax.swing.JCheckBox();
                jGardeningCheckBox9 = new javax.swing.JCheckBox();
                jArtCheckBox10 = new javax.swing.JCheckBox();
                jListeningtoMusicCheckBox11 = new javax.swing.JCheckBox();
                jMoviesCheckBox12 = new javax.swing.JCheckBox();
                jInternetSurfingCheckBox13 = new javax.swing.JCheckBox();
                jTravellingCheckBox14 = new javax.swing.JCheckBox();
                jFlimSongsCheckBox15 = new javax.swing.JCheckBox();
                jIndianClassicalMusicCheckBox16 = new javax.swing.JCheckBox();
                jWesternMusicCheckBox17 = new javax.swing.JCheckBox();
                jCricketCheckBox18 = new javax.swing.JCheckBox();
                jCarromCheckBox19 = new javax.swing.JCheckBox();
                jChessCheckBox20 = new javax.swing.JCheckBox();
                jJoggingCheckBox21 = new javax.swing.JCheckBox();
                jBadmintonCheckBox22 = new javax.swing.JCheckBox();
                jSwimmingCheckBox23 = new javax.swing.JCheckBox();
                jTennisCheckBox24 = new javax.swing.JCheckBox();
                jFootballCheckBox25 = new javax.swing.JCheckBox();
                jEnglishCheckBox26 = new javax.swing.JCheckBox();
                jHindiCheckBox27 = new javax.swing.JCheckBox();
                jTamilCheckBox28 = new javax.swing.JCheckBox();
                jTeluguCheckBox29 = new javax.swing.JCheckBox();
                jMalayalamCheckBox30 = new javax.swing.JCheckBox();
                jKannadaCheckBox31 = new javax.swing.JCheckBox();
                jGujaratiCheckBox32 = new javax.swing.JCheckBox();
                jMarathiCheckBox33 = new javax.swing.JCheckBox();
                jUrduCheckBox34 = new javax.swing.JCheckBox();
                jothers4IntLabel8 = new javax.swing.JLabel();
                jothers4TextField4 = new javax.swing.JTextField();
                jSubmitIntButton1 = new javax.swing.JButton();
                JButton jBackButton = new JButton();

                jHeading1IntLabel1.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jHeading1IntLabel1.setForeground(new java.awt.Color(51, 204, 0));
                jHeading1IntLabel1.setText("What are your hobbies and interests?");

                jothers1IntLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                jothers1IntLabel2.setText("others");

                jHeading2IntLabel3.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jHeading2IntLabel3.setForeground(new java.awt.Color(51, 204, 0));
                jHeading2IntLabel3.setText("Your Favourite music");

                jothers2IntLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                jothers2IntLabel4.setText("others");

                jHeading3IntLabel5.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jHeading3IntLabel5.setForeground(new java.awt.Color(51, 204, 0));
                jHeading3IntLabel5.setText("Sports/Fitness you like");

                jothers3IntLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                jothers3IntLabel6.setText("others");

                jHeading4IntLabel7.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
                jHeading4IntLabel7.setForeground(new java.awt.Color(51, 204, 0));
                jHeading4IntLabel7.setText("Spoken Languages");

                jCookingCheckBox1.setText("Cooking");

                jNatureCheckBox2.setText("Nature");

                jPhotographyCheckBox3.setText("Photography");

                jDancingCheckBox4.setText("Dancing");

                jPaintingCheckBox5.setText("Painting");

                jPetsCheckBox6.setText("Pets");

                jPlayingMusicalInstrmentationCheckBox7.setText("Playing musical Instruments");

                jPuzzlesCheckBox8.setText("Puzzles");

                jGardeningCheckBox9.setText("Gardening");

                jArtCheckBox10.setText("Art/Handcraft");

                jListeningtoMusicCheckBox11.setText("Listening to music");

                jMoviesCheckBox12.setText("Movies");

                jInternetSurfingCheckBox13.setText("Internet Surfing");

                jTravellingCheckBox14.setText("Travelling");

                jFlimSongsCheckBox15.setText("Flim songs");

                jIndianClassicalMusicCheckBox16.setText("Indian/Classical Music");

                jWesternMusicCheckBox17.setText("Western Music");

                jCricketCheckBox18.setText("Cricket");

                jCarromCheckBox19.setText("Carrom");

                jChessCheckBox20.setText("Chess");

                jJoggingCheckBox21.setText("Jogging");

                jBadmintonCheckBox22.setText("Badminton");

                jSwimmingCheckBox23.setText("Swimming");

                jTennisCheckBox24.setText("Tennis");

                jFootballCheckBox25.setText("Football");

                jEnglishCheckBox26.setText("English");

                jHindiCheckBox27.setText("Hindi");

                jTamilCheckBox28.setText("Tamil");

                jTeluguCheckBox29.setText("Telugu");

                jMalayalamCheckBox30.setText("Malayalam");

                jKannadaCheckBox31.setText("Kanada");

                jGujaratiCheckBox32.setText("Gujarati");

                jMarathiCheckBox33.setText("Marathi");

                jUrduCheckBox34.setText("Urdu");

                jothers4IntLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
                jothers4IntLabel8.setText("others");

                jSubmitIntButton1.setBackground(new java.awt.Color(255, 153, 0));
                jSubmitIntButton1.setFont(new java.awt.Font("Monotype Corsiva", 0, 18)); // NOI18N
                jSubmitIntButton1.setForeground(new java.awt.Color(255, 255, 255));
                jSubmitIntButton1.setText("Submit");
                jSubmitIntButton1.addActionListener((e) -> {
                        if (jCookingCheckBox1.isSelected()) {
                                extraInfo.setHobbiesAndInterset("Cooking");
                        }
                        if (jNatureCheckBox2.isSelected()) {
                                extraInfo.setHobbiesAndInterset("Nature");
                        }
                        if (jPhotographyCheckBox3.isSelected()) {
                                extraInfo.setHobbiesAndInterset("Photography");
                        }
                        if (jDancingCheckBox4.isSelected()) {
                                extraInfo.setHobbiesAndInterset("Dancing");
                        }
                        if (jPaintingCheckBox5.isSelected()) {
                                extraInfo.setHobbiesAndInterset("Painting");
                        }
                        if (jPetsCheckBox6.isSelected()) {
                                extraInfo.setHobbiesAndInterset("Pets");
                        }
                        if (jPlayingMusicalInstrmentationCheckBox7.isSelected()) {
                                extraInfo.setHobbiesAndInterset("Playing Musical Instrument");
                        }
                        if (jPuzzlesCheckBox8.isSelected()) {
                                extraInfo.setHobbiesAndInterset("Solving Puzzles");
                        }
                        if (jGardeningCheckBox9.isSelected()) {
                                extraInfo.setHobbiesAndInterset("Gardening");
                        }
                        if (jArtCheckBox10.isSelected()) {
                                extraInfo.setHobbiesAndInterset("Art/Handcraft");
                        }
                        if (jListeningtoMusicCheckBox11.isSelected()) {
                                extraInfo.setHobbiesAndInterset("Listening to Music");
                        }
                        if (jMoviesCheckBox12.isSelected()) {
                                extraInfo.setHobbiesAndInterset("Movies");
                        }
                        if (jInternetSurfingCheckBox13.isSelected()) {
                                extraInfo.setHobbiesAndInterset("Internet Surfing");
                        }
                        if (jTravellingCheckBox14.isSelected()) {
                                extraInfo.setHobbiesAndInterset("Travelling");
                        }

                        if (jothers1TextField1.getText() != null)
                                extraInfo.setHobbiesAndInterset(jothers1TextField1.getText());

                        if (jFlimSongsCheckBox15.isSelected())
                                extraInfo.setFavouriteMusic("Flim Songs");
                        if (jIndianClassicalMusicCheckBox16.isSelected())
                                extraInfo.setFavouriteMusic("Indian/Classical Music");
                        if (jWesternMusicCheckBox17.isSelected())
                                extraInfo.setFavouriteMusic("Western Music");

                        if (jothers2TextField2.getText() != null)
                                extraInfo.setFavouriteMusic(jothers2TextField2.getText());

                        if (jCricketCheckBox18.isSelected())
                                extraInfo.setSportsFitness("Cricket");
                        if (jCarromCheckBox19.isSelected())
                                extraInfo.setSportsFitness("Carrom");
                        if (jChessCheckBox20.isSelected())
                                extraInfo.setSportsFitness("Chess");
                        if (jJoggingCheckBox21.isSelected())
                                extraInfo.setSportsFitness("Jogging");
                        if (jBadmintonCheckBox22.isSelected())
                                extraInfo.setSportsFitness("Badminton");
                        if (jSwimmingCheckBox23.isSelected())
                                extraInfo.setSportsFitness("Swimming");
                        if (jTennisCheckBox24.isSelected())
                                extraInfo.setSportsFitness("Tennis");
                        if (jFootballCheckBox25.isSelected())
                                extraInfo.setSportsFitness("Football");

                        if (jOthers3TextField3.getText() != null)
                                extraInfo.setSportsFitness(jOthers3TextField3.getText());

                        if (jEnglishCheckBox26.isSelected())
                                extraInfo.setSpokenLanguage("English");
                        if (jHindiCheckBox27.isSelected())
                                extraInfo.setSpokenLanguage("Hindi");
                        if (jTamilCheckBox28.isSelected())
                                extraInfo.setSpokenLanguage("Tamil");
                        if (jTeluguCheckBox29.isSelected())
                                extraInfo.setSpokenLanguage("Telugu");
                        if (jMalayalamCheckBox30.isSelected())
                                extraInfo.setSpokenLanguage("Malayalam");
                        if (jKannadaCheckBox31.isSelected())
                                extraInfo.setSpokenLanguage("Kannada");
                        if (jGujaratiCheckBox32.isSelected())
                                extraInfo.setSpokenLanguage("Gujarati");
                        if (jMarathiCheckBox33.isSelected())
                                extraInfo.setSpokenLanguage("Marathi");
                        if (jUrduCheckBox34.isSelected())
                                extraInfo.setSpokenLanguage("Urdu");
                        if (jothers4TextField4.getText() != null)
                                extraInfo.setSpokenLanguage(jothers4TextField4.getText());

                        Client client = new Client();
                        Login login = client.register(userDetails);
                        if (login != null) {
                                mainPanel.removeAll();
                                new HomeUI(mainPanel, new Client().profileDetails(login.getUserID()));
                                mainPanel.revalidate();
                                mainPanel.repaint();
                        } else {
                                JOptionPane.showMessageDialog(null, "Registration Failed");
                                mainPanel.removeAll();
                                createHomeUI(mainPanel);
                                mainPanel.revalidate();
                                mainPanel.repaint();
                        }
                });

                jBackButton.setBackground(new java.awt.Color(255, 153, 0));
                jBackButton.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
                jBackButton.setForeground(new java.awt.Color(255, 255, 255));
                jBackButton.setText("Back");
                jBackButton.setBounds(10, 10, 100, 25);
                jBackButton.addActionListener((e) -> {
                        mainPanel.removeAll();
                        createForm5UI(mainPanel);
                        mainPanel.revalidate();
                        mainPanel.repaint();
                });
                mainPanel.add(jBackButton);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup().addGap(134, 134, 134)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jFlimSongsCheckBox15)
                                                                                .addGap(65, 65, 65)
                                                                                .addComponent(jIndianClassicalMusicCheckBox16)
                                                                                .addGap(96, 96, 96)
                                                                                .addComponent(jWesternMusicCheckBox17))
                                                                .addComponent(jListeningtoMusicCheckBox11)
                                                                .addComponent(jHeading2IntLabel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                394,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jHeading1IntLabel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                351,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                false)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jHeading3IntLabel5,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                231,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(202, 202,
                                                                                                                                202))
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jCricketCheckBox18)
                                                                                                                                                .addComponent(jSwimmingCheckBox23,
                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING))
                                                                                                                                .addGap(84, 84, 84)
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jCarromCheckBox19)
                                                                                                                                                .addComponent(jTennisCheckBox24))
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                162,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jFootballCheckBox25)
                                                                                                                                                .addComponent(jChessCheckBox20))))
                                                                                .addGap(115, 115, 115)
                                                                                .addComponent(jJoggingCheckBox21)
                                                                                .addGap(128, 128, 128)
                                                                                .addComponent(jBadmintonCheckBox22))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                false)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jothers4IntLabel8,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                87,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(18, 18, 18)
                                                                                                                .addComponent(jothers4TextField4))
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                                .createSequentialGroup()
                                                                                                                                                                .addComponent(jEnglishCheckBox26)
                                                                                                                                                                .addGap(91, 91, 91)
                                                                                                                                                                .addComponent(jHindiCheckBox27))
                                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                                .createParallelGroup(
                                                                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                                                                                                .addComponent(jKannadaCheckBox31)
                                                                                                                                                                                                .addGap(91, 91, 91)
                                                                                                                                                                                                .addComponent(jGujaratiCheckBox32))
                                                                                                                                                                .addComponent(jHeading4IntLabel7,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                                279,
                                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                                                .addGap(80, 80, 80)
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jTamilCheckBox28)
                                                                                                                                                .addComponent(jMarathiCheckBox33))))
                                                                                .addGap(101, 101, 101)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jTeluguCheckBox29)
                                                                                                                .addGap(102, 102,
                                                                                                                                102)
                                                                                                                .addComponent(jMalayalamCheckBox30))
                                                                                                .addComponent(jUrduCheckBox34)))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                false)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jothers3IntLabel6,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                99,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jOthers3TextField3))
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addComponent(jothers2IntLabel4,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                86,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                                                .addComponent(jothers2TextField2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                359,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                                .addComponent(jothers1IntLabel2,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                93,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(jothers1TextField1,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                358,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jCookingCheckBox1,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                93,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(jPetsCheckBox6,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                69,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                                                .addGap(57, 57, 57)
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jNatureCheckBox2,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                93,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(jPlayingMusicalInstrmentationCheckBox7)
                                                                                                                                                .addComponent(jMoviesCheckBox12))
                                                                                                                                .addPreferredGap(
                                                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                                .addComponent(jInternetSurfingCheckBox13)
                                                                                                                                                .addComponent(jPhotographyCheckBox3,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                98,
                                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addComponent(jPuzzlesCheckBox8))))
                                                                                .addGap(76, 76, 76)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(jDancingCheckBox4)
                                                                                                                                .addComponent(jGardeningCheckBox9))
                                                                                                                .addGap(96, 96, 96)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(jArtCheckBox10)
                                                                                                                                .addComponent(jPaintingCheckBox5)))
                                                                                                .addComponent(jTravellingCheckBox14))))
                                                .addContainerGap(340, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                .createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jSubmitIntButton1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(157, 157, 157)));
                jPanel1Layout.setVerticalGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup().addGap(29, 29, 29)
                                                .addComponent(jHeading1IntLabel1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 38,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jCookingCheckBox1)
                                                                .addComponent(jNatureCheckBox2)
                                                                .addComponent(jPhotographyCheckBox3).addComponent(
                                                                                jDancingCheckBox4)
                                                                .addComponent(jPaintingCheckBox5))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jPetsCheckBox6)
                                                                .addComponent(jPlayingMusicalInstrmentationCheckBox7)
                                                                .addComponent(jPuzzlesCheckBox8).addComponent(
                                                                                jGardeningCheckBox9)
                                                                .addComponent(jArtCheckBox10))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jListeningtoMusicCheckBox11)
                                                                .addComponent(jMoviesCheckBox12)
                                                                .addComponent(jInternetSurfingCheckBox13).addComponent(
                                                                                jTravellingCheckBox14))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jothers1IntLabel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                26,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jothers1TextField1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                35,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(39, 39, 39)
                                                .addComponent(jHeading2IntLabel3,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 49,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jFlimSongsCheckBox15)
                                                                .addComponent(jIndianClassicalMusicCheckBox16)
                                                                .addComponent(jWesternMusicCheckBox17))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jothers2IntLabel4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                26,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jothers2TextField2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                36,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(63, 63, 63)
                                                .addComponent(jHeading3IntLabel5,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jCricketCheckBox18)
                                                                .addComponent(jCarromCheckBox19)
                                                                .addComponent(jChessCheckBox20)
                                                                .addComponent(jJoggingCheckBox21).addComponent(
                                                                                jBadmintonCheckBox22))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jSwimmingCheckBox23)
                                                                .addComponent(jTennisCheckBox24)
                                                                .addComponent(jFootballCheckBox25))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jothers3IntLabel6,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                28,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jOthers3TextField3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                37,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(54, 54, 54)
                                                .addComponent(jHeading4IntLabel7,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 44,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jEnglishCheckBox26)
                                                                .addComponent(jHindiCheckBox27)
                                                                .addComponent(jTamilCheckBox28)
                                                                .addComponent(jTeluguCheckBox29).addComponent(
                                                                                jMalayalamCheckBox30))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jKannadaCheckBox31)
                                                                .addComponent(jGujaratiCheckBox32)
                                                                .addComponent(jMarathiCheckBox33)
                                                                .addComponent(jUrduCheckBox34))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jothers4IntLabel8,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                28,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jothers4TextField4,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                38,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57,
                                                                Short.MAX_VALUE)
                                                .addComponent(jSubmitIntButton1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(305, 305, 305)));

                jInterestScrollPane1.setViewportView(jPanel1);
                jInterestScrollPane1.setBounds(0, 0, width, height);

                if (extraInfo.getHobbiesAndInterest() != null) {
                        if (extraInfo.getHobbiesAndInterest().equals("Cooking"))
                                jCookingCheckBox1.setSelected(true);
                        if (extraInfo.getHobbiesAndInterest().equals("Nature"))
                                jNatureCheckBox2.setSelected(true);
                        if (extraInfo.getHobbiesAndInterest().equals("Photography"))
                                jPhotographyCheckBox3.setSelected(true);
                        if (extraInfo.getHobbiesAndInterest().equals("Dancing"))
                                jDancingCheckBox4.setSelected(true);
                        if (extraInfo.getHobbiesAndInterest().equals("Painting"))
                                jPaintingCheckBox5.setSelected(true);
                        if (extraInfo.getHobbiesAndInterest().equals("Pets"))
                                jPetsCheckBox6.setSelected(true);
                        if (extraInfo.getHobbiesAndInterest().equals("Playing Musical Instrument"))
                                jPlayingMusicalInstrmentationCheckBox7.setSelected(true);
                        if (extraInfo.getHobbiesAndInterest().equals("Solving Puzzles"))
                                jPuzzlesCheckBox8.setSelected(true);
                        if (extraInfo.getHobbiesAndInterest().equals("Gardening"))
                                jGardeningCheckBox9.setSelected(true);
                        if (extraInfo.getHobbiesAndInterest().equals("Art/Handcraft"))
                                jArtCheckBox10.setSelected(true);
                        if (extraInfo.getHobbiesAndInterest().equals("Listening to Music"))
                                jListeningtoMusicCheckBox11.setSelected(true);
                        if (extraInfo.getHobbiesAndInterest().equals("Movies"))
                                jMoviesCheckBox12.setSelected(true);
                        if (extraInfo.getHobbiesAndInterest().equals("Internet Surfing"))
                                jInternetSurfingCheckBox13.setSelected(true);
                        if (extraInfo.getHobbiesAndInterest().equals("Travelling"))

                                jTravellingCheckBox14.setSelected(true);

                        if (extraInfo.getFavouriteMusic().equals("Flim Songs"))

                                jFlimSongsCheckBox15.setSelected(true);
                        if (extraInfo.getFavouriteMusic().equals("Indian/Classical Music"))

                                jIndianClassicalMusicCheckBox16.setSelected(true);
                        if (extraInfo.getFavouriteMusic().equals("Western Music"))

                                jWesternMusicCheckBox17.setSelected(true);

                        if (extraInfo.getSportsFitness().equals("Cricket"))
                                jCricketCheckBox18.setSelected(true);
                        if (extraInfo.getSportsFitness().equals("Carrom"))
                                jCarromCheckBox19.setSelected(true);

                        if (extraInfo.getSportsFitness().equals("Chess"))
                                jChessCheckBox20.setSelected(true);

                        if (extraInfo.getSportsFitness().equals("Jogging"))
                                jJoggingCheckBox21.setSelected(true);

                        if (extraInfo.getSportsFitness().equals("Badminton"))
                                jBadmintonCheckBox22.setSelected(true);

                        if (extraInfo.getSportsFitness().equals("Swimming"))
                                jSwimmingCheckBox23.setSelected(true);

                        if (extraInfo.getSportsFitness().equals("Tennis"))
                                jTennisCheckBox24.setSelected(true);

                        if (extraInfo.getSportsFitness().equals("Football"))
                                jFootballCheckBox25.setSelected(true);

                        if (extraInfo.getSpokenLanguage().equals("English"))
                                jEnglishCheckBox26.setSelected(true);

                        if (extraInfo.getSpokenLanguage().equals("Hindi"))
                                jHindiCheckBox27.setSelected(true);

                        if (extraInfo.getSpokenLanguage().equals("Tamil"))
                                jTamilCheckBox28.setSelected(true);

                        if (extraInfo.getSpokenLanguage().equals("Telugu"))
                                jTeluguCheckBox29.setSelected(true);

                        if (extraInfo.getSpokenLanguage().equals("Malayalam"))
                                jMalayalamCheckBox30.setSelected(true);

                        if (extraInfo.getSpokenLanguage().equals("Kannada"))
                                jKannadaCheckBox31.setSelected(true);

                        if (extraInfo.getSpokenLanguage().equals("Gujarati"))
                                jGujaratiCheckBox32.setSelected(true);

                        if (extraInfo.getSpokenLanguage().equals("Marathi"))
                                jMarathiCheckBox33.setSelected(true);

                        if (extraInfo.getSpokenLanguage().equals("Urdu"))
                                jUrduCheckBox34.setSelected(true);

                }

                profileInfo.setProfileImageIcon(new ImageIcon("src/client/resource/images/default.jpg"));
                profileInfo.setAcceptedPair(new HashSet<>());
                profileInfo.setPairDeclined(new HashSet<>());
                profileInfo.setPairRequest(new HashSet<>());
                profileInfo.setRequestedPair(new HashSet<>());
                profileInfo.setChatHistoryIds(new HashMap<>());

                mainPanel.add(jInterestScrollPane1);

        }

        // Variables declaration - do not modify
        private javax.swing.JCheckBox jArtCheckBox10;
        private javax.swing.JCheckBox jBadmintonCheckBox22;
        private javax.swing.JCheckBox jCarromCheckBox19;
        private javax.swing.JCheckBox jChessCheckBox20;
        private javax.swing.JCheckBox jCookingCheckBox1;
        private javax.swing.JCheckBox jCricketCheckBox18;
        private javax.swing.JCheckBox jDancingCheckBox4;
        private javax.swing.JCheckBox jEnglishCheckBox26;
        private javax.swing.JCheckBox jFlimSongsCheckBox15;
        private javax.swing.JCheckBox jFootballCheckBox25;
        private javax.swing.JCheckBox jGardeningCheckBox9;
        private javax.swing.JCheckBox jGujaratiCheckBox32;
        private javax.swing.JLabel jHeading1IntLabel1;
        private javax.swing.JLabel jHeading2IntLabel3;
        private javax.swing.JLabel jHeading3IntLabel5;
        private javax.swing.JLabel jHeading4IntLabel7;
        private javax.swing.JCheckBox jHindiCheckBox27;
        private javax.swing.JCheckBox jIndianClassicalMusicCheckBox16;
        private javax.swing.JScrollPane jInterestScrollPane1;
        private javax.swing.JCheckBox jInternetSurfingCheckBox13;
        private javax.swing.JCheckBox jJoggingCheckBox21;
        private javax.swing.JCheckBox jKannadaCheckBox31;
        private javax.swing.JCheckBox jListeningtoMusicCheckBox11;
        private javax.swing.JCheckBox jMalayalamCheckBox30;
        private javax.swing.JCheckBox jMarathiCheckBox33;
        private javax.swing.JCheckBox jMoviesCheckBox12;
        private javax.swing.JCheckBox jNatureCheckBox2;
        private javax.swing.JTextField jOthers3TextField3;
        private javax.swing.JCheckBox jPaintingCheckBox5;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JCheckBox jPetsCheckBox6;
        private javax.swing.JCheckBox jPhotographyCheckBox3;
        private javax.swing.JCheckBox jPlayingMusicalInstrmentationCheckBox7;
        private javax.swing.JCheckBox jPuzzlesCheckBox8;
        private javax.swing.JButton jSubmitIntButton1;
        private javax.swing.JCheckBox jSwimmingCheckBox23;
        private javax.swing.JCheckBox jTamilCheckBox28;
        private javax.swing.JCheckBox jTeluguCheckBox29;
        private javax.swing.JCheckBox jTennisCheckBox24;
        private javax.swing.JCheckBox jTravellingCheckBox14;
        private javax.swing.JCheckBox jUrduCheckBox34;
        private javax.swing.JCheckBox jWesternMusicCheckBox17;
        private javax.swing.JLabel jothers1IntLabel2;
        private javax.swing.JTextField jothers1TextField1;
        private javax.swing.JLabel jothers2IntLabel4;
        private javax.swing.JTextField jothers2TextField2;
        private javax.swing.JLabel jothers3IntLabel6;
        private javax.swing.JLabel jothers4IntLabel8;
        private javax.swing.JTextField jothers4TextField4;

}
