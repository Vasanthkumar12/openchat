import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(55551);
        Socket socket=serverSocket.accept();
        DataInputStream readString=new DataInputStream(socket.getInputStream());
        String str=readString.readUTF();
        System.out.println(str);


    }
}
