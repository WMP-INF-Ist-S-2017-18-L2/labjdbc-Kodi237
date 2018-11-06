import java.sql.*;

public class MySQLConnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/BAZA_PRODUKTOW?user=root&password=root&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery("select * from produkt");
        ResultSetMetaData meta = result.getMetaData();

        for (int i = 0; i < meta.getColumnCount(); i++) {
            System.out.print(meta.getColumnName(i + 1) + " ");
        }
        System.out.println();

        while (result.next()) {
            for (int i = 0; i < meta.getColumnCount(); i++) {
                System.out.print(result.getString(i + 1) + " ");
                System.out.println();
            }
        }
    }
}
