import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {

    public static void main(String[] args) {

        String url = "jdbc:h2:./banco/test";
        String user = "sa";
        String password = "";

        try {

            Connection conn = DriverManager.getConnection(url, user, password);

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(
                "SELECT f.id, f.nome, f.cargo, c.codigo " +
                "FROM funcionarios f " +
                "JOIN cracha c ON f.id = c.funcionario_id"
            );

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("nome") + " | " +
                    rs.getString("cargo") + " | " +
                    rs.getString("codigo")
                );
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}