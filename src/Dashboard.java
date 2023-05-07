import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;


public class Dashboard extends JFrame {

    private JButton login;
    private JButton addAccount;

    Dashboard() {
        setTitle("Dashboard");

        login = new JButton("Login");
        login.setBounds(10, 10, 120, 25);
        add(login);

        addAccount = new JButton("Add Account");
        addAccount.setBounds(10, 40, 120, 25);
        add(addAccount);


        InitialiseListeners();
        setLayout(null);
        setSize(150, 130);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void InitialiseListeners() {

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame login = new Login();
                login.setVisible(true);

                //change GUIs
                setVisible(false);
            }
        });

        addAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // needs new GUI class

                JFrame newAccount = new newAccount();
                newAccount.setVisible(true);

                //change GUIs
                setVisible(false);
            }
        });

    }


}
