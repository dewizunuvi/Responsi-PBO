package view;

import controller.Inputcontroller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Menuview extends JFrame implements ActionListener {
    private JLabel labelMenu;
    private JButton btnCreate, btnUpdate, btnRead;

    public Menuview(){
        setTitle("Menu");
        labelMenu = new JLabel("Main Menu");
        labelMenu.setHorizontalAlignment(SwingConstants.CENTER);
        btnCreate = new JButton(" Tambah Barang");
        btnUpdate = new JButton(" Update Barang ");
        btnRead = new JButton(" Lihat Barang ");
        setLayout(new GridLayout(3,0));
        add(labelMenu);
        add(btnCreate);
        add(btnRead);
        pack();
        setResizable(false);
        setLocation(600,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnRead.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCreate.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnRead.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnCreate){
            Inputcontroller input = new Inputcontroller();
            input.createBarang();
            dispose();
        }
        else{
            Inputcontroller ic = new Inputcontroller();
            ic.readBarang();
            dispose();
        }
    }


}
