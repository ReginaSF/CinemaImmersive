package week7.jmdns;

import java.io.IOException ;
import java.net.InetAddress ;
import javax.jmdns.JmDNS ;
import javax.jmdns.ServiceInfo ;
import java.net.UnknownHostException;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;

public class ExampleServiceRegistration {
	public static void main (String [] args ) throws InterruptedException {
		
		   try {
					 
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			//Register a service
		   	// ServiceInfo.create takes the hostname, service name, port name and 
		      //  the URL to access the service		 
		      ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", 
		                                "example", 1234, "path=index.html");
					 
			jmdns.registerService(serviceInfo);
			} catch ( IOException e) {
					 System.out.println(e.getMessage());
			}
		   }	 
				

	
	
}
