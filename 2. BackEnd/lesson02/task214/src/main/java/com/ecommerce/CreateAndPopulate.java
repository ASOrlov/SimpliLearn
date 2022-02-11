package com.ecommerce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@WebServlet(name = "CreateAndPopulate", value = "/CreateAndPopulate")
public class CreateAndPopulate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");

            InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
            Properties props = new Properties();
            props.load(in);

            DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
//            Statement stmt = conn.getConnection().createStatement();
//            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS eproduct (ID bigint primary key auto_increment, name varchar(100), price decimal(10,2), date_added timestamp default now()) ");
//            out.println("Table eproduct created successfully ");
//            stmt.executeUpdate("INSERT INTO eproduct (name, price) VALUES (\"Laptop\", 12000)");
//            stmt.executeUpdate("INSERT INTO eproduct (name, price) VALUES (\"Car\", 25000)");
//            stmt.executeUpdate("INSERT INTO eproduct (name, price) VALUES (\"House\", 35000)");
//            stmt.executeUpdate("INSERT INTO eproduct (name, price) VALUES (\"Mouse\", 15)");
//            stmt.executeUpdate("INSERT INTO eproduct (name, price) VALUES (\"Suit\", 1500)");
//            out.println("Table eproduct populated successfully");

            CallableStatement stmtCallable = conn.getConnection().prepareCall("{call select_product_by_id(?)}");
            stmtCallable.setLong(1, 1);
            ResultSet rst=stmtCallable.executeQuery();

            while (rst.next()) {
                out.println(rst.getInt("ID")
                        + ", "  + rst.getString("name")
                        + ", " + rst.getBigDecimal("price")+"<Br>");
            }


            conn.closeConnection();


            out.println("</body></html>");
            conn.closeConnection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
