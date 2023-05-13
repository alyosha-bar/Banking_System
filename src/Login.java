import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;


public class Login extends JFrame {
    private JLabel userLabel;
    private static JTextField userText;
    private JLabel passwordLabel;
    private static JPasswordField passwordText;
    private JButton login;
    public Login() {
        setTitle("Login");

        // username input
        userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 10, 80, 25);
        add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        add(userText);

        // password input
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 40, 80, 25);
        add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        add(passwordText);


        login = new JButton("Login");
        login.setBounds(100, 60, 80, 25);
        add(login);


        // frame properties
        setLayout(null);
        InitialiseListeners();
        setSize(400, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void InitialiseListeners() {
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = getUser();
                String pass = getPass();
                try {
                    boolean found = Main.checkDetails(user, pass);
                    if(found) {
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(getParent(),"Invalid Login");
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }

    public String getUser() {
        return userText.getText();
    }

    public String getPass() {
        return passwordText.getText();
    }
}
