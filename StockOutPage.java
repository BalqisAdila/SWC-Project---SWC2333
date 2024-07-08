/**
 * PROGRAM DESCRIPTION : TO CREATE A STOCK OUT PAGE FOR AN INVENTORY MANAGEMENT SYSTEM
 * PROGRAMMER : RADHIAH
 * DATE : 29 JUNE 2024
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StockOutPage implements ActionListener {

    private JComboBox<String> quantityBox, productBox, supplierBox;
    private JButton btnSubmit, btnBack;
    private JFrame frame;

    public StockOutPage() {
        List<String> products = loadDataFromFile("inventory_report.txt");
        List<String> suppliers = loadDataFromFile("suppliers.txt");
        String[] quantities = {"1", "2", "3", "4", "5"};

        productBox = new JComboBox<>(products.toArray(new String[0]));
        supplierBox = new JComboBox<>(suppliers.toArray(new String[0]));
        quantityBox = new JComboBox<>(quantities);
        btnSubmit = new JButton("Submit");
        btnBack = new JButton("Back");

        frame = new JFrame("Stock Out Page");
        frame.setSize(500, 300);
        frame.setLayout(new GridLayout(5, 2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new JLabel("Product:"));
        frame.add(productBox);
        frame.add(new JLabel("Supplier:"));
        frame.add(supplierBox);
        frame.add(new JLabel("Quantity:"));
        frame.add(quantityBox);
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
                data.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error loading data from " + filename + ": " + 	e.getMessage());
        }
        return data;
    }

    private void saveStockOutData() {
        String quantity = (String) quantityBox.getSelectedItem();
        String product = (String) productBox.getSelectedItem();
        String supplier = (String) supplierBox.getSelectedItem();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("stock_out_report.txt", true))) {
            writer.write(product + "," + quantity + "," + supplier + "\n");
            JOptionPane.showMessageDialog(frame, "Stock Out data saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving data: " + e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            saveStockOutData();
        } else if (e.getSource() == btnBack) {
            new CoverPage();
            frame.dispose();
        }
    }

    public static void main(String[] args) {
        new StockOutPage();
    }
}