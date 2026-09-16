package dao;

import model.Pet;
import model.Tutor;

import java.sql.*;
import java.util.ArrayList;



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


public void editar (Pet pet, String nomeOriginal, String cpftutorOriginal){



        String sql=
        "UPDATE cadastropet SET nomeAnimal = ?, cpfTutor = ?, especie = ?, raca = ?,corPelagem = ?,peso = ?,sexo = ?,idade = ? WHERE nomeAnimal = ? AND cpfTutor = ?";

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
stmt.setString(9, nomeOriginal);
stmt.setString(10, cpftutorOriginal);
            stmt.executeUpdate();



        }catch(Exception e){

            e.printStackTrace();

        }
   


} 

public Pet preencherPet(String nomeAnimal, String cpftutorOriginal){

    String sql = "SELECT * FROM cadastroPet WHERE nomeAnimal = ? AND cpfTutor = ?";
    Pet pet = null;

    try(Connection conn=
            Conexao.conectar()){

            PreparedStatement stmt=
                conn.prepareStatement(sql);
            stmt.setString(1, nomeAnimal);
            stmt.setString(2, cpftutorOriginal);
            ResultSet rs = stmt.executeQuery();

        if(rs.next()){

            pet = new Pet();

            pet.setIdAnimal(rs.getInt("idAnimal"));
            pet.setNomeAnimal(rs.getString("nomeAnimal"));
            pet.setCpfTutor(rs.getString("cpfTutor"));
            pet.setEspecie(rs.getString("especie"));
            pet.setRaca(rs.getString("raca"));
            pet.setCorPelagem(rs.getString("corPelagem"));
            pet.setPeso(rs.getFloat("peso"));
            pet.setSexo(rs.getString("sexo"));
            pet.setIdade(rs.getInt("idade"));

        }


        }catch(Exception e){

            e.printStackTrace();

        }
        
        
return pet;
}


public void excluir(String nomeAnimal, String cpftutorOriginal){

        String sql=
        "DELETE FROM cadastropet WHERE nomeAnimal=? AND cpfTutor = ?";

        try(Connection conn=
            Conexao.conectar()){

            PreparedStatement stmt=
            conn.prepareStatement(sql);

            stmt.setString(1,nomeAnimal);
            stmt.setString(2,cpftutorOriginal);
            stmt.executeUpdate();

        }catch(Exception e){

            e.printStackTrace();

        }

    }


public ArrayList<Pet> listar(){

        ArrayList<Pet> lista=
        new ArrayList<>();

        String sql=
        "SELECT * FROM cadastropet";

        try(Connection conn=
            Conexao.conectar()){

            PreparedStatement stmt=
            conn.prepareStatement(sql);

            ResultSet rs=
            stmt.executeQuery();

            while(rs.next()){

                Pet p=
                new Pet();

                p.setNomeAnimal(
                    rs.getString("nomeAnimal")
                );

                p.setCpfTutor(
                    rs.getString("cpfTutor")
                );

                lista.add(p);

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return lista;
    }





}