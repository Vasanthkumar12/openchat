package openchat;

import java.net.*;
import java.io.*;

public class Client extends Thread {
    private Socket socket = null;
    private CallOnConnect onConnected = null;
    private Chat chatInstance = null;

    public Client( CallOnConnect con ){
        System.out.println("Hello CLient Created vasanth");
        this.start();
        this.onConnected =con;
    }

    public void run(){
        System.out.println("Thread Started.");
        while(this.socket==null){
            this.connect();
        }
        onConnected.onConnected();
    }  
    
    synchronized public void connect(){
        try{
            this.socket = new Socket(Config.SERVER_ADDRESS, Config.SERVER_PORT);
        }catch(Exception e){
            System.out.println("Connection failed, Retrying..."+e);
        }
    }
    public Chat getChatInstance(){
        if(this.chatInstance==null){
            this.chatInstance = new Chat(this.socket);
        }
        return this.chatInstance;
    }
}
