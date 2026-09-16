package dao;

import model.Pet;
import java.sql.*;

public class PetDAO {

    public void inserir(Pet pet){

        String sql=
        "INSERT INTO cadastropet(nomeAnimal,cpfTutor,especie,raca,corPelagem,peso,sexo,idade) VALUES (?,?,?,?,?,?,?,?)";

        try(Connection conn=
            Conexao.conectar()){

            PreparedStatement stmt=
                conn.prepareStatement(sql);

            stmt.setString(
                1,
                pet.getNomeAnimal()
            );

            stmt.setString(
                2,
                pet.getCpfTutor()
            );

            stmt.setString(
                3,
                pet.getEspecie()
            );

            stmt.setString(
                4,
                pet.getRaca()
            );

            stmt.setString(
                5,
                pet.getCorPelagem()
            );

            stmt.setFloat(
                6,
                pet.getPeso()
            );

            stmt.setString(
                7,
                pet.getSexo()
            );

            stmt.setInt(
                8,
                pet.getIdade()
            );

            stmt.executeUpdate();

        }catch(Exception e){

            e.printStackTrace();

        }

    }

}