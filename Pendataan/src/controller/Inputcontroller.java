package controller;

import model.Barangmodel;
import model.Inputmodel;
import view.*;
import view.Inputform;
import view.Menuview;
import view.Databarangview;

public class Inputcontroller {

    public void createBarang(){
        Inputform view = new Inputform();
        view.openForm();
    }

    public void createBarang(String[] data){
        Inputmodel input = new Inputmodel();
        input.createBarang(data);
    }

    public void readBarang(){
        Inputmodel model = new Inputmodel();
        String[][] data = model.readBarang();
        if(data == null)
            new Menuview();
        else
            new Barangview(data);
    }

    public void readBarang(String id){
        Inputmodel model = new Inputmodel();
        Databarangview view = new Databarangview();
        view.openDetail(model.readBarang(id));
    }

    public void updateBarang(String id){
        Inputmodel bm = new Inputmodel();
        String kode = bm.getData("nama", "massa", "harga", id);
        Updateformview update = new Updateformview();
        update.openForm(bm.readBarang(kode));
    }

    public void updateBarang(String[] data){
        Barangmodel bm = new Barangmodel();
        bm.updateData(data);
    }

    public void delete(String id){
        Barangmodel model = new Inputmodel();
        model.delete(id);
    }

    public void total(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
