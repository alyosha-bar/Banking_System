import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JFrame {
    private JButton viewBalance;
    private JButton addMoney;
    private JButton withdraw;

    public Menu() {
        setTitle("Menu");

        // view balance button
        viewBalance = new JButton("View Balance");
        viewBalance.setBounds(10, 10, 120, 25);
        add(viewBalance);

        // add money button
        addMoney = new JButton("Add Money");
        addMoney.setBounds(10, 40, 120, 25);
        add(addMoney);

        // withdraw button
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(10, 70, 120, 25);
        add(withdraw);

        // frame properties
        setLayout(null);
        InitialiseListeners();
        setSize(170, 170);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void InitialiseListeners() {

        viewBalance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //display account balance
                System.out.println("Account balance lol");
            }
        });

        addMoney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ask for money amount
                //add to balance
                System.out.println("add money");
            }
        });

        withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ask for withdrawal amount
                //subtract from balance
                System.out.println("withdraw");
            }
        });

    }

}
