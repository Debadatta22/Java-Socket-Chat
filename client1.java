import java.io.*;
import java.net.*;

class Client1 {
    public static void main(String args[]) throws Exception {
        Socket c = new Socket(InetAddress.getLocalHost(), 12345);
        System.out.println("Connected to Server");

        // Sending to server
        String z = "Hello Server";
        PrintStream out = new PrintStream(c.getOutputStream(), true);
        out.println(z);

        // Reading from server
        BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
        z = br.readLine();
        System.out.println("From Server: " + z);

        out.close();
        br.close();
    }
}
// done by Debadatta Rout
// routdebadatta22@gmail.com
// ----Credits-----------------
// Coaching- PythonSoft LLP training
// Educator- Gitesh Sir
