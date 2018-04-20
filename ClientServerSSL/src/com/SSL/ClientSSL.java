package com.SSL;

 import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

public class ClientSSL {
	public static void main(String[] arstring) {
        try {
        	//String keystorePath="C:\\Users\\gs-1697\\Desktop\\Shubham\\Workspace\\ClientServerSSL\\key.jks";
        	String keystorePath="C:\\Keytool\\keystr.txt";
        	String keystorePass="password";
        	System.setProperty("javax.net.ssl.trustStore",keystorePath);
            System.setProperty("javax.net.ssl.trustStorePassword", keystorePass);
            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket("localhost", 9999);

            InputStream inputstream = System.in;
            InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
            BufferedReader bufferedreader = new BufferedReader(inputstreamreader);

            OutputStream outputstream = sslsocket.getOutputStream();
            OutputStreamWriter outputstreamwriter = new OutputStreamWriter(outputstream);
            BufferedWriter bufferedwriter = new BufferedWriter(outputstreamwriter);

            String string = null;
            while ((string = bufferedreader.readLine()) != null) {
                bufferedwriter.write(string + '\n');
                bufferedwriter.flush();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
    