package vn.plusplus.database.buoi4;

import vn.plusplus.database.buoi3.Laptop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CounterService {
    Connection con;

    public CounterService(Connection con) {this.con = con;}

    public List<Counter> getCounterByMaker() {
        try {
            Statement stmt = con.createStatement();
            String querySQL = "SELECT `maker`, COUNT(*) AS `quantity` FROM `laptop` GROUP BY `maker` ORDER BY `quantity` DESC";
            ResultSet rs = stmt.executeQuery(querySQL);
            return getCounter(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Counter> getCounter(ResultSet rs) {
        List<Counter> counters = new ArrayList<>();
        try {
            while(rs.next()) {
                Counter counter = new Counter();
                counter.setMaker(rs.getString("maker"));
                counter.setQuantity(rs.getInt("quantity"));
                counters.add(counter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return counters;
    }
}
