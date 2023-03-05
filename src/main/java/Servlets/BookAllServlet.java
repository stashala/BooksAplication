package Servlets;

import Models.Book;
import Models.BookDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/all")
public class BookAllServlet extends HttpServlet {
    private final BookDao recipeDao = new BookDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> allBookss = recipeDao.findAll();
        request.setAttribute("book", allBookss);
        request.getRequestDispatcher("/WEB-INF/all.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
