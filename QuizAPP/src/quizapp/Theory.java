
package quizapp;

import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;

public class Theory extends JFrame implements ActionListener{

    static String[][][][] strArr = ControllerClass.ExamTheoryQuestions(45);
    static String[][][][] Pra_arr=ControllerClass.ExamPracticalQuestions(30);
    static JButton END,Pratical,Objective,Pratical1,Objective1,Pratical2,Objective2,Next,Previous,Submit;
    static JLabel lT,lP,l2,l3,l4;
    static JButton b1;
    static JRadioButton jb[]=new JRadioButton[4];    
    static ButtonGroup bg;
    static public int userscreenwidth,userscreenheight;
    static int current=0;
    static int current2=0;
    static int sec=0,level=0;
    static JFrame frame;
    public Timer timer;
    public int timeLeft = 1800;
    JLabel timerLabel;
    static ActionListener listener;
    static String [] ans; //For storing answers of exam
    static int M=0;
    
    static JButton One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten,Eleven,Twelve,Thirteen,Fourteen,Fifteen;
    static JButton [] btn={One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten,Eleven,Twelve,Thirteen,Fourteen,Fifteen}; 
    static JButton [] btn2={One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten};
    static JButton [] btn3={One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten,Eleven,Twelve,Thirteen,Fourteen,Fifteen};
    static JButton [] btn4={One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten};
    static JButton [] btn5={One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten,Eleven,Twelve,Thirteen,Fourteen,Fifteen};
    static JButton [] btn6={One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten};
    
