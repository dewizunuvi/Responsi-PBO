package view;

import controller.Inputcontroller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Updateformview extends JFrame implements ActionListener {
    private JTextField fieldnama, fieldmassa, fieldharga;
    private JLabel labelJudul, labelnama, labelharga, labelmassa;
    private JButton btnSubmit, btnReset, btnBack;
    private String id, kode;

    public void openForm(String[] data){
        id = data[0];
        kode = data[1];
        setTitle("Update Barang");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,225);

        fieldnama = new JTextField(data[1],10);
        fieldmassa = new JTextField(data[2],10);
        fieldharga = new JTextField(data[3], 10);
        labelJudul = new JLabel(" Update Barang ");
        labelnama= new JLabel(" Nama Barang ");
        labelmassa = new JLabel(" Massa ");
        labelharga = new JLabel(" Harga ");
        btnSubmit = new JButton("Submit");
        btnReset = new JButton("Reset");
        btnBack = new JButton("Kembali");

        setLayout(null);
        add(labelJudul);
        add(fieldnama);
        add(labelnama);
        add(labelmassa);
        add(fieldmassa);
        add(labelharga);
        add(fieldharga);
        add(btnSubmit);
        add(btnReset);
        add(btnBack);

        labelJudul.setBounds(10,10,120,20);
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
                setMessage("Provinsi harus diisi");
            }
            if (fieldmassa.getText().equals("")) {
                setMessage("Kota harus diisi");
            }
            if (fieldharga.getText().equals("")) {
                setMessage("Kode daerah harus diisi");
            }
            else {
                String[] data = {
                        fieldnama.getText(), fieldmassa.getText(), fieldharga.getText(), id
                };
                Inputcontroller brg = new Inputcontroller();
                brg.updateBarang(data);
            }
        }
        else if(e.getSource()==btnReset){
            reset();
        }
        else if(e.getSource()==btnBack){
            dispose();
            Inputcontroller daerahController = new Inputcontroller();
            daerahController.readBarang(kode);
            dispose();
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

