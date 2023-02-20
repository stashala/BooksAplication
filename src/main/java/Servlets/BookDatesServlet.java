package Servlets;


import Models.Book;
import Models.BookDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;


@WebServlet("/dates")
public class BookDatesServlet extends HttpServlet {
    private final BookDao recipeDao = new BookDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/dates.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int value= Integer.parseInt(request.getParameter("date1"));
        int value2= Integer.parseInt(request.getParameter("date2"));


        List<Book> allBookss = recipeDao.findByDates(value,value2);

        if(allBookss.isEmpty()){

            response.sendRedirect("http://localhost:8080/BooksAplication/null");

        }else {

            request.setAttribute("book", allBookss);

            request.getRequestDispatcher("/WEB-INF/all.jsp").forward(request, response);

        }

    }
}
