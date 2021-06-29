package view;

import controller.Inputcontroller;
import controller.Menucontroller;
import exception.Dataerror;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inputform extends JFrame implements ActionListener {
    private JTextField fieldnama, fieldmassa, fieldharga;
    private JLabel labelJudul, labelnama, labelmassa, labelharga;
    private JSpinner massa, harga;

    private JButton btnSubmit, btnReset, btnBack;

    public void openForm(){
        setTitle("Input Barang");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,225);

        labelJudul = new JLabel(" Input Barang ");
        fieldnama = new JTextField(5);
        labelnama = new JLabel(" Nama Barang ");
        fieldnama = new JTextField(99);
        labelmassa = new JLabel(" Massa ");
        fieldmassa = new JTextField(10);
        labelharga = new JLabel(" Harga ");
        fieldharga = new JTextField(10);
        btnSubmit = new JButton("Submit");
        btnReset = new JButton("Reset");
        btnBack = new JButton("Kembali");

        setLayout(null);
        add(labelJudul);
        add(labelnama);
        add(fieldnama);
        add(labelmassa);
        add(fieldmassa);
        add(labelharga);
        add(fieldharga);
        add(btnSubmit);
        add(btnReset);
        add(btnBack);

        labelJudul.setBounds(100,10,120,20);
        labelnama.setBounds(10,35,120,20);
        fieldnama.setBounds(130,35,190,20);
        labelmassa.setBounds(10,60,120,20);
        fieldmassa.setBounds(130,60,190,20);
        labelharga.setBounds(10,85,120,20);
        fieldharga.setBounds(130,85,190,20);
        btnSubmit.setBounds(75,125,120,20);
        btnSubmit.setBackground(Color.blue);
        btnSubmit.setForeground(Color.white);
        btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSubmit.addActionListener(this);
        btnReset.setBounds(200,125,120,20);
        btnReset.setBackground(Color.red);
        btnReset.setForeground(Color.white);
        btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnReset.addActionListener(this);
        btnBack.setBounds(10,155,320,20);
        btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBack.addActionListener(this);

        setResizable(false);
        setLocation(450,200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSubmit) {
            if (fieldnama.getText().equals("")) {
                setMessage("Nama Barang tidak boleh kosong");
            }
            if(fieldmassa.getText().equals("")){
                setMessage("Massa barang harus diisi");
            }
            if(fieldharga.getText().equals("")){
                setMessage("Harga harus diisi");
            }
            if(Integer.valueOf(fieldmassa.getText())<0){
                    setMessage("Massa harus bernilai positif");
            }
            if(Integer.valueOf(fieldharga.getText())<0){
                    setMessage("Harga harus bernilai positif");
            }
           
            else {
                    String[] data = {
                            fieldnama.getText(),
                            fieldmassa.getText(),
                            fieldharga.getText()
                   };
                    Inputcontroller barang = new Inputcontroller();
                    barang.createBarang(data);
                 }

        }
        else if(e.getSource()==btnReset){
            reset();
        }
        else if(e.getSource()==btnBack){
            dispose();
            Menucontroller m = new Menucontroller();
            m.openMenu();
        }
    }

    public void reset(){
        fieldnama.setText("");
        fieldmassa.setText("");
        fieldharga.setText("");
    }

    public void setMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}

