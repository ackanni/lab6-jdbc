import java.sql.*;

public class InserirRegistro {

    public static void main(String[] args) {

        String url = "jdbc:h2:C:./banco/test";
        String user = "sa";
        String password = "";

        try {

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // inserir funcionario
            stmt.executeUpdate(
                "INSERT INTO funcionarios (nome, cargo) VALUES ('João', 'Analista')"
            );

            // pegar id do funcionário inserido
            ResultSet rs = stmt.executeQuery(
                "SELECT MAX(id) AS ultimo_id FROM funcionarios"
            );

            int funcionarioId = 0;

            if (rs.next()) {
                funcionarioId = rs.getInt("ultimo_id");
            }

            // inserir crachá
            stmt.executeUpdate(
                "INSERT INTO cracha (id_cracha, funcionario_id, codigo) VALUES (200, " 
                + funcionarioId + ", 'CR200')"
            );

            System.out.println("Funcionário e crachá inseridos!");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}