
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author althorman
 */
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPasswordField;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class LogIn extends JFrame {
    static String email;
    private StudentQueries StudentQueries;
    private List< Student > results;
    private int numberOfEntries = 0;
    private JLabel EmailL;
    private JLabel PassL;
    private JTextField EmailT;
    private JPasswordField PassT;
    private JButton Log;
    private JButton Reg;
    private JMenuBar MenuBar;
    private JMenu Menu;
    private JMenuItem AboutMe;
    
    LogIn (){
       super ("LogIn");
       setLayout(new FlowLayout()); 
       StudentQueries = new StudentQueries();
       MenuBar = new JMenuBar();
         Menu = new JMenu ("File");
         AboutMe = new JMenuItem("About");
       EmailL = new JLabel ("Email: ");
       PassL = new JLabel ("Password: "); 
       EmailT = new JTextField (10);
       PassT = new JPasswordField (10);
       Log = new JButton ("LogIn");
       Reg = new JButton ("Registration");
       Menu.add(AboutMe);
       MenuBar.add(Menu);
       setJMenuBar(MenuBar);
       
        add(EmailL);
        add(EmailT);
        add(PassL);
        add(PassT);
        add(Log);
        add(Reg);
        
        ButtonHandler handler = new ButtonHandler();
        Log.addActionListener(handler);
        Reg.addActionListener(handler);
        AboutMe.addActionListener(
                new ActionListener ()
                {
                    public void actionPerformed (ActionEvent e){
            JOptionPane.showMessageDialog(null, "Made by:\nAbulRahman AlThorman\n" , "About", JOptionPane.PLAIN_MESSAGE);
                    }});
        
        
    }

    
    
    private class ButtonHandler implements ActionListener
    {
    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource() == Log)
        {
            

results =
StudentQueries.login( EmailT.getText(),PassT.getText() );
numberOfEntries = results.size();
if ( numberOfEntries != 0 )
{email = EmailT.getText();

   JOptionPane.showMessageDialog(null, "You have Logged in Successfully ", "Successfully!", JOptionPane.PLAIN_MESSAGE);
   
        Welcome welcome  = new Welcome();
        welcome.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        welcome.setSize(400, 360);
        welcome.setVisible(true);
        setVisible(false);
        
   }
else {
    JOptionPane.showMessageDialog(null, "Incorrect Input!" , "Incorrect Input!", JOptionPane.ERROR_MESSAGE);
    
}
    }
        if (e.getSource() == Reg)
        {	Registration Registration  = new Registration();
        Registration.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Registration.setSize( 400, 300 );
        Registration.setVisible(true);
            
        }
    }
}
    
    public String getEmail ()
    {
        return email ;
    }
   
}

    
