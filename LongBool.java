package client_ServerRequests;

import java.io.*;
/**
 *
 * @author Nevanor
 */
public class LongBool implements Serializable
{
    long time;
    boolean truefalse;
    public LongBool (long time, boolean truefalse)
    {
        this.time = time;
        this.truefalse = truefalse;
    }
}
//Anlegen von Constructor um Übergabevariablen in ein einzelnes Objekt zu binden um die Übertragung zu erleichtern
