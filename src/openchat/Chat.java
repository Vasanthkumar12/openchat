package openchat;

import java.io.*;
import java.net.*;
import openchat.data.ChatMessage;

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
            System.out.println("Message Sent.");            // dis.close();
        } catch (Exception e) {
            System.out.println("Error sending message: "+e);
        }
    }

    public ChatMessage receive() {
        try {
            System.out.println("Receiving message..");
            DataInputStream dis = new DataInputStream(this.s.getInputStream());
            Byte str = dis.readByte();
            return new ChatMessage(str.toString(),"","","");

        } catch (Exception e) {
            System.out.println("Error reading message" + e);
            return null;
        }
    }

}
