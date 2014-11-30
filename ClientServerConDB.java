package client_ServerRequests;

import java.util.ArrayList;
import java.net.Socket;
import java.io.*;
/**
 *
 * @author Nevanor
 */
public class ClientServerConDB extends RequestServer
{
    //Aufsetzen der notwendigen Variablen und Objekte für Socketverbindungen
    private static Socket socket;
    //private static FileOutputStream fileOut;
    //private static FileInputStream fileIn;
    private static ObjectOutputStream oOut;
    private static ObjectInputStream oIn;
    private static ArrayList answer = new ArrayList();
    
    public static ArrayList minorCon (long time, boolean truefalse)
    {
        //Einsetzen der Übergabe Variablen in ein Objekt, zum vereinfachen der Verbindung
        LongBool longBool = new LongBool(time,truefalse);
        try
        {
            //start der Übertragung
            socket = new Socket("localhost",1);
            //fileOut = new FileOutputStream("/tmp/longBool.ser");
            oOut = new ObjectOutputStream(socket.getOutputStream());
            oOut.writeObject(longBool);
            oOut.flush();   //flush um verbleibende Daten zu vollen Paketen aufzufüllen und heraus zu schieben
            oOut.close();
            //Übergang von Senden zu Empfangen
            oIn =  new ObjectInputStream(socket.getInputStream());
            try{answer = (ArrayList) oIn.readObject();}catch(ClassNotFoundException e){System.out.println(e);}
            oIn.close();

            socket.close();
            //ende der Übertragung
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return answer;
    }
    public static ArrayList majorCon (boolean truefalse)
    {
        try
        {
            //start der Übertragung
            socket = new Socket("localhost",1);
            //fileOut = new FileOutputStream("/tmp/longBool.ser");
            oOut = new ObjectOutputStream(socket.getOutputStream());
            oOut.writeObject(truefalse);
            oOut.flush();
            oOut.close();
            //Übergang von Senden zu Empfangen
            oIn =  new ObjectInputStream(socket.getInputStream());
            try{answer = (ArrayList) oIn.readObject();}catch(ClassNotFoundException e){System.out.println(e);}
            oIn.close();

            socket.close();
            //ende der Übertragung
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return answer;
    }
    public static ArrayList numberCon (int number, boolean truefalse)
    {
        //Einsetzen der Übergabe Variablen in ein Objekt, zum vereinfachen der Verbindung
        IntBool intBool = new IntBool(number,truefalse);
        try
        {
            //start der Übertragung
            socket = new Socket("localhost",1);
            //fileOut = new FileOutputStream("/tmp/longBool.ser");
            oOut = new ObjectOutputStream(socket.getOutputStream());
            oOut.writeObject(intBool);
            oOut.flush();
            oOut.close();
            //Übergang von Senden zu Empfangen
            oIn =  new ObjectInputStream(socket.getInputStream());
            try{answer = (ArrayList) oIn.readObject();}catch(ClassNotFoundException e){System.out.println(e);}
            oIn.close();

            socket.close();
            //ende der Übertragung
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return answer;
    }
}
