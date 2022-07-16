package vn.plusplus.database.buoi3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LaptopSearchService {
    Connection con;

    public LaptopSearchService(Connection con) {
        this.con = con;
    }

    public List<Laptop> findLaptopByMaker(String maker) {
        try {
            Statement stmt = con.createStatement();
            String querySQL = "SELECT * FROM `laptop` WHERE `maker`='" + maker + "'";
            ResultSet rs = stmt.executeQuery(querySQL);
            return getLaptop(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Laptop> findLaptopByType(String type) {
        try {
            Statement stmt = con.createStatement();
            String querySQL = "SELECT * FROM `laptop` WHERE `type`='" + type + "'";
            ResultSet rs = stmt.executeQuery(querySQL);
            return getLaptop(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Laptop> findLaptop(String maker, String type, Long fromPrice, Long toPrice, Integer fromSold, Integer toSold, String screenResolution) {
        try {
            Statement stmt = con.createStatement();
            String querySQL = "SELECT * FROM `laptop` WHERE 1=1";
            if (maker != null){
                querySQL += " AND `maker`='" + maker + "'";
            }
            if (type != null) {
                querySQL += " AND `type`='" + type + "'";
            }
            if (fromPrice != null) {
                querySQL += " AND `price`>='" + fromPrice + "'";
            }
            if (toPrice != null) {
                querySQL += " AND `price`<='" + toPrice + "'";
            }
            if (fromSold != null) {
                querySQL += " AND `sold` >= '" + fromSold + "'";
            }
            if (toSold != null) {
                querySQL += " AND `sold` <= '" + toSold + "'";
            }
            if (screenResolution != null) {
                querySQL += " AND `screen_resolution` = '" + screenResolution + "'";
            }
            ResultSet rs = stmt.executeQuery(querySQL);
            return getLaptop(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Laptop> getLaptop(ResultSet rs) {
        List<Laptop> laptops = new ArrayList<>();
        try {
            while (rs.next()) {
                Laptop item = new Laptop();
                item.setName(rs.getString("name"));
                item.setMaker(rs.getString("maker"));
                item.setPrice(rs.getLong("price"));
                item.setSold(rs.getInt("sold"));
                item.setScreenResolution("screen_resolution");
                laptops.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return laptops;
    }

}
