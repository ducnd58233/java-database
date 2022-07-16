package vn.plusplus.database;

import vn.plusplus.database.buoi3.Laptop;
import vn.plusplus.database.buoi3.LaptopSearchService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class DatabaseConnection {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/forum_zclouds", "root", "1234"
                    "jdbc:mysql://localhost:3306/store_cms_plusplus", "root", "icub4ucme"
                    // here forum_zclouds is database name, root is username and 1234 is password
            );
            LaptopSearchService searchLaptop = new LaptopSearchService(con);
            /*---------- Activity 3.2 ----------*/
            Scanner sc = new Scanner(System.in);
            String maker;
            String type;
            String fromPriceStr;
            String toPriceStr;
            String fromSoldStr;
            String toSoldStr;
            String screenResolution;

            System.out.println("Search by maker: ");
            maker = sc.nextLine();
            System.out.println("Search by type: ");
            type = sc.nextLine();
            System.out.println("Search from price: ");
            fromPriceStr = sc.nextLine();
            System.out.println("Search to price: ");
            toPriceStr = sc.nextLine();
            System.out.println("Search from sold: ");
            fromSoldStr = sc.nextLine();
            System.out.println("Search to sold: ");
            toSoldStr = sc.nextLine();
            System.out.println("Search by screen resolution: ");
            screenResolution = sc.nextLine();

            maker = maker.equals("") ? null : maker;
            type = type.equals("") ? null : type;
            screenResolution = screenResolution.equals("") ? null : screenResolution;
            Long fromPrice = fromPriceStr.equals("") ? null : Long.parseLong(fromPriceStr);
            Long toPrice = toPriceStr.equals("") ? null : Long.parseLong(toPriceStr);
            Integer fromSold = fromSoldStr.equals("") ? null : Integer.parseInt(fromSoldStr);
            Integer toSold = toSoldStr.equals("") ? null : Integer.parseInt(toSoldStr);

            List<Laptop> laptops = searchLaptop.findLaptop(maker, type, fromPrice, toPrice, fromSold, toSold, screenResolution);
            System.out.println(laptops);
            /*---------- Activity 3.2 ----------*/
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
