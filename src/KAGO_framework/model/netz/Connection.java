package KAGO_framework.model.netz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection {

    private Socket socket;
    private BufferedReader fromServer;
    private PrintWriter toServer;

    public Connection(String pServerIP, int pServerPort) {
        try{
            socket = new Socket(pServerIP, pServerPort);
            toServer = new PrintWriter(socket.getOutputStream(), true);
            fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }catch(Exception e){
            socket = null;
            toServer = null;
            fromServer = null;
        }
    }

    public String receive() {
        if(fromServer != null)
            try{
                return fromServer.readLine();
            }catch (IOException ignored){}
        return(null);
    }

    public void send(String pMessage) {
        if(toServer != null) toServer.println(pMessage);

    }

    public void close() {
        if(socket != null && !socket.isClosed())
            try{
                socket.close();
            }catch(IOException ignored){}
    }
}
