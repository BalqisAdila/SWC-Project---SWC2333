/**
 * PROGRAM DESCRIPTION : TO CREATE A COVER PAGE FOR AN INVENTORY MANAGEMENT SYSTEM
 * PROGRAMMER : NUR IZZATI
 * DATE : 29 JUNE 2024
 *
 */

import javax.swing.*;
import java.awt.event.*;

public class CoverPage implements ActionListener 

{
    private JFrame frame;
    private JButton btnStockIn, btnStockOut, btnSupplier, btnReport;

    public CoverPage() {
        frame = new JFrame("Welcome To MiniMart Outlet");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        btnStockIn = new JButton("Stock In");
        btnStockIn.setBounds(140, 50, 120, 30);
        btnStockIn.addActionListener(this);
        frame.add(btnStockIn);

        btnStockOut = new JButton("Stock Out");
        btnStockOut.setBounds(140, 90, 120, 30);
        btnStockOut.addActionListener(this);
        frame.add(btnStockOut);

        btnSupplier = new JButton("Supplier Management");
        btnSupplier.setBounds(110, 130, 180, 30);
        btnSupplier.addActionListener(this);
        frame.add(btnSupplier);

        btnReport = new JButton("Report");
        btnReport.setBounds(140, 170, 120, 30);
        btnReport.addActionListener(this);
        frame.add(btnReport);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        if (e.getSource() == btnStockIn) {
            new StockInPage();
        } else if (e.getSource() == btnStockOut) {
            new StockOutPage();
        } else if (e.getSource() == btnSupplier) {
            new SupplierPage();
        } else if (e.getSource() == btnReport) {
            new ReportPage();
        }
    }

    public static void main(String[] args) {
        new CoverPage();
    }
}