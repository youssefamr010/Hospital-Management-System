package AdminManagementModule;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class AdminShowUserForm {
    public JFrame AdminShowUserFormOperation () {
        JFrame ReportFrame = new JFrame("Show Users Page");
        ReportFrame.setSize(600 , 550);
        ReportFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultTableModel ReportModel = new DefaultTableModel();
        JTable ReportTable = new JTable(ReportModel);
        ReportTable.setSize(400 , 200);

        ReportFrame.add(ReportTable);
        ReportTable.setVisible(true);

        JScrollPane TableScrollBar = new JScrollPane(ReportTable);

        TableScrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        TableScrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        ReportFrame.add(TableScrollBar);

        ReportModel.addColumn("User ID");
        ReportModel.addColumn("User Name");
        ReportModel.addColumn("User Email");
        ReportModel.addColumn("User Phone Number");

        Connection connection = null;
        Statement created_select_statement = null;
        ResultSet result_set = null;

        try {

            DataBaseConnectionManager connectionManager = new DataBaseConnectionManager();
            connectionManager.setDataBaseFilePath("f:\\ObjectOrianted_Project\\HospitalDB.db");
            connectionManager.setDataBaseUrl(connectionManager.getDataBaseFilePath());
            connection = connectionManager.createDataBaseConnection(connectionManager.getDataBaseUrl());
            created_select_statement = connection.createStatement();
            String sql_select_statement = "select * from users_table;";

            result_set = created_select_statement.executeQuery(sql_select_statement);

            while (result_set.next()) {
                ReportModel.addRow(new Object[] {
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
            try { if (created_select_statement != null) created_select_statement.close(); } catch (SQLException ignored) {}
            try { if (connection != null) connection.close(); } catch (SQLException ignored) {}
        }


        ReportFrame.setVisible(true);

        return ReportFrame;
    }
}
