import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Peer extends Thread {
    Socket connection;
    BufferedReader in;
    BufferedWriter out;
    Gson gson;
    public Peer(Socket connection) throws IOException {
        this.connection = connection;
        this.gson = new Gson();
        this.in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        this.out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
    }

    @Override
    public void run() {
        String recived;
        try {
            while(connection.isConnected() && (recived = in.readLine()) != null) {
                System.out.println(Constants.RECEIVE  + "Message from:" + connection.hashCode());
                System.out.println(Constants.RECEIVE  + "Message payload:" + recived);

                Message m = gson.fromJson(recived, Message.class);
                System.out.println("Header " +m.header);
                System.out.println("time " +m.timestamp);
                System.out.println("Body " +m.body);
            }
        } catch (IOException e) {
            System.out.println(Constants.ERROR + "Something broke");
            in.close();
            out.close();
            connection.close();
            System.out.println(Constants.UTIL + "Connection closed");
        }
    }
}
