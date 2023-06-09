import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UserLogin implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5;
    JTextField t1;
    JPasswordField pf1;
    JButton b1, b2, b3;
    Utility util = new Utility();

    UserLogin() {
        f = new JFrame("Login Account");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 580, 350);
        l1.setLayout(null);

        l2 = new JLabel("Login Account");
        l2.setBounds(190, 30, 500, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        l1.add(l2);
        f.add(l1);

        l3 = new JLabel("Email : ");
        l3.setBounds(120, 120, 150, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l1.add(l3);

        l4 = new JLabel("Password : ");
        l4.setBounds(120, 170, 150, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l1.add(l4);

        t1 = new JTextField();
        t1.setBounds(320, 120, 150, 30);
        l1.add(t1);

        pf1 = new JPasswordField();
        pf1.setBounds(320, 170, 150, 30);
        l1.add(pf1);

        b2 = new JButton("SignUp");
        b2.setBounds(120, 220, 150, 40);

        b1 = new JButton("Login");
        b1.setBounds(320, 220, 150, 40);

        b3 = new JButton("Back");
        b3.setBounds(220, 270, 150, 40);
        f.add(b3);

        l1.add(b1);
        l1.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        f.setVisible(true);
        f.setSize(580, 400);
        f.setResizable(false);

    }

    public void actionPerformed(ActionEvent ee) {
        if (ee.getSource() == b1) {
            try {
                String email = t1.getText();
                String password1 = pf1.getText();

                if (email.equals("") || password1.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                    f.dispose();
                    new UserLogin();
                } else {
                    if (util.Login(email, password1, "user") == 1) {
                        f.dispose();
                        new UserHome();
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ee.getSource() == b2) {
            f.dispose();
            new UserSignUp();
        } else if (ee.getSource() == b3) {
            f.dispose();
            new App();
        }
    }
}
