import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyStore;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setTitle("Reģistrs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 250);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(null);


        JLabel virsraksts = new JLabel("Ir laiks piereģistrēties");
        virsraksts.setBounds(40, 20, 150, 25);
        panel.add(virsraksts);
        virsraksts.setBackground(Color.GRAY);


        JLabel username = new JLabel("Vārds");
        username.setBounds(30, 50, 80, 25);
        panel.add(username);


        JLabel passsword = new JLabel("Parole");
        passsword.setBounds(30, 75, 80, 25);
        panel.add(passsword);

        JTextField vardsTextField = new JTextField();
        vardsTextField.setBounds(110, 50, 80,25);
        panel.add(vardsTextField);
        vardsTextField.setVisible(true);
        vardsTextField.setBackground(Color.lightGray);


        JPasswordField paroleTextField = new JPasswordField();
        paroleTextField.setBounds(110, 75, 80, 25);
        panel.add(paroleTextField);
        paroleTextField.setVisible(true);
        paroleTextField.setBackground(Color.lightGray);


        JButton btn = new JButton("Aiziet");
        btn.setBounds(65, 150, 80, 25);
        panel.add(btn);
        btn.setBackground(Color.green);

//        JLabel paldies = new JLabel("paldies");
//        paldies.setBounds(65, 185, 80, 25);
//        panel.add(paldies);
//        paldies.setBackground(Color.GREEN);
//        paldies.setVisible(true);


        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String vaVal = vardsTextField.getText();
                String pasVal = paroleTextField.getText();

                    try {
                        String DB = "jdbc:mysql://localhost:3306/registrs";
                        String USER = "root";
                        String PASS = "Kirzaka112";
                        Connection conn = DriverManager.getConnection(DB, USER, PASS);
                        Statement stmt = conn.createStatement();







                        String vards = vardsTextField.getText();
                        String password = paroleTextField.getText();

                        String register = "INSERT INTO users (username, password) VALUES ('"+ vards + "','"+ password +"')";




                        stmt.executeUpdate(register);




                        conn.close();
//                        paldies.setVisible(true);
//
//                        paldies.setText("Paldies");

                    }

                    catch (SQLException e) {

                        e.printStackTrace();

                    }
                }





            })

        ;}

        }






