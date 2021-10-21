import openchat.Client;
import openchat.CallOnConnect;
import openchat.Chat;

class ChatApp {
    private Chat chat = null;
    private Client client = null;

    class ConnectionStatus implements CallOnConnect {
        public void onConnected() {
            System.out.println("Connected to Server, can Start a chat now.");
            chat = client.getChatInstance();
            chat.send("hello", "nithi");
        }
    }

    public void startApp() {
        this.client = new Client(new ConnectionStatus());

    }

}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Openchat app Started");
        ChatApp app = new ChatApp();
        app.startApp();
    }   
}
