/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataan;

import controller.Menucontroller;

/**
 *
 * @author ASUS
 */
public class Pendataan {

    public static void main(String[] args) {
        Connectdb connect = new Connectdb();
        Menucontroller menu = new Menucontroller();
        menu.openMenu();
    }
    
}
