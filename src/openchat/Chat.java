package openchat;

import java.io.*;
import java.net.*;

public class Chat {
    private Socket s = null;

    public Chat(Socket s) {
        this.s = s;
    }

    public void send(String msg, String userName) {
        try {
            DataOutputStream dis = new DataOutputStream(this.s.getOutputStream());
            dis.writeUTF("message: " + msg + " " + "userName: " + userName);
            dis.flush();
            dis.close();
        } catch (Exception e) {
            System.out.println("Error sending message");
        }
    }

}
