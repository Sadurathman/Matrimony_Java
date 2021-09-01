
package client.java.ui;

import client.java.Client;
import com.sun.org.apache.bcel.internal.classfile.ExceptionTable;
import javabeans.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProfileUI {
  private JLabel userIcon, verified, age, name, motherTongue, livesin, education, work, income, about, dob, mobileNo,
      studiedin, star, heightLabel, address, studiedinTemp, starTopic, heightTemp, addressTemp, aboutTemp;
  private JLabel nameTemp, motherTongueTemp, ageTemp, livesInTemp, dobTemp, educationTemp, workTemp, mobilenoTemp,
      incomeTemp;
  private JButton jBackButton;
  private UserDetails userDetail;

  ProfileUI(JPanel panel, UserDetails userInfo, int userId) {

    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) dimension.getWidth();
    int height = (int) dimension.getHeight();
    panel.setBounds(0, 0, width, height);

    userDetail = new Client().profileDetails(userId);
//    userDetail = new UserDetails();

//    ProfileInfo profileInfo = new ProfileInfo();
//    BasicDetails basicDetails = new BasicDetails();
//    PersonalDetails personalDetails = new PersonalDetails();
//    ProfessionalDetails professionalDetails = new ProfessionalDetails();
//
//    userDetail.setBasicDetails(basicDetails);
//    userDetail.setProfileInfo(profileInfo);
//    userDetail.setPersonalDetails(personalDetails);
//    userDetail.setProfessionalDetails(professionalDetails);
//
//    profileInfo.setName("Priya");
//    profileInfo.setProfileImageIcon(new ImageIcon("src/client/resource/images/E4TU9esUcAU2llJ.jpg"));
//    profileInfo.setAge(23);
//    profileInfo.setCity("Chennai");
//    profileInfo.setHighestEducation("B.Tech");
//    profileInfo.setHeight(5);
//    profileInfo.setMotherTongue("Tamil");
//    profileInfo.setOccupation("Actress");
//    basicDetails.setPhone("9999992134");
//    personalDetails.setAbout("Nothing Much");
//    professionalDetails.setAnnualIncome(100000);
//
//    try {
//      basicDetails.setDateOfBirth((new SimpleDateFormat("MM/dd/yyyy"))
//              .parse("12/16/1996"));
//    }catch(Exception e){
//
//    }
//
//
    userIcon = new JLabel(new ImageIcon(userDetail.getProfileInfo().getProfileImageIcon().getImage()
        .getScaledInstance(230, 230, Image.SCALE_DEFAULT)));
    userIcon.setBounds(80, 80, 230, 230);
    panel.add(userIcon);

    verified = new JLabel("\u2713 Verified");
    verified.setBounds(80, 320, 100, 20);
    panel.add(verified);

    verified.setForeground(java.awt.Color.blue);

    name = new JLabel();
    age = new JLabel();
    motherTongue = new JLabel();
    livesin = new JLabel();
    education = new JLabel();
    work = new JLabel();
    income = new JLabel();
    about = new JLabel();
    dob = new JLabel();
    mobileNo = new JLabel();
    jBackButton = new JButton("Back");
    jBackButton.setBackground(new java.awt.Color(255, 153, 0));
    jBackButton.setFont(new java.awt.Font("Monotype Corsiva", 0, 18));
    jBackButton.setForeground(new java.awt.Color(255, 255, 255));
    jBackButton.setText("Back");
    jBackButton.setBounds(10,5,100,30);
    jBackButton.addActionListener((e)->{
      panel.removeAll();
      new HomeUI(panel, userInfo);
      panel.revalidate();
      panel.repaint();
    });
    panel.add(jBackButton);
    panel.setBackground(java.awt.Color.WHITE);

    nameTemp = new JLabel("Name:");
    nameTemp.setBounds(350, 60, 100, 50);
    nameTemp.setFont(new Font("Times New Roman", Font.BOLD, 20));
    nameTemp.setForeground(java.awt.Color.DARK_GRAY);
    panel.add(nameTemp);
    name.setBounds(450, 60, 100, 50);
    name.setFont(new Font("Times New Roman", Font.BOLD, 20));
    name.setForeground(java.awt.Color.DARK_GRAY);
    name.setText(userDetail.getProfileInfo().getName());

    ageTemp = new JLabel("Age:");
    ageTemp.setBounds(350, 120, 100, 30);
    ageTemp.setFont(new Font("Times New Roman", Font.BOLD, 18));
    ageTemp.setForeground(java.awt.Color.DARK_GRAY);
    panel.add(ageTemp);

    age.setText(userDetail.getProfileInfo().getAge()+" Years");
    age.setBounds(450, 120, 100, 30);
    age.setFont(new Font("Times New Roman", Font.BOLD, 18));
    age.setForeground(java.awt.Color.DARK_GRAY);

    livesInTemp = new JLabel("Lives in:");
    livesInTemp.setBounds(350, 180, 100, 30);
    livesInTemp.setFont(new Font("Times New Roman", Font.BOLD, 18));
    livesInTemp.setForeground(java.awt.Color.DARK_GRAY);
    panel.add(livesInTemp);

    livesin.setText(userDetail.getProfileInfo().getCity());
    livesin.setBounds(450, 180, 100, 30);
    livesin.setFont(new Font("Times New Roman", Font.BOLD, 18));
    livesin.setForeground(java.awt.Color.DARK_GRAY);

    dobTemp = new JLabel("<html>Date <br/>of Birth</html>");
    dobTemp.setBounds(350, 240, 200, 50);
    dobTemp.setFont(new Font("Times New Roman", Font.BOLD, 18));
    dobTemp.setForeground(java.awt.Color.DARK_GRAY);
    panel.add(dobTemp);

    dob.setText((new SimpleDateFormat("MM/dd/yyyy")).format(userDetail.getBasicDetails().getDateOfBirth()));
    dob.setBounds(450, 240, 100, 30);
    dob.setFont(new Font("Times New Roman", Font.BOLD, 18));
    dob.setForeground(java.awt.Color.DARK_GRAY);

    educationTemp = new JLabel("Education:");
    educationTemp.setBounds(350, 300, 100, 30);
    educationTemp.setFont(new Font("Times New Roman", Font.BOLD, 18));
    educationTemp.setForeground(java.awt.Color.DARK_GRAY);
    panel.add(educationTemp);

    education.setText(userDetail.getProfileInfo().getHighestEducation());
    education.setBounds(450, 300, 100, 30);
    education.setFont(new Font("Times New Roman", Font.BOLD, 18));
    education.setForeground(java.awt.Color.DARK_GRAY);

    workTemp = new JLabel("Work:");
    workTemp.setBounds(1030, 410, 100, 30);
    workTemp.setFont(new Font("Times New Roman", Font.BOLD, 18));
    workTemp.setForeground(java.awt.Color.DARK_GRAY);
    panel.add(workTemp);

    work.setText(userDetail.getProfileInfo().getOccupation());
    work.setBounds(1030, 440, 100, 30);
    work.setFont(new Font("Times New Roman", Font.BOLD, 18));
    work.setForeground(java.awt.Color.DARK_GRAY);
    incomeTemp = new JLabel("Income:");
    incomeTemp.setBounds(90, 410, 100, 40);
    incomeTemp.setFont(new Font("Times New Roman", Font.BOLD, 18));
    incomeTemp.setForeground(java.awt.Color.DARK_GRAY);
    panel.add(incomeTemp);

    income.setText(userDetail.getProfessionalDetails().getAnnualIncome()+"");
    income.setBounds(90, 440, 100, 30);
    income.setFont(new Font("Times New Roman", Font.BOLD, 18));
    income.setForeground(java.awt.Color.DARK_GRAY);

    mobilenoTemp = new JLabel("Mobile Number:");
    mobilenoTemp.setBounds(230, 410, 200, 40);
    mobilenoTemp.setFont(new Font("Times New Roman", Font.BOLD, 18));
    mobilenoTemp.setForeground(java.awt.Color.DARK_GRAY);
    panel.add(mobilenoTemp);

    mobileNo.setText(userDetail.getBasicDetails().getPhone());
    mobileNo.setBounds(230, 440, 100, 30);
    mobileNo.setFont(new Font("Times New Roman", Font.BOLD, 18));
    mobileNo.setForeground(java.awt.Color.DARK_GRAY);

    aboutTemp = new JLabel("About:");
    aboutTemp.setBounds(700, 70, 100, 20);
    aboutTemp.setFont(new Font("Times New Roman", Font.BOLD, 20));
    aboutTemp.setForeground(java.awt.Color.DARK_GRAY);
    panel.add(aboutTemp);

    about.setText(userDetail.getPersonalDetails().getAbout());
    about.setBounds(700, 50, 800, 200);
    about.setFont(new Font("Times New Roman", Font.BOLD, 18));
    about.setForeground(java.awt.Color.DARK_GRAY);

    heightLabel = new JLabel();
    heightLabel.setText(userDetail.getProfileInfo().getHeight()+"");
    heightLabel.setBounds(700, 440, 100, 20);
    heightLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
    heightLabel.setForeground(java.awt.Color.DARK_GRAY);

    heightTemp = new JLabel("Height:");

    heightTemp.setBounds(700, 410, 100, 20);
    heightTemp.setFont(new Font("Times New Roman", Font.BOLD, 18));
    heightTemp.setForeground(java.awt.Color.DARK_GRAY);

    motherTongueTemp = new JLabel("MotherTongue:");
    motherTongueTemp.setBounds(870, 410, 190, 30);
    motherTongueTemp.setFont(new Font("Times New Roman", Font.BOLD, 18));
    motherTongueTemp.setForeground(java.awt.Color.DARK_GRAY);
    panel.add(motherTongueTemp);

    motherTongue.setText(userDetail.getProfileInfo().getMotherTongue());
    motherTongue.setBounds(870, 440, 100, 30);
    motherTongue.setFont(new Font("Times New Roman", Font.BOLD, 18));
    motherTongue.setForeground(java.awt.Color.DARK_GRAY);

    panel.add(name);
    panel.add(age);
    panel.add(motherTongue);
    panel.add(livesin);
    panel.add(education);
    panel.add(work);
    panel.add(income);
    panel.add(dob);

    panel.add(about);
    panel.add(mobileNo);
    panel.add(studiedin);
    panel.add(studiedinTemp);
    panel.add(star);
    panel.add(starTopic);
    panel.add(heightLabel);
    panel.add(heightTemp);
    panel.add(addressTemp);
    panel.add(address);
    panel.setLayout(null);
  }

}
