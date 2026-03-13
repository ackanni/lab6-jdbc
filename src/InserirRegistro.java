import java.sql.*;

public class InserirRegistro {

    public static void main(String[] args) {

        String url = "jdbc:h2:C:/Users/andre/test";
        String user = "sa";
        String password = "";

        try {

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(
                "INSERT INTO funcionarios (nome, cargo) VALUES ('João', 'Analista')"
            );

            System.out.println("Funcionário inserido!");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}