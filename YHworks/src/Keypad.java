import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Keypad extends JFrame implements ActionListener{
    
    private JTextField field;
    private JButton[] button;

    public Keypad() {
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

        JPanel panel1 = new JPanel(); //output
        panel.add(panel1, BorderLayout.NORTH);
        JPanel panel2 = new JPanel(); //Numpad
        panel.add(panel2, BorderLayout.CENTER);

        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new GridLayout(3,3));

        //panel1
        field = new JTextField();
        panel1.add(field);

        //panel2
        button = new JButton[9];

        for(int i=0; i<6; i++) {
            button[i] = new JButton();
            button[i].setText(""+(i+1));
            button[i].addActionListener(this);
            panel2.add(button[i]);
        }

        button[6] = new JButton();
        button[6].setText("+");
        button[6].addActionListener(this);
        panel2.add(button[6]);

        button[7] = new JButton();
        button[7].setText("-");
        button[7].addActionListener(this);
        panel2.add(button[7]);

        button[8] = new JButton();
        button[8].setText("=");
        button[8].addActionListener(this);
        panel2.add(button[8]);
        

        setSize(300, 320); //프레임 사이즈
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료시 작동방법
        setTitle(null); //프레임 타이틀
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        field.setText(field.getText()+((JButton) e.getSource()).getText());
    }
    public static void main(String[] args) {

        new Keypad();
    }
}
