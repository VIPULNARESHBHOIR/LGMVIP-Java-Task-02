import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
class O_X implements ActionListener{
    JLabel text,text2,text3;
    JFrame frame=new JFrame("O-X");
    JButton buttons[]=new JButton[9];
    JButton reset=new JButton("RESET");
    JPanel panel1=new JPanel();
    JPanel panel2=new JPanel();
    Random rand=new Random();
    String text1="X";
    int a=0,xscore=0,oscore=0;
    Color c=new Color(255,0,0);

    
    O_X(){
        frame.setSize(700, 800);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(50,50,50));
        
        text=new JLabel();
        text.setBounds(250, 0, 200, 100);
        text.setBackground(Color.BLACK);
        text.setText("O-X");
        text.setOpaque(true);
        text.setFont(new Font("mv boli", Font.PLAIN, 60));
        text.setForeground(Color.YELLOW);
        text.setHorizontalAlignment(JLabel.CENTER);

        text2=new JLabel();
        text2.setBounds(0, 0, 250, 100);
        text2.setBackground(Color.BLACK);
        text2.setText("X-score=0");
        text2.setOpaque(true);
        text2.setFont(new Font("mv boli", Font.PLAIN, 20));
        text2.setForeground(Color.YELLOW);
        text2.setHorizontalAlignment(JLabel.CENTER);

        text3=new JLabel();
        text3.setBounds(450, 0, 250, 100);
        text3.setBackground(Color.BLACK);
        text3.setText("O-score=0");
        text3.setOpaque(true);
        text3.setFont(new Font("mv boli", Font.PLAIN, 20));
        text3.setForeground(Color.YELLOW);
        text3.setHorizontalAlignment(JLabel.CENTER);


        for(int button=0;button<9;button++){
            buttons[button]=new JButton();
            buttons[button].setFocusable(false);
            buttons[button].setBackground(new Color(50,50,50));
            buttons[button].setFont(new Font("INK FREE",Font.PLAIN,100));
            buttons[button].addActionListener(this);
            panel2.add(buttons[button]);
            
        }

        panel2.setLayout(new GridLayout(3,3));
        panel2.setBounds(0, 100, 700, 600);
        panel2.setBackground(new Color(150,150,150));

        reset.setBackground(Color.blue);
        reset.setForeground(Color.black);
        reset.setFocusable(false);
        reset.setBounds(0, 700, 700, 55);
        reset.setFont(new Font("MV boli", Font.BOLD,40));
        reset.addActionListener(this);

        frame.add(text);
        frame.add(text2);
        frame.add(text3);
        frame.add(panel2);
        frame.add(reset);
        frame.setVisible(true);



    }

    public static void main(String[] args) {
        new O_X();
    }

    public void actionPerformed(ActionEvent e){
        for (int but=0;but<9;but++){
            if(e.getSource()==buttons[but]){
    
                if(buttons[but].getText()==""){
                    a++;
                    buttons[but].setForeground(c);
                    buttons[but].setText(text1);
                    if(a>4){
                    check();
                    }
                }
            }

            if (a%2!=0){
                text1="O";
                c=new Color(0,255,0);

            }
            else{
                text1="X";
                c=new Color(255,0,0);
            }
            
            
        }
        if(e.getSource()==reset){
            for(int i=0;i<9;i++){
                buttons[i].setText("");
                buttons[i].setBackground(new Color(50,050,050));
                buttons[i].setEnabled(true);
                
            }
            Random rand=new Random();
            if(rand.nextInt(2)==0){
                c=new Color(255,0,0);
                a=0;
                text1="X";
            }
            else{
                c=new Color(0,255,0);
                a=1;
                text1="O";
            }
            System.out.println();
            
            text.setText("");
        }
    }
    public void check(){
        if(buttons[0].getText()==buttons[1].getText() && buttons[1].getText()==buttons[2].getText()){
            highliter(0,1,2);

        }
        if(buttons[0].getText()==buttons[3].getText() && buttons[3].getText()==buttons[6].getText()){
            highliter(0,3,6);

        }
        if(buttons[0].getText()==buttons[4].getText() && buttons[4].getText()==buttons[8].getText()){
            highliter(0,4,8);

        }
        if(buttons[1].getText()==buttons[4].getText() && buttons[4].getText()==buttons[7].getText()){
            highliter(1,4,7);
        }
        if(buttons[2].getText()==buttons[5].getText() && buttons[5].getText()==buttons[8].getText()){
            highliter(2,5,8);
        }
        if(buttons[2].getText()==buttons[4].getText() && buttons[4].getText()==buttons[6].getText()){
            highliter(2,4,6);
            
        }
        if(buttons[3].getText()==buttons[4].getText() && buttons[4].getText()==buttons[5].getText()){
            highliter(3,4,5);
        }
        if(buttons[6].getText()==buttons[7].getText() && buttons[7].getText()==buttons[8].getText()){
            highliter(6,7,8);
        }
    
    }
    public void highliter(int i,int j,int k){
        if(buttons[i].getText()!=""){
        buttons[i].setBackground(Color.cyan);
        buttons[j].setBackground(Color.cyan);
        buttons[k].setBackground(Color.cyan);

        if(buttons[i].getText()=="X"){
            text.setText("X won");
            text2.setText("x-score="+String.valueOf(++xscore));
        }
        else{
            text.setText("O won");
            text3.setText("O-score="+String.valueOf(++oscore));
        }
        for(int l=0;l<9;l++){
            buttons[l].setEnabled(false);
        }
        }
        
    }
}