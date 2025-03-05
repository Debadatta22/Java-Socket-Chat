import java.io.*;
import java.net.*;

class Server2 {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(12345);
        Socket s = ss.accept();
        System.out.println("Connected to Client");

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintStream out = new PrintStream(s.getOutputStream(), true);

        String z;
        while (!(z = br.readLine()).equalsIgnoreCase("exit")) {
            System.out.println("From client: " + z);

            // Reverse and send data back to client
            StringBuffer sb = new StringBuffer(z);
            sb = sb.reverse();
            z = sb.toString();
            out.println(z);
        }
        br.close();
        out.close();
    }
}
// done by Debadatta Rout
// routdebadatta22@gmail.com
// ----Credits-----------------
// Coaching- PythonSoft LLP training
// Educator- Gitesh Sir
