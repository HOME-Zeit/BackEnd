package client_ServerRequests;

import java.io.*;
/**
 *
 * @author Nevanor
 */
public class IntBool implements Serializable
{
    int number;
    boolean truefalse;
    public IntBool (int number, boolean truefalse)
    {
        this.number = number;
        this.truefalse = truefalse;
    }
}
//Anlegen von Constructor um Übergabevariablen in ein einzelnes Objekt zu binden um die Übertragung zu erleichtern
