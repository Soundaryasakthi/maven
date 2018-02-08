import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class Adduser{
    public void addUser(Countries countries) {
    try {
        Connection connection=null;
        connection = FetchData.getConnection();
        PreparedStatement preparedStatement = connection
                .prepareStatement("insert into country(code,name,continent,region,population,capital) values (?, ?, ?, ?,?,? )");
        // Parameters start with 1
        preparedStatement.setString(1, countries.getCode());
        preparedStatement.setString(2, countries.getName());
        preparedStatement.setString(3,countries.getContinent());
        preparedStatement.setString(4, countries.getRegion());
        preparedStatement.setInt(5, countries.getPopulation());
        preparedStatement.setString(4, countries.getCapital());
        int j=preparedStatement.executeUpdate();
        if(j>0)
        {
            System.out.println("successfully inserted");
        }


    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
