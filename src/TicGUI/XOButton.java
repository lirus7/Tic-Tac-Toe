package TicGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static TicGUI.Login.*;
/**
 * Created by lirus on 8/10/16.
 */
public class XOButton extends JButton implements ActionListener{
    public static ImageIcon X,O;
    int x;
    int moves;
    static boolean win;
    static int value=0;
	/*
	0:nothing
	1:X
	2:O
	*/
    public XOButton(){
        X=new ImageIcon(this.getClass().getResource("X.png"));
        O=new ImageIcon(this.getClass().getResource("O.png"));
        this.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        switch (value) {
            case 0:
                this.setHorizontalTextPosition(SwingConstants.CENTER);
                this.setText("X");
                this.setForeground(Color.CYAN);
                this.setIcon(X);
                x = check2(button);
                if (x == 1) {
                    if (option == 1 && usr2.equals("X"))
                        text1.setText(user_2 + "wins");
                    else if (option == 1 && usr.equals("X"))
                        text1.setText(user_2 + "wins");
                    else if (option == 2 && usr.equals("X"))
                        text1.setText(user_1 + "wins");
                    else if (option == 2 && cpu.equals("X"))
                        text1.setText("CPU wins");
                    else if (option == 3 && Ai.equals("X"))
                        text1.setText("AI wins");
                    else if (option == 3 && cpu.equals("X"))
                        text1.setText("CPU wins");
                    else if (option == 4 && usr.equals("X"))
                        text1.setText(user_1 + "wins");
                    else if (option == 4 && Ai.equals("X"))
                        text1.setText("Ai wins");
                    win=true;
                    break;

                }
        else {
                if (option == 2 && cpu.equals("O")) {
                    text1.setText("CPU s turn");
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            CPU();
                            text1.setText(user_1+" turn");
                        }
                    }).start();
                }
                else if (option == 3 && cpu.equals("O")) {
                    text1.setText("CPU s turn");
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            CPU();
                            text1.setText("AIs turn");
                        }
                    }).start();
                }
                else if (option == 3 && Ai.equals("O")) {
                    text1.setText("AIs turn");
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            AI(0);
                            text1.setText("CPUs turn");
                        }
                    }).start();
                }
                else if (option == 4 && Ai.equals("O"))
                {
                    text1.setText("AIs turn");
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            AI(0);
                            text1.setText(user_1+" turn");
                        }
                    }).start();
                }
            }
            if(option==1) {
                if (usr.equals("O")) {
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            text1.setText(user_1 + " turn");
                        }
                    }).start();
                } else {
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            text1.setText(user_2 + " turn");
                        }
                    }).start();
                }
            }
            break;
        case 1:
            this.setHorizontalTextPosition(SwingConstants.CENTER);
            this.setText("O");
            this.setForeground(Color.WHITE);
            this.setIcon(O);
            x = check1(button);
            if (x == 1) {
                if (option == 1 && usr2.equals("O"))
                    text1.setText(user_2 + "wins");
                else if (option == 1 && usr.equals("O"))
                    text1.setText(user_2 + "wins");
                else if (option == 2 && usr.equals("O"))
                    text1.setText(user_1 + "wins");
                else if (option == 2 && cpu.equals("O"))
                    text1.setText("CPU wins");
                else if (option == 3 && Ai.equals("O"))
                    text1.setText("AI wins");
                else if (option == 3 && cpu.equals("O"))
                    text1.setText("CPU wins");
                else if (option == 4 && usr.equals("O"))
                    text1.setText(user_1 + "wins");
                else if (option == 4 && Ai.equals("O"))
                    text1.setText("Ai wins");
                win=true;
                break;
            }
            else
            {
                if (option == 2 && cpu.equals("X")) {
                    text1.setText("CPUs turn");
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            CPU();
                            text1.setText(user_1+" turn");
                        }
                    }).start();

                }   else if (option == 3 && cpu.equals("X")) {
                    text1.setText("CPUs turn");
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            CPU();
                            text1.setText("AIs turn");
                        }
                    }).start();

                }    else if (option == 3 && Ai.equals("X")) {
                    text1.setText("AIs turn");
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            AI(1);
                            text1.setText("CPUs turn");
                        }
                    }).start();
                }   else if (option == 4 && Ai.equals("X"))
                {
                    text1.setText("AIs turn");
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            AI(1);
                            text1.setText(user_1+" turn");
                        }
                    }).start();
                }
            }
            if(option==1)
            {
                if(usr.equals("X"))
                {
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            text1.setText(user_1+" turn");
                        }
                    }).start();
                }
                else
                {
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(800);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            text1.setText(user_2+" turn");
                        }
                    }).start();
                }
            }
            break;
        }
    value++;
    value=value%2;
        move++;
        if(move>=9 && check1(button)==0 && check2(button)==0)
        {
            text1.setText("Its a tie");
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();
            win=true;
        }
        if(win) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    framem.dispose();
                    frame.dispose();
                    runner();
                }
            }).start();
        }
    }

    public static int check1(XOButton[] button)
    {
        if (button[0].getText().equals("O") && button[1].getText().equals("O") && button[2].getText().equals("O") )
        {
            button[0].setBackground(Color.GREEN);
            button[1].setBackground(Color.GREEN);
            button[2].setBackground(Color.GREEN);
            return 1;
        }
        else if (button[0].getText().equals("O") && button[3].getText().equals("O") && button[6].getText().equals("O"))
        {
            button[0].setBackground(Color.GREEN);
            button[3].setBackground(Color.GREEN);
            button[6].setBackground(Color.GREEN);
            return 1;

        }
        else if (button[0].getText().equals("O") && button[4].getText().equals("O") && button[8].getText().equals("O"))
        {
            button[0].setBackground(Color.GREEN);
            button[4].setBackground(Color.GREEN);
            button[8].setBackground(Color.GREEN);
            return 1;

        }
        else if (button[1].getText().equals("O") && button[4].getText().equals("O") && button[7].getText().equals("O"))
        {
            button[1].setBackground(Color.GREEN);
            button[4].setBackground(Color.GREEN);
            button[7].setBackground(Color.GREEN);
            return 1;
        }
        else if (button[2].getText().equals("O") && button[5].getText().equals("O") && button[8].getText().equals("O"))
        {
            button[2].setBackground(Color.GREEN);
            button[5].setBackground(Color.GREEN);
            button[8].setBackground(Color.GREEN);
            return 1;
        }
        else if (button[2].getText().equals("O") && button[4].getText().equals("O") && button[6].getText().equals("O"))
        {
            button[2].setBackground(Color.GREEN);
            button[4].setBackground(Color.GREEN);
            button[6].setBackground(Color.GREEN);
            return 1;
        }
        else if (button[3].getText().equals("O") && button[4].getText().equals("O") && button[5].getText().equals("O"))
        {
            button[3].setBackground(Color.GREEN);
            button[4].setBackground(Color.GREEN);
            button[5].setBackground(Color.GREEN);
            return 1;
        }
        else if (button[6].getText().equals("O") && button[7].getText().equals("O") && button[8].getText().equals("O"))
        {
            button[6].setBackground(Color.GREEN);
            button[7].setBackground(Color.GREEN);
            button[8].setBackground(Color.GREEN);
            return 1;
        }
        else
            return 0;
    }
    public static int check2(XOButton[] button)
    {
        if (button[0].getText().equals("X") && button[1].getText().equals("X") && button[2].getText().equals("X") )
        {
            button[0].setBackground(Color.GREEN);
            button[1].setBackground(Color.GREEN);
            button[2].setBackground(Color.GREEN);
            return 1;
        }
        else if (button[0].getText().equals("X") && button[3].getText().equals("X") && button[6].getText().equals("X"))
        {
            button[0].setBackground(Color.GREEN);
            button[3].setBackground(Color.GREEN);
            button[6].setBackground(Color.GREEN);
            return 1;

        }
        else if (button[0].getText().equals("X") && button[4].getText().equals("X") && button[8].getText().equals("X"))
        {
            button[0].setBackground(Color.GREEN);
            button[4].setBackground(Color.GREEN);
            button[8].setBackground(Color.GREEN);
            return 1;

        }
        else if (button[1].getText().equals("X") && button[4].getText().equals("X") && button[7].getText().equals("X"))
        {
            button[1].setBackground(Color.GREEN);
            button[4].setBackground(Color.GREEN);
            button[7].setBackground(Color.GREEN);
            return 1;
        }
        else if (button[2].getText().equals("X") && button[5].getText().equals("X") && button[8].getText().equals("X"))
        {
            button[2].setBackground(Color.GREEN);
            button[5].setBackground(Color.GREEN);
            button[8].setBackground(Color.GREEN);
            return 1;
        }
        else if (button[2].getText().equals("X") && button[4].getText().equals("X") && button[6].getText().equals("X"))
        {
            button[2].setBackground(Color.GREEN);
            button[4].setBackground(Color.GREEN);
            button[6].setBackground(Color.GREEN);
            return 1;
        }
        else if (button[3].getText().equals("X") && button[4].getText().equals("X") && button[5].getText().equals("X"))
        {
            button[3].setBackground(Color.GREEN);
            button[4].setBackground(Color.GREEN);
            button[5].setBackground(Color.GREEN);
            return 1;
        }
        else if (button[6].getText().equals("X") && button[7].getText().equals("X") && button[8].getText().equals("X"))
        {
            button[6].setBackground(Color.GREEN);
            button[7].setBackground(Color.GREEN);
            button[8].setBackground(Color.GREEN);
            return 1;
        }
        else
            return 0;
    }
}
