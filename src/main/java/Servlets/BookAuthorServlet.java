package Servlets;

import Models.Book;
import Models.BookDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/author")
public class BookAuthorServlet extends HttpServlet {
    private final BookDao recipeDao = new BookDao();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/author.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String value = request.getParameter("description");
        List<Book> allBookss = recipeDao.findByAuthor(value);
        if (allBookss.isEmpty()) {
            response.sendRedirect("http://localhost:8080/BooksAplication/null");
        } else {
            request.setAttribute("book", allBookss);
            request.getRequestDispatcher("/WEB-INF/all.jsp").forward(request, response);
        }
    }
}
