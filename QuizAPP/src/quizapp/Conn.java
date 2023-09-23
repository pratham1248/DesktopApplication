package quizapp;

import java.sql.*;

public class Conn {
       Connection c;
       Statement s;
       public Conn()
       {
           try{
               
               c = DriverManager.getConnection("jdbc:mysql://aws-rds.cbht2ghmproo.ap-northeast-1.rds.amazonaws.com:3306/mydata", "admin", "Prathamesh");
               //c=DriverManager.getConnection("jdbc:mysql:///mydata","admin","Prathamesh");
               s=c.createStatement();
                
             }
           catch(Exception e){
               System.out.println(e);}
       }
}
