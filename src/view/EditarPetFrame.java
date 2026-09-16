package view;
import javax.swing.*;
import model.Pet;
import dao.PetDAO;
public class EditarPetFrame extends JFrame{

JTextField nome,cpf,especie,raca,cor,peso,idade;
JComboBox<String> sexo;
JLabel[] labels;
JComponent[] campos;
private String nomeOriginal;
private String cpfTutorOriginal;
public EditarPetFrame(){
setTitle("Editar Pet");
setSize(580,450);
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

//String[] txt={"Nome","CPF Tutor","Espécie","Raça","Cor","Peso","Sexo","Idade"};
//JComponent[] c={nome,cpf,especie,raca,cor,peso,sexo,idade};
String[] txt={"Nome","CPF Tutor","Espécie","Raça","Cor","Peso","Sexo","Idade"};

campos = new JComponent[]{
    nome,cpf,especie,raca,cor,peso,sexo,idade
};

labels = new JLabel[txt.length];

for(int i=0;i<txt.length;i++){
labels[i] = new JLabel(txt[i]);

    labels[i].setBounds(20,30+i*40,100,25);

    campos[i].setBounds(140,30+i*40,200,25);

    add(labels[i]);
    add(campos[i]);

    labels[i].setVisible(false);
    campos[i].setVisible(false);

}
labels[0].setVisible(true);
campos[0].setVisible(true);
labels[1].setVisible(true);
campos[1].setVisible(true);

JButton salvar=new JButton("Salvar");
salvar.setBounds(300,360,100,30);
add(salvar);

JButton consultar=new JButton("Consultar");
consultar.setBounds(180,360,100,30);
add(consultar);

JButton deletar=new JButton("Excluir");
deletar.setBounds(420,360,100,30);
add(deletar);

salvar.setVisible(false);
deletar.setVisible(false);

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

new PetDAO().editar(p, nomeOriginal, cpfTutorOriginal);
JOptionPane.showMessageDialog(null,"Pet atualizado");
});


consultar.addActionListener(e->{


   

    PetDAO dao = new PetDAO();

    Pet p = dao.preencherPet(nome.getText(), cpf.getText());
    
    if(p != null){

        for(int i = 1; i < campos.length; i++){

    labels[i].setVisible(true);
    campos[i].setVisible(true);
    salvar.setVisible(true);
deletar.setVisible(true);

}
        
nomeOriginal = p.getNomeAnimal();
cpfTutorOriginal = p.getCpfTutor();
        cpf.setText(p.getCpfTutor());
        especie.setText(p.getEspecie());
        raca.setText(p.getRaca());
        cor.setText(p.getCorPelagem());
        peso.setText(String.valueOf(p.getPeso()));
        p.setSexo(sexo.getSelectedItem().toString());
        idade.setText(String.valueOf(p.getIdade()));

    }else{

        JOptionPane.showMessageDialog(null, "Pet não encontrado");

    }


});

deletar.addActionListener(e->{
String nomePet = nome.getText();
PetDAO dao = new PetDAO();

dao.excluir(nomePet, cpfTutorOriginal);
JOptionPane.showMessageDialog(null,"Pet excluído.");
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
