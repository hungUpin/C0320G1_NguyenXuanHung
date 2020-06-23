import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet",urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double firstNumber = Double.parseDouble(request.getParameter("operand"));
        Double secondNumber = Double.parseDouble(request.getParameter("secondOperand"));
        String operator = request.getParameter("cal");
        Calculator calculator = new Calculator(firstNumber,secondNumber,operator);
        Double result = calculator.calculate();
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result</h1>");
        writer.println("First number: "+firstNumber+ "<br>"+"Second number: "+secondNumber +"<br>Operator: "+operator+"<br>Result is: " +result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
