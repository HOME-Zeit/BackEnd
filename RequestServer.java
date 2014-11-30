package client_ServerRequests;

import java.util.ArrayList;
/**
 *
 * @author Nevanor
 */
public class RequestServer 
{
    //Methoden die der Client benutzt um eine Anfrage an den Server zu stellen über Programminformation-ArrayList-Objekte
    public static ArrayList requestMinor(long time, boolean truefalse)
    {
        //Fragt den Server nach Programminformationen im Bereich -4h bis +20h
        return ClientServerConDB.minorCon(time,truefalse);
    }
    public static ArrayList requestMajor(boolean truefalse)
    {
        //Fragt den Server nach ALLEN Programminformation'en
        return ClientServerConDB.majorCon(truefalse);
    }
    public static ArrayList requestNumber(int number, boolean truefalse)
    {
        //Fragt den Server nach der PRogramminformation mit der mitgegebenen Seriennummer
        return ClientServerConDB.numberCon(number,truefalse);
    }
    
    //-------------------------------------------------------
    
    //Methoden die der Client benutzt um eine Anfrage an den Server zu stellen über die Zeit
    public static String requestClk ()
    {
        //Fragt den Server nach der aktuellen Zeit im format hh:mm:ss (String)
        return ClientServerConTime.clkCon();
    }
    public static String requestDate ()
    {
        //Fragt den Server nach der aktuellen Zeitinformation im Format Date(vollständig)(String)
        return ClientServerConTime.dateCon();
    }
    public static long requestSec ()
    {
        //Fragt den Server nach der aktuellen Zeit als epoch (long)
        return ClientServerConTime.secCon();
    }
}
