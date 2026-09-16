package view;

import javax.swing.*;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal(){

        setTitle("VetFlow");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painel=new JPanel();
        painel.setLayout(null);

        JButton tutor=new JButton("Tutor");
        JButton pet=new JButton("Pet");
        JButton vet=new JButton("Veterinário");
        JButton relatorio=new JButton("Relatórios");

        tutor.setBounds(50,50,150,40);
        pet.setBounds(50,110,150,40);
        vet.setBounds(50,170,150,40);
        relatorio.setBounds(50,230,150,40);

        tutor.addActionListener(e->{

            dispose();
            new CadastroTutorFrame();

        });

        pet.addActionListener(e->{

            dispose();
            new CadastroPetFrame();

        });

        vet.addActionListener(e->{

            dispose();
            new CadastroVeterinarioFrame();

        });

        relatorio.addActionListener(e->{

            dispose();
            new RelatorioFrame();

        });

        painel.add(tutor);
        painel.add(pet);
        painel.add(vet);
        painel.add(relatorio);

        add(painel);

        setVisible(true);

    }

}
