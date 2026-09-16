package dao;

import model.Veterinario;
import java.sql.*;
import java.util.ArrayList;

public class VeterinarioDAO {

    public void inserir(Veterinario vet){

        String sql=
        "INSERT INTO veterinario(nome,crmv,especialidade,email,contato) VALUES (?,?,?,?,?)";

        try(Connection conn=
                Conexao.conectar()){

            PreparedStatement stmt=
                    conn.prepareStatement(sql);

            stmt.setString(1,vet.getNome());
            stmt.setString(2,vet.getCrmv());
            stmt.setString(3,vet.getEspecialidade());
            stmt.setString(4,vet.getEmail());
            stmt.setString(5,vet.getContato());

            stmt.executeUpdate();

        }catch(Exception e){

            e.printStackTrace();

        }

    }

    public ArrayList<Veterinario> listar(){

        ArrayList<Veterinario> lista=
                new ArrayList<>();

        String sql=
        "SELECT * FROM veterinario";

        try(Connection conn=
                Conexao.conectar()){

            PreparedStatement stmt=
                    conn.prepareStatement(sql);

            ResultSet rs=
                    stmt.executeQuery();

            while(rs.next()){

                Veterinario v=
                        new Veterinario();

                v.setNome(
                        rs.getString("nome")
                );

                v.setCrmv(
                        rs.getString("crmv")
                );

                lista.add(v);

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return lista;

    }

}