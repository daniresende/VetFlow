package view;

import javax.swing.*;
import dao.LoginDAO;


public class LoginFrame extends JFrame{

    JTextField usuarioField;
    JPasswordField senhaField;
    JButton entrar;

    public LoginFrame(){

        setTitle("VetFlow Login");
        setSize(400,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel u=new JLabel("Usuário");
        u.setBounds(50,40,100,25);

        usuarioField=new JTextField();
        usuarioField.setBounds(150,40,150,25);

        JLabel s=new JLabel("Senha");
        s.setBounds(50,80,100,25);

        senhaField=new JPasswordField();
        senhaField.setBounds(150,80,150,25);

        entrar=new JButton("Entrar");
        entrar.setBounds(80,140,110,30);

        JButton cadastrar=
        new JButton("Cadastrar");

        cadastrar.setBounds(
                210,
                140,
                110,
                30
        );

        cadastrar.addActionListener(e->{

            new CadastroUsuarioFrame();

            dispose();

        });

add(cadastrar);

        entrar.addActionListener(e->{
            LoginDAO dao=new LoginDAO();

            boolean ok=dao.autenticar(
                usuarioField.getText(),
                String.valueOf(senhaField.getPassword())
            );

            if(ok){
                new TelaPrincipal();
                dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Login inválido");
            }
        });

        add(u);
        add(usuarioField);
        add(s);
        add(senhaField);
        add(entrar);
usuarioField.addActionListener(e -> senhaField.requestFocus());

        setVisible(true);
    }
}