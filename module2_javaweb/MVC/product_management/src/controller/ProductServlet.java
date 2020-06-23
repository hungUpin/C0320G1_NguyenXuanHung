package controller;

import module.Product;
import service.ProductService;
import service.Impl.ProductServiceImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "ProductServlet",urlPatterns = "/products")
public class ProductServlet extends javax.servlet.http.HttpServlet {
    private ProductService productServlet = new ProductServiceImpl();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action= "";
        }
        switch (action){
            case "create":
                createProduct(request,response);
                break;
            case "update":
                updateProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productServlet.findById(id);
        RequestDispatcher requestDispatcher;
        if(product==null){
            requestDispatcher = request.getRequestDispatcher("views/error-404.jsp");
        }else {
            productServlet.delete(id);
            request.setAttribute("message","The product has been deleted");
            showListProduct(request,response);
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        Product product = new Product(id,name,price,description);
        productServlet.save(product);
        request.setAttribute("message","Product has been updated!!!");
        showListProduct(request,response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        int id = (int) (Math.random()*10000);
        Product product = new Product(id,name,price,description);
        productServlet.save(product);
        request.setAttribute("message","New customer has been created!!!");
        showListProduct(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action= " ";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "update":
                showUpdateForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "view":
                showViewForm(request,response);
                break;
            case "findByName":
                findByName(request,response);
                break;
            default:
                showListProduct(request,response);
                break;
        }
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nameSearch");
        List<Product> product = productServlet.findByName(name);
        RequestDispatcher requestDispatcher;
        if(name==null){
            requestDispatcher = request.getRequestDispatcher("views/error-404");
        }else {
            request.setAttribute("product",product);
            requestDispatcher= request.getRequestDispatcher("views/view.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productServlet.findById(id);
        RequestDispatcher requestDispatcher;
        if(product==null){
            requestDispatcher = request.getRequestDispatcher("views/error-404.jsp");
        }else {
            request.setAttribute("product",product);
            requestDispatcher = request.getRequestDispatcher("views/view.jsp");
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productServlet.findById(id);
        RequestDispatcher requestDispatcher;
        if(product==null){
            requestDispatcher = request.getRequestDispatcher("views/error-404.jsp");
        }else {
            request.setAttribute("product",product);
            requestDispatcher = request.getRequestDispatcher("views/delete.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productServlet.findById(id);
        RequestDispatcher requestDispatcher;
        if(product==null){
            requestDispatcher = request.getRequestDispatcher("views/error-404.jsp");
        }else {
            request.setAttribute("product",product);
            requestDispatcher = request.getRequestDispatcher("views/update.jsp");
            try {
                requestDispatcher.forward(request,response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        String nameSearch=request.getParameter("nameSearch");
         RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/list.jsp");
        if(nameSearch==null) {
            List<Product> productList = productServlet.findAll();
            request.setAttribute("productList",productList);
        } else {
            String name = request.getParameter("nameSearch");
            List<Product> products = productServlet.findByName(name);
            request.setAttribute("productList",products);
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
