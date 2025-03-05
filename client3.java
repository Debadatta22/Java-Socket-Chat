import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

class Client3 extends Frame implements Runnable {
    TextArea ta;
    TextField t1;
    Button b1;
    BufferedReader br;
    PrintStream out;

    Client3() {
        super("Client");
        setFont(new Font("Arial", Font.BOLD, 20));
        Panel p1 = new Panel();
        p1.setBackground(Color.orange);

        p1.add(t1 = new TextField(10));
        p1.add(b1 = new Button("Send"));
        add("South", p1);
        add("Center", ta = new TextArea(10, 30));

        b1.addActionListener(new Lis());
        setSize(600, 700);
        setLocation(700, 100);
        setVisible(true);

        try {
            Socket c = new Socket(InetAddress.getLocalHost(), 12345);
            System.out.println("Connected to Server");

            br = new BufferedReader(new InputStreamReader(c.getInputStream()));
            out = new PrintStream(c.getOutputStream(), true);

            Thread tt = new Thread(this);
            tt.setDaemon(true);
            tt.start();
        } catch (Exception ae) {
            System.out.println("Client error: " + ae);
        }
    }

    class Lis implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            String z = t1.getText();
            out.println(z);
            ta.append("Me: " + z + "\n");
            t1.setText("");
        }
    }

    public void run() {
        while (true) {
            try {
                String z = br.readLine();
                ta.append("Server: " + z + "\n");
            } catch (Exception e) {
            }
        }
    }

    public static void main(String args[]) throws Exception {
        new Client3();
    }
}
// done by Debadatta Rout
// routdebadatta22@gmail.com
// ----Credits-----------------
// Coaching- PythonSoft LLP training
// Educator- Gitesh Sir
