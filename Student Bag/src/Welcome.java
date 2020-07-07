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

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
public class Welcome extends JFrame {
    private JLabel kfuIconL;
    private JLabel welcomL;
    private Icon icon;
    private JButton Contact;
    private JButton Calculator;
    private JButton Schedule;
    private JButton Jour;
    private JMenuBar MenuBar;
    private JMenu Menu;
    private JMenuItem About;
    
    public static void main (String[] args ){
      Welcome welcome  = new Welcome();
        welcome.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        welcome.setSize(400, 360);
        welcome.setVisible(true);
        
        
    }
    
  
    
    public Welcome (){
        super ("Welcome");
        
        setLayout(new FlowLayout());
         MenuBar = new JMenuBar();
         Menu = new JMenu ("File");
         About = new JMenuItem("About");
         Menu.add(About);
         MenuBar.add(Menu);
         setJMenuBar(MenuBar);
         icon = new ImageIcon (getClass().getResource("1.png"));
        kfuIconL = new JLabel (icon);
         welcomL = new JLabel ("Welcome to Student bag Application");
        Font font = new Font ("Serif",Font.BOLD,20);
        welcomL.setFont(font);
        add(kfuIconL);
        add(welcomL);
        Contact = new JButton ("Contact with an Instructor");
        Calculator = new JButton ("Calculator");
        Schedule = new JButton ("Schedule");
        Jour = new JButton ("Your Journey in the College");
        Contact.setToolTipText("First In First Out Replacement Algorithm");
        Calculator.setToolTipText("Least Recently Used Replacement Algorithm");
        add(Contact);
        add(Calculator);
        add(Schedule);
        add(Jour); 
        ButtonHandler handler = new ButtonHandler();
        Contact.addActionListener(handler);
        Calculator.addActionListener(handler);
        Schedule.addActionListener(handler);
        Jour.addActionListener(handler);
        
        About.addActionListener(
                new ActionListener ()
                {
                    public void actionPerformed (ActionEvent e){
            JOptionPane.showMessageDialog(null, "Made by:\nAbdulRahman AlThorman\nInstructor:\nDr. Nauman Qureshi" , "About", JOptionPane.PLAIN_MESSAGE);
                    }});
        


    }
    private class ButtonHandler implements ActionListener
    {
    @Override
    public void actionPerformed (ActionEvent e){

        if (e.getSource()== Contact)
        {

        	Contact Contact  = new Contact();
        Contact.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Contact.setSize(550, 350);
        Contact.setVisible(true);
        
        }
        if (e.getSource()== Calculator)
        {


            Calc c  = new Calc();
        c.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        c.setSize(350,500);
        c.setVisible(true);
        
        }
        if (e.getSource()== Schedule)
        {


            Schedule Schedule  = new Schedule();
        Schedule.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Schedule.setSize(564, 536);
        Schedule.setVisible(true);
        
        }
        if (e.getSource()== Jour)
        {


            Jour Jour  = new Jour();
        Jour.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Jour.setSize( 800, 500 );
        Jour.setVisible(true);
        
        }
    }
    }
    
}
