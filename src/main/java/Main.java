import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8089;
        String name = null;

        while (true) {
            ServerSocket serverSocket = new ServerSocket(port); // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
            Socket clientSocket = serverSocket.accept(); // ждем подключения
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println("Write your name.");
            String answer = in.readLine();

            if (answer.equals("Den")) {
                System.out.println(answer);
                out.println("Are you child? (yes/no)");
                name = answer;
            }
            answer = in.readLine();
            if (answer.equals("yes")) {
                System.out.println(answer);
                out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
            } else if (answer.equals("no")) {
                System.out.println(answer);
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
            }
            serverSocket.close();
            break;
        }
    }
}