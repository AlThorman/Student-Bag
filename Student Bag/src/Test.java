
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author althorman
 */
public class Test {
    public static void  main (String[] args) {
        
    LogIn login = new LogIn();
            login.getContentPane();
        login.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        login.setSize(150, 250);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    
}
}