    static int numberofTquePerSec;
    static int numberofPquePerSec;
    static JPanel centerPanel2,centerPanel3,centerPanel4,centerPanel5,centerPanel6,centerPanel7;
    Theory()
    {
        frame = new JFrame("My Frame");
        frame.setLayout(null);
        frame.setTitle("ExamPage");
    
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizes the window to fill the entire screen
        frame.setAlwaysOnTop(true);
        
         userscreenwidth = screenSize.width;
         userscreenheight = screenSize.height;
         
         ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icons/User.jpeg"));
        Image i11=i10.getImage().getScaledInstance(150, 150, WIDTH);
        ImageIcon i12=new ImageIcon(i11);
        JLabel label5=new JLabel(i12);
        label5.setBounds(userscreenwidth*2/200,userscreenheight*7/200,userscreenwidth/12,userscreenwidth/10);
        frame.add(label5); 
        
        String name="Prathamesh Sanjay Mandave";
        JLabel l5=new JLabel("Candidate's Name:");
        l5.setFont(new Font("System",Font.BOLD,22));
        l5.setBounds(20,20,50,25);
        JLabel Name=new JLabel(name);
        Name.setBounds(10,10,20,20);
        Name.setFont(new Font("System",Font.BOLD,18));
   
        String name2="1956";
        JLabel l6=new JLabel("Application Number:");
        l6.setFont(new Font("System",Font.BOLD,22));
        JLabel Name2=new JLabel(name2);
        Name2.setFont(new Font("System",Font.BOLD,18));
        
        JPanel centerPanel = new JPanel();
            
            centerPanel.add(l5);
            centerPanel.add(Name);
            
            centerPanel.add(l6);
            centerPanel.add(Name2);
           
            
            centerPanel.setBackground(new Color(200, 220, 240));
            centerPanel.setLayout(new GridLayout(2, 2));
            centerPanel.setBounds(userscreenwidth*2/20,userscreenheight*7/200,userscreenwidth*2/5,userscreenwidth/10);
            frame.add(centerPanel,BorderLayout.PAGE_START);
        
        Next=new JButton("Next");
        Next.setBounds(userscreenwidth*19/100,(userscreenheight*3)/4, 100, 30);
        Next.setFont(new Font("Arial", Font.PLAIN, 24));
        Next.addActionListener(this);
        Next.setBorder(BorderFactory.createRaisedBevelBorder());
        Next.setOpaque(true);
        
        frame.add(Next);
        
        Next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Next.setBackground(new Color(220, 240, 220));
                Next.setForeground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Next.setBackground(UIManager.getColor("Button.background"));
                Next.setForeground(UIManager.getColor("Button.foreground"));
            }
        });
        
        Previous=new JButton("Previous");
        Previous.setBounds(userscreenwidth/10,(userscreenheight*3)/4, 100, 30);
        Previous.setFont(new Font("Arial", Font.PLAIN, 24));
        Previous.addActionListener(this);
        Previous.setBorder(BorderFactory.createRaisedBevelBorder());
        Previous.setOpaque(true);
        frame.add(Previous);
        
        Previous.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Previous.setBackground(new Color(220, 240, 220));
                Previous.setForeground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Previous.setBackground(UIManager.getColor("Button.background"));
                Previous.setForeground(UIManager.getColor("Button.foreground"));
            }
            
        });
        
        END=new JButton("END EXAMINATION");
        END.setBounds(userscreenwidth*80/100,(userscreenheight*85)/100, 250, 30);
        END.setFont(new Font("Arial", Font.PLAIN, 24));
        END.setBackground(new Color(255, 200, 200));
        END.setForeground(Color.BLACK);
        END.addActionListener(this);
        END.setBorder(BorderFactory.createRaisedBevelBorder());
        END.setOpaque(true);
        frame.add(END);
        
        timerLabel = new JLabel("Time left: " + getTimeString(timeLeft)+"!!!");
        timerLabel.setBounds(userscreenwidth*120/144,(userscreenheight)*12/100,userscreenwidth*2/15,userscreenwidth/15);
        timerLabel.setForeground(Color.red);
        timerLabel.setFont(new Font("System",Font.BOLD,20));
        frame.add(timerLabel);
        
        ImageIcon i25=new ImageIcon(ClassLoader.getSystemResource("icons/clock.png"));
        Image i26=i25.getImage().getScaledInstance(userscreenwidth/13, userscreenwidth/13, WIDTH);
        ImageIcon i27=new ImageIcon(i26);
        JLabel label28=new JLabel(i27);
        label28.setBounds(userscreenwidth*123/144,(userscreenheight)*5/100,userscreenwidth/13,userscreenwidth/13);
        frame.add(label28); 
        
        
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                timerLabel.setText("Time left: " + getTimeString(timeLeft)+"!!!");
                if (timeLeft == 0) {
                    dispose();
                }
            }
        });
        timer.start();
        
        numberofTquePerSec=(ControllerClass.Theoryquestions)/3;
        numberofPquePerSec=(ControllerClass.Practicalquestions)/3;
        ans=new String[ControllerClass.Theoryquestions]; 
        
        JLabel j=new JLabel("Question Number");
        j.setBounds(userscreenwidth*56/72,userscreenheight*45/100, 200, 30);
        j.setFont(new Font("Arial", Font.PLAIN, 24));
        j.setForeground(Color.black);
        frame.add(j);
        
        JButton answ=new JButton();
        answ.setBounds(userscreenwidth*26/36,(userscreenheight)*41/100, 30, 30);
        answ.setFont(new Font("Arial", Font.PLAIN, 24));
        answ.setBackground(Color.green);
        frame.add(answ);
        
        JLabel j2=new JLabel("Answered Que");
        j2.setBounds(userscreenwidth*107/144,(userscreenheight)*41/100, 150, 30);
        j2.setFont(new Font("Arial", Font.PLAIN, 20));
        j2.setForeground(Color.black);
        frame.add(j2);
        
        JButton unans=new JButton();
        unans.setBounds(userscreenwidth*30/36,(userscreenheight)*41/100, 30, 30);
        unans.setFont(new Font("Arial", Font.PLAIN, 24));
        unans.setBackground(Color.red);
        frame.add(unans);
        
        JLabel j1=new JLabel("Unanswered Que");
        j1.setBounds(userscreenwidth*123/144,(userscreenheight)*41/100, 180, 30);
        j1.setFont(new Font("Arial", Font.PLAIN, 20));
        j1.setForeground(Color.black);
        frame.add(j1);    
            
        Submit=new JButton("SUBMIT");
        Submit.setBounds(userscreenwidth*29/100,(userscreenheight*3)/4, 150, 30);
        Submit.setFont(new Font("Arial", Font.PLAIN, 24));
        Submit.setBorder(BorderFactory.createRaisedBevelBorder());
        Submit.setOpaque(true);
        Submit.addActionListener(this);
        frame.add(Submit);
        
        Submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Submit.setBackground(new Color(255, 200, 200));
                Submit.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Submit.setBackground(UIManager.getColor("Button.background"));
                Submit.setForeground(UIManager.getColor("Button.foreground"));
            }
        });
        Submit.repaint();
       
        b1=new JButton("Perform Actions");
        b1.setBounds(userscreenwidth*329/800,(userscreenheight)*100/200, 225, 50);
        b1.setFont(new Font("Arial", Font.PLAIN, 20));
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.DARK_GRAY);
        b1.addActionListener(this);
        b1.setBorder(BorderFactory.createRaisedBevelBorder());
        b1.setOpaque(true);
        frame.add(b1);
        
        b1.setVisible(false);
        
       lP=new JLabel();
            lP.setFont(new Font("System",Font.BOLD,20));
            lP.setBounds(userscreenwidth*1/10,userscreenheight*39/100,1600,50);
            lP.setText(Pra_arr[0][0][0][1]);
            frame.add(lP);
            lP.setVisible(false);
        
        Objective=new JButton("Objective");
        Objective.setBounds(userscreenwidth*55/800,(userscreenheight)*53/200, 225, 50);
        Objective.setFont(new Font("Arial", Font.PLAIN, 20));
        Objective.setBackground(new Color(255, 200, 200));
        Objective.setForeground(Color.red);
        Objective.addActionListener(this);
        Objective.setBackground(new Color(255, 200, 200));
        Objective.setForeground(Color.red);
        Objective.setBorder(BorderFactory.createRaisedBevelBorder());
        Objective.setOpaque(true);
        frame.add(Objective);
    
        Pratical=new JButton("Pratical");
        Pratical.setBounds(userscreenwidth*159/800,(userscreenheight)*53/200, 225, 50);
        Pratical.setFont(new Font("Arial", Font.PLAIN, 20));
        Pratical.setBackground(new Color(176, 224, 230));
        Pratical.setForeground(Color.BLACK);;
        Pratical.addActionListener(this);
        Pratical.setBorder(BorderFactory.createRaisedBevelBorder());
        Pratical.setOpaque(true);
        frame.add(Pratical);
        
        l2=new JLabel("Level 1:Easy");
            l2.setFont(new Font("System",Font.BOLD,20));
            l2.setBounds(userscreenwidth*125/800,userscreenheight*44/200,1600,50);
            frame.add(l2);
        
        Objective1=new JButton("Objective");
        Objective1.setBounds(userscreenwidth*309/800,(userscreenheight)*53/200, 225, 50);
        Objective1.setFont(new Font("Arial", Font.PLAIN, 20));
        Objective1.setBackground(new Color(176, 224, 230));
        Objective1.setForeground(Color.BLACK);
        Objective1.addActionListener(this);
        Objective1.setBorder(BorderFactory.createRaisedBevelBorder());
        Objective1.setOpaque(true);
        frame.add(Objective1);
        
        Pratical1=new JButton("Pratical");
        Pratical1.setBounds(userscreenwidth*415/800,(userscreenheight)*53/200, 225, 50);
        Pratical1.setFont(new Font("Arial", Font.PLAIN, 20));
        Pratical1.setBackground(new Color(176, 224, 230));
        Pratical1.setForeground(Color.BLACK);
        Pratical1.addActionListener(this);
        Pratical1.setBorder(BorderFactory.createRaisedBevelBorder());
        Pratical1.setOpaque(true);
        frame.add(Pratical1);
        
        l3=new JLabel("Level 2:MEDIUM");
            l3.setFont(new Font("System",Font.BOLD,20));
            l3.setBounds(userscreenwidth*380/800,userscreenheight*44/200,1600,50);
            frame.add(l3);
        
        Objective2=new JButton("Objective");
        Objective2.setBounds(userscreenwidth*565/800,(userscreenheight)*53/200, 225, 50);
        Objective2.setFont(new Font("Arial", Font.PLAIN, 20));
        Objective2.setBackground(new Color(176, 224, 230));
        Objective2.setForeground(Color.BLACK);
        Objective2.addActionListener(this);
        Objective2.setBorder(BorderFactory.createRaisedBevelBorder());
        Objective2.setOpaque(true);
        frame.add(Objective2);
        
        Pratical2=new JButton("Pratical");
        Pratical2.setBounds(userscreenwidth*675/800,(userscreenheight)*53/200, 225, 50);
        Pratical2.setFont(new Font("Arial", Font.PLAIN, 20));
        Pratical2.setBackground(new Color(176, 224, 230));
        Pratical2.setForeground(Color.BLACK);
        Pratical2.addActionListener(this);
        Pratical2.setBorder(BorderFactory.createRaisedBevelBorder());
        Pratical2.setOpaque(true);
        frame.add(Pratical2);
        
        l4=new JLabel("Level 3:HARD");
            l4.setFont(new Font("System",Font.BOLD,20));
            l4.setBounds(userscreenwidth*640/800,userscreenheight*44/200,1600,50);
            frame.add(l4);
        
        lT=new JLabel();
            lT.setFont(new Font("System",Font.BOLD,20));
            lT.setBounds(userscreenwidth*1/10,userscreenheight*39/100,1600,50);
            frame.add(lT); 
            bg=new ButtonGroup();  
        
        for(int i=0;i<4;i++)  
        {  
            jb[i]=new JRadioButton(); 
            jb[i].setFont(new Font("System",Font.BOLD,18));
            bg.add(jb[i]);  
        }
         
        
        lT.setText(strArr[0][0][0][1]);
        jb[0].setText(strArr[0][0][0][2]);
        jb[1].setText(strArr[0][0][0][3]);
        jb[2].setText(strArr[0][0][0][4]);
        jb[3].setText(strArr[0][0][0][5]);
        
        
        jb[0].setBounds(userscreenwidth*1/10,userscreenheight*45/100,500,50);
           // add(jb[0]);
        jb[1].setBounds(userscreenwidth*1/10,userscreenheight*50/100,500,50);
           // add(jb[1]);
        jb[2].setBounds(userscreenwidth*1/10,userscreenheight*55/100,500,50);
          //  add(jb[2]);
        jb[3].setBounds(userscreenwidth*1/10,userscreenheight*60/100,500,50);
           // add(jb[3]);
           frame.add(jb[0]); 
           frame.add(jb[1]); 
           frame.add(jb[2]); 
           frame.add(jb[3]);
        
        frame.setVisible(true);
        frame.setLocation(0,0);
        
        makeGrid(numberofTquePerSec,btn,0);
        centerPanel2 = new JPanel();
        for(int i=0;i<numberofTquePerSec;i++)
        {
        centerPanel2.add(btn[i]);
        }
            centerPanel2.setBackground(new Color(200, 220, 240));
            centerPanel2.setLayout(new GridLayout(numberofTquePerSec/5, 5));
            centerPanel2.setBounds(userscreenwidth*11/15,userscreenheight*48/100,305,305*numberofTquePerSec/25);
            frame.add(centerPanel2,BorderLayout.PAGE_START);
            
        makeGrid(numberofPquePerSec,btn2,1);
        centerPanel3 = new JPanel();
        for(int i=0;i<numberofPquePerSec;i++)
        {
        centerPanel3.add(btn2[i]);
        }
            centerPanel3.setBackground(new Color(200, 220, 240));
            centerPanel3.setLayout(new GridLayout(numberofPquePerSec/5, 5));
            centerPanel3.setBounds(userscreenwidth*11/15,userscreenheight*48/100,305,305*numberofPquePerSec/25);
            frame.add(centerPanel3,BorderLayout.PAGE_START);
            
        makeGrid(numberofTquePerSec,btn3,1);
        centerPanel4 = new JPanel();
        for(int i=0;i<numberofTquePerSec;i++)
        {
            centerPanel4.add(btn3[i]);
        }
            centerPanel4.setBackground(new Color(200, 220, 240));
            centerPanel4.setLayout(new GridLayout(numberofTquePerSec/5, 5));
            centerPanel4.setBounds(userscreenwidth*11/15,userscreenheight*48/100,305,305*numberofTquePerSec/25);
            frame.add(centerPanel4,BorderLayout.PAGE_START);
            
        makeGrid(numberofPquePerSec,btn4,1);
        centerPanel5 = new JPanel();
        for(int i=0;i<numberofPquePerSec;i++)
        {
            centerPanel5.add(btn4[i]);
        }
            centerPanel5.setBackground(new Color(200, 220, 240));
            centerPanel5.setLayout(new GridLayout(numberofPquePerSec/5, 5));
            centerPanel5.setBounds(userscreenwidth*11/15,userscreenheight*48/100,305,305*numberofPquePerSec/25);
            frame.add(centerPanel5,BorderLayout.PAGE_START);
            
        makeGrid(numberofTquePerSec,btn5,1);
        centerPanel6 = new JPanel();
        for(int i=0;i<numberofTquePerSec;i++)
        {
            centerPanel6.add(btn5[i]);
        }
            centerPanel6.setBackground(new Color(200, 220, 240));
            centerPanel6.setLayout(new GridLayout(numberofTquePerSec/5, 5));
            centerPanel6.setBounds(userscreenwidth*11/15,userscreenheight*48/100,305,305*numberofTquePerSec/25);
            frame.add(centerPanel6,BorderLayout.PAGE_START);
            
            
        makeGrid(numberofPquePerSec,btn6,1);
        centerPanel7 = new JPanel();
        for(int i=0;i<numberofPquePerSec;i++)
        {
            centerPanel7.add(btn6[i]);
        }
            centerPanel7.setBackground(new Color(200, 220, 240));
            centerPanel7.setLayout(new GridLayout(numberofPquePerSec/5, 5));
            centerPanel7.setBounds(userscreenwidth*11/15,userscreenheight*48/100,305,305*numberofPquePerSec/25);
            frame.add(centerPanel7,BorderLayout.PAGE_START);
           
        centerPanel2.setVisible(true);
        centerPanel3.setVisible(false);
        centerPanel4.setVisible(false);
        centerPanel5.setVisible(false);
        centerPanel6.setVisible(false);
        centerPanel7.setVisible(false);
            
    }
    
     public static void set(int sec,int level,int current)
   {
       lT.setText(strArr[sec][level][current][1]);
        jb[0].setText(strArr[sec][level][current][2]);
        jb[1].setText(strArr[sec][level][current][3]);
        jb[2].setText(strArr[sec][level][current][4]);
        jb[3].setText(strArr[sec][level][current][5]);
   }
    public static void set2(int sec,int level,int current2)
    {
        lP.setText(Pra_arr[sec][level][current2][1]);
    }
     
    
     public String getTimeString(int seconds) {
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
        }
     
    public static void makeGrid(int N,JButton[] btn,int r)
    {
        for(int i1=1;i1<=N;i1++)
        {
        final int i=i1;
        btn[i-1]=new JButton(""+(i+r*M));
        btn[i-1].setBounds(400+70*i, 400, 50, 50);
        btn[i-1].setFont(new Font("Arial", Font.PLAIN, 24));
        
        ActionListener listener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // define what should happen when the button is clicked
        if(e.getSource()==btn[0])
        {
            setButtonGreen(current);
            current=0;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn[1])
        {
            setButtonGreen(current);
            current=1;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn[2])
        {
            setButtonGreen(current);
            current=2;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn[3])
        {
            setButtonGreen(current);
            current=3;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn[4])
        {
            setButtonGreen(current);
            current=4;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn[5])
        {
            setButtonGreen(current);
            current=5;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn[6])
        {
            setButtonGreen(current);
            current=6;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn[7])
        {
            setButtonGreen(current);
            current=7;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn[8])
        {
            setButtonGreen(current);
            current=8;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn[9])
        {
            setButtonGreen(current);
            current=9;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn[10])
        {
            setButtonGreen(current);
            current=10;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn[11])
        {
            setButtonGreen(current);
            current=11;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn[12])
        {
            setButtonGreen(current);
            current=12;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn[13])
        {
            setButtonGreen(current);
            current=13;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn[14])
        {
            setButtonGreen(current);
            current=14;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        
        if(e.getSource()==btn2[0])
        {
           // setButtonGreen(current); write a function that set button green if they submitted
            current2=0;
            set2(sec,level,current2);
            
        }
        if(e.getSource()==btn2[1])
        {
            current2=1;
            set2(sec,level,current2); 
        }
        if(e.getSource()==btn2[2])
        {
            current2=2;
            set2(sec,level,current2);
        }
        if(e.getSource()==btn2[3])
        {
            current2=3;
            set2(sec,level,current2);
        }
        if(e.getSource()==btn2[4])
        {
            current2=4;
            set2(sec,level,current2);
        }
        if(e.getSource()==btn2[5])
        {
            current2=5;
            set2(sec,level,current2);
        }
        if(e.getSource()==btn2[6])
        {
            current2=6;
            set2(sec,level,current2);
        }
        if(e.getSource()==btn2[7])
        {
            current2=7;
            set2(sec,level,current2);
        }
        if(e.getSource()==btn2[8])
        {
            current2=8;
            set2(sec,level,current2);
        }
        if(e.getSource()==btn2[9])
        {
            current2=9;
            set2(sec,level,current2);
        }
        
        if(e.getSource()==btn3[0])
        {
            setButtonGreen(current);
            current=15;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn3[1])
        {
            setButtonGreen(current);
            current=16;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn3[2])
        {
            setButtonGreen(current);
            current=17;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn3[3])
        {
            setButtonGreen(current);
            current=18;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn3[4])
        {
            setButtonGreen(current);
            current=19;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn3[5])
        {
            setButtonGreen(current);
            current=20;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn3[6])
        {
            setButtonGreen(current);
            current=21;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn3[7])
        {
            setButtonGreen(current);
            current=22;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn3[8])
        {
            setButtonGreen(current);
            current=23;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn3[9])
        {
            setButtonGreen(current);
            current=24;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn3[10])
        {
            setButtonGreen(current);
            current=25;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn3[11])
        {
            setButtonGreen(current);
            current=26;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn3[12])
        {
            setButtonGreen(current);
            current=27;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn3[13])
        {
            setButtonGreen(current);
            current=28;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn3[14])
        {
            setButtonGreen(current);
            current=29;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        
        if(e.getSource()==btn5[0])
        {
            setButtonGreen(current);
            current=30;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn5[1])
        {
            setButtonGreen(current);
            current=31;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn5[2])
        {
            setButtonGreen(current);
            current=32;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn5[3])
        {
            setButtonGreen(current);
            current=33;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn5[4])
        {
            setButtonGreen(current);
            current=34;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn5[5])
        {
            setButtonGreen(current);
            current=35;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn5[6])
        {
            setButtonGreen(current);
            current=36;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn5[7])
        {
            setButtonGreen(current);
            current=37;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn5[8])
        {
            setButtonGreen(current);
            current=38;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn5[9])
        {
            setButtonGreen(current);
            current=39;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn5[10])
        {
            setButtonGreen(current);
            current=40;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn5[11])
        {
            setButtonGreen(current);
            current=41;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn5[12])
        {
            setButtonGreen(current);
            current=42;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn5[13])
        {
            setButtonGreen(current);
            current=43;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(e.getSource()==btn5[14])
        {
            setButtonGreen(current);
            current=44;
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
    }
};

        btn[i-1].addActionListener(listener);
        
        btn[i-1].addMouseListener(new MouseAdapter() {
            
            
            @Override
            public void mouseExited(MouseEvent e) {
            if(ans[i-1]=="1" || ans[i-1]=="2" || ans[i-1]=="3" || ans[i-1]=="4")
            {
                btn[i-1].setBackground(new Color(220, 240, 220));
                btn[i-1].setForeground(Color.GREEN);
            }
            
            }
        });
        }
        M=M+N;
        for(int i=0;i<N;i++)
       {
            {
                btn[i].setBackground(new Color(255, 200, 200));
                btn[i].setForeground(Color.red);
            }
       }
           
    }
    
     public static void setButtonGreen(int current)
   {
       
           if(centerPanel2.isVisible())
           {
               for(int i=0;i<btn.length;i++)
               {
                    if(ans[i]=="1" || ans[i]=="2" || ans[i]=="3" || ans[i]=="4")
                    {
                        btn[i].setBackground(new Color(220, 240, 220));
                        btn[i].setForeground(Color.GREEN);
                    }
                    else
                    {
                        btn[i].setBackground(new Color(255, 200, 200));
                        btn[i].setForeground(Color.red);
                    }
               }
           }
           if(centerPanel3.isVisible())
           {
               for(int i=0;i<btn2.length;i++)
               {
                    if(ans[i]=="1" || ans[i]=="2" || ans[i]=="3" || ans[i]=="4")  //Logic for checking praticals in Pratical section
                    {
                        btn2[i].setBackground(new Color(220, 240, 220));
                        btn2[i].setForeground(Color.GREEN);
                    }
                    else
                    {
                        btn2[i].setBackground(new Color(255, 200, 200));
                        btn2[i].setForeground(Color.red);
                    }
               }
           }
           if(centerPanel4.isVisible())
           {
               for(int i=0;i<btn3.length;i++)
               {
                    if(ans[i+numberofTquePerSec*1]=="1" || ans[i+numberofTquePerSec*1]=="2" || ans[i+numberofTquePerSec*1]=="3" || ans[i+numberofTquePerSec*1]=="4")
                    {
                        btn3[i].setBackground(new Color(220, 240, 220));
                        btn3[i].setForeground(Color.GREEN);
                    }
                    else
                    {
                        btn3[i].setBackground(new Color(255, 200, 200));
                        btn3[i].setForeground(Color.red);
                    }
               }
           }
           if(centerPanel5.isVisible())
           {
               for(int i=0;i<btn4.length;i++)
               {
                    if(ans[i]=="1" || ans[i]=="2" || ans[i]=="3" || ans[i]=="4")
                    {
                        btn4[i].setBackground(new Color(220, 240, 220));
                        btn4[i].setForeground(Color.GREEN);
                    }
                    else
                    {
                        btn4[i].setBackground(new Color(255, 200, 200));
                        btn4[i].setForeground(Color.red);
                    }
               }
           }
           if(centerPanel6.isVisible())
           {
               for(int i=0;i<btn5.length;i++)
               {
                    if(ans[i+numberofTquePerSec*2]=="1" || ans[i+numberofTquePerSec*2]=="2" || ans[i+numberofTquePerSec*1]=="3" || ans[i+numberofTquePerSec*2]=="4")
                    {
                        btn5[i].setBackground(new Color(220, 240, 220));
                        btn5[i].setForeground(Color.GREEN);
                    }
                    else
                    {
                        btn5[i].setBackground(new Color(255, 200, 200));
                        btn5[i].setForeground(Color.red);
                    }
               }
           }
           if(centerPanel7.isVisible())
           {
               for(int i=0;i<btn6.length;i++)
               {
                    if(ans[i]=="1" || ans[i]=="2" || ans[i]=="3" || ans[i]=="4")
                    {
                        btn6[i].setBackground(new Color(220, 240, 220));
                        btn6[i].setForeground(Color.GREEN);
                    }
                    else
                    {
                        btn6[i].setBackground(new Color(255, 200, 200));
                        btn6[i].setForeground(Color.red);
                    }
               }
           }
   }
   
   public static void updateRadiobutton(int current)
   {
       if(ans[current]=="1")
       {
           jb[0].setSelected(true);
       }
       else if(ans[current]=="2")
       {
           jb[1].setSelected(true);
       }
       if(ans[current]=="3")
       {
           jb[2].setSelected(true);
       }
       if(ans[current]=="4")
       {
           jb[3].setSelected(true);
       }
   }
    public void actionPerformed(ActionEvent ae)
    {
       
        if(ae.getSource()==Submit)
        {
            //add Actions when submit button is clicked
        }
        
        if(ae.getSource()==Next && lT.isVisible())
        {
            if (jb[0].isSelected()) {
                ans[current]="1";
                
            } else if (jb[1].isSelected()) {
                ans[current]="2";
                
            } else if (jb[2].isSelected()) {
                ans[current]="3";
                
            } else if(jb[3].isSelected()) {
                ans[current]="4";
  
            }
            //Evaluate and storing objective answer is necessary
            setButtonGreen(current);
            current++;
            if(current==ControllerClass.Theoryquestions)
            {
                current=ControllerClass.Theoryquestions-1;
            }
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
            
        }
        if(ae.getSource()==Next && lP.isVisible())
        {
            //Evaluate and storing pratical answer is necessary
            current2++;
            if(current2==ControllerClass.Practicalquestions)
            {
                current2=ControllerClass.Practicalquestions-1;
            }
            set2(sec,level,current2);
        }
        if(ae.getSource()==Previous && lT.isVisible())
        {
            
            //Evaluate and storing theory answer is necessary
            setButtonGreen(current);
            if(current>0)
            {
                current--;
            }
            set(sec,level,current);
            bg.clearSelection();
            updateRadiobutton(current);
        }
        if(ae.getSource()==Previous && lP.isVisible())
        {
            //Evaluate and storing pratical answer is necessary
            if(current2>0)
            {
                current2--;
            }
            set2(sec,level,current2);
        }
       
        if(ae.getSource()==b1)
        {
            lP.setText(Pra_arr[sec][level][current2][1]);
            new Overlay(Pra_arr[sec][level][current2][1]);
        }
        if(ae.getSource()==Objective)
        {
            
           sec=0;
           level=0;
           current=0;
           set(sec,level,current);
           
           Objective.setBackground(new Color(255, 200, 200));
           Objective.setForeground(Color.red);
           
           lP.setVisible(false);
           b1.setVisible(false);
           
           lT.setVisible(true);
           jb[0].setVisible(true);
           jb[1].setVisible(true);
           jb[2].setVisible(true);
           jb[3].setVisible(true);
           
           centerPanel2.setVisible(true);
           centerPanel3.setVisible(false);
           centerPanel4.setVisible(false);
           centerPanel5.setVisible(false);
           centerPanel6.setVisible(false);
           centerPanel7.setVisible(false);
           
           Pratical.setBackground(new Color(176, 224, 230));
           Pratical.setForeground(Color.BLACK);
           Pratical1.setBackground(new Color(176, 224, 230));
           Pratical1.setForeground(Color.BLACK);
           Objective1.setBackground(new Color(176, 224, 230));
           Objective1.setForeground(Color.BLACK);
           Objective2.setBackground(new Color(176, 224, 230));
           Objective2.setForeground(Color.BLACK);
           Pratical2.setBackground(new Color(176, 224, 230));
           Pratical2.setForeground(Color.BLACK);
           
        }
        if(ae.getSource()==Pratical)
        {
           
           sec=0;
           level=0;
           current2=0;
           set2(sec,level,current2);
           
           Pratical.setBackground(new Color(255, 200, 200));
           Pratical.setForeground(Color.red);
           
           lP.setVisible(true);
           b1.setVisible(true);
           
           lT.setVisible(false);
           jb[0].setVisible(false);
           jb[1].setVisible(false);
           jb[2].setVisible(false);
           jb[3].setVisible(false);
           
           centerPanel2.setVisible(false);
           centerPanel3.setVisible(true);
           centerPanel4.setVisible(false);
           centerPanel5.setVisible(false);
           centerPanel6.setVisible(false);
           centerPanel7.setVisible(false);
           
           Objective.setBackground(new Color(176, 224, 230));
           Objective.setForeground(Color.BLACK);
           Pratical1.setBackground(new Color(176, 224, 230));
           Pratical1.setForeground(Color.BLACK);
           Objective1.setBackground(new Color(176, 224, 230));
           Objective1.setForeground(Color.BLACK);
           Objective2.setBackground(new Color(176, 224, 230));
           Objective2.setForeground(Color.BLACK);
           Pratical2.setBackground(new Color(176, 224, 230));
           Pratical2.setForeground(Color.BLACK);
           //remove submit button and radio buttons and add perfrom action button and after adding this button add action event on that button to open overlay class.
        }
        
        if(ae.getSource()==Objective1)
        {
           sec=0;
           level=1;
           current=15;
           set(sec,level,current);
           
           Objective1.setBackground(new Color(255, 200, 200));
           Objective1.setForeground(Color.red);
           
           lP.setVisible(false);
           b1.setVisible(false);
           
           lT.setVisible(true);
           jb[0].setVisible(true);
           jb[1].setVisible(true);
           jb[2].setVisible(true);
           jb[3].setVisible(true);
           
           centerPanel2.setVisible(false);
           centerPanel3.setVisible(false);
           centerPanel4.setVisible(true);
           centerPanel5.setVisible(false);
           centerPanel6.setVisible(false);
           centerPanel7.setVisible(false);
           
           Objective.setBackground(new Color(176, 224, 230));
           Objective.setForeground(Color.BLACK);
           Pratical1.setBackground(new Color(176, 224, 230));
           Pratical1.setForeground(Color.BLACK);
           Pratical.setBackground(new Color(176, 224, 230));
           Pratical.setForeground(Color.BLACK);
           Objective2.setBackground(new Color(176, 224, 230));
           Objective2.setForeground(Color.BLACK);
           Pratical2.setBackground(new Color(176, 224, 230));
           Pratical2.setForeground(Color.BLACK);
           //remove submit button and radio buttons and add perfrom action button and after adding this button add action event on that button to open overlay class.
        }
        
        if(ae.getSource()==Pratical1)
        {
           sec=0;
           level=1;
           current2=10;
           set2(sec,level,current2);
           
           Pratical1.setBackground(new Color(255, 200, 200));
           Pratical1.setForeground(Color.red);
           
           lP.setVisible(true);
           b1.setVisible(true);
           
           lT.setVisible(false);
           jb[0].setVisible(false);
           jb[1].setVisible(false);
           jb[2].setVisible(false);
           jb[3].setVisible(false);
           
           centerPanel2.setVisible(false);
           centerPanel3.setVisible(false);
           centerPanel4.setVisible(false);
           centerPanel5.setVisible(true);
           centerPanel6.setVisible(false);
           centerPanel7.setVisible(false);
           
           Objective.setBackground(new Color(176, 224, 230));
           Objective.setForeground(Color.BLACK);
           Pratical.setBackground(new Color(176, 224, 230));
           Pratical.setForeground(Color.BLACK);
           Objective1.setBackground(new Color(176, 224, 230));
           Objective1.setForeground(Color.BLACK);
           Objective2.setBackground(new Color(176, 224, 230));
           Objective2.setForeground(Color.BLACK);
           Pratical2.setBackground(new Color(176, 224, 230));
           Pratical2.setForeground(Color.BLACK);
           //remove submit button and radio buttons and add perfrom action button and after adding this button add action event on that button to open overlay class.
        }
        
        if(ae.getSource()==Objective2)
        {
           sec=0;
           level=2;
           current=30;
           set(sec,level,current);
           
           Objective2.setBackground(new Color(255, 200, 200));
           Objective2.setForeground(Color.red);
           
           lP.setVisible(false);
           b1.setVisible(false);
           
           lT.setVisible(true);
           jb[0].setVisible(true);
           jb[1].setVisible(true);
           jb[2].setVisible(true);
           jb[3].setVisible(true);
           
           centerPanel2.setVisible(false);
           centerPanel3.setVisible(false);
           centerPanel4.setVisible(false);
           centerPanel5.setVisible(false);
           centerPanel6.setVisible(true);
           centerPanel7.setVisible(false);
           
           Objective.setBackground(new Color(176, 224, 230));
           Objective.setForeground(Color.BLACK);
           Pratical1.setBackground(new Color(176, 224, 230));
           Pratical1.setForeground(Color.BLACK);
           Objective1.setBackground(new Color(176, 224, 230));
           Objective1.setForeground(Color.BLACK);
           Pratical.setBackground(new Color(176, 224, 230));
           Pratical.setForeground(Color.BLACK);
           Pratical2.setBackground(new Color(176, 224, 230));
           Pratical2.setForeground(Color.BLACK);
           //remove submit button and radio buttons and add perfrom action button and after adding this button add action event on that button to open overlay class.
        }
        
        if(ae.getSource()==Pratical2)
        {
           sec=0;
           level=2;
           current2=20;
           set2(sec,level,current2);
           
           Pratical2.setBackground(new Color(255, 200, 200));
           Pratical2.setForeground(Color.red);
           
           lP.setVisible(true);
           b1.setVisible(true);
           
           lT.setVisible(false);
           jb[0].setVisible(false);
           jb[1].setVisible(false);
           jb[2].setVisible(false);
           jb[3].setVisible(false);
           
           centerPanel2.setVisible(false);
           centerPanel3.setVisible(false);
           centerPanel4.setVisible(false);
           centerPanel5.setVisible(false);
           centerPanel6.setVisible(false);
           centerPanel7.setVisible(true);
           
           Objective.setBackground(new Color(176, 224, 230));
           Objective.setForeground(Color.BLACK);
           Pratical1.setBackground(new Color(176, 224, 230));
           Pratical1.setForeground(Color.BLACK);
           Objective1.setBackground(new Color(176, 224, 230));
           Objective1.setForeground(Color.BLACK);
           Pratical.setBackground(new Color(176, 224, 230));
           Pratical.setForeground(Color.BLACK);
           Objective2.setBackground(new Color(176, 224, 230));
           Objective2.setForeground(Color.BLACK);
           //remove submit button and radio buttons and add perfrom action button and after adding this button add action event on that button to open overlay class.
        }
        if(ae.getSource()==END)
        {
            frame.dispose();
            Mainpage.FullWindow(userscreenwidth*95/100,2);
        }
        
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new Theory();
        Mainpage.FullWindow(userscreenwidth*95/100,2);
        
        
        
    }
    
}
