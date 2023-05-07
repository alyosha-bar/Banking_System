import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;

public class newAccount extends JFrame{

    private JLabel userLabel;
    private JTextField userText;
    private JLabel confirmUserLabel;
    private JTextField confirmUserText;
    private JLabel passwordLabel;
    private JPasswordField passwordText;
    private JLabel confirmPasswordLabel;
    private JPasswordField confirmPasswordText;
    private JButton register;
    newAccount() {
        setTitle("Registration");

        // user input
        userLabel = new JLabel("User:");
        userLabel.setBounds(10, 10, 80, 25);
        add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        add(userText);

        // confirm user input
        confirmUserLabel = new JLabel("Confirm User:");
        confirmUserLabel.setBounds(10, 40, 100, 25);
        add(confirmUserLabel);

        confirmUserText = new JTextField(20);
        confirmUserText.setBounds(100, 40, 160, 25);
        add(confirmUserText);

        // password input
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 70, 80, 25);
        add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 70, 160, 25);
        add(passwordText);

        // confirm password input
        confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(10, 100, 120, 25);
        add(confirmPasswordLabel);

        confirmPasswordText = new JPasswordField(20);
        confirmPasswordText.setBounds(130, 100, 130, 25);
        add(confirmPasswordText);

        register = new JButton("Register");
        register.setBounds(130, 130, 130, 25);
        add(register);

        // frame properties
        InitialiseListeners();
        setLayout(null);
        setSize(350, 180);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void InitialiseListeners() {

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String confirmUser = confirmUserText.getText();

                String pass = passwordText.getText();
                String confirmPass = confirmPasswordText.getText();

                if (user.equals(confirmUser) && pass.equals(confirmPass)) {

                    //add account to CSV
                    String filePath = "files/Customers.csv";
                    String[] userData1 = {user, pass, "0"};

                    try {
                        FileWriter fileWriter = new FileWriter(filePath, true);

                        fileWriter.append("\n");

                        // write user data
                        fileWriter.append(userData1[0]);
                        fileWriter.append(",");
                        fileWriter.append(userData1[1]);
                        fileWriter.append(",");
                        fileWriter.append(userData1[2]);


                        fileWriter.close();
                        System.out.println("Data written to CSV file successfully!");

                        setVisible(false);

                        JFrame dashboard = new Dashboard();
                        dashboard.setVisible(true);

                    } catch (IOException er) {
                        System.err.println("Error writing data to CSV file: " + er.getMessage());
                    }
                    System.out.println("Valid Details - adding account");
                } else {
                    System.out.println("Invalid Details");
                }
            }
        });
    }


}
