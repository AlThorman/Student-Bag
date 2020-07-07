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
public class Contact extends JFrame {
 private Instructor currentEntry;
private InstructorQueries InstructorQueries;
private List< Instructor > results;
private int numberOfEntries = 0;
private int currentEntryIndex;
private JButton browseButton;
private JLabel emailLabel;
private JTextField emailTextField;
private JLabel firstNameLabel;
private JTextField firstNameTextField;
private JTextField indexTextField;
private JLabel lastNameLabel;
private JTextField lastNameTextField;
private JTextField maxTextField;
private JButton nextButton;
private JLabel ofLabel;
private JLabel courseLabel;
private JTextField courseTextField;
private JLabel departmentLabel;
private JTextField departmentTextField;
private JButton previousButton;
private JButton queryButton;
private JLabel queryLabel;
private JPanel queryPanel;
private JPanel navigatePanel;
private JPanel displayPanel;
private JTextField queryTextField;
private JButton insertButton;


Contact (){
    
    super("Contact an Instructor");
    InstructorQueries = new InstructorQueries();
   
    navigatePanel = new JPanel();
    previousButton = new JButton();
    indexTextField = new JTextField( 2 );
    ofLabel = new JLabel();
    maxTextField = new JTextField( 2 );
    nextButton = new JButton();
    displayPanel = new JPanel();
    firstNameLabel = new JLabel();
    firstNameTextField = new JTextField( 20 );
    
    lastNameLabel = new JLabel();
    lastNameTextField = new JTextField( 20 );
    emailLabel = new JLabel();
    emailTextField = new JTextField( 20 );
    courseLabel = new JLabel();
    courseTextField = new JTextField( 20 );
    departmentLabel = new JLabel();
    departmentTextField = new JTextField( 20 );
    queryPanel = new JPanel();
    queryLabel = new JLabel();
    queryTextField = new JTextField( 20 );
    queryButton = new JButton();
    browseButton = new JButton();
    insertButton = new JButton();
    
    setLayout( new FlowLayout( FlowLayout.CENTER, 10, 10 ) );
    setSize( 550, 350 );
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
   // setResizable( false );
    navigatePanel.setLayout(
    new BoxLayout( navigatePanel, BoxLayout.X_AXIS ) );
    previousButton.setText( "Previous" );
    previousButton.setEnabled( false );
    previousButton.addActionListener(
    new ActionListener()
   {
      public void actionPerformed( ActionEvent evt )
      {
         previousButtonActionPerformed( evt );
      } 
   } 
); 
navigatePanel.add( previousButton );
navigatePanel.add( Box.createHorizontalStrut( 10 ) );
indexTextField.setHorizontalAlignment(
   JTextField.CENTER );
indexTextField.addActionListener(
   new ActionListener()
   {
      public void actionPerformed( ActionEvent evt )
      {
         indexTextFieldActionPerformed( evt );
      } 
   } 
); 
navigatePanel.add( indexTextField );
navigatePanel.add( Box.createHorizontalStrut( 10 ) );
ofLabel.setText( "of" );
navigatePanel.add( ofLabel );
navigatePanel.add( Box.createHorizontalStrut( 10 ) );
    
maxTextField.setHorizontalAlignment(
JTextField.CENTER );
 maxTextField.setEditable( false );
 navigatePanel.add( maxTextField );
 navigatePanel.add( Box.createHorizontalStrut( 10 ) );

 nextButton.setText( "Next" );
 nextButton.setEnabled( false );
 nextButton.addActionListener(
 new ActionListener()
 {
 public void actionPerformed( ActionEvent evt )
 {
 nextButtonActionPerformed( evt );
 } 
 } 
 ); 

 navigatePanel.add( nextButton );
 add( navigatePanel );

 displayPanel.setLayout( new GridLayout( 5, 2, 4, 4 ) ); 



 firstNameLabel.setText( "First Name:" );
 displayPanel.add( firstNameLabel );
 displayPanel.add( firstNameTextField );

 lastNameLabel.setText( "Last Name:" );
 displayPanel.add( lastNameLabel );
 displayPanel.add( lastNameTextField );

 emailLabel.setText( "Email:" );
 displayPanel.add( emailLabel );
 displayPanel.add( emailTextField );

 courseLabel.setText( "Course:" );
 displayPanel.add( courseLabel );
 displayPanel.add( courseTextField );
 
 departmentLabel.setText( "Department:" );
 displayPanel.add( departmentLabel );
 displayPanel.add( departmentTextField );
 
 add( displayPanel );

 queryPanel.setLayout(
 new BoxLayout( queryPanel, BoxLayout.X_AXIS) );

 queryPanel.setBorder( BorderFactory.createTitledBorder(
 "Find an entry by last name" ) );
 queryLabel.setText( "Last Name:" );
   
queryPanel.add( Box.createHorizontalStrut( 5 ) );
queryPanel.add( queryLabel );
queryPanel.add( Box.createHorizontalStrut( 10 ) );
queryPanel.add( queryTextField );
queryPanel.add( Box.createHorizontalStrut( 10 ) );
queryButton.setText( "Find" );
queryButton.addActionListener(
   new ActionListener()
   {
      public void actionPerformed( ActionEvent evt )
      {
         queryButtonActionPerformed( evt );
      }
   }
        
); 
queryPanel.add( queryButton );
queryPanel.add( Box.createHorizontalStrut( 5 ) );
add( queryPanel );
browseButton.setText( "Browse All Entries" );
browseButton.addActionListener(
   new ActionListener()
   {
      public void actionPerformed( ActionEvent evt )
      {
         browseButtonActionPerformed( evt );
      }
   }
        
); 
add( browseButton );
insertButton.setText( "Insert New Entry" );
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
         InstructorQueries.close(); 
    
         System.exit( 0 );
 } 
 } 
); 

 setVisible( true );
 } 

 
