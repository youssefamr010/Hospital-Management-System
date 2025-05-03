package AdminManagementModule;

import javax.swing.*;
import java.awt.*;

public class AdminUserManagementPage {
    static JFrame currentFrame = null;

    public JFrame AdminUserManagementFormOperation () {
        JFrame HomePageFrame = new JFrame("User Management Admin Panel");
        HomePageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HomePageFrame.setSize(400, 350);
        HomePageFrame.setLocationRelativeTo(null);
        HomePageFrame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.gridx = 0;

        JButton AddUserButton = new JButton("Add User");
        AddUserButton.setPreferredSize(new Dimension(200, 30));
        gbc.gridy = 0;
        HomePageFrame.add(AddUserButton, gbc);

        AddUserButton.addActionListener(e -> {
            if (currentFrame != null) currentFrame.dispose();
            AdminAddUserForm addForm = new AdminAddUserForm();
            currentFrame = addForm.AdminAddUserFormOperation();
        });

        JButton RemoveUserButton = new JButton("Remove User");
        RemoveUserButton.setPreferredSize(new Dimension(200, 30));
        gbc.gridy = 1;
        HomePageFrame.add(RemoveUserButton, gbc);

        RemoveUserButton.addActionListener(e -> {
            if (currentFrame != null) currentFrame.dispose();
            AdminDeleteUserForm deleteForm = new AdminDeleteUserForm();
            currentFrame = deleteForm.AdminDeleteUserFormOperation();
        });
//
        JButton UpdateUserButton = new JButton("Update User");
        UpdateUserButton.setPreferredSize(new Dimension(200, 30));
        gbc.gridy = 2;
        HomePageFrame.add(UpdateUserButton, gbc);

        UpdateUserButton.addActionListener(e -> {
            if (currentFrame != null) currentFrame.dispose();
            AdminUpdateUserForm updateForm = new AdminUpdateUserForm();
            currentFrame = updateForm.AdminUpdateUserFormOperation();
        });
//
        JButton ShowUserButton = new JButton("Show Users");
        ShowUserButton.setPreferredSize(new Dimension(200, 30));
        gbc.gridy = 3;
        HomePageFrame.add(ShowUserButton, gbc);

        ShowUserButton.addActionListener(e -> {
            if (currentFrame != null) currentFrame.dispose();
            AdminShowUserForm showForm = new AdminShowUserForm();
            currentFrame = showForm.AdminShowUserFormOperation();
        });
//
        JButton SearchUserButton = new JButton("Search For User");
        SearchUserButton.setPreferredSize(new Dimension(200, 30));
        gbc.gridy = 4;
        HomePageFrame.add(SearchUserButton, gbc);

        SearchUserButton.addActionListener(e -> {
            if (currentFrame != null) currentFrame.dispose();
            AdminSearchUserForm searchForm = new AdminSearchUserForm();
            currentFrame = searchForm.AdminSearchUserFormOperation();
        });


        HomePageFrame.setVisible(true);

        return HomePageFrame;

    }
}
