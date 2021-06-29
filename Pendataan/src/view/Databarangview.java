package view;

import controller.Inputcontroller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Databarangview extends JFrame implements ActionListener {
    private JLabel labelJudul, labelnama, labelmassa, labelharga, isnama, ismassa, isharga;
    private JButton btnUpdate, btnDelete, btnBack, btnSet;
    private String id;

    public void openDetail(String[] data){
        this.id = data[0];
        setTitle(data[3] + ", " + data[2]);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,325);
        labelJudul = new JLabel(" Detail Inventaris ");
        labelnama = new JLabel(" Nama Barang : ");
        labelmassa = new JLabel("Massa : ");
        labelharga = new JLabel(" Harga Satuan : ");


        isnama = new JLabel(data[1]);
        ismassa = new JLabel(data[2]);
        isharga = new JLabel(data[3]);
        btnUpdate = new JButton("Edit");
        btnDelete = new JButton("Hapus");
        btnBack = new JButton("Kembali");
        btnSet = new JButton("Total Harga");

        setLayout(null);
        add(labelJudul);
        add(labelnama);
        add(isnama);
        add(labelmassa);
        add(ismassa);
        add(labelharga);
        add(isharga);

        add(btnUpdate);
        add(btnDelete);
        add(btnBack);
        add(btnSet);

        labelJudul.setBounds(70,10,120,20);
        labelnama.setBounds(10,40,120,20);
        isnama.setBounds(130,40,190,20);
        labelmassa.setBounds(12,55,120,20);
        ismassa.setBounds(130,55,190,20);
        labelharga.setBounds(10,70,120,20);
        isharga.setBounds(130,70,190,20);
        
        btnSet.setBounds(130,185,90,20);
        btnSet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSet.addActionListener(this);
        btnBack.setBounds(10,260,90,20);
        btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBack.addActionListener(this);
        btnUpdate.setBounds(110,260,90,20);
        btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnUpdate.setBackground(Color.blue);
        btnUpdate.setForeground(Color.white);
        btnUpdate.addActionListener(this);
        btnDelete.setBounds(210,260,90,20);
        btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDelete.setBackground(Color.red);
        btnDelete.setForeground(Color.white);
        btnDelete.addActionListener(this);

        setResizable(false);
        setLocation(450,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==btnUpdate){
            Inputcontroller ic = new Inputcontroller();
            ic.updateBarang(id);
            dispose();
        }
        else if(e.getSource()==btnDelete){
            Inputcontroller d = new Inputcontroller();
            d.delete(id);
            dispose();
        }
        else{
            Inputcontroller d = new Inputcontroller();
            d.readBarang();
            dispose();
        }
    }
}

