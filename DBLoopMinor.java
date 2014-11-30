package server_loops;

import java.net.ServerSocket;
import java.net.Socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import datenbank.Datenbank;

/**
 *
 * @author Nevanor
 */
public class DBLoopMinor extends Thread
{
    //Vorbereitungen für Socket Übertragung
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static ObjectOutputStream oOut;
    private static ObjectInputStream oIn;
    private static LongBool longBool = new LongBool(0,false);
    private static ArrayList returnThis = new ArrayList();
    
    public void run() //spezielle "run" Methode um mit Thread zu arbeiten
    {
        while(true)
        {
            try
            {
                //Socket öffnen und auf Anfrage mit ÜbergabeObjekt warten
                serverSocket = new ServerSocket(55305);
                clientSocket = serverSocket.accept();
                oIn =  new ObjectInputStream(clientSocket.getInputStream());
                try{longBool = (LongBool) oIn.readObject();}catch(ClassNotFoundException e){System.out.println(e);}
                oIn.close();
                //Ende des Empfangens
                
                //TODO Minor besorgen von DB
                //Anfrage an die Datenbank vom Server mit den Übergabevariablen
                returnThis = Datenbank.ausgeben(longBool.time,longBool.truefalse);
                
                //Rückgabe der ermittelten Programminformation'en in form einer ArrayList
                oOut = new ObjectOutputStream(clientSocket.getOutputStream());
                oOut.writeObject(returnThis);
                oOut.flush();
                oOut.close();
                //Ende des Sendens von Daten
                serverSocket.close();
                clientSocket.close();
                //Ender der Übertragung
                try{Thread.sleep(50);}catch(Exception e){System.out.println(e);} //Sleep um Überlastung der Sockets zu unterbinden
            }
            catch(IOException e)
            {
                System.out.println(e+": 5Socket Problem");
                return;
            }
        }
    }
}
