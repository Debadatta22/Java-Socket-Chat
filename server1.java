import java.io.*;
import java.net.*;

class Server1 {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(12345);
        Socket s = ss.accept();
        System.out.println("Connected to Client");

        // Reading from client
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String z = br.readLine(); // Reading from client
        System.out.println("From client: " + z);

        // Reverse and send data back to client
        StringBuffer sb = new StringBuffer(z);
        sb = sb.reverse();
        z = sb.toString();

        PrintStream out = new PrintStream(s.getOutputStream(), true);
        out.println(z); // Writing to client

        br.close();
        out.close();
    }
}
// done by Debadatta Rout
// routdebadatta22@gmail.com
// ----Credits-----------------
// Coaching- PythonSoft LLP training
// Educator- Gitesh Sir
