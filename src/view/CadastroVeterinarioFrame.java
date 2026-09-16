package view;

import javax.swing.*;
import model.Veterinario;
import dao.VeterinarioDAO;

public class CadastroVeterinarioFrame extends JFrame{

public CadastroVeterinarioFrame(){
setTitle("Veterinário");
setSize(450,350);
setLocationRelativeTo(null);
setLayout(null);

JTextField nome=new JTextField();
JTextField crmv=new JTextField();
JTextField especialidade=new JTextField();
JTextField email=new JTextField();
JTextField contato=new JTextField();

String[] txt={"Nome","CRMV","Especialidade","Email","Contato"};
JTextField[] campos={nome,crmv,especialidade,email,contato};

for(int i=0;i<txt.length;i++){
JLabel l=new JLabel(txt[i]);
l.setBounds(20,40+i*40,120,25);
campos[i].setBounds(150,40+i*40,200,25);
add(l); add(campos[i]);
}

JButton salvar=new JButton("Salvar");
salvar.setBounds(260,260,100,30);
add(salvar);

JButton voltar = new JButton("Voltar");

voltar.setBounds(
        90,
        260,
        100,
        30
);

add(voltar);

voltar.addActionListener(e->{

    dispose();

    new TelaPrincipal();

});

salvar.addActionListener(e->{
Veterinario v=new Veterinario();
v.setNome(nome.getText());
v.setCrmv(crmv.getText());
v.setEspecialidade(especialidade.getText());
v.setEmail(email.getText());
v.setContato(contato.getText());
new VeterinarioDAO().inserir(v);
JOptionPane.showMessageDialog(null,"Veterinário(a) cadastrado(a)");
});


nome.addActionListener(e ->crmv.requestFocus());
crmv.addActionListener(e ->especialidade.requestFocus());
especialidade.addActionListener(e ->email.requestFocus());
email.addActionListener(e ->contato.requestFocus());

setVisible(true);
}
}
