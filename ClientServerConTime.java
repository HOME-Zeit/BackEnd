package client_ServerRequests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Nevanor
 */
public class ClientServerConTime 
{
    //Vorbereiten der notwendigen Variablen und Objekte
    private static BufferedReader bufferedReader;
    private static Socket socket;
    private static String inputLine;
    private static String returnString; 
    
    public static String clkCon()
    {
        try
        {
            //start der übertragung - Einfacher Empfang von Daten über BufferedReader
            socket = new Socket("localhost",55303);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while((inputLine = bufferedReader.readLine())!=null)
                returnString = inputLine;
            bufferedReader.close();
            socket.close();
            //ende der übertragung
        }
        catch(Exception e)
        {
            System.out.println(e+"\n!Socket Problem!");
        }
        
        return returnString;
    }
    public static String dateCon()
    {
        try
        {
            //start der übertragung - Einfacher Empfang von Daten über BufferedReader
            socket = new Socket("localhost",55302);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while((inputLine = bufferedReader.readLine())!=null)
                returnString = inputLine;
            bufferedReader.close();
            socket.close();
            //ende der übertragung
        }
        catch(Exception e)
        {
            System.out.println(e+"\n!Socket Problem!");
        }
        
        return returnString;
    }
    public static long secCon()
    {
        try
        {
            //start der übertragung - Einfacher Empfang von Daten über BufferedReader
            socket = new Socket("localhost",55301);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while((inputLine = bufferedReader.readLine())!=null)
                returnString = inputLine;
            bufferedReader.close();
            socket.close();
            //ende der übertragung
        }
        catch(Exception e)
        {
            System.out.println(e+"\n!Socket Problem!");
        }
        //Empfangenen String auf long parsen vor der Rückgabe
        return Long.parseLong(returnString,10);
    }
}
