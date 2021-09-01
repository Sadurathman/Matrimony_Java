package client.java.forms;

import client.java.Client;
import client.java.ui.HomeUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import javabeans.Login;

import java.awt.Dimension;
import java.awt.Toolkit;

public class LoginForm {

  private JLabel userIcon, userLabel, passLabel, headerLabel, welcomeLabel;
  private JTextField userInput;
  private JPasswordField passInput;
  private JButton loginbutton, registerbutton, forgetpassword;
  private JCheckBox showpassword;
  Login login;

  public LoginForm(JPanel panel) {
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) dimension.getWidth();
    int height = (int) dimension.getHeight();
    login = new Login();
    userIcon = new JLabel(
        new ImageIcon(new ImageIcon("src/client/resource/images/wedding_inscription_words_166526_1366x768.jpg")
            .getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
    userLabel = new JLabel("Username");
    passLabel = new JLabel("Password");
    headerLabel = new JLabel("Login");
    welcomeLabel = new JLabel("Life Journey");
    userInput = new JTextField();
    passInput = new JPasswordField();
    loginbutton = new JButton("Login");
    registerbutton = new JButton("Register");
    showpassword = new JCheckBox("Showpassword");
    forgetpassword = new JButton("Forget password?");
    // vertical = new JScrollBar(JScrollBar.VERTICAL,30,40,0,height);

    panel.setLayout(null);
    // panel.setBounds(0, 0, width, height);
    welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
    welcomeLabel.setForeground(Color.WHITE);
    // welcomeLabel.setBorder(new MatteBorder(4, 4, 4, 4, Color.GRAY));
    headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
    headerLabel.setForeground(Color.WHITE);
    // headerLabel.setBorder(new MatteBorder(4, 4, 4, 4, Color.GRAY));
    userLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
    userLabel.setForeground(Color.WHITE);
    userInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    userInput.setBorder(new MatteBorder(2, 2, 2, 2, Color.WHITE));
    userInput.setForeground(Color.WHITE);
    passLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
    passLabel.setForeground(Color.WHITE);
    passInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    passInput.setBorder(new MatteBorder(2, 2, 2, 2, Color.WHITE));
    passInput.setForeground(Color.WHITE);
    showpassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    showpassword.setForeground(Color.white);
    showpassword.setBorder(new MatteBorder(2, 2, 2, 2, Color.WHITE));
    loginbutton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    loginbutton.setBorder(new MatteBorder(2, 2, 2, 2, Color.WHITE));
    registerbutton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    registerbutton.setBorder(new MatteBorder(2, 2, 2, 2, Color.WHITE));
    forgetpassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
    forgetpassword.setBorder(new MatteBorder(2, 2, 2, 2, Color.WHITE));
    showpassword.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (showpassword.isSelected()) {
          passInput.setEchoChar((char) 0);
        } else {
          passInput.setEchoChar('*');
        }
      }
    });
    userIcon.setBounds(0, 0, width, height);

    welcomeLabel.setBounds(0, 70, width, 50);
    welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
    headerLabel.setBounds(0, 140, width, 50);
    headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
    userLabel.setBounds(width / 2, 210, 200, 50);
    userInput.setBounds(width / 2, 250, 200, 30);
    passLabel.setBounds(width / 2, 290, 200, 50);
    passInput.setBounds(width / 2, 340, 200, 30);
    showpassword.setBounds(width / 2, 380, 200, 30);
    loginbutton.setBounds(width / 2 - 20, 420, 100, 30);
    registerbutton.setBounds(width / 2 + 110, 420, 100, 30);
    forgetpassword.setBounds(width / 2, 460, 200, 30);
    userInput.setOpaque(false);
    passInput.setOpaque(false);
    showpassword.setOpaque(false);

    loginbutton.addActionListener((e) -> {
       Client client = new Client();
       Login login = client.login(userInput.getText(),
               new String(passInput.getPassword()));
       if (login != null) {
      panel.removeAll();
      new HomeUI(panel, new Client().profileDetails(login.getUserID()));
      panel.revalidate();
      panel.repaint();
       } else {
       JOptionPane.showMessageDialog(null, "Invalid Credentials");
       }
    });

    registerbutton.addActionListener((e) -> {
      panel.removeAll();

      new RegisterForm().createHomeUI(panel);
      panel.revalidate();
      panel.repaint();
    });

    forgetpassword.addActionListener((e) -> {

    });
    // panel.add(vertical);
    // panel.add(vertical,BorderLayout.EAST);

    panel.add(welcomeLabel);
    panel.add(headerLabel);
    panel.add(userLabel);
    panel.add(userInput);
    panel.add(passLabel);
    panel.add(passInput);
    panel.add(showpassword);
    panel.add(loginbutton);
    panel.add(registerbutton);
    panel.add(forgetpassword);

    panel.add(userIcon);
  }
}