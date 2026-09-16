package view;

import javax.swing.*;
import model.Relatorio;
import dao.RelatorioDAO;

public class RelatorioFrame extends JFrame{

public RelatorioFrame(){
setTitle("Relatório Médico");
setSize(600,550);
setLocationRelativeTo(null);
setLayout(null);

JTextField idAnimal=new JTextField();
JTextField idVet=new JTextField();
JTextField data=new JTextField();
JTextField queixa=new JTextField();
JTextField historico=new JTextField();
JTextField temp=new JTextField();
JTextField peso=new JTextField();
JTextField diagnostico=new JTextField();
JTextField tratamento=new JTextField();
JTextField obs=new JTextField();



String[] txt={"ID Animal","ID Veterinário","Data","Queixa","Histórico","Temperatura","Peso","Diagnóstico","Tratamento","Observações"};
JTextField[] campos={idAnimal,idVet,data,queixa,historico,temp,peso,diagnostico,tratamento,obs};

for(int i=0;i<txt.length;i++){
JLabel l=new JLabel(txt[i]);
l.setBounds(20,20+i*40,120,25);
campos[i].setBounds(150,20+i*40,300,25);
add(l); add(campos[i]);
}

JButton salvar=new JButton("Salvar");
salvar.setBounds(230,450,100,30);
add(salvar);

JButton voltar = new JButton("Voltar");

voltar.setBounds(
        60,
        450,
        100,
        30
);

add(voltar);

voltar.addActionListener(e->{

    dispose();

    new TelaPrincipal();

});

salvar.addActionListener(e->{
Relatorio r=new Relatorio();
r.setIdAnimal(Integer.parseInt(idAnimal.getText()));
r.setIdVeterinario(Integer.parseInt(idVet.getText()));
r.setDataConsulta(data.getText());
r.setQueixaPrincipal(queixa.getText());
r.setHistorico(historico.getText());
r.setTemperatura(Float.parseFloat(temp.getText()));
r.setPeso(Float.parseFloat(peso.getText()));
r.setDiagnostico(diagnostico.getText());
r.setTratamento(tratamento.getText());
r.setObservacoes(obs.getText());

new RelatorioDAO().inserir(r);
JOptionPane.showMessageDialog(null,"Relatório salvo");
});


idAnimal.addActionListener(e ->idVet.requestFocus());
idVet.addActionListener(e ->data.requestFocus());
data.addActionListener(e ->queixa.requestFocus());
queixa.addActionListener(e ->historico.requestFocus());
historico.addActionListener(e ->temp.requestFocus());
temp.addActionListener(e ->peso.requestFocus());
peso.addActionListener(e ->diagnostico.requestFocus());
diagnostico.addActionListener(e ->tratamento.requestFocus());
tratamento.addActionListener(e ->obs.requestFocus());

setVisible(true);
}
}