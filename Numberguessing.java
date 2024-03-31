//importing all necessary components....
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
//MAin frame setting...
public class Numberguessing{
    JFrame jf;
    JLabel jl,jl1,jl2;
    JTextArea jt;
    JButton jb,jb1;
    int number;
    String num2;
    int marks=100;
    int i=0;
    int K=5;
    int p=5;
    int guess;
    Numberguessing(){
        number = 1 + (int)(100* Math.random());
        jf=new JFrame();
        jf.setTitle("Number Guess");
        jf.setLayout(null);
        jf.setSize(300,400);
        jf.setVisible(true);
        jl=new JLabel("A number is chosen between 1 to 100.Guess the number within 5 trials.");
        jl.setBounds(10,10,500,50);
        jf.add(jl);
        jl1=new JLabel("Guess it....");
        jl1.setBounds(10,50,100,50);
        jf.add(jl1);
        jt=new JTextArea();
        jt.setBounds(100,70,30,30);
        jf.add(jt);
        jl2=new JLabel();
        jl2.setBounds(10, 200, 500, 40);
        jf.add(jl2);
        jb1=new JButton("Close");
        jb1.setBounds(10,250,100,40);
        jf.add(jb1);
        jb1.setVisible(false);
        jb1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0); 
            }
        }); 
        jb=new JButton("Guess");
        jb.setBounds(10,120,100,40);
        jf.add(jb);
        jb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                num2=jt.getText();
                guess=Integer.parseInt(num2);
                if (number == guess) {
                    jl2.setText("Congratulations!You guessed the number.Your marks is:"+marks);
                    jb1.setVisible(true);
                    jt.setVisible(false);
                }
                else if(number>guess) {
                    K-=1;
                    jl2.setText("The number is greater than " + guess+".You have now "+K+" trials left.");
                    marks-=20;
                }
                else if(number<guess){
                    K-=1;
                    jl2.setText("The number is less than " + guess+".You have now "+K+" trials left.");
                    marks-=20;
                }
                if(K==0){
                    jl2.setText("You have exhausted all trials.Your marks is:0.The number was "+ number);
                    jb1.setVisible(true);
                    jt.setVisible(false);
                }
            }
        });    
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
    public static void main(String[] args) {
        new Numberguessing();
    }
}