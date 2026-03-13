import java.sql.*;

public class RemoverRegistro {

    public static void main(String[] args) {

        String url = "jdbc:h2:C:/Users/andre/test";
        String user = "sa";
        String password = "";

        try {

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(
                "DELETE FROM funcionarios WHERE id = 2"
            );

            System.out.println("Funcionário removido!");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}