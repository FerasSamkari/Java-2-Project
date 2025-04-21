package carwashproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    private JMenuBar menuB;
    private JMenu File;
    private JMenuItem Help;
    private JMenuItem exit;
    private JLabel ImageLabel;
    private ImageIcon image;
    private JButton Services;
    private JLabel Welcome;
    public MainFrame() {
        setTitle("Car Wash");
        setSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creating mainmenu
        menuB = new JMenuBar();
        File = new JMenu("File");
        Help = new JMenuItem("Help");
        Help.addActionListener(new MenuAction());
        exit = new JMenuItem("Exit");
        exit.addActionListener(new MenuAction());
        File.add(exit);
        menuB.add(File);
        menuB.add(Help);
        setJMenuBar(menuB);
        
        //adding Labels
        Welcome = new JLabel("Make Your car clean and Bright With Car Wash!");
        Welcome.setFont(new Font("Times", Font.HANGING_BASELINE, 22));
        Welcome.setForeground(Color.BLUE);
        JPanel panel1 = new JPanel();
        panel1.add(Welcome);
        add(panel1, BorderLayout.NORTH);
        
        //adding image
        image = new ImageIcon(new ImageIcon("1122.jpeg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        ImageLabel = new JLabel();
        ImageLabel.setIcon(image);
        JPanel panel2 = new JPanel();
        panel2.add(ImageLabel);
        add(panel2, BorderLayout.CENTER);
       
        //adding Buttons
        Services = new JButton("Take a look at our services!");
        Services.addActionListener(new BtnAction());
        Services.setBackground(Color.DARK_GRAY);
        Services.setPreferredSize(new Dimension(200, 50));
        Services.setForeground(Color.black);
        JPanel panel3 = new JPanel();
        panel3.add(Services);
        add(panel3, BorderLayout.SOUTH);
        super.setLocationRelativeTo(null);
        setVisible(true);
    }
    private class MenuAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == exit) {
                System.exit(0);
            } else if (e.getSource() == Help) {
                JOptionPane.showMessageDialog(null, "For Help Please Contact Car Wash E-mail :- (CarWashSupport@hotmail.com) ");
            }
        }
    }
    private class BtnAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == Services) {
                setVisible(false);
                new CheckFrame();
            }
        }
    }
}
 

