public class Main {
    public static void main(String[] args) {

//        AdminManagementModule.AdminAddUserForm form = new AdminManagementModule.AdminAddUserForm();
//        form.AdminAddUserFormOperation();

//        AdminManagementModule.AdminDeleteUserForm form2 = new AdminManagementModule.AdminDeleteUserForm();
//        form2.AdminDeleteUserFormOperation();

//        AdminManagementModule.AdminUpdateUserForm form3 = new AdminManagementModule.AdminUpdateUserForm();
//        form3.AdminUpdateUserFormOperation();

//        AdminManagementModule.AdminShowUserForm form4 = new AdminManagementModule.AdminShowUserForm();
//        form4.AdminShowUserFormOperation();

//        AdminManagementModule.AdminSearchUserForm form4 = new AdminManagementModule.AdminSearchUserForm();
//        form4.AdminSearchUserFormOperation();

//        AdminManagementModule.AdminUserManagementPage home = new AdminManagementModule.AdminUserManagementPage();
//        home.AdminUserManagementFormOperation();

        // ======================= appointement  ===================== //

        Appointment appt = new Appointment("Alice", "1234567890", 28, "Stable",
                "Dr. Smith", "2024-06-12 10:30", 300.00);

        appt.viewAppointmentDetails();

        appt.receivePayment(); // Patient pays bill
        appt.receivePayment(); // Trying to pay again (demonstrate prevention)

        System.out.println("Total Appointments: " + Appointment.getAppointmentCount());


    }
}