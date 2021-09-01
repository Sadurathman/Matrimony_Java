package client.java;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Image;
import javax.swing.*;
import java.awt.Dimension;
import client.java.forms.RegisterForm;
import java.awt.BorderLayout;

public class ClientStarter {
  private JPanel mainPanel;
  private RegisterForm registerForm;
  private int height, width;

  public ClientStarter() {
    Image icon = Toolkit.getDefaultToolkit().getImage("src/client/resource/images/Logo3.jpg");
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    width = (int) dimension.getWidth();
    height = (int) dimension.getHeight();

    JFrame f = new JFrame("Life Jouney Matrimonial");
    f.setLayout(new BorderLayout());
    f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    f.setBackground(Color.orange);
    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    f.setResizable(false);
    f.setSize(width, height);
    f.setIconImage(icon);

    Object result = JOptionPane.showInputDialog(f, "Enter URL:");
    String url = result.toString();
    if(url!=null){
      String[] uri = url.split(":");
      if(uri.length == 2) {
        Client.setHost(uri[0]);
        Client.setPort(Integer.parseInt(uri[1]));
      }
    }

    mainPanel = new JPanel();

    registerForm = new RegisterForm();

    registerForm.createHomeUI(mainPanel);
    mainPanel.setVisible(true);

    f.add(mainPanel);

    f.setVisible(true);
  }

  public static void main(String[] args) {
    new ClientStarter();
  }

}