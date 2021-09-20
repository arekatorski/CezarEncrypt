package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends JFrame implements ActionListener {
    public JLabel label = new JLabel("Wpisz poniżej tekst do zaszyfrowania (bez polskich znaków i znaków specjalnych)");
    public static JTextArea text = new JTextArea();
    JButton button = new JButton("Zaszyfruj");
    static JLabel encodedLabel = new JLabel("test");
    public Main(){

        setSize(500,550);
        setTitle("Apka Cezar");
        setLayout(null);
        label.setBounds(10, 10, 550, 20);
        add(label);
        text.setLineWrap(true);
        text.setBounds(10,50,450,150);
        add(text);
        button.setBounds(130, 200, 200, 20);
        add(button);
        encodedLabel.setBounds(1, 250, 550, 150);
        add(encodedLabel);
        button.addActionListener(this);
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);


       
    }

    public static String inputText(){

        String textToEncrypt = text.getText();
       
        return textToEncrypt;
    }

    public static  String encryptCode(String input){
        StringBuilder builder = new StringBuilder(input);
        int move = 3;
        for(int i= 0; i< builder.length(); i++){
            int a = (int)builder.charAt(i);
            if((a > 122 || a < 97) && a!= 32 ){
                return("Wprowadziłeś zły znak");
            }
            if(a + move > 122){
                a = 97 + (move - (122 - a));

            }else if(a == 32){
                continue;
            } else
                a += move;

            builder.setCharAt(i, (char)a);
        }
        return builder.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputText().trim();
        String encrypted = Main.encryptCode(input);
        encodedLabel.setText(encrypted);

    }
}
