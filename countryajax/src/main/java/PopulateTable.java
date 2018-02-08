import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/PopulateTable")
public class PopulateTable extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FetchData fd;

    public PopulateTable() {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    
}
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             
        ArrayList<Countries> country = new ArrayList<Countries>();
        country = FetchData.getAllCountries();
        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(country, new TypeToken<List<Countries>>() {
        }.getType());

        JsonArray jsonArray = element.getAsJsonArray();
        response.setContentType("application/json");
        response.getWriter().print(jsonArray);
        String action = request.getServletPath();
       
    //     try {
    //         switch (action) {
            
    //         case "/delete":
    //             delete(request, response);
    //             break;
            
    //         case "/update":
    //             update(request, response);
    //             break;
    //         // default:
    //             // listBook(request, response);
    //             //break;
    //         // }
    //     }
    // }
    //     catch (SQLException ex) {
    //         throw new ServletException(ex);
    //     }
    }

        private void delete(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException {
    int id = Integer.parseInt(request.getParameter("code"));

    //Book book = new Book(code);
    //bookDAO.deleteBook(book);
    //response.sendRedirect("list");
   // if(id!=null){
         String code=Integer.toString(id);
        fd.deleteUser(code);
       // String listData="{\"Result\":\"OK\"}";
        //response.getWriter().print(listData);
        response.sendRedirect("list");
}
}


