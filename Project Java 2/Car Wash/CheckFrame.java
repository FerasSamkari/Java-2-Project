package carwashproject;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.*;

public class CheckFrame extends JFrame {
    private JLabel title;
    private JLabel Name;
    private JLabel PhoneNumber;
    private JTextField nameF;
    private JTextField phoneNumberF;
    private JLabel Type;
    private JLabel color;
    private JComboBox carTypecombo;
    private JComboBox WashType;
    private JButton showPrice;
    private JLabel price;
    private JTextField priceTxt;
    private JLabel payby;
    private JRadioButton cash;
    private JRadioButton installments;
    private ButtonGroup btngroup = new ButtonGroup();
    private JButton Confirm;
    private JButton Cancel;
    String[] carType = {"Small car", "Medium Vehicle", "Small Vehicle", "Trucks"};
    String[] WashingType = {"Internal Washing", "External Washing", "Internal & External wash"};

    public CheckFrame() {
        setTitle("Car Wash");
        setSize(new Dimension(600, 700));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Panel Title 
        JPanel ptitle = new JPanel();
        title = new JLabel("Car Wash Services:");
        title.setFont(new Font("Times", Font.BOLD, 24));
        title.setForeground(Color.RED);
        ptitle.add(title);
        add(ptitle, BorderLayout.NORTH);

        //gridlayout for all 
        JPanel pgrid = new JPanel();
        pgrid.setLayout(new GridLayout(7, 1, 0, 0));

        //Customer Name
        JPanel namepanel = new JPanel();
        namepanel.setLayout(new GridLayout(1, 2, 0, 0));
        Name = new JLabel("    Customer Name :");
        Name.setFont(new Font("Times", Font.ROMAN_BASELINE, 18));
        Name.setForeground(Color.blue);
        JPanel test = new JPanel();
        nameF = new JTextField(10);
        nameF.setSize(new Dimension(10, 10));
        nameF.setFont(new Font("Times", Font.ROMAN_BASELINE, 18));
        nameF.setForeground(Color.RED);
        namepanel.add(Name);
        namepanel.add(nameF);
        pgrid.add(namepanel);
        
        //Phone Number
        JPanel phonepanel = new JPanel();
        phonepanel.setLayout(new GridLayout(1, 2, 0, 0));
        PhoneNumber = new JLabel("    Phone Number :");
        PhoneNumber.setFont(new Font("Times", Font.ROMAN_BASELINE, 18));
        PhoneNumber.setForeground(Color.blue);
        phoneNumberF = new JTextField(10);
        phoneNumberF.setFont(new Font("Times", Font.ROMAN_BASELINE, 18));
        phoneNumberF.setForeground(Color.RED);
        phonepanel.add(PhoneNumber);
        phonepanel.add(phoneNumberF);
        pgrid.add(phonepanel);

        //labels and ComboBox
        JPanel typepanel = new JPanel();
        typepanel.setLayout(new GridLayout(1, 2, 0, 0));
        Type = new JLabel("    Car Size :");
        Type.setFont(new Font("Times", Font.ROMAN_BASELINE, 18));
        Type.setForeground(Color.blue);
        typepanel.add(Type);
        carTypecombo = new JComboBox(carType);
        typepanel.add(carTypecombo);
        pgrid.add(typepanel);

        JPanel WashTypepanel = new JPanel();
        WashTypepanel.setLayout(new GridLayout(1, 2, 0, 0));
        color = new JLabel("    Washing Type :");
        color.setFont(new Font("Times", Font.ROMAN_BASELINE, 18));
        color.setForeground(Color.blue);
        WashTypepanel.add(color);
        WashType = new JComboBox(WashingType);
        WashTypepanel.add(WashType);
        pgrid.add(WashTypepanel);

        //Price Button
        JPanel pBtn = new JPanel();
        showPrice = new JButton("Enter :");
        showPrice.setFont(new Font("Times", Font.ROMAN_BASELINE, 18));
        showPrice.setBackground(Color.LIGHT_GRAY);
        showPrice.setForeground(Color.RED);
        showPrice.addActionListener(new btnsAction());
        pBtn.add(showPrice);
        pgrid.add(pBtn);

        //Show the Price
        JPanel pricepanel = new JPanel();
        pricepanel.setLayout(new GridLayout(1, 2, 0, 0));
        price = new JLabel("    Washing Car Price");
        price.setFont(new Font("Times", Font.ROMAN_BASELINE, 18));
        price.setForeground(Color.RED);
        priceTxt = new JTextField();
        priceTxt.setEditable(false);
        priceTxt.setFont(new Font("Times", Font.ROMAN_BASELINE, 18));
        price.setForeground(Color.RED);
        pricepanel.add(price);
        pricepanel.add(priceTxt);
        pgrid.add(pricepanel);

        //Cash or Creditcard
        JPanel paypanel = new JPanel();
        pricepanel.setLayout(new GridLayout(1, 2, 0, 0));
        payby = new JLabel("Pay by :");
        payby.setFont(new Font("Times", Font.ROMAN_BASELINE, 18));
        payby.setForeground(Color.DARK_GRAY);
        
        //Panels and RadioButtons
        JPanel radiopanel = new JPanel();
        radiopanel.setLayout(new GridLayout(1, 2, 0, 0));
        cash = new JRadioButton("Cash");
        cash.setFont(new Font("Times", Font.ROMAN_BASELINE, 18));
        cash.setForeground(Color.LIGHT_GRAY);
        installments = new JRadioButton("Credit Card");
        installments.setFont(new Font("Times", Font.ROMAN_BASELINE, 18));
        installments.setForeground(Color.LIGHT_GRAY);
        btngroup.add(cash);
        btngroup.add(installments);
        radiopanel.add(cash);
        radiopanel.add(installments);
        paypanel.add(payby);
        paypanel.add(radiopanel);
        pgrid.add(paypanel);
        add(pgrid, BorderLayout.CENTER);

        JPanel buttonspanel = new JPanel();
        buttonspanel.setLayout(new GridLayout(1, 2, 0, 0));
        Confirm = new JButton("The Bill");
        Confirm.setFont(new Font("Times", Font.ROMAN_BASELINE, 18));
        Confirm.setBackground(Color.gray);
        Confirm.setForeground(Color.BLUE);
        Cancel = new JButton("Cancel");
        Cancel.setFont(new Font("Times", Font.ROMAN_BASELINE, 18));
        Cancel.setBackground(Color.gray);
        Cancel.setForeground(Color.RED);
        Confirm.addActionListener(new btnsAction());
        Cancel.addActionListener(new btnsAction());
        buttonspanel.add(Confirm);
        buttonspanel.add(Cancel);

        add(buttonspanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class btnsAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == showPrice) {
                ArrayList<String> prices = new ArrayList<String>();
                prices.add("55 (110 for Both)");
                prices.add("45 (90 for Both)");
                prices.add("30 (60 for Both)");
                prices.add("25 (50 for Both)");

                String selectedCar = (String) carTypecombo.getSelectedItem();
                if (selectedCar.equals(carType[0])) {
                    priceTxt.setText(prices.get(0) + " SAR");
                } else if (selectedCar.equals(carType[1])) {
                    priceTxt.setText(prices.get(1) + " SAR");
                } else if (selectedCar.equals(carType[2])) {
                    priceTxt.setText(prices.get(2) + " SAR");
                } else if (selectedCar.equals(carType[3])) {
                    priceTxt.setText(prices.get(3) + " SAR");
                } else if (selectedCar.equals(carType[4])) {
                    priceTxt.setText(prices.get(4) + " SAR");
                }
            } else if (e.getSource() == Confirm) {
                if (nameF.getText().isEmpty()|| (!cash.isSelected() && !installments.isSelected())) {
                    try {
                        throw new Exception();
                    } catch (Exception exp) {
                        JOptionPane.showMessageDialog(null, "Name cannot be null and you have to choose payment method");
                        setVisible(false);
                        new CheckFrame();
                    }
                } else {
                    setVisible(false);

                    createBill();
                    new BillFrame(nameF.getText());
                }
            } else if (e.getSource()
                    == Cancel) {
                System.exit(0);
            }
        }

    }

    void createBill() {
        try {

            FileWriter customerBill = new FileWriter(nameF.getText() + "Bill");
            customerBill.write("This is bill for " + nameF.getText() + ":\n");
            customerBill.write("Car Type : " + (String) carTypecombo.getSelectedItem() + ". \n");
            customerBill.write("Wash service : " + (String) WashType.getSelectedItem() + ". \n");
            customerBill.write("total price : " + priceTxt.getText() + " \n");
            if (cash.isSelected()) {
                customerBill.write("The payment will be Cash for total of " + priceTxt.getText());
            } else if (installments.isSelected()) {
                customerBill.write("The payment will be Credit for total of " + priceTxt.getText());
            }

            customerBill.write("\nThank you for choosing Car Wash app, have a great day!");

            customerBill.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

}
