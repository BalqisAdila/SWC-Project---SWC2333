/**
 * PROGRAM DESCRIPTION : TO CREATE A STOCK IN FOR AN INVENTORY MANAGEMENT SYSTEM
 * PROGRAMMER : AMIRUL ZIKRI 
 * DATE : 29 JUNE 2024
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StockInPage implements ActionListener {

    private JTextField quantityField, productField, supplierField, priceField;
    private JButton btnSubmit, btnBack;
    private JFrame frame;

    public StockInPage() {
        List<String> products = loadDataFromFile("inventory_report.txt");
        List<String> suppliers = loadDataFromFile("suppliers.txt");
        String[] quantities = {"1", "2", "3", "4", "5"};

        productField = new JTextField();
        supplierField = new JTextField();
        quantityField = new JTextField();
        priceField = new JTextField();
        btnSubmit = new JButton("Submit");
        btnBack = new JButton("Back");

        frame = new JFrame("Stock In Page");
        frame.setSize(500, 300);
        frame.setLayout(new GridLayout(6, 2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new JLabel("Product:"));
        frame.add(productField);
        frame.add(new JLabel("Supplier:"));
        frame.add(supplierField);
        frame.add(new JLabel("Quantity:"));
        frame.add(quantityField);
        frame.add(new JLabel("Price:"));
        frame.add(priceField);
        frame.add(btnSubmit);
        frame.add(btnBack);

        btnSubmit.addActionListener(this);
        btnBack.addActionListener(this);
        frame.setVisible(true);
    }

    private List<String> loadDataFromFile(String filename) {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line.split(",")[0]);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error loading data from " + filename + ": " + e.getMessage());
        }
        return data;
    }

    private void saveStockInData() {
        String quantity = quantityField.getText();
        String product = productField.getText();
        String supplier = supplierField.getText();
        String price = priceField.getText();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("inventory_report.txt", true))) {
            writer.write(product + "," + quantity + "," + price + "," + supplier + "\n");
            JOptionPane.showMessageDialog(frame, "Stock In data saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving data: " + e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            saveStockInData();
        } else if (e.getSource() == btnBack) {
            new CoverPage();
            frame.dispose();
        }
    }

    public static void main(String[] args) {
        new StockInPage();
    }
}