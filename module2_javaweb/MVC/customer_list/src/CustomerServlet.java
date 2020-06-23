import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "CustomerServlet",urlPatterns = "")
public class CustomerServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        List<Customer> list= DBUtils.getCustomerList();
        request.setAttribute("customers",list);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request,response);
    }
}
