package AdminManagementModule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminUpdateUserForm {
    public JFrame AdminUpdateUserFormOperation () {
        JFrame frame = new JFrame("Update User Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // عشان مسافة حوالين الحواف

        // UserName Filed
        JLabel UserNameUpdateLabel = new JLabel("Enter UserName To Update:");
        JTextField UserNameUpdateFiled = new JTextField(20);
        UserNameUpdateFiled.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));

        // UserName Filed
        JLabel UserNameLabel = new JLabel("Enter New UserName:");
        JTextField UserNameFiled = new JTextField(20);
        UserNameFiled.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));

        // Phone Number Filed
        JLabel PhoneNumberLabel = new JLabel("Enter New UserPhoneNumber:");
        JTextField PhoneNumberFiled = new JTextField(20);
        PhoneNumberFiled.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));

        // User Email Filed
        JLabel EmailLabel = new JLabel("Enter New UserEmail:");
        JTextField EmailFiled = new JTextField(20);
        EmailFiled.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));

        // Submit Button
        JButton SubmitDataButton = new JButton("Submit Data");

        panel.add(UserNameUpdateLabel);
        panel.add(UserNameUpdateFiled);

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
                    String sql_update_statement = "update users_table set username = ? , userphonenumber = ? , user_email = ? where lower(username) = ?";

                    Connection connection = null;
                    PreparedStatement prepared_update_statement = null;

                    try {
                        connection = connectionManager.createDataBaseConnection(connectionManager.getDataBaseUrl());
                        prepared_update_statement = connection.prepareStatement(sql_update_statement);


                        prepared_update_statement.setString(1 , UserNameFiled.getText());
                        prepared_update_statement.setString(2 , PhoneNumberFiled.getText());
                        prepared_update_statement.setString(3 , EmailFiled.getText());
                        prepared_update_statement.setString(4 , UserNameUpdateFiled.getText());

                        prepared_update_statement.executeUpdate();
                        System.out.println("data is updated");

                    } catch (SQLException ex) {
                        System.out.println("data base error : ");
                        System.out.println(ex.getMessage());
                    } finally {
                        try {if (connection != null) {connection.close();}} catch (SQLException ex){}
                        try {if (prepared_update_statement != null) {prepared_update_statement.close();}} catch (SQLException ex){}
                    }

                }
            }
        });

        return frame;
    }
}
