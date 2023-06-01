import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class frame extends JFrame {
    JTextField jtf;
    JLabel lb;
    JButton jbt;

    public frame() {

        super();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250, 200);
        jbt = new JButton();
        jtf = new JTextField(10);
        this.add(jtf);
        jbt.setSize(70, 30);
        jbt.setText("claer");
        this.add(jbt);
        lb = new JLabel();
        jtf.setBounds(50, 50, 100, 50);
        this.add(lb);
        Timer timer = new Timer();
        // This code is called when the Clear button is clicked.
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf.setText("");
                lb.setText("");
                timer.cancel();
                
            }
        });

        // this.setLayout(new FlowLayout());
        jtf.addActionListener(new JTextFieldlistener());
        this.setVisible(true);
    }

    class JTextFieldlistener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            

            String ans = jtf.getText();
            Timer timer = new Timer();
            jtf.setEditable(false);
            // jbt.setAction(jtf.setText(""));
                    // This code is called when the Clear button is clicked.
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf.setText("");
                lb.setText("");
                timer.cancel();
                jtf.setEditable(true);
                
                
            }
        });

            timer.scheduleAtFixedRate(new TimerTask() {
                int counter = Integer.parseInt(ans);

                @Override
                public void run() {

                    jtf.setText("Countdown:" + counter--);
                    if (counter < 0) {
                        timer.cancel();
                        lb.setText("End!");
                        jtf.setEditable(true);
                        // System.out.println("Countdown:" + counter--);

                    }

                }

            }, 0, 1000);

        }
    }
}
