/**
 * PROGRAM DESCRIPTION : TO CREATE A FIRST PAGE FOR AN INVENTORY MANAGEMENT SYSTEM
 * PROGRAMMER : AMIRUL ZIKRI 
 * DATE : 29 JUNE 2024
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstPage extends JFrame implements ActionListener 
{
    private JButton coverPageButton;
    private JLabel logoLabel;

    public FirstPage()
    {
        // Set the title of the JFrame
        setTitle("WELCOME TO MINIMART OUTLET");
        setSize(500, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create icon logo
        ImageIcon logo = new ImageIcon("C:/Users/anas7/Documents/Java sem 2/SWC2333-zul");
        logoLabel = new JLabel(logo);

        // Create a Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(panel);

        // Add logo to the panel at the top
        panel.add(logoLabel, BorderLayout.NORTH);

        // Create Label
        JLabel label = new JLabel("WELCOME TO MINI MART INVENTORY SYSTEM", JLabel.CENTER);
        label.setFont(new Font("ALGERIAN", Font.BOLD, 18));
        panel.add(label, BorderLayout.CENTER);

        // Create a button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 0, 10)); // GridLayout with 3 rows, 1 column, and spacing

        // Create Buttons
        coverPageButton = new JButton("Enter");

       
 // Register to a listener
        coverPageButton.addActionListener(this);

        // Add buttons to button panel
        buttonPanel.add(coverPageButton);

        // Add button panel to main panel
        panel.add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    } // end of constructor

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == coverPageButton) {
            new CoverPage();
        }
        dispose();
    } // end of method

    public static void main(String[] args)
    {
        new FirstPage();
    } // end of main
} // end of class
