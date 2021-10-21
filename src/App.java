import openchat.Client;
import openchat.CallOnConnect;

class ConnectionStatus implements CallOnConnect{
    public void onConnected(){
        System.out.println("Connected to Server, can Start a chat now.");
    }
}
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Openchat app Started");
        Client client = new Client(new ConnectionStatus());
    }
}
    