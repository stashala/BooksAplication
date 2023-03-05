package Models;



import Servlets.BookController;
import Source.DataSourceProvider;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private final DataSource dataSource;



    public BookDao() {
        try {
            this.dataSource = DataSourceProvider.getDataSource();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

    }
    public   List<Book> findAll () {
        final String sql =
                "SELECT idbook, title, description, author, releaseyear FROM Book"+ BookController.getOrderBy();
        try {
            return dBResult(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public  List<Book> findByAuthor(String author)   {
        final String sql =
                "SELECT idbook, title, description, author, releaseyear FROM Book where author= " +
                        "'"+ author+"'"+BookController.getOrderBy();
        try {
            return dBResult(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public  List<Book> findByTitle(String title)   {
        final String sql =
                "SELECT idbook, title, description, author, releaseyear FROM Book Where title=" +
                        "'"+ title+"'"+BookController.getOrderBy();
        try {
            return dBResult(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public List<Book> findByDates(int date1,int date2)   {
        final String sql =
                "SELECT idbook, title, description, author, releaseyear from book where releaseyear  between " +
                        date1 +" and "+ date2+BookController.getOrderBy();
        try {
            return dBResult(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    List<Book> dBResult(final String s) throws SQLException {
        List<Book> resultList = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(s);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String title2 = resultSet.getString(2);

                String description = resultSet.getString(3);
                String author2= resultSet.getString(4);
                int releaseyear = resultSet.getInt(5);
                resultList.add(new Book(id, title2, description, author2, releaseyear));
            }
        }
        return resultList;
    }
}


