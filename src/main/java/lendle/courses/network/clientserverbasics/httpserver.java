/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lendle.courses.network.clientserverbasics;

import static java.awt.Color.BLACK;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.paint.Color.color;

/**
 *
 * @author user
 */
public class httpserver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            ServerSocket server = new ServerSocket(5080);
            while(true){
                Socket client = server.accept();
                OutputStream outputStream = client.getOutputStream();
                OutputStreamWriter writer = new OutputStreamWriter(outputStream, "utf-8");
                writer.write("HTTP/1.0 200 OK\r\n\r\n");
                writer.write("<body style='background-color: BLACK'><hl>Hello jk</hl></body>");
                writer.flush();
                writer.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(httpserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
