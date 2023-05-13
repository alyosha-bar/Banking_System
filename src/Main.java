
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        //initialise dashboard
        JFrame dashboard = new Dashboard();
        dashboard.setVisible(true);
    }

    public static boolean checkDetails(String user, String pass) throws IOException {
        String[][] customers = readFile();

        String[] usernames = new String[customers.length];
        String[] passwords = new String[customers.length];
        for(int i = 0; i<customers.length; i++) {
            usernames[i] = customers[i][0];
            passwords[i] = customers[i][1];
        }



        boolean found = false;

        for (int i = 0; i < usernames.length; i++) {
            //checking username
            if(user.equals(usernames[i])) {
                //checking password
                if (pass.equals(passwords[i])) {
                    //both checks passed
                    found = true;
                    System.out.println("Access Granted");
                }
                break;
            }
        }

        if (found) {
            //OPEN NEW WINDOW
            JFrame menu = new Menu();
            menu.setVisible(true);
        }
        return found;
    }

//    public static void printArray(String[] arr, String prefix) {
//        for(int i = 0; i < arr.length; i++) {
//            System.out.println(prefix + " : "+arr[i]);
//        }
//        return;
//    }

//    public static boolean exitSystem() {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Exit System? (y/n)");
//        String answer = sc.nextLine();
//        if (answer.equals("y")) {
//            return true;
//        }
//        return false;
//    }

    public static String[][] readFile() throws IOException{
        String filePath = "files/Customers.csv";
        File file = new File(filePath);

        List<String[]> rows = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                rows.add(values);
            }
        }

        String username;
        String password;
        String balance;


        String[][] customers = new String[rows.size()][3];

        // Now you have a list of rows, each row represented as a String array
        for (int i = 0; i < rows.size(); i++) {
            String[] row = rows.get(i);

            // Do something with each row
            username = row[0];
            password = row[1];
            balance = row[2];

//            System.out.println("Username: " + username);
//            System.out.println("Password: " + password);
//            System.out.println("Balance: " + balance + "\n");

            //add the rows into some sort of 2D array
            customers[i][0] = username;
            customers[i][1] = password;
            customers[i][2] = balance;
        }



        return customers;

    }

}
