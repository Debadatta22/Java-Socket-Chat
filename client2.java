import java.io.*;
import java.net.*;

class Client2 {
    public static void main(String args[]) throws Exception {
        Socket c = new Socket(InetAddress.getLocalHost(), 12345);
        System.out.println("Connected to Server");

        PrintStream out = new PrintStream(c.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        String z;
        System.out.println("Enter data, type 'exit' to terminate:");
        while (!(z = kb.readLine()).equalsIgnoreCase("exit")) {
            out.println(z);
            z = br.readLine();
            System.out.println("From Server: " + z);
        }

        out.println("exit");
        out.close();
        br.close();
    }
}
// done by Debadatta Rout
// routdebadatta22@gmail.com
// ----Credits-----------------
// Coaching- PythonSoft LLP training
// Educator- Gitesh Sir
