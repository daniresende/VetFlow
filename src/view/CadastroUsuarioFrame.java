package view;

import javax.swing.*;
import dao.LoginDAO;

public class CadastroUsuarioFrame extends JFrame {

    JTextField usuarioField;
    JPasswordField senhaField;
    JButton salvar;
    JButton voltar;

    public CadastroUsuarioFrame(){

        setTitle("Cadastrar Usuário");
        setSize(400,300);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel usuarioLabel=
                new JLabel("Usuário");

        usuarioLabel.setBounds(
                50,50,100,25
        );

        usuarioField=
                new JTextField();

        usuarioField.setBounds(
                150,50,180,25
        );

        JLabel senhaLabel=
                new JLabel("Senha");

        senhaLabel.setBounds(
                50,100,100,25
        );

        senhaField=
                new JPasswordField();

        senhaField.setBounds(
                150,100,180,25
        );

        salvar=
                new JButton("Salvar");

        salvar.setBounds(
                80,180,100,30
        );

        voltar=
                new JButton("Voltar");

        voltar.setBounds(
                200,180,100,30
        );

        salvar.addActionListener(e->{

            LoginDAO dao=
                    new LoginDAO();

            dao.cadastrar(

                usuarioField.getText(),

                String.valueOf(
                        senhaField.getPassword()
                )

            );

            JOptionPane.showMessageDialog(
                    null,
                    "Usuário cadastrado!"
            );

            dispose();

            new LoginFrame();

        });

        voltar.addActionListener(e->{

            dispose();

            new LoginFrame();

        });

        add(usuarioLabel);
        add(usuarioField);

        add(senhaLabel);
        add(senhaField);

        add(salvar);
        add(voltar);

        setVisible(true);

    }

}