private void previousButtonActionPerformed( ActionEvent evt )
 {
 currentEntryIndex--;

 if ( currentEntryIndex < 0 )
 currentEntryIndex = numberOfEntries - 1;

 indexTextField.setText( "" + ( currentEntryIndex + 1 ) );
 indexTextFieldActionPerformed( evt );
 } 

 
 private void nextButtonActionPerformed( ActionEvent evt )
 {
 currentEntryIndex++;

if ( currentEntryIndex >= numberOfEntries )
 currentEntryIndex = 0;

 indexTextField.setText( "" + ( currentEntryIndex + 1 ) );
 indexTextFieldActionPerformed( evt );
 } 

 private void queryButtonActionPerformed( ActionEvent evt )
 {

results =
InstructorQueries.getInstructorByLastName( queryTextField.getText() );
numberOfEntries = results.size();
if ( numberOfEntries != 0 )
{
   currentEntryIndex = 0;
   currentEntry = results.get( currentEntryIndex );
   firstNameTextField.setText( currentEntry.getFirstName() );
   lastNameTextField.setText( currentEntry.getLastName() );
   emailTextField.setText( currentEntry.getEmail() );
   courseTextField.setText( currentEntry.getCourse() );
   departmentTextField.setText( currentEntry.getDepartment() );
   maxTextField.setText( "" + numberOfEntries );
   indexTextField.setText( "" + ( currentEntryIndex + 1 ) );
   nextButton.setEnabled( true );
   previousButton.setEnabled( true );
   }

    else
    browseButtonActionPerformed( evt );

 }   
 private void indexTextFieldActionPerformed( ActionEvent evt )
 {
     currentEntryIndex =
   ( Integer.parseInt( indexTextField.getText() ) - 1 );
     
     if
( numberOfEntries != 0 && currentEntryIndex < numberOfEntries )
{
   currentEntry = results.get( currentEntryIndex );
   firstNameTextField.setText( currentEntry.getFirstName() );
   lastNameTextField.setText( currentEntry.getLastName() );
   emailTextField.setText( currentEntry.getEmail() );
   courseTextField.setText( currentEntry.getCourse() );
   departmentTextField.setText( currentEntry.getDepartment() );
   maxTextField.setText( "" + numberOfEntries );
   indexTextField.setText( "" + ( currentEntryIndex + 1 ) );
     
     
 }

 } 

 private void browseButtonActionPerformed( ActionEvent evt )
 {
 try
 {
 results = InstructorQueries.getAllInstructor();
 numberOfEntries = results.size();

 if ( numberOfEntries != 0 )
 {
     currentEntryIndex = 0;
currentEntry = results.get( currentEntryIndex );
firstNameTextField.setText( currentEntry.getFirstName() );
lastNameTextField.setText( currentEntry.getLastName() );
emailTextField.setText( currentEntry.getEmail() );
courseTextField.setText( currentEntry.getCourse() );
departmentTextField.setText( currentEntry.getDepartment() );
maxTextField.setText( "" + numberOfEntries );
indexTextField.setText( "" + ( currentEntryIndex + 1 ) );
nextButton.setEnabled( true );
previousButton.setEnabled( true );

}
 }
 catch ( Exception e )
 {
      e.printStackTrace();

 }
 }
 private void insertButtonActionPerformed( ActionEvent evt )
{
    int result = InstructorQueries.addInstructor( firstNameTextField.getText(),
lastNameTextField.getText(), emailTextField.getText(),
courseTextField.getText(),departmentTextField.getText() );

   if ( result == 1 )
      JOptionPane.showMessageDialog( this, "Person added!",
         "Person added", JOptionPane.PLAIN_MESSAGE );
   else
      JOptionPane.showMessageDialog( this, "Person not added!",
         "Error", JOptionPane.PLAIN_MESSAGE );
   browseButtonActionPerformed( evt );
} 

public static void main( String args[] )
{
    new Contact();
    
}

}



    

   
    

