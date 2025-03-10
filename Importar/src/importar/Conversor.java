/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package importar;

import com.btmstudio.App;

import exportar.Exportar;

/**
 *
 * @author guill
 */
public class Conversor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String[] arguments = new String[]{"02041993"};
        App.main(arguments);
        
        Exportar exp = new Exportar();
       exp.setVisible(true);
    }
    
}
