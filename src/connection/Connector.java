/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import org.json.JSONObject;

/**
 *
 * @author VIVEK
 */
public class Connector implements Runnable, BlinkObserver {

    private Socket thinkSocket;
    private OutputStream outStream;
    private InputStream inStream;
    private OnBlinkEvent parent;
    
    public Connector(OnBlinkEvent evt){
        parent = evt;
    }

    @Override
    public void run() {
        try {
            thinkSocket = new Socket("127.0.0.1", 13854);
            inStream = thinkSocket.getInputStream();
            outStream = thinkSocket.getOutputStream();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("enableRawOutput", true);
            localJSONObject.put("format", "Json");
            sendMessage(localJSONObject.toString());
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(this.thinkSocket.getInputStream()));
            String str;
            while ((str = stdIn.readLine()) != null) {
                String[] arrayOfString = str.split("/\r/");
                for (int i = 0; i < arrayOfString.length; i++) {
                    if (arrayOfString[i].indexOf("{") > -1) {
                        JSONObject jobj = new JSONObject(arrayOfString[i]);
                        parsePacket(jobj);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String paramString) {
        PrintWriter localPrintWriter = new PrintWriter(this.outStream, true);
        localPrintWriter.println(paramString);
    }

    private void parsePacket(JSONObject paramJSONObject) {
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext()) {
            Object localObject = localIterator.next();
            String str = localObject.toString();
            try {
                if (str.matches("blinkStrength")) {
                    System.out.println(paramJSONObject.getInt(localObject.toString()));
                }
            } catch (Exception localException) {
                localException.printStackTrace();
            }
        }
    }

    @Override
    public void notifyListeners() {
        parent.BlinkAction();
    }
}
