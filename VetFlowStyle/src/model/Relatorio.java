package model;

public class Relatorio {

    private int idRelatorio;
    private int idAnimal;
    private int idVeterinario;

    private String dataConsulta;
    private String queixaPrincipal;
    private String historico;
    private float temperatura;
    private float peso;
    private String diagnostico;
    private String tratamento;
    private String observacoes;

    public Relatorio(){}

    public int getIdRelatorio() {
        return idRelatorio;
    }

    public void setIdRelatorio(int idRelatorio) {
        this.idRelatorio = idRelatorio;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal){
        this.idAnimal=idAnimal;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario){
        this.idVeterinario=idVeterinario;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta){
        this.dataConsulta=dataConsulta;
    }

    public String getQueixaPrincipal(){
        return queixaPrincipal;
    }

    public void setQueixaPrincipal(String queixaPrincipal){
        this.queixaPrincipal=queixaPrincipal;
    }

    public String getHistorico(){
        return historico;
    }

    public void setHistorico(String historico){
        this.historico=historico;
    }

    public float getTemperatura(){
        return temperatura;
    }

    public void setTemperatura(float temperatura){
        this.temperatura=temperatura;
    }

    public float getPeso(){
        return peso;
    }

    public void setPeso(float peso){
        this.peso=peso;
    }

    public String getDiagnostico(){
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico){
        this.diagnostico=diagnostico;
    }

    public String getTratamento(){
        return tratamento;
    }

    public void setTratamento(String tratamento){
        this.tratamento=tratamento;
    }

    public String getObservacoes(){
        return observacoes;
    }

    public void setObservacoes(String observacoes){
        this.observacoes=observacoes;
    }

}
