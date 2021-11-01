import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        DatabaseHelper databaseHelper = new DatabaseHelper();

        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = databaseHelper.getConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select Code,Name,Continent,Region from country");

            ArrayList<Country> countries = new ArrayList<Country>();

            while (resultSet.next()){
                countries.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region")));
            }

           

        }
        catch (SQLException e){
            databaseHelper.showErrorMessage(e);
        }
        finally {
            connection.close();
        }
    }
}
