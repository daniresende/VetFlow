package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import org.mindrot.jbcrypt.BCrypt;

public class LoginDAO {

    //Cadastrar usuário
    public void cadastrar(
            String usuario,
            String senha){

        String sql=
        "INSERT INTO login(usuario,senha) VALUES (?,?)";

        try(Connection conn=
                Conexao.conectar()){

            PreparedStatement stmt=
                    conn.prepareStatement(sql);

            //Criptografa a senha
            String senhaHash=
                    BCrypt.hashpw(
                            senha,
                            BCrypt.gensalt()
                    );

            stmt.setString(
                    1,
                    usuario
            );

            stmt.setString(
                    2,
                    senhaHash
            );

            stmt.executeUpdate();

        }catch(Exception e){

            JOptionPane.showMessageDialog(
                null,
                e.getMessage()
            );

            e.printStackTrace();

        }
    }

    //Autenticar usuário
    public boolean autenticar(
            String usuario,
            String senha){

        String sql=
        "SELECT senha FROM login WHERE usuario=?";

        try(Connection conn=
                Conexao.conectar()){

            PreparedStatement stmt=
                    conn.prepareStatement(sql);

            stmt.setString(
                    1,
                    usuario
            );

            ResultSet rs=
                    stmt.executeQuery();

            if(rs.next()){

                String senhaHash=
                        rs.getString("senha");

                //compara senha digitada com senha criptografada
                return BCrypt.checkpw(
                        senha,
                        senhaHash
                );

            }

        }catch(Exception e){

            JOptionPane.showMessageDialog(
                null,
                e.getMessage()
            );

            e.printStackTrace();

        }

        return false;
    }
}