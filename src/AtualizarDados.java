import java.sql.*;

public class AtualizarDados {

    public static void main(String[] args) {

        String url = "jdbc:h2:C:./banco/test";
        String user = "sa";
        String password = "";

        try {

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(
                "UPDATE funcionarios SET cargo = 'Diretor' WHERE id = 2"
            );

            System.out.println("Funcionário atualizado!");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}