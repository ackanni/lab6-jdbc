import java.sql.*;

public class RemoverRegistro {

    public static void main(String[] args) {

        String url = "jdbc:h2:C:./banco/test";
        String user = "sa";
        String password = "";

        try {

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // remover crachá primeiro
            stmt.executeUpdate(
                "DELETE FROM cracha WHERE funcionario_id = 2"
            );

            // depois remover funcionário
            stmt.executeUpdate(
                "DELETE FROM funcionarios WHERE id = 2"
            );

            System.out.println("Funcionário e crachá removidos!");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}