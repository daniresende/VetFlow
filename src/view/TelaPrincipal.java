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
        JButton editarPet=new JButton("Editar Pet");
        JButton editarTutor=new JButton("Editar Tutores");

        tutor.setBounds(320,50,150,40);
        pet.setBounds(320,110,150,40);
        vet.setBounds(320,170,150,40);
        relatorio.setBounds(320,230,150,40);
        editarPet.setBounds(320,290,150,40);
        editarTutor.setBounds(320,350,150,40);

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

        editarPet.addActionListener(e->{

            dispose();
            new EditarPetFrame();
        });

        editarTutor.addActionListener(e->{

            dispose();
            new EditarTutorFrame();
        });


       

        painel.add(tutor);
        painel.add(pet);
        painel.add(vet);
        painel.add(relatorio);
        painel.add(editarPet);
        painel.add(editarTutor);

        add(painel);

        setVisible(true);

    }

}
