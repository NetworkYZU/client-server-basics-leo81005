/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.network.clientserverbasics;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author user
 */
public class timeserver {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
            ServerSocket server = new ServerSocket(13);
        while(true){
            Socket client = server.accept();
            OutputStream outputStream = client.getOutputStream();
            try (OutputStreamWriter writer = new OutputStreamWriter(outputStream, "ascii")) {
                Date date = new Date();
                writer.write(date.toString());
                writer.flush();
            }
        }
        
    }
    
}
