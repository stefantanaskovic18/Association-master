package database;

import java.sql.*;

public class DB {

    private static DB instanca;
    private static final int MAX_CON = 5;
    private static final Connection[] bafer = new Connection[MAX_CON];
    private int first = 0, last = 0, free = MAX_CON;

    private DB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < MAX_CON; i++) {
                bafer[i] = DriverManager.getConnection("jdbc:mysql://localhost:3306/ip_projekat", "root", "");
            }

        } catch (Exception e) {
            System.err.println("Doslo je do greske pri konekciji na bazu podataka " + e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    
    public static DB getInstanca() {
        if (instanca == null) {
            instanca = new DB();
        }
        return instanca;
    }

    public synchronized Connection getConnection() {
        if (free == 0) {
            return null;
        }
        free--;
        Connection con = bafer[first];
        first = (first + 1) % MAX_CON;
        return con;
    }

    public synchronized void putConnection(Connection con) {
        if (con == null) {
            return;
        }
        free++;
        bafer[last] = con;
        last = (last + 1) % MAX_CON;
    }

    

    //metoda za upite koji su tipa INSERT, UPDATE, DELETE
    /*public int iudQuerry(String sql) throws SQLException {
        //System.out.println(sql);
        Statement statement = conn.createStatement();
        return statement.executeUpdate(sql);
    }

    public ResultSet select(String upit) {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(upit);
            return rs;
        } catch (SQLException e) {
            System.out.println("Doslo je do greske u radu sa bazom: " + e.getMessage());
            System.exit(1);
        }
        return null;
    }

    public int BrojZapisa(ResultSet rs) {
        int rezultat = 0;
        try {
            while (rs.next()) {
                rezultat++;
            }

        } catch (SQLException e) {
            System.out.println("Doslo je do greske u radu sa bazom: " + e.getMessage());
            System.exit(1);
        }
        return rezultat;
    }*/
}
