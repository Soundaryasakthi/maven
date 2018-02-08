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
public class UpdateServlet extends HttpServlet {


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

        
        try{
          Connection connection=null;
            connection = fd.getConnection();
                             PreparedStatement statement;        
                             String query ="UPDATE country SET code=?,name=?,continent=?,region=?,population=?,capital=? where code="+myid;
                             statement = connection.prepareStatement(query);
                             statement.setString(1, code);
                             statement.setString(2, Name);
                             statement.setString(3, Continent);
                             statement.setString(4, Region);
                             statement.setString(5, Population);
                             statement.setString(6, Capital);
                             int i=statement.executeUpdate();
                             out.println(i);
                          if(i>0)
                          {
                            out.println("You are sucessfully updated");
                            
                          }
                          

        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
    }

}