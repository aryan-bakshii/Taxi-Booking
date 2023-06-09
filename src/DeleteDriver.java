import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class DeleteDriver implements ActionListener {
    static JFrame f;
    JTable jTable1 = new JTable();
    static JButton b1, b2, b3, b4, b5, b6;
    static JLabel l1, l2, l3, l4, l5, l6;
    static JTextField t1, t2, t3, t4, t5, t6;
    Utility util = new Utility();

    final int pad = 50;

    final int tx = 200;
    final int ty = 25;
    final int tw = 150;
    final int th = 35;

    final int lx = 50;
    final int ly = 20;
    final int lw = 150;
    final int lh = 50;

    public int pay = 0;

    public DeleteDriver() {

        f = new JFrame("Delete Driver");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1 = new JLabel("Name");
        l1.setBounds(lx, ly, lw, lh);
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        f.add(l1);

        l2 = new JLabel("Email");
        l2.setBounds(lx, ly + pad, lw, lh);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        f.add(l2);

        l3 = new JLabel("Phone");
        l3.setBounds(lx, ly + pad * 2, lw, lh);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        f.add(l3);

        l4 = new JLabel("Plate");
        l4.setBounds(lx, ly + pad * 3, lw, lh);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        f.add(l4);

        l5 = new JLabel("Status");
        l5.setBounds(lx, ly + pad * 4, lw, lh);
        l5.setFont(new Font("Arial", Font.BOLD, 20));
        f.add(l5);

        t1 = new JTextField();
        t1.setBounds(tx, ty, tw, th);
        f.add(t1);

        t2 = new JTextField();
        t2.setBounds(tx, ty + pad, tw, th);
        f.add(t2);

        t3 = new JTextField();
        t3.setBounds(tx, ty + pad * 2, tw, th);
        t3.setEditable(false);
        f.add(t3);

        t4 = new JTextField();
        t4.setBounds(tx, ty + pad * 3, tw, th);
        f.add(t4);

        t5 = new JTextField();
        t5.setBounds(tx, ty + pad * 4, tw, th);
        f.add(t5);

        b1 = new JButton("Find");
        b1.setBounds(lx, ty + pad * 7, 150, 100);
        f.add(b1);

        b2 = new JButton("Update");
        b2.setBounds(tx, ty + pad * 7, 150, 100);
        f.add(b2);

        b3 = new JButton("Remove");
        b3.setBounds(lx, ty + pad * 9, 150, 100);
        f.add(b3);

        b4 = new JButton("Back");
        b4.setBounds(tx, ty + pad * 9, 150, 100);
        f.add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        // Frame Size
        f.getContentPane();
        f.setVisible(true);
        f.setSize(400, 700);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == b1) {
            Search s = new Search(t1.getText(), t2.getText(), t3.getText());
            if (!s.getAadhaar().equals("")) { // Aadhaar field cannot be empty if the driver is found
                // display table for the driver if found
                t1.setText(s.getName());
                t2.setText(s.getAadhaar());
                t3.setText(s.getPhone());
                t4.setText(s.getPlate());
                t5.setText(s.getStatus());
            } else {
                JOptionPane.showMessageDialog(null, "Driver not registered.");
            }
        } else if (e.getSource() == b2) {
            util.UpdateDriver(t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText());
        } else if (e.getSource() == b4) {
            f.dispose();
        } else if (e.getSource() == b3) {
            String query = "Delete from driver WHERE phone_number like '" + t3.getText() + "';";
            int aa;
            try {
                ConnectionClass obj = new ConnectionClass();
                aa = obj.stm.executeUpdate(query);
                if (aa == 1) {
                    JOptionPane.showMessageDialog(null, "Driver removed.");
                } else {
                    JOptionPane.showMessageDialog(null, "Driver not found. Try Again.");
                }
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}
