/*****************************************************/
/* File: Project2.java                               */
/* CMIS242                                           */
/* Created by: James F. Gibson Jr                    */
/* Date: 11/2/2011                                   */
/*                                                   */
/*   Create a Java GUI app to contain:               */         
/*     3 Jtextfields fname, lname, age               */
/*     JComboBox to select statte of birth           */
/*     JRadioButton to select male or female         */
/*                                                   */
/*     Jtextfield and Jbutton to display             */
/*      enterd user info to text area                */
/*                                                   */
/*                                                   */
/*                                                   */
/*                                                   */
/*                                                   */
/*                                                   */
/*                                                   */
/*****************************************************/

package CMISProgrammingProject2;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;


public class Project2 extends JFrame {
    
    //Declare array for state names
    private String[] stateNames = {"AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA",
       "HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT",
       "NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN",
       "TX","UT","VT","VA","WA","WV","WI","WY"
    };
    
    //RadioButton Strings
     public static String maleString = "Male";
     public static String femaleString = "Female";

    
    //Define inputs
    private JTextField jtfFirstName = new JTextField(15);
    private JTextField jtfLastName = new JTextField(15);
    private JTextField jtfAge = new JTextField(3);
    private JRadioButton jrbMale, jrbFemale;
    private JTextArea textArea1 = new JTextArea(10,1);
    private JTextArea textArea2 = new JTextArea();
    
    //Button click to fill entered data field
        private JButton jbtClick = new JButton("Submit");
        
        //JComboBox
        private JComboBox jcbo1 = new JComboBox(stateNames);
        
        
    public Project2(){
        
        //Panel for Name and age
        JPanel panel1 = new JPanel();
        panel1.setLayout (new FlowLayout(FlowLayout.LEFT, 3,3));
        panel1.setBorder(new TitledBorder("Please enter your information and click the submit button"));
        panel1.add(new JLabel("First Name:"));
        panel1.add(jtfFirstName);
        panel1.add(new JLabel("Last name:"));
        panel1.add(jtfLastName);
        panel1.add(new JLabel("Your age:"));
        panel1.add(jtfAge);
      
        
        //Panel for ComboBox
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout (FlowLayout.LEFT, 5,5));
        panel2.add(new JLabel("Choose your State"));
        panel2.add(jcbo1);
        
        //Panel for RadioButtons
        JPanel radioButtons = new JPanel();
        radioButtons.add(new JLabel("Choose your sex"));
        radioButtons.add(jrbMale = new JRadioButton(maleString));
        jrbMale.setSelected(true);
        jrbMale.setActionCommand(maleString);
        radioButtons.add(jrbFemale = new JRadioButton(femaleString));
        jrbFemale.setActionCommand(femaleString);
        
        //Radio Buttons group
        ButtonGroup group1 = new ButtonGroup();
         group1.add(jrbMale);
         group1.add(jrbFemale);
         
         
         
        //Panel for submit Button
         JPanel panel3 = new JPanel();
         panel3.setLayout(new GridLayout(2,0));
         panel3.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
         panel3.add(jbtClick);
         //jbtClick.setPreferredSize(new Dimension(100,100));
        
         
       //JText Area1
         //JPanel textArea1 = new JPanel();
         textArea1.setLayout(new FlowLayout(FlowLayout.CENTER, 10,0));
         textArea1.setLineWrap(true);
         textArea1.setWrapStyleWord(true);
         textArea1.setFont(new Font("Courier", Font.BOLD, 14));
         
         //JText Area2
         //JPanel textArea2 = new JPanel();
         textArea2.setLayout(new FlowLayout(FlowLayout.CENTER, 1,0));
         textArea2.setLineWrap(false);
         textArea2.setWrapStyleWord(true);
         textArea2.setFont(new Font("Courier", Font.BOLD, 14));
         
         //Lock Output field
         textArea1.setEditable(false);
         textArea2.setEditable(false);
                
        //Add panels to frame
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.WEST);
        //add(radioButtons);
        add(panel3,BorderLayout.SOUTH);
        panel3.add(textArea1, BorderLayout.WEST);
        
        panel2.add(radioButtons, BorderLayout.CENTER);
        panel2.add(textArea2, BorderLayout.EAST);
        
        //Listener for button click
        jbtClick.addActionListener(new ButtonListener());
        
        
}
    
    
    //Button handler
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
        
        //Register a listener for the radio buttons.
        jrbMale.addActionListener(this);
        jrbFemale.addActionListener(this);
            
        int x = 0;
        
            //Retrieve entered values
            String fName = jtfFirstName.getText();
            String lName = jtfLastName.getText();
            String age = jtfAge.getText();
            
            
            // Test the value of age for an interger
          try{   
               x = Integer.parseInt(age);                
              } 
         
               
          catch(NumberFormatException ex){ 
                textArea2.setText("The age box requires an integer Ex. 25. Please enter an integer and click submit");
              }
          
       
        
            Object jcbo = jcbo1.getSelectedItem();
            Object rButton1 = e.getSource();
         
            if (rButton1 == jrbFemale)
              rButton1 = femaleString;
            
            else 
               rButton1 = maleString;
    
            //Display text to JTextArea            
            textArea1.setText("Your first name is: " +fName + "\n" +"Your last name is: "
                    + lName + "\n" +"Your age is: " + age + "\n" + "You reside in: " + jcbo 
                    + "\n" + "Your sex is: " + rButton1);

           
          
        }
    }
    
    


    
    public static void main(String[] args) {
       
        //Build frame
        Project2 frame = new Project2();
        frame.setTitle("James Gibson, CMIS242 7380, Project 2");
        frame.setSize(1100, 600); //Use if frame.pack doesnt not size properly
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //frame.pack();
        
        
    
    }
}
