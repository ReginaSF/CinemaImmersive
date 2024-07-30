package week7.jmdns;
 

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

