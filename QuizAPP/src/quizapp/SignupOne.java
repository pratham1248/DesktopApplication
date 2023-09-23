
package quizapp;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;



public class SignupOne extends JFrame implements ActionListener{

    JButton next;
    long randno;
    JTextField nametextfield,fnametextfield,emailtextfield,addtextfield,citytextfield,statetextfield,pincodetextfield;
    
    JRadioButton male,female,married,unmarried,other;
    
    
       SignupOne()
    {
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        
        Random ran = new Random();
        randno=Math.abs((ran.nextLong()%9000L)+1000L);
        
        JLabel name1=new JLabel("Signup");
        name1.setFont(new Font("Raleway",Font.BOLD,34));
        name1.setBounds(350,80,500,50);
        add(name1);
        
        JLabel name=new JLabel("First Name:");
        name.setFont(new Font("Raleway",Font.BOLD,24));
        name.setBounds(100,140,200,40);
        add(name);
        
        nametextfield=new JTextField();
        nametextfield.setBounds(320, 142,400, 30);
        nametextfield.setFont(new Font("Raleway",Font.BOLD,18));
        add(nametextfield);
        
        JLabel fname=new JLabel("Last Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,24));
        fname.setBounds(100,180,200,40);
        add(fname);
        
        fnametextfield=new JTextField();
        fnametextfield.setBounds(320, 182,400, 30);
        fnametextfield.setFont(new Font("Raleway",Font.BOLD,18));
        add(fnametextfield);
        
        
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,24));
        gender.setBounds(100,260,200,40);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(320,260,100,40);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Raleway",Font.BOLD,20));
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(420,260,100,40);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Raleway",Font.BOLD,20));
        add(female);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email=new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD,24));
        email.setBounds(100,300,200,40);
        add(email);
        
        emailtextfield=new JTextField();
        emailtextfield.setBounds(320, 302,400, 30);
        emailtextfield.setFont(new Font("Raleway",Font.BOLD,18));
        add(emailtextfield);
        
        
        JLabel address=new JLabel("Password:");
        address.setFont(new Font("Raleway",Font.BOLD,24));
        address.setBounds(100,380,200,40);
        add(address);
        
        addtextfield=new JTextField();
        addtextfield.setBounds(320, 382,400, 30);
        addtextfield.setFont(new Font("Raleway",Font.BOLD,18));
        add(addtextfield);
        
        JLabel city=new JLabel("ReEnter Password:");
        city.setFont(new Font("Raleway",Font.BOLD,24));
        city.setBounds(100,420,250,40);
        add(city);
        
        citytextfield=new JTextField();
        citytextfield.setBounds(320, 422,400, 30);
        citytextfield.setFont(new Font("Raleway",Font.BOLD,18));
        add(citytextfield);
        
       
        next=new JButton("Submit");
        next.setBounds(625,562,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        next.setFont(new Font("Raleway",Font.BOLD,20));
        add(next);
        
        setSize(800,780);
        setVisible(true);
        setLocation(400,100);
        
        
    }
       
     public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==next)
        {
            
            String name=nametextfield.getText();            
            String fname=fnametextfield.getText();   
            
            String gender=null;
            if(male.isSelected())
            {
               gender="Male"; 
            }
            else if(female.isSelected())
            {
                gender="Female"; 
            }
            String email=emailtextfield.getText();
            
            
            String address=addtextfield.getText();
            String city=citytextfield.getText();
            
            try{
                if(name.equals(""))
                {
                    //JOptionPane.showMessageDialog(null, "Name is required"); 
                    //Validation can be added by us
                }
                else
                {
                    Conn c=new Conn();
                    //query
                    String query="insert into login values('" +name +"','" +fname+"','"+email+ "','"+address+"' );";
                    new Login();
                    /*
                    INSERT INTO table_name (column1, column2, column3, ...)
                    VALUES (value1, value2, value3, ...);
                    
                    */
                    
                    
                    c.s.executeUpdate(query);
                    
                }
            }catch(Exception e){
                System.out.println(e);
            }
            //next page
            this.dispose();
    
            
            
        }
      
    }
    public static void main(String args[]) {
        // TODO code application logic here
        new SignupOne();
    }
}