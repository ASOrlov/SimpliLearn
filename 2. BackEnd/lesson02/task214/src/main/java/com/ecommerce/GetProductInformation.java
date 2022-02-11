package com.ecommerce;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@WebServlet(name = "GetProductInformation", value = "/GetProductInformation")
public class GetProductInformation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            HttpSession session=request.getSession();
            Long productId = Long.parseLong(request.getParameter("productid"));

            PrintWriter out = response.getWriter();
            InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
            Properties props = new Properties();
            props.load(in);

            DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
            out.println("<html><body>");



            if (productId>0) {

                CallableStatement stmtCallable = conn.getConnection().prepareCall("{call select_product_by_id(?)}");
                stmtCallable.setLong(1, productId);
                ResultSet rst=stmtCallable.executeQuery();



                if (rst.next()) {
                    out.println("Product information about product with id="+rst.getInt("ID")
                            + ": name=" + rst.getString("name")
                            + ", price=" + rst.getBigDecimal("price") + "<Br>");
                }

                else {
                    out.println("Product with ID="+productId+" not found in the database <Br>");
                }

                stmtCallable.close();
            }
            else {
                out.println("Invalid Id entered. Id must be larger then 0 <Br>");
            }


            out.println("</body></html>");
            conn.closeConnection();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
