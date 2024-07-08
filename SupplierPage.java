/**
 * PROGRAM DESCRIPTION : TO CREATE A SUPPLIER PAGE FOR AN INVENTORY MANAGEMENT SYSTEM
 * PROGRAMMER : ZUL ALWAN
 * DATE : 29 JUNE 2024
 *
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SupplierPage implements ActionListener {

    private JTable supplierTable;
    private DefaultTableModel tableModel;
    private JButton btnAddSupplier, btnBack;
    private JTextField supplierNameField;
    private JFrame frame;

    public SupplierPage() {
        frame = new JFrame("Supplier Management");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel(new String[]{"Supplier Name"}, 0);
        supplierTable = new JTable(tableModel);
        loadSuppliersFromFile();

        JPanel panel = new JPanel(new FlowLayout());
        supplierNameField = new JTextField(20);
        btnAddSupplier = new JButton("Add Supplier");
        btnBack = new JButton("Back");

        panel.add(new JLabel("Supplier Name:"));
        panel.add(supplierNameField);
        panel.add(btnAddSupplier);
        panel.add(btnBack);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(supplierTable), BorderLayout.CENTER);

        btnAddSupplier.addActionListener(this);
        btnBack.addActionListener(this);
        frame.setVisible(true);
    }

    private void loadSuppliersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("suppliers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tableModel.addRow(new Object[]{line});
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error loading suppliers: " + e.getMessage());
        }
    }

    private void saveSupplierToFile(String supplierName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("suppliers.txt", true))) {
            writer.write(supplierName + "\n");
            JOptionPane.showMessageDialog(frame, "Supplier added successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving supplier: " + e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddSupplier) {
            String supplierName = supplierNameField.getText().trim();
            if (!supplierName.isEmpty()) {
                tableModel.addRow(new Object[]{supplierName});
                saveSupplierToFile(supplierName);
                supplierNameField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Supplier name cannot be empty!");
            }
        } else if (e.getSource() == btnBack) {
            new CoverPage();
            frame.dispose();
        }
    }

    public static void main(String[] args) {
        new SupplierPage();
    }
}