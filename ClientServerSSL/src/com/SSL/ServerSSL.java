package com.SSL;


import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public
class ServerSSL {
   
	public static void main(String[] arstring) {
        try {
        	//String keystorePath="C:\\Users\\gs-1697\\Desktop\\Shubham\\Workspace\\ClientServerSSL\\key.jks";
        	String keystorePath="C:\\Keytool\\keystr.txt";
        	String keystorePass="password";
        	System.setProperty("javax.net.ssl.keyStore", keystorePath); 
        	System.setProperty("javax.net.ssl.keyStorePassword", keystorePass); 
        	SSLServerSocket serverSocket = (SSLServerSocket) SSLServerSocketFactory.getDefault().createServerSocket(9999); 
        	SSLSocket workSocket = (SSLSocket) serverSocket.accept();

            InputStream inputstream = workSocket.getInputStream();
            InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
            BufferedReader bufferedreader = new BufferedReader(inputstreamreader);

            String string = null;
            while ((string = bufferedreader.readLine()) != null) {
                System.out.println(string);
                System.out.flush();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
      