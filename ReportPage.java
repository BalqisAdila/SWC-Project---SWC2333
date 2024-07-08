/**
 * PROGRAM DESCRIPTION : TO CREATE REPORT PAGE FOR AN INVENTORY MANAGEMENT SYSTEMSYSTEM
 * PROGRAMMER : NURUL BALQIS ADILA
 * DATE : 29 JUNE 2024
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReportPage implements ActionListener {

    private JTextArea reportArea;
    private JButton btnBack;
    private JFrame frame;

    public ReportPage() {
        reportArea = new JTextArea();
        reportArea.setEditable(false);
        btnBack = new JButton("Back");

        frame = new JFrame("Report Page");
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new JScrollPane(reportArea), BorderLayout.CENTER);
        frame.add(btnBack, BorderLayout.SOUTH);

        btnBack.addActionListener(this);
        frame.setVisible(true);

        loadReports();
    }

    private void loadReports() {
        StringBuilder reportContent = new StringBuilder();

        reportContent.append("Inventory Report:\n");
        reportContent.append(loadDataFromFile("inventory_report.txt")).append("\n");

        reportContent.append("Stock Out Report:\n");
        reportContent.append(loadDataFromFile("stock_out_report.txt")).append("\n");

        reportContent.append("Suppliers:\n");
        reportContent.append(loadDataFromFile("suppliers.txt")).append("\n");

        reportArea.setText(reportContent.toString());
    }

    private String loadDataFromFile(String filename) {
        StringBuilder data = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error loading data from " + filename + ": " + e.getMessage());
        }
        return data.toString();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            new CoverPage();
            frame.dispose();
        }
    }

    public static void main(String[] args) {
        new ReportPage();
    }
}