/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author althorman
 */
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.awt.event.WindowAdapter;
 import java.awt.event.WindowEvent;
 import java.awt.FlowLayout;
 import java.awt.GridLayout;
 import java.util.List;
 import javax.swing.JButton;
 import javax.swing.Box;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JPanel;
 import javax.swing.JTextField;
 import javax.swing.WindowConstants;
 import javax.swing.BoxLayout;
 import javax.swing.BorderFactory;
 import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
public class Registration extends JFrame {
    
private StudentQueries StudentQueries;
private JLabel emailLabel;
private JTextField emailTextField;
private JLabel firstNameLabel;
private JTextField firstNameTextField;
private JLabel lastNameLabel;
private JTextField lastNameTextField;
private JLabel passwordL;
private JPasswordField passwordT;
private JLabel phoneLabel;
private JTextField phoneTextField;
private JPanel navigatePanel;
private JPanel displayPanel;
private JButton insertButton;


Registration (){
    
    super("Registration");
    StudentQueries = new StudentQueries();
    navigatePanel = new JPanel();
    displayPanel = new JPanel();
    firstNameLabel = new JLabel();
    firstNameTextField = new JTextField( 10 );
    lastNameLabel = new JLabel();
    lastNameTextField = new JTextField( 10 );
    passwordL = new JLabel();
    passwordT = new JPasswordField( 10 );
    emailLabel = new JLabel();
    emailTextField = new JTextField( 10 );
    phoneLabel = new JLabel();
    phoneTextField = new JTextField( 10 );
    insertButton = new JButton();
    
    setLayout( new FlowLayout( FlowLayout.CENTER, 10, 10 ) );
    setSize( 400, 300 );
    setResizable( false );
    navigatePanel.setLayout(
    new BoxLayout( navigatePanel, BoxLayout.X_AXIS ) );
   
navigatePanel.add( Box.createHorizontalStrut( 10 ) );
navigatePanel.add( Box.createHorizontalStrut( 10 ) );
navigatePanel.add( Box.createHorizontalStrut( 10 ) );
 add( navigatePanel );

 displayPanel.setLayout( new GridLayout( 5, 2, 4, 4 ) ); 
 firstNameLabel.setText( "First Name:" );
 displayPanel.add( firstNameLabel );
 displayPanel.add( firstNameTextField );

 lastNameLabel.setText( "Last Name:" );
 displayPanel.add( lastNameLabel );
 displayPanel.add( lastNameTextField );
 
 passwordL.setText( "Password:" );
 displayPanel.add( passwordL );
 displayPanel.add( passwordT );

 emailLabel.setText( "Email:" );
 displayPanel.add( emailLabel );
 displayPanel.add( emailTextField );

 phoneLabel.setText( "Phone Number:" );
 displayPanel.add( phoneLabel );
 displayPanel.add( phoneTextField );
 add( displayPanel );
insertButton.setText( "Register" );
insertButton.addActionListener(
   new ActionListener()
   {
      public void actionPerformed( ActionEvent evt )
      {
         insertButtonActionPerformed( evt );
      }
   }
        
); 
add( insertButton );
addWindowListener(
   new WindowAdapter()
   {
      public void windowClosing( WindowEvent evt )
      {
         StudentQueries.close(); 
    
         System.exit( 0 );
 } 
 } 
); 

 setVisible( true );
 } 

 


 private void insertButtonActionPerformed( ActionEvent evt )
{
    int result = StudentQueries.addStudent( firstNameTextField.getText(),
lastNameTextField.getText(),passwordT.getText() ,emailTextField.getText(),
phoneTextField.getText() );
    
    if (firstNameTextField.getText().isEmpty() || lastNameTextField.getText().isEmpty() || passwordT.getText().isEmpty() ||
            emailTextField.getText().isEmpty() || phoneTextField.getText().isEmpty())
    {
        JOptionPane.showMessageDialog( this, "You Have not Successfully Registered!","Error!", JOptionPane.ERROR_MESSAGE );
    }
    

    else if ( result == 1 )
   {
      JOptionPane.showMessageDialog( this, "You Have Successfully Registered!",
         "Successfully", JOptionPane.PLAIN_MESSAGE );
      setVisible(false);
   }
   else
      JOptionPane.showMessageDialog( this, "You Have not Successfully Registered!","Error!", JOptionPane.ERROR_MESSAGE );
} 

public static void main( String args[] )
{
    new Registration();
}

}



    

