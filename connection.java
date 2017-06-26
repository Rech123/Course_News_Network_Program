import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by rashed on 5/3/2017.
 */
public class connection {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
          //  Socket connection_proxy = new Socket("192.168.0.102",9409);
          //  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection_proxy.getInputStream()));
          //  String Serve_ip_address =bufferedReader.readLine();
          //  bufferedReader.close();


            Socket client =new Socket("192.168.0.102",9109);
            System.out.println("connection");

            PrintStream out = new PrintStream(client.getOutputStream(),true);

            BufferedReader bin = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String Server_message =bin.readLine();
            System.out.println(Server_message);
            String studentnme =sc.next();
            out.println(studentnme);

            String news =bin.readLine();




                System.out.println(" Course news : "+news);


            bin.close();



            out.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }}
