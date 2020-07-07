import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
public class Jour extends JFrame
{
    int size;
private JList courseJList; 
private JList copyJList; 
private JButton copyJButton;
private JButton countJButton;
private JScrollPane JScrollPane;
private static final String[] colorNames = { "Introduction to Computing", "Fundamentals of IS", "Calculus",
      "Physics", "Islamic Creed & Contemporary Doctrines", "Fund. of Programming", "Electronics", "Biology",
      "Intro. To Statistics & Probability Theory","Islamic & Profession’s Morals",
      "Object Oriented Prog. (1)", "Data Structure", "Technical Reports","Digital Hardware",
      "Com. & Network Fund.","Discrete Math","Object Oriented Prog. (2)","Operating Systems",
      "Database Concepts & Design","Net. Protocols & E-Commerce Technology","Business (1)",
      "Software Engineering","Algorithms Analysis & Design","Professional Responsibility",
      "Computer Organization","Logic & proof Techniques","University Elective Course 1",
      "PhysiComputer Data Security & Privacycs","Language Theory & Finite Automata","Human Computer Interaction",
      "Web-Based Systems","Numerical Analysis","Project Proposal","Artificial Intelligence","Mobile Computing",
      "Program Elective Course 1","University Elective Course 2","Project Implementation",
      "Selected Topics in CS","Program Elective Course 2","Program Elective Course 2" };
   
   public Jour()
   {
      super( "Journey" );
      setLayout( new FlowLayout() ); 
      courseJList = new JList( colorNames ); 
      courseJList.setVisibleRowCount( 20 );
      courseJList.setFixedCellWidth(200);
      courseJList.setSelectionMode(
ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
      add( new JScrollPane( courseJList ) ); 
   

      copyJButton = new JButton( "Copy >>>" ); 
      copyJButton.addActionListener(
         new ActionListener() 
         {
          
            public void actionPerformed( ActionEvent event )
            {
               
               copyJList.setListData( courseJList.getSelectedValues() );
            } 
         } 
      ); 
      countJButton = new JButton( "Count" ); 
      countJButton.addActionListener(
         new ActionListener() 
         {
          
            public void actionPerformed( ActionEvent event )
            {int count=41;
               
               size=copyJList.getModel().getSize();
               
               if (size <=10 && size>=0)
{count=count-size;
    JOptionPane.showMessageDialog(null, "Remaining: " +count+"\nYou still have a long journey to graduate -_-\nWork hard to reach Your goal" , "Journey", JOptionPane.PLAIN_MESSAGE);
}
else if (size <=20 && size>=11)
{count=count-size;
   JOptionPane.showMessageDialog(null,"Remaining: " +count+ "\nYou are in the middle of your journey to graduate ^_-\nKeep the hard work" , "Journey", JOptionPane.PLAIN_MESSAGE); 
}
else if (size <=40 && size>=21)
{count=count-size;
   JOptionPane.showMessageDialog(null,"Remaining: " +count+ "\nYou are almost finish your journey to graduate ^_^\nDon't give up" , "Journey", JOptionPane.PLAIN_MESSAGE); 
}
else if (size <=41)
{count=count-size;
   JOptionPane.showMessageDialog(null,"Remaining: " +count+ "\nCongratulations on your graduation ^_^\nHave a nice life","Journey", JOptionPane.PLAIN_MESSAGE); 
}

            } 
         } 
      ); 
      add( copyJButton );
      add( countJButton );
      copyJList = new JList();
      copyJList.setVisibleRowCount( 20 );
      
      copyJList.setFixedCellWidth( 200 );
copyJList.setSelectionMode(
ListSelectionModel.SINGLE_INTERVAL_SELECTION );

add( new JScrollPane( copyJList ) );





      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
      setSize( 800, 500 ); 
      setVisible( true );


   }
   public static void main(String...s)
	{
		new Jour();
	}
}