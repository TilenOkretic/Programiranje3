public class Message {
    long timestamp;
    String header;
    String body;

    public Message(long timestamp, String header, String body) {
        this.timestamp = timestamp;
        this.header = header;
        this.body = body;    
    }
}
