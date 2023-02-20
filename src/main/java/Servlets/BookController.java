package Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("")
public class BookController extends HttpServlet {

    private static String orderBy=" ";

    public static String getOrderBy() {
        return orderBy;
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//        response.sendRedirect(request.getContextPath() + "/all");
        request.getRequestDispatcher("/WEB-INF/controller.jsp").forward(request,response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String value=request.getParameter("type");

        orderBy=request.getParameter("sort");



        response.sendRedirect(request.getContextPath() +"/"+ value);

    }
}
