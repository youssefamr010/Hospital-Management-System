package AdminManagementModule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminAddUserForm {
    public JFrame AdminAddUserFormOperation () {
        JFrame frame = new JFrame("Add User Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // عشان مسافة حوالين الحواف

        // UserName Filed
        JLabel UserNameLabel = new JLabel("Enter UserName:");
        JTextField UserNameFiled = new JTextField(20);
        UserNameFiled.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));

        // Phone Number Filed
        JLabel PhoneNumberLabel = new JLabel("Enter UserPhoneNumber:");
        JTextField PhoneNumberFiled = new JTextField(20);
        PhoneNumberFiled.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));

        // User Email Filed
        JLabel EmailLabel = new JLabel("Enter UserEmail:");
        JTextField EmailFiled = new JTextField(20);
        EmailFiled.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));

        // Submit Button
        JButton SubmitDataButton = new JButton("Submit Data");

        // Add components to panel
        panel.add(UserNameLabel);
        panel.add(UserNameFiled);

        panel.add(UserNameLabel);
        panel.add(UserNameFiled);

        panel.add(PhoneNumberLabel);
        panel.add(PhoneNumberFiled);

        panel.add(EmailLabel);
        panel.add(EmailFiled);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(SubmitDataButton);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Action on button click
        SubmitDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (UserNameFiled.getText().isEmpty() || UserNameFiled.getText().isBlank()) {
                    JOptionPane.showMessageDialog(frame, "Please enter the User Name");
                } else if (PhoneNumberFiled.getText().isEmpty() || PhoneNumberFiled.getText().isBlank()) {
                    JOptionPane.showMessageDialog(frame, "Please enter the Phone Number");
                } else if (EmailFiled.getText().isEmpty() || EmailFiled.getText().isBlank()) {
                    JOptionPane.showMessageDialog(frame, "Please enter the User Email");
                }

                else {

                    DataBaseConnectionManager connectionManager = new DataBaseConnectionManager();
                    connectionManager.setDataBaseFilePath("f:\\ObjectOrianted_Project\\HospitalDB.db");
                    connectionManager.setDataBaseUrl(connectionManager.getDataBaseFilePath());
                    String sql_insert_statement = "insert into users_table (username , userphonenumber , user_email)" +
                            "values (? , ? , ?);";

                    Connection connection = null;
                    PreparedStatement prepared_insert_statement = null;

                    try {
                        connection = connectionManager.createDataBaseConnection(connectionManager.getDataBaseUrl());
                        prepared_insert_statement = connection.prepareStatement(sql_insert_statement);
                        prepared_insert_statement.setString(1 , UserNameFiled.getText());
                        prepared_insert_statement.setString(2 , PhoneNumberFiled.getText());
                        prepared_insert_statement.setString(3 , EmailFiled.getText());

                        prepared_insert_statement.executeUpdate();
                        System.out.println("data is inserted");

                    } catch (SQLException ex) {
                        System.out.println("data base error : ");
                        System.out.println(ex.getMessage());
                    } finally {
                        try {if (connection != null) {connection.close();}} catch (SQLException ex){}
                        try {if (prepared_insert_statement != null) {prepared_insert_statement.close();}} catch (SQLException ex){}
                    }


                }
            }
        });

        return frame;
    }
}
