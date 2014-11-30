package server_loops;

import server_NTPRequest.Retrieve_Time;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.IOException;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
/**
 *
 * @author Nevanor
 */
public class TimeLoopClk extends Thread 
{
    //Vorbereitung der notwendigen variablen und objekte
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static PrintWriter printWriter;
    long epoch = 0;
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    Date date = new Date();
    
    public void run()
    {
        System.out.println("Clk READY! Waiting for Clients...");
        while(true)
        {
            try
            {
                //aufbau der Verbindung und warten auf client
                serverSocket = new ServerSocket(55303);
                clientSocket = serverSocket.accept();
                printWriter = new PrintWriter(clientSocket.getOutputStream(),true);
                //nach eingang der anfrage die aktuelle zeit abrufen vom NTPServer
                try
                {
                    epoch = Retrieve_Time.getTime();
                    date = new Date(epoch);
                }
                //bei nichtverfügbarkeit die eigene Systemzeit benutzen
                catch(Exception e)
                {
                    epoch = Retrieve_Time.getTime_failed();
                    date = new Date(epoch);
                }
                //die ermittelte zeit senden über printWriter
                printWriter.println(dateFormat.format(date));
                printWriter.flush();
                printWriter.close();
                serverSocket.close();
                clientSocket.close();
                //ende der übertragung
                try{Thread.sleep(50);}catch(Exception e){}
            }
            catch(IOException e)
            {
                System.out.println(e+": Socket 3Problem");
                return;
            }
        }
    }
}
