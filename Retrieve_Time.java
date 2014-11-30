package server_NTPRequest;

import java.net.InetAddress;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
/**
 *
 * @author Nevanor
 */
public class Retrieve_Time 
{
    //festlegen eines Zeitservers, jederzeit hier änderbar, nicht allgemeiner standard
    final private static String TIME_SERVER = "time-a.nist.gov";

    public static long getTime() throws Exception 
    {
        //verbindung zum NTP aufbauen 
        NTPUDPClient timeClient = new NTPUDPClient();
        InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
        TimeInfo timeInfo = timeClient.getTime(inetAddress);    //org.apache.commons.net.ntp.TimeInfo@2503dbd3
        //erlangte Daten auf epoch zuschneiden
        long returnTime = timeInfo.getReturnTime();             //1415862544656
        //Date time = new Date(returnTime);                     //Thu Nov 13 08:09:04 CET 2014
        
        return returnTime;
    }
    //bei nichtverfügbarkeit des NTP die lokale zeit benutzen
    public static long getTime_failed()
    {
        //aktuelle systemzeit beziehen
        long time = System.currentTimeMillis();
        return time;
    }
}
