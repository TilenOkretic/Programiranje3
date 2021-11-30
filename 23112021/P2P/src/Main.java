import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

class Main {

    public static final int PORT = 6000;
    public static Vector<Peer> peers = new Vector<>();
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println(Constants.UTIL + "listening on port " + PORT);
            while(true) {
                Socket connection = server.accept();
                System.out.println(Constants.MISC + "Connection accepted on port " + connection.getPort());
                Peer p = new Peer(connection);
                peers.add(p);
                p.start();
            }
        } catch (IOException e) {
            System.out.println(Constants.ERROR + "port already in use");
        }
    }

}