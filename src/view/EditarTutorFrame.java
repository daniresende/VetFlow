package view;
import javax.swing.*;


import model.Tutor;

import dao.TutorDAO;
public class EditarTutorFrame extends JFrame{
    JTextField nome,cpf,email,contato,dataNasc,sexo,endereco,cep,pessoaEmergencia,contatoEmergencia;
JButton salvar;

private String nomeOriginal;
private String cpfOriginal;


public EditarTutorFrame(){

setTitle("Editar Tutor");
setSize(600,500);
setLocationRelativeTo(null);
setLayout(null);

String[] labels={"Nome","CPF","Email","Contato","Nascimento(yyyy-mm-dd)","Sexo","Endereço","CEP","Pessoa Emergência","Contato Emergência"};
JLabel[] label = new JLabel[labels.length];
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
//JLabel l=new JLabel(labels[i]);
//l.setBounds(20,30+i*35,150,25);
//campos[i].setBounds(180,30+i*35,250,25);
//add(l); add(campos[i]);
//l.setVisible(false);
//campos[i].setVisible(false);

label[i] = new JLabel(labels[i]);

    label[i].setBounds(20,30+i*35,150,25);
    campos[i].setBounds(180,30+i*35,250,25);

    add(label[i]);
    add(campos[i]);

    label[i].setVisible(false);
    campos[i].setVisible(false);

}
label[0].setVisible(true);
label[1].setVisible(true);
nome.setVisible(true);
cpf.setVisible(true);




salvar=new JButton("Salvar");
salvar.setBounds(300,400,100,30);
add(salvar);

JButton voltar = new JButton("Voltar");

voltar.setBounds(
        60,
        400,
        100,
        30
);

add(voltar);

JButton consultar=new JButton("Consultar");
consultar.setBounds(180,400,100,30);
add(consultar);


JButton deletar=new JButton("Excluir");
deletar.setBounds(420,400,100,30);
add(deletar);

deletar.setVisible(false);
salvar.setVisible(false);
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

new TutorDAO().editar(t, nomeOriginal, cpfOriginal);
JOptionPane.showMessageDialog(null,"Tutor atualizado");
});


consultar.addActionListener(e->{


   

    TutorDAO dao = new TutorDAO();

    Tutor tutor = dao.preencher(nome.getText(), cpf.getText());
    
    if(tutor != null){

        for(int i = 1; i < campos.length; i++){

    

}
        
nomeOriginal = tutor.getNome();
cpfOriginal = tutor.getCpf();
email.setText(tutor.getEmail());
contato.setText(tutor.getContato());
dataNasc.setText(tutor.getDataNascimento());
sexo.setText(tutor.getSexo());
endereco.setText(tutor.getEndereco());
cep.setText(tutor.getCep());
pessoaEmergencia.setText(tutor.getPessoaEmergencia());
contatoEmergencia.setText(tutor.getContatoEmergencia());
 email.setVisible(true);
    contato.setVisible(true);
    dataNasc.setVisible(true);
    sexo.setVisible(true);
    endereco.setVisible(true);
    cep.setVisible(true);
    pessoaEmergencia.setVisible(true);
    contatoEmergencia.setVisible(true);
    label[2].setVisible(true);
    label[3].setVisible(true);
label[4].setVisible(true);
label[5].setVisible(true);
label[6].setVisible(true);
label[7].setVisible(true);
label[8].setVisible(true);
label[9].setVisible(true);
deletar.setVisible(true);
salvar.setVisible(true);
    }else{

        JOptionPane.showMessageDialog(null, "Tutor não encontrado");

    }
   

});

deletar.addActionListener(e->{
    String cpfTutor = cpf.getText();
    TutorDAO dao = new TutorDAO();

    dao.excluir(cpfTutor);

});

nome.addActionListener(e -> cpf.requestFocus());
cpf.addActionListener(e -> email.requestFocus());
email.addActionListener(e ->contato.requestFocus());
contato.addActionListener(e ->dataNasc.requestFocus());
dataNasc.addActionListener(e ->sexo.requestFocus());
sexo.addActionListener(e -> endereco.requestFocus());
endereco.addActionListener(e -> cep.requestFocus());
cep.addActionListener(e -> pessoaEmergencia.requestFocus());
pessoaEmergencia.addActionListener(e -> contatoEmergencia.requestFocus());
contatoEmergencia.addActionListener(e ->salvar.requestFocus());



setVisible(true);
}
}
