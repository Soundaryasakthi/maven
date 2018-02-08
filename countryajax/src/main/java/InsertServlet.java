import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class InsertServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;
	private String code;
    private String Name;
    private String	Continent;
    private String	Region;
    private String	Population;
    private String	Capital;
    private FetchData fd;
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String myid= request.getParameter("code");
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