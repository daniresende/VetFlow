package dao;

import model.Pet;
import model.Tutor;
import java.sql.*;
import java.util.ArrayList;

public class TutorDAO {

    public void inserir(Tutor tutor){

        String sql =
        "INSERT INTO cadastrotutor(nome,cpf,email,contato,dataNascimento,sexo,endereco,cep,pessoaEmergencia,contatoEmergencia) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try(Connection conn=Conexao.conectar()){

            PreparedStatement stmt=
            conn.prepareStatement(sql);

            stmt.setString(1,tutor.getNome());
            stmt.setString(2,tutor.getCpf());
            stmt.setString(3,tutor.getEmail());
            stmt.setString(4,tutor.getContato());
            stmt.setDate(
                5,
                Date.valueOf(
                    tutor.getDataNascimento()
                )
            );

            stmt.setString(6,tutor.getSexo());
            stmt.setString(7,tutor.getEndereco());
            stmt.setString(8,tutor.getCep());
            stmt.setString(9,tutor.getPessoaEmergencia());
            stmt.setString(10,tutor.getContatoEmergencia());

            stmt.executeUpdate();

        }catch(Exception e){

            e.printStackTrace();

        }

    }

    public ArrayList<Tutor> listar(){

        ArrayList<Tutor> lista=
        new ArrayList<>();

        String sql=
        "SELECT * FROM cadastrotutor";

        try(Connection conn=
            Conexao.conectar()){

            PreparedStatement stmt=
            conn.prepareStatement(sql);

            ResultSet rs=
            stmt.executeQuery();

            while(rs.next()){

                Tutor t=
                new Tutor();

                t.setNome(
                    rs.getString("nome")
                );

                t.setCpf(
                    rs.getString("cpf")
                );

                lista.add(t);

            }

        }catch(Exception e){

            e.printStackTrace();

        }

        return lista;
    }

    public void excluir(String cpf){

        String sql=
        "DELETE FROM cadastrotutor WHERE cpf=?";

        try(Connection conn=
            Conexao.conectar()){

            PreparedStatement stmt=
            conn.prepareStatement(sql);

            stmt.setString(1,cpf);

            stmt.executeUpdate();

        }catch(Exception e){

            e.printStackTrace();

        }

    }


    public Tutor preencher(String nome, String cpf ){

    String sql = "SELECT * FROM cadastroTutor WHERE nome = ? AND cpf = ?";
    Tutor tutor = null;

    try(Connection conn=
            Conexao.conectar()){

            PreparedStatement stmt=
                conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            ResultSet rs = stmt.executeQuery();

        if(rs.next()){

            tutor = new Tutor();

        
            tutor.setNome(rs.getString("nome"));
            tutor.setCpf(rs.getString("cpf"));
            tutor.setEmail(rs.getString("email"));
            tutor.setContato(rs.getString("contato"));
            tutor.setDataNascimento(rs.getDate("dataNascimento").toString());
            tutor.setSexo(rs.getString("sexo"));
            tutor.setEndereco(rs.getString("endereco"));
            tutor.setCep(rs.getString("cep"));
            tutor.setPessoaEmergencia(rs.getString("pessoaEmergencia"));
            tutor.setContatoEmergencia(rs.getString("contatoEmergencia"));


        }


        }catch(Exception e){

            e.printStackTrace();

        }


        
        
        
return tutor;
}


public void editar (Tutor tutor, String nomeOriginal, String cpfOriginal){

        String sql =
        "UPDATE cadastrotutor set nome = ?, cpf = ?, email = ?, contato = ?, dataNascimento = ?, sexo = ?, endereco =?, cep = ?, pessoaEmergencia = ?, contatoEmergencia = ? WHERE nome = ? AND cpf = ?";

        try(Connection conn=Conexao.conectar()){

            PreparedStatement stmt=
            conn.prepareStatement(sql);

            stmt.setString(1,tutor.getNome());
            stmt.setString(2,tutor.getCpf());
            stmt.setString(3,tutor.getEmail());
            stmt.setString(4,tutor.getContato());
            stmt.setDate(
                5,
                Date.valueOf(
                    tutor.getDataNascimento()
                )
            );

            stmt.setString(6,tutor.getSexo());
            stmt.setString(7,tutor.getEndereco());
            stmt.setString(8,tutor.getCep());
            stmt.setString(9,tutor.getPessoaEmergencia());
            stmt.setString(10,tutor.getContatoEmergencia());

            stmt.setString(11, nomeOriginal);
            stmt.setString(12, cpfOriginal);

            stmt.executeUpdate();

        }catch(Exception e){

            e.printStackTrace();

        }

    }


    



}
