package view;

import javax.swing.*;
import model.Tutor;
import dao.TutorDAO;

public class CadastroTutorFrame extends JFrame {

JTextField nome,cpf,email,contato,dataNasc,sexo,endereco,cep,pessoaEmergencia,contatoEmergencia;
JButton salvar;

public CadastroTutorFrame(){

setTitle("Cadastro Tutor");
setSize(600,500);
setLocationRelativeTo(null);
setLayout(null);

String[] labels={"Nome","CPF","Email","Contato","Nascimento(yyyy-mm-dd)","Sexo","Endereço","CEP","Pessoa Emergência","Contato Emergência"};
JTextField[] campos={
nome=new JTextField(),
cpf=new JTextField(),
email=new JTextField(),
contato=new JTextField(),
dataNasc=new JTextField(),
sexo=new JTextField(),
endereco=new JTextField(),
cep=new JTextField(),
pessoaEmergencia=new JTextField(),
contatoEmergencia=new JTextField()
};

for(int i=0;i<labels.length;i++){
JLabel l=new JLabel(labels[i]);
l.setBounds(20,30+i*35,150,25);
campos[i].setBounds(180,30+i*35,250,25);
add(l); add(campos[i]);
}

salvar=new JButton("Salvar");
salvar.setBounds(220,400,100,30);
add(salvar);

JButton voltar = new JButton("Voltar");

voltar.setBounds(
        60,
        400,
        100,
        30
);

add(voltar);

voltar.addActionListener(e->{

    dispose();

    new TelaPrincipal();

});

salvar.addActionListener(e->{
Tutor t=new Tutor();
t.setNome(nome.getText());
t.setCpf(cpf.getText());
t.setEmail(email.getText());
t.setContato(contato.getText());
t.setDataNascimento(dataNasc.getText());
t.setSexo(sexo.getText());
t.setEndereco(endereco.getText());
t.setCep(cep.getText());
t.setPessoaEmergencia(pessoaEmergencia.getText());
t.setContatoEmergencia(contatoEmergencia.getText());

new TutorDAO().inserir(t);
JOptionPane.showMessageDialog(null,"Tutor cadastrado");
});
setVisible(true);
}
}
