import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)){
            Socket socket = serverSocket.accept();
            System.out.println("Server accepts");
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while(true){
                String echoString = input.readLine();
                System.out.println("Sever got request data: " + echoString);
                if(echoString.equals("exit")){
                    break;
                }
                output.println("Echo from server: " + echoString);
            }
        } catch (IOException e){
            System.out.println("Server exception " + e.getMessage());
        }
    }
}
