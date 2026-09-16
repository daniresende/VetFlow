package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListagemFrame extends JFrame{

    JTable tabela;

    public ListagemFrame(){

        setSize(700,400);
        setLocationRelativeTo(null);

        tabela=new JTable();

        DefaultTableModel modelo=
        new DefaultTableModel();

        modelo.addColumn("Nome");
        modelo.addColumn("CPF");

        tabela.setModel(modelo);

        add(new JScrollPane(tabela));

        setVisible(true);
    }
}