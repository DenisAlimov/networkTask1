import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {

    private static final String HOST = "netology.homework";//netology.homework
    private static final int PORT = 8089;
    public static Scanner SCANNER = new Scanner(System.in);


    public static void main(String[] args) {
        String answer = "0";

        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String buffer = in.readLine();

            while (!buffer.isEmpty()) {
                System.out.println(buffer);
                if (answer.equals("yes")||answer.equals("no")) return;
                answer = SCANNER.nextLine();
                out.println(answer);
                buffer = in.readLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}