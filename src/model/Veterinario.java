package model;

public class Veterinario {

    private int idVeterinario;
    private String nome;
    private String crmv;
    private String especialidade;
    private String email;
    private String contato;

    public Veterinario(){}

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public String getCrmv(){
        return crmv;
    }

    public void setCrmv(String crmv){
        this.crmv=crmv;
    }

    public String getEspecialidade(){
        return especialidade;
    }

    public void setEspecialidade(String especialidade){
        this.especialidade=especialidade;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getContato(){
        return contato;
    }

    public void setContato(String contato){
        this.contato=contato;
    }

}