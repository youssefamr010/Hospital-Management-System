package AdminManagementModule;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminSearchUserForm {
    public JFrame AdminSearchUserFormOperation () {
        JFrame frame = new JFrame("Search User Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 550);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));

        // Username
        JLabel UserSearchLabel = new JLabel("User Name To Search:");
        JTextField UserSearchFiled = new JTextField(20);

        JButton UserSearchButton = new JButton("Search");

        UserSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel SearchTableModel = new DefaultTableModel();

                JTable SearchTable = new JTable(SearchTableModel);

                SearchTable.setSize(400 , 200);

                frame.add(SearchTable);

                JScrollPane TableScrollBar = new JScrollPane(SearchTable);

                TableScrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                TableScrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

                frame.add(TableScrollBar);

                SearchTableModel.addColumn("User ID");
                SearchTableModel.addColumn("User Name");
                SearchTableModel.addColumn("User Email");
                SearchTableModel.addColumn("User Phone Number");

                Connection connection = null;
                PreparedStatement prepared_select_statement = null;
                ResultSet result_set = null;

                try {
                    DataBaseConnectionManager connectionManager = new DataBaseConnectionManager();
                    connectionManager.setDataBaseFilePath("f:\\ObjectOrianted_Project\\HospitalDB.db");
                    connectionManager.setDataBaseUrl(connectionManager.getDataBaseFilePath());
                    String sql_select_statement = "select * from users_table where lower(username) = ?";

                    connection = connectionManager.createDataBaseConnection(connectionManager.getDataBaseUrl());

                    prepared_select_statement = connection.prepareStatement(sql_select_statement);

                    prepared_select_statement.setString(1 , UserSearchFiled.getText().toLowerCase());

                   result_set = prepared_select_statement.executeQuery();

                    while (result_set.next()) {
                        SearchTableModel.addRow(new Object [] {
                                result_set.getString("userid") ,
                                result_set.getString("username") ,
                                result_set.getString("user_email") ,
                                result_set.getString("userphonenumber")
                        });
                    }

                    System.out.println("data is selected");
                } catch (SQLException ex){
                    System.out.println("data base error : ");
                    System.out.println(ex.getMessage());
                } finally {

                    try { if (result_set != null) result_set.close(); } catch (SQLException ignored) {}
                    try { if (prepared_select_statement != null) prepared_select_statement.close(); } catch (SQLException ignored) {}
                    try { if (connection != null) connection.close(); } catch (SQLException ignored) {}
                }

                TableScrollBar.setVisible(true);
                SearchTable.setVisible(true);
                frame.setVisible(true);
            }
        });

        frame.add(UserSearchLabel);
        frame.add(UserSearchFiled);
        frame.add(UserSearchButton);

        frame.setVisible(true);

        return frame;
    }
}
