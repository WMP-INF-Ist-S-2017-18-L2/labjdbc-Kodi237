import java.sql.*;

public class SQLiteConnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:sqlite:D:/^Konrad/^URz/Obiektówka/SQLiteStudio/BAZA_PRODUKTOW.db";
        Connection con = DriverManager.getConnection(url);
        Class.forName("org.sqlite.JDBC");
        Statement stmt = con.createStatement();
        ResultSet result = stmt.executeQuery("select * from PRODUKT");
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
