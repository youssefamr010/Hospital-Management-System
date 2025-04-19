import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectionManager {

    // put your database file path here

    private String dataBaseFilePath = "";
    private String dataBaseUrl = "";
    private Connection dataBaseConnection = null;

    public void setDataBaseFilePath (String dataBaseFilePath) {
        this.dataBaseFilePath = dataBaseFilePath;
    }

    public void setDataBaseUrl (String dataBaseFilePath){
        this.dataBaseUrl = "jdbc:sqlite:" + dataBaseFilePath;
    }

    public Connection createDataBaseConnection (String dataBaseUrl) {
        try {

        this.dataBaseConnection = DriverManager.getConnection(dataBaseUrl);

        } catch (SQLException e){
            System.out.println("data base error : ");
            System.out.println(e.getMessage());
        }

        return this.dataBaseConnection;
    }

    public String getDataBaseFilePath () {
        return this.dataBaseFilePath;
    }

    public String getDataBaseUrl () {
        return this.dataBaseUrl;
    }

}
