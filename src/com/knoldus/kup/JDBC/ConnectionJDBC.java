package com.knoldus.kup.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
public class ConnectionJDBC {
    public static void main(String... args)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ConnectionJDBC con = (ConnectionJDBC) DriverManager.getConnection("jdbc:mysql://localhost:3306/Shopping","root","P@ssW0rd");
            Statement st = ((Connection) con).createStatement();
            ResultSet rs = st.executeQuery("select sum(qty*price) from Cart,Products where Cart.pid = Products.pid");
            System.out.println("Output is " +rs); //Output is 106
            System.out.println("database Shopping and tables Products, Cart are created successfully");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
