package TicGUI;
import org.omg.CORBA.SystemException;
import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static TicGUI.Login.q;
import static TicGUI.XOButton.*;
/**
 * Created by lirus on 8/10/16.
 */
public class Login extends JFrame {
    private static JTextField userText;
    public static JTextField text1;
    public static JFrame framem,frame;
    public static String usr,usr2,Ai,cpu;
    private static JTextField user2Text;
    public static String user_1, user_2,user_11;
    public static int option;
    public static int move, q;
    public static XOButton button[] = new XOButton[9];

    public static void main(String[] args) {
        runner();
    }
    public static void runner()
    {
        frame = new JFrame("TIC TAC TOE");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(frame, panel);
        frame.setVisible(true);
    }
    public static void placeComponents(JFrame frame, JPanel panel) {
        panel.setLayout(null);
        JLabel userLabel = new JLabel("TIC - TAC - TOE", SwingConstants.LEFT);
        userLabel.setFont(userLabel.getFont().deriveFont(24.0f));
        userLabel.setBounds(160, 50, 250, 25);
        panel.add(userLabel);
        JButton start = new JButton("Start Game");
        start.setBounds(200, 120, 120, 25);
        start.setBackground(Color.CYAN);
        panel.add(start);
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                display();
            }
        });

        JButton finish = new JButton("Exit");
        finish.setBounds(200, 170, 120, 25);
        finish.setBackground(Color.CYAN);
        panel.add(finish);
        finish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public static void display() {
        //   System.out.println("i have been called1");
        framem = new JFrame();
        option=0;
        move=0;
        framem.setSize(600, 400);
        framem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JPanel panel4 = new JPanel();
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        panel.setPreferredSize(new Dimension(600, 350));
        panel2.setLayout(new GridLayout(3, 3, 5, 5));
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 5));
        for (int i = 0; i < 9; i++) {
            button[i] = new XOButton();
            button[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel2.add(button[i]);
        }
        JPanel panel3 = new JPanel();
        panel3.setBounds(500, 250, 80, 125);
        text1 = new JTextField(20);
        panel3.add(text1);
        panel3.setPreferredSize(new Dimension(30, 20));
        Components(framem, panel1);
        panel.add(panel1);
        panel.add(panel2);
        panel4.add(panel);
        panel4.add(panel3);
        framem.add(panel4);
        framem.setVisible(true);
    }

    public static void Components(JFrame frame, JPanel panel) {
        panel.setLayout(null);

        JButton user = new JButton("User 1 vs User 2");
        user.setBounds(8, 40, 180, 25);
        user.setBackground(Color.CYAN);
        panel.add(user);
        user.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                option = 1;
                user.setBackground(Color.WHITE);
                win=false;
                move=0;
                name();
            }
        });

        JButton user1 = new JButton("User 1 vs CPU");
        user1.setBounds(8, 90, 180, 25);
        user1.setBackground(Color.CYAN);
        panel.add(user1);
        user1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    option = 2;
                    move=0;
                    win=false;
                    user1.setBackground(Color.WHITE);
                    name1();
                }

            });
        JButton ai = new JButton("AI vs CPU");
        ai.setBounds(8, 140, 180, 25);
        ai.setBackground(Color.CYAN);
        panel.add(ai);
        ai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                option = 3;
                move=0;
                win=false;
                ai.setBackground(Color.WHITE);
                int q = (int) (Math.random() * 2);
                //System.out.println(" I have been called " + q);
                if (q == 1) {
                    value=0;
                    text1.setText(" AI  starts ");
                    Ai="X";
                    cpu="O";
                    AI(1);
                } else {
                    value=0;
                    text1.setText(" CPU  starts ");
                    Ai="O";
                    cpu="X";
                    CPU();
                    }
            }

        });
        JButton ai1 = new JButton("User vs AI");
        ai1.setBounds(8, 190, 180, 25);
        ai1.setBackground(Color.CYAN);
        panel.add(ai1);
        ai1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                option = 4;
                move=0;
                win=false;
                ai1.setBackground(Color.WHITE);
                name1();
            }
        });
        JButton finish = new JButton("Exit");
        finish.setBounds(40, 240, 120, 25);
        finish.setBackground(Color.CYAN);
        panel.add(finish);
        finish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public static void name() {
        JFrame frame = new JFrame("Demo application");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        getname(frame, panel);
        frame.setVisible(true);
    }
    public static void name1() {
        JFrame frame = new JFrame("Application");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        getuser(frame, panel);
        frame.setVisible(true);
    }
    public static void getname(JFrame frame, JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User 1");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        panel.add(userText);

        JLabel user2 = new JLabel("User 2");
            user2.setBounds(10, 40, 80, 25);
            panel.add(user2);

            JTextField user2Text = new JTextField(20);
            user2Text.setBounds(100, 40, 160, 25);
            panel.add(user2Text);

        JButton k = new JButton("OK");
        k.setBounds(100, 100, 80, 25);
        panel.add(k);
        k.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                user_1 = userText.getText();
                user_2 = user2Text.getText();
                if (user_1.isEmpty())
                    JOptionPane.showMessageDialog(null, "Username 1 Field is empty");
                else if (user_2.isEmpty())
                    JOptionPane.showMessageDialog(null, "Username 2 Field is empty");
                else if (user_1.isEmpty() && user_2.isEmpty())
                    JOptionPane.showMessageDialog(null, "Username 1,2  Fields is empty");
                else {
                    int q = (int) (Math.random() * 1);
                    if (q == 1) {
                        text1.setText(user_1 + " starts ");
                        usr = "X";
                        usr2 = "O";
                    } else {
                        text1.setText(user_2 + " starts ");
                         usr = "O";
                        usr2 = "X";
                    }
                    frame.dispose();

                }
            }
        });
    }
    public static void getuser(JFrame frame, JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User 1");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        panel.add(userText);

        JButton k = new JButton("OK");
        k.setBounds(100, 100, 80, 25);
        panel.add(k);
        System.out.println(userText.getText());
        k.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                user_1 = userText.getText();
                if (user_1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Username Field is empty");
                } else {
                    q = (int) (Math.random() * 2);
                    if (option == 2) {
                        if (q == 0) {
                            value = 0;
                            text1.setText(user_1 + " starts ");
                            usr = "X";
                            cpu = "O";
                        } else {
                            text1.setText(" CPU starts ");
                            value = 0;
                            usr = "O";
                            cpu = "X";
                            CPU();
                        }

                    } else {
                        if (q == 0) {
                            value = 0;
                            text1.setText(user_1 + " starts ");
                            usr = "X";
                            Ai = "O";
                        } else {
                            text1.setText(" AI starts ");
                            value = 0;
                            usr = "O";
                            Ai = "X";
                            AI(1);
                        }
                    }
                    frame.dispose();
                }
            }
        });

    }
    public static void CPU() {
        int n;
        final int x1;
         n = (int) (Math.random() * 8);
        while (button[n].getText() != "")
            n = (int) (Math.random() * 8);
        x1=n;
        new Thread(new Runnable(){
            public void run(){
                try{
                    Thread.sleep(800);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
                button[x1].doClick();
            }
        }).start();
    }
    public static void AI(int i) {
        int z=0;
        final int z1;
            if (i == 0) {
                if (button[0].getText().equals("O") && button[1].getText().equals("O") && button[2].getText().equals("")) {
                   z=2;
                } else if (button[0].getText().equals("O") && button[3].getText().equals("O") && button[6].getText().equals("")) {
                   z=6;
                } else if (button[0].getText().equals("O") && button[4].getText().equals("O") && button[8].getText().equals("")) {
                    z=8;
                } else if (button[1].getText().equals("O") && button[2].getText().equals("O") && button[0].getText().equals("")) {
                    z=0;
                } else if (button[1].getText().equals("O") && button[4].getText().equals("O") && button[7].getText().equals("")) {
                    z=7;
                } else if (button[2].getText().equals("O") && button[5].getText().equals("O") && button[8].getText().equals("")) {
                    z=8;
                } else if (button[2].getText().equals("O") && button[4].getText().equals("O") && button[6].getText().equals("")) {
                    z=6;
                } else if (button[3].getText().equals("O") && button[6].getText().equals("O") && button[0].getText().equals("")) {
                    z=0;
                } else if (button[3].getText().equals("O") && button[4].getText().equals("O") && button[5].getText().equals("")) {
                    z=5;
                } else if (button[4].getText().equals("O") && button[6].getText().equals("O") && button[2].getText().equals("")) {
                    z=2;
                } else if (button[4].getText().equals("O") && button[7].getText().equals("O") && button[1].getText().equals("")) {
                  z=1;
                } else if (button[4].getText().equals("O") && button[8].getText().equals("O") && button[0].getText().equals("")) {
                    z=0;
                } else if (button[4].getText().equals("O") && button[5].getText().equals("O") && button[3].getText().equals("")) {
                   z=3;
                } else if (button[0].getText().equals("O") && button[2].getText().equals("O") && button[1].getText().equals("")) {
                   z=1;
                } else if (button[0].getText().equals("O") && button[6].getText().equals("O") && button[3].getText().equals("")) {
                    z=3;
                } else if (button[0].getText().equals("O") && button[8].getText().equals("O") && button[4].getText().equals("")) {
                    z=4;
                } else if (button[1].getText().equals("O") && button[7].getText().equals("O") && button[4].getText().equals("")) {
                    z=4;
                } else if (button[2].getText().equals("O") && button[8].getText().equals("O") && button[5].getText().equals("")) {
                    z=5;
                } else if (button[2].getText().equals("O") && button[6].getText().equals("O") && button[4].getText().equals("")) {
                  z=4;
                } else if (button[3].getText().equals("O") && button[5].getText().equals("O") && button[3].getText().equals("")) {
                    z=4;
                } else if (button[0].getText().equals("X") && button[1].getText().equals("X") && button[2].getText().equals("")) {
                    z=2;
                } else if (button[0].getText().equals("X") && button[3].getText().equals("X") && button[6].getText().equals("")) {
                    z=6;
                } else if (button[0].getText().equals("X") && button[4].getText().equals("X") && button[8].getText().equals("")) {
                    z=8;
                } else if (button[1].getText().equals("X") && button[2].getText().equals("X") && button[0].getText().equals("")) {
                    z=0;
                } else if (button[1].getText().equals("X") && button[4].getText().equals("X") && button[7].getText().equals("")) {
                   z=7;
                } else if (button[2].getText().equals("X") && button[5].getText().equals("x") && button[8].getText().equals("")) {
                    z=8;
                } else if (button[2].getText().equals("X") && button[4].getText().equals("X") && button[6].getText().equals("")) {
                    z=6;
                } else if (button[3].getText().equals("X") && button[6].getText().equals("X") && button[0].getText().equals("")) {
                    z=0;
                } else if (button[3].getText().equals("X") && button[4].getText().equals("X") && button[5].getText().equals("")) {
                    z=5;
                } else if (button[4].getText().equals("X") && button[6].getText().equals("X") && button[2].getText().equals("")) {
                   z=2;
                } else if (button[4].getText().equals("X") && button[7].getText().equals("X") && button[1].getText().equals("")) {
                    z=1;
                } else if (button[4].getText().equals("X") && button[8].getText().equals("X") && button[0].getText().equals("")) {
                    z=0;
                } else if (button[4].getText().equals("X") && button[5].getText().equals("X") && button[3].getText().equals("")) {
                    z=3;
                } else if (button[0].getText().equals("X") && button[2].getText().equals("X") && button[1].getText().equals("")) {
                   z=1;
                } else if (button[0].getText().equals("X") && button[6].getText().equals("X") && button[3].getText().equals("")) {
                    z=3;
                } else if (button[0].getText().equals("X") && button[8].getText().equals("X") && button[4].getText().equals("")) {
                    z=4;
                } else if (button[1].getText().equals("X") && button[7].getText().equals("X") && button[4].getText().equals("")) {
                   z=4;
                } else if (button[2].getText().equals("X") && button[8].getText().equals("X") && button[5].getText().equals("")) {
                 z=5;
                } else if (button[2].getText().equals("X") && button[6].getText().equals("X") && button[4].getText().equals("")) {
                    z=4;
                } else if (button[3].getText().equals("X") && button[5].getText().equals("X") && button[4].getText().equals("")) {
                    z=4;
                } else {
                    int n = (int) (Math.random() * 8);
                    while (button[n].getText() != "")
                        n = (int) (Math.random() * 8);
                    z=n;
                }
                z1=z;
            }
            else {
                if (button[0].getText().equals("X") && button[1].getText().equals("X") && button[2].getText().equals("")) {
                    z=2;
                } else if (button[0].getText().equals("X") && button[3].getText().equals("X") && button[6].getText().equals("")) {
                    z=6;
                } else if (button[0].getText().equals("X") && button[4].getText().equals("X") && button[8].getText().equals("")) {
                    z=8;
                } else if (button[1].getText().equals("X") && button[2].getText().equals("X") && button[0].getText().equals("")) {
                    z=0;
                } else if (button[1].getText().equals("X") && button[4].getText().equals("X") && button[7].getText().equals("")) {
                    z=7;
                } else if (button[2].getText().equals("X") && button[5].getText().equals("X") && button[8].getText().equals("")) {
                    z=8;
                } else if (button[2].getText().equals("X") && button[4].getText().equals("X") && button[6].getText().equals("")) {
                  z=6;
                } else if (button[3].getText().equals("X") && button[6].getText().equals("X") && button[0].getText().equals("")) {
                    z=0;
                } else if (button[3].getText().equals("X") && button[4].getText().equals("x") && button[5].getText().equals("")) {
                    z=5;
                } else if (button[4].getText().equals("X") && button[6].getText().equals("X") && button[2].getText().equals("")) {
                    z=2;
                } else if (button[4].getText().equals("X") && button[7].getText().equals("X") && button[1].getText().equals("")) {
                z=1;
                } else if (button[4].getText().equals("X") && button[8].getText().equals("X") && button[0].getText().equals("")) {
                    z=0;
                } else if (button[4].getText().equals("X") && button[5].getText().equals("X") && button[3].getText().equals("")) {
                    z=3;
                } else if (button[0].getText().equals("X") && button[2].getText().equals("X") && button[1].getText().equals("")) {
                    z=1;
                } else if (button[0].getText().equals("X") && button[6].getText().equals("X") && button[3].getText().equals("")) {
                    z=3;
                } else if (button[0].getText().equals("X") && button[8].getText().equals("X") && button[4].getText().equals("")) {
                    z=4;
                } else if (button[1].getText().equals("X") && button[7].getText().equals("X") && button[4].getText().equals("")) {
                   z=4;
                } else if (button[2].getText().equals("X") && button[8].getText().equals("X") && button[5].getText().equals("")) {
                    z=5;
                } else if (button[2].getText().equals("X") && button[6].getText().equals("X") && button[4].getText().equals("")) {
                  z=4;
                } else if (button[3].getText().equals("X") && button[5].getText().equals("X") && button[4].getText().equals("")) {
                    z=4;
                } else if (button[0].getText().equals("O") && button[1].getText().equals("O") && button[2].getText().equals("")) {
                   z=2;
                } else if (button[0].getText().equals("O") && button[3].getText().equals("O") && button[6].getText().equals("")) {
                   z=6;
                } else if (button[0].getText().equals("O") && button[4].getText().equals("O") && button[8].getText().equals("")) {
                    z=8;
                } else if (button[1].getText().equals("O") && button[2].getText().equals("O") && button[0].getText().equals("")) {
                   z=0;
                } else if (button[1].getText().equals("O") && button[4].getText().equals("O") && button[7].getText().equals("")) {
                   z=7;
                } else if (button[2].getText().equals("O") && button[5].getText().equals("O") && button[8].getText().equals("")) {
                    z=8;
                } else if (button[2].getText().equals("O") && button[4].getText().equals("O") && button[6].getText().equals("")) {
                    z=6;
                } else if (button[3].getText().equals("O") && button[6].getText().equals("O") && button[0].getText().equals("")) {
                    z=0;
                } else if (button[3].getText().equals("O") && button[4].getText().equals("O") && button[5].getText().equals("")) {
                    z=5;
                } else if (button[4].getText().equals("O") && button[6].getText().equals("O") && button[2].getText().equals("")) {
                    z=2;
                } else if (button[4].getText().equals("O") && button[7].getText().equals("O") && button[1].getText().equals("")) {
                    z=1;
                } else if (button[4].getText().equals("O") && button[8].getText().equals("O") && button[0].getText().equals("")) {
                    z=0;
                } else if (button[4].getText().equals("O") && button[5].getText().equals("O") && button[3].getText().equals("")) {
                   z=3;
                } else if (button[0].getText().equals("O") && button[2].getText().equals("O") && button[1].getText().equals("")) {
                    z=1;
                } else if (button[0].getText().equals("O") && button[6].getText().equals("O") && button[3].getText().equals("")) {
                    z=3;
                } else if (button[0].getText().equals("O") && button[8].getText().equals("O") && button[4].getText().equals("")) {
                    z=4;
                } else if (button[1].getText().equals("O") && button[7].getText().equals("O") && button[4].getText().equals("")) {
                    z=4;
                } else if (button[2].getText().equals("O") && button[8].getText().equals("O") && button[4].getText().equals("")) {
                    z=4;
                } else if (button[2].getText().equals("O") && button[6].getText().equals("O") && button[4].getText().equals("")) {
                    z=4;
                } else if (button[3].getText().equals("O") && button[5].getText().equals("O") && button[4].getText().equals("")) {
                    z=4;
                } else {
                    int n = (int) (Math.random() * 8);
                    while (button[n].getText() != "")
                        n = (int) (Math.random() * 8);
                    z=n;
                }
                    z1=z;
            }
        new Thread(new Runnable(){
            public void run(){
                try{
                    Thread.sleep(800);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
                button[z1].doClick();
            }
        }).start();
    }
}
