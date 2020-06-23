import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@javax.servlet.annotation.WebServlet(name = "ProductServlet",urlPatterns = "/displayDiscount")
public class ProductServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String productDetail = request.getParameter("productDescription");
        float price = Float.parseFloat(request.getParameter("listPrice"));
        float discount = Float.parseFloat(request.getParameter("discountPrice"));
        float discountAmount = price*discount*0.01f;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>"+productDetail+"</h1>");
        writer.println("<h2>Discount amount: "+discountAmount+"</h2>");
        writer.println("</html>");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
