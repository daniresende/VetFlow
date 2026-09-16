package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

    public boolean autenticar(
            String usuario,
            String senha){

        String sql =
        "SELECT * FROM login WHERE usuario=? AND senha=?";

        try(Connection conn =
                Conexao.conectar()){

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setString(1, usuario);

            stmt.setString(2, senha);

            ResultSet rs =
                    stmt.executeQuery();

            return rs.next();

        }
        catch(Exception e){

            e.printStackTrace();

        }

        return false;
    }
}