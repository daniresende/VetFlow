package view;

import javax.swing.*;
import model.Pet;
import dao.PetDAO;

public class CadastroPetFrame extends JFrame{

JTextField nome,cpf,especie,raca,cor,peso,idade;
JComboBox<String> sexo;

public CadastroPetFrame(){
setTitle("Cadastro Pet");
setSize(500,450);
setLocationRelativeTo(null);
setLayout(null);

nome=new JTextField();
cpf=new JTextField();
especie=new JTextField();
raca=new JTextField();
cor=new JTextField();
peso=new JTextField();
idade=new JTextField();
sexo=new JComboBox<>(new String[]{"Macho","Fêmea"});

String[] txt={"Nome","CPF Tutor","Espécie","Raça","Cor","Peso","Sexo","Idade"};
JComponent[] c={nome,cpf,especie,raca,cor,peso,sexo,idade};

for(int i=0;i<txt.length;i++){
JLabel l=new JLabel(txt[i]);
l.setBounds(20,30+i*40,100,25);
c[i].setBounds(140,30+i*40,200,25);
add(l); add(c[i]);
}

JButton salvar=new JButton("Salvar");
salvar.setBounds(180,360,100,30);
add(salvar);

JButton voltar = new JButton("Voltar");

voltar.setBounds(
        60,
        360,
        100,
        30
);

add(voltar);

voltar.addActionListener(e->{

    dispose();

    new TelaPrincipal();

});

salvar.addActionListener(e->{
Pet p=new Pet();
p.setNomeAnimal(nome.getText());
p.setCpfTutor(cpf.getText());
p.setEspecie(especie.getText());
p.setRaca(raca.getText());
p.setCorPelagem(cor.getText());
p.setPeso(Float.parseFloat(peso.getText()));
p.setSexo(sexo.getSelectedItem().toString());
p.setIdade(Integer.parseInt(idade.getText()));

new PetDAO().inserir(p);
JOptionPane.showMessageDialog(null,"Pet cadastrado");
});

nome.addActionListener(e -> cpf.requestFocus());
cpf.addActionListener(e -> especie.requestFocus());
especie.addActionListener(e ->raca.requestFocus());
raca.addActionListener(e ->cor.requestFocus());
cor.addActionListener(e ->peso.requestFocus());
peso.addActionListener(e ->sexo.requestFocus());
sexo.addActionListener(e ->idade.requestFocus());

setVisible(true);
}

}


