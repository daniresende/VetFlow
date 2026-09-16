package dao;

import model.Relatorio;
import java.sql.*;

public class RelatorioDAO {

    public void inserir(
            Relatorio r){

        String sql=
        "INSERT INTO relatorio(idAnimal,idVeterinario,dataConsulta,queixaPrincipal,historico,temperatura,peso,diagnostico,tratamento,observacoes) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try(Connection conn=
                Conexao.conectar()){

            PreparedStatement stmt=
                    conn.prepareStatement(sql);

            stmt.setInt(
                    1,
                    r.getIdAnimal()
            );

            stmt.setInt(
                    2,
                    r.getIdVeterinario()
            );

            stmt.setString(
                    3,
                    r.getDataConsulta()
            );

            stmt.setString(
                    4,
                    r.getQueixaPrincipal()
            );

            stmt.setString(
                    5,
                    r.getHistorico()
            );

            stmt.setFloat(
                    6,
                    r.getTemperatura()
            );

            stmt.setFloat(
                    7,
                    r.getPeso()
            );

            stmt.setString(
                    8,
                    r.getDiagnostico()
            );

            stmt.setString(
                    9,
                    r.getTratamento()
            );

            stmt.setString(
                    10,
                    r.getObservacoes()
            );

            stmt.executeUpdate();

        }
        catch(Exception e){

            e.printStackTrace();

        }

    }

}