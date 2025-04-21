package carwashproject;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class BillFrame extends JFrame {

    private JLabel title;
    private JTextArea Cbill;
    private JButton Finish;
    private String Vname;

    public BillFrame(String name) {
        Vname = name;
        setTitle("Car Wash");
        setSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        title = new JLabel("Your Bill:");
        title.setFont(new Font("Times", Font.BOLD, 18));
        title.setForeground(Color.RED);
        panel1.add(title);
        add(panel1, BorderLayout.NORTH);

        JPanel panel2 = new JPanel();
        Cbill = new JTextArea(30, 30);
        Cbill.setEditable(false);
        Cbill.setFont(new Font("Times", Font.BOLD, 14));
        Cbill.setForeground(Color.BLUE);
        JScrollPane spanel = new JScrollPane(Cbill);
        panel2.add(spanel);
        add(panel2, BorderLayout.CENTER);

        Finish = new JButton("Finish");
        Finish.addActionListener(new doneBtn());
        Finish.setFont(new Font("Times", Font.BOLD, 18));
        Finish.setBackground(Color.gray);
        Finish.setForeground(Color.RED);
        Finish.setSize(new Dimension(100, 100));
        add(Finish, BorderLayout.SOUTH);
        addBill();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class doneBtn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    void addBill() {
        String bill = "";

        try {
            File fBill = new File(Vname + "Bill");
            Scanner scanner = new Scanner(fBill);
            while (scanner.hasNextLine()) {
                bill += scanner.nextLine() + "\n";
            }
            Cbill.setText(bill);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
