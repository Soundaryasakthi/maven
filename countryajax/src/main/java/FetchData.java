import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Properties;

public  class FetchData {

    private static Connection connection = null;

    public static com.mysql.jdbc.Connection getConnection() {
        if (connection != null)
            return (com.mysql.jdbc.Connection) connection;
        else {
            try {
                Properties prop = new Properties();
                // InputStream inputStream = FetchData.class.getClassLoader().getResourceAsStream("/db.properties");
                ClassLoader c1 = Thread.currentThread().getContextClassLoader();
                InputStream inputStream = c1.getResourceAsStream("db.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return (com.mysql.jdbc.Connection) connection;
        }

    }

    // public void addUser(Countries countries) {
    // try {
    // PreparedStatement preparedStatement = connection
    //      .prepareStatement("insert into tblUser(code,name,continent,region,population,capital) values (?,?, ?, ?,?,? )");
    //    // Parameters start with 1
    //  preparedStatement.setInt(1, countries.getCode());
    //  preparedStatement.setString(2, countries.getName());
    //  preparedStatement.setString(3, countries.getContinent()); 
    //  preparedStatement.setString(4, countries.getRegion());
    //  preparedStatement.setString(4, countries.getPopulation());
    //  preparedStatement.setString(4, countries.getCapital());
    //  preparedStatement.executeUpdate();
    //  
    // } catch (SQLException e) {
    //  e.printStackTrace();
    // }
    //  }

    public void deleteUser(String code) {
        try {
            connection = FetchData.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from country where code=?");
            preparedStatement.setString(1, code);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(Countries countries) throws ParseException {
        try {
            connection = FetchData.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update country set code=?,name=?,continent=?,region=?,population=?,capital=?" + "where code=?");
            preparedStatement.setString(1, countries.getCode());
            preparedStatement.setString(2, countries.getName());
            preparedStatement.setString(3, countries.getContinent());
            preparedStatement.setString(4, countries.getRegion());
            preparedStatement.setInt(5, countries.getPopulation());
            preparedStatement.setString(6, countries.getCapital());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Countries> getAllCountries() {
        connection = FetchData.getConnection();
        ArrayList<Countries> countryList = new ArrayList<Countries>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from country limit 10");

            while (rs.next()) {
                Countries country = new Countries();
                country.setCode(rs.getString("Code"));
                country.setName(rs.getString("Name"));
                country.setContinent(rs.getString("Continent"));
                country.setRegion(rs.getString("Region"));
                country.setPopulation(rs.getInt("Population"));
                country.setCapital(rs.getString("Capital"));
                countryList.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countryList;
    }

}
