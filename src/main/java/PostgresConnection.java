import java.sql.*;

public class PostgresConnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://localhost/BAZA_PRODUKTOW?user=postgres&password=root&ssl=false";
        Connection con = DriverManager.getConnection(url);
        Class.forName("org.postgresql.Driver");
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery("select * from \"PRODUKT\"");
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
