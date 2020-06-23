package controller;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import model.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "CustomersServlet",urlPatterns = "/customers")
public class CustomersServlet extends javax.servlet.http.HttpServlet {
    private static CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request,response);
                break;
            case "edit":
                editCustomer(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            default:
                break;
        }
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(response, request);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "view":
                viewCustomer(request,response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
        try{
            requestDispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    protected void showCreateForm(HttpServletRequest request,HttpServletResponse response){
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/create.jsp");
        try{
            requestDispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    protected void createCustomer(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address= request.getParameter("address");
        int id = (int) Math.random()*10000;
        Customer customer = new Customer(id,name,email,address);
        customerService.addCustomer(customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/create.jsp");
        request.setAttribute("message","New customer was created!!!");
        try{
            requestDispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void showEditForm(HttpServletResponse response,HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher requestDispatcher;
        if(customer==null){
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("customer",customer);
            requestDispatcher=request.getRequestDispatcher("customer/edit.jsp");
        }
        try{
            requestDispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = customerService.findById(id);
        RequestDispatcher requestDispatcher;
        if(customer==null){
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);
            customerService.updateCustomer(id,customer);
            request.setAttribute("customer",customer);
            request.setAttribute("message", "Customer has been updated!!!");
            requestDispatcher = request.getRequestDispatcher("customer/edit.jsp");
        }
        try{
            requestDispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void showDeleteForm(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher requestDispatcher;
        if(customer==null){
            requestDispatcher=request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("customer",customer);
            requestDispatcher = request.getRequestDispatcher("customer/delete.jsp");
        }
        try {
            requestDispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private void deleteCustomer(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher requestDispatcher = null;
        if(customer==null){
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {

            customerService.removeCustomer(id);
            List<Customer> customerList = customerService.findAll();
            request.setAttribute("deleteMessage","Delete Completed!!!!");
            request.setAttribute("customerList",customerList);
            requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
            request.setAttribute("action","");
            //response.sendRedirect("/customers");
        }
        try {
            requestDispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    private void viewCustomer(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher requestDispatcher;
        if(customer==null){
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("customer",customer);
            requestDispatcher = request.getRequestDispatcher("customer/view.jsp");
            try{
                requestDispatcher.forward(request,response);
            }catch (ServletException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
