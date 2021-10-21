package openchat.data;

public class ChatMessage {
    public String message;
    public String username;
    public String timeSent;
    public String timeReceived;
    public ChatMessage(String message, String username, String timeSent, String timeReceived){

        this.timeReceived = timeReceived;
        this.message = message;
        this.username = username;
        this.timeSent = timeSent;
    }
}
