import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titelPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1Turn;

    TicTacToe(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.PINK); //BAKGROUND
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(Color.WHITE);
        textField.setForeground(Color.LIGHT_GRAY);
        textField.setFont(new Font("Ink Free",Font.ITALIC,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic Tac Toe");
        textField.setOpaque(true);

        titelPanel.setLayout(new BorderLayout());
        titelPanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3,3));

        for(int i = 0; i<9; i++){
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("Ink Free",Font.ITALIC,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titelPanel.add(textField);
        frame.add(titelPanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i<9; i++){ 
            if(e.getSource() == buttons[i]){
                if(player1Turn){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(Color.BLACK);
                        buttons[i].setText("X");
                        player1Turn=false;
                        textField.setText("O Turn!");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(Color.GRAY);
                        buttons[i].setText("0");
                        player1Turn=true;
                        textField.setText("X Turn!");
                        check();
                    }

                }
            }

        }
        
        
    }

    public void firstTurn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(random.nextInt(2) == 0){
            player1Turn = true;
            textField.setText("X Turn!");
        }else {
            player1Turn = false;
            textField.setText("O Turn!");
        }

    }

    public void check(){

    }

    public void xWins(int a,int b,int c){

    }

    public void oWins(int a,int b,int c){

    }

    
}
