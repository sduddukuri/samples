package org.sample.web.wso2.stats;

import java.io.IOException;
import java.util.HashMap;

import javax.management.AttributeList;
import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/wso2/stats")
public class WSO2JmxStatsController {


	@RequestMapping(value = "/http", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody AttributeList getWso2HttpStats() throws IOException, InstanceNotFoundException, IntrospectionException, MalformedObjectNameException, ReflectionException {
		MBeanServerConnection connection = getJmxConnection().getMBeanServerConnection();
		
		String[] attributes = {"LastMinuteConnections","RequestSizesMap","LastResetTime"};
		
		return connection.getAttributes(new ObjectName("org.apache.synapse:Type=PassThroughConnections,Name=http-listener"), attributes);
	}
	
	private JMXConnector getJmxConnection() throws IOException{
		
		JMXServiceURL url = 
			    new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");

		HashMap env = new HashMap(); 
		 
	      /* SslRMIClientSocketFactory csf =  
	                  new SslRMIClientSocketFactory(); 
	       SslRMIServerSocketFactory ssf =  
	                  new SslRMIServerSocketFactory(); 
	       env.put(RMIConnectorServer. 
	                  RMI_CLIENT_SOCKET_FACTORY_ATTRIBUTE,csf); 
	       env.put(RMIConnectorServer. 
	                  RMI_SERVER_SOCKET_FACTORY_ATTRIBUTE,ssf); 
	 
	       env.put("jmx.remote.x.password.file", 
	                 "config" + File.separator + "password.properties"); 
	       env.put("jmx.remote.x.access.file", 
	                 "config" + File.separator + "access.properties"); 
	                 
	                 */
	       
	       String[] credentials = new String[] { "admin" , "admin" }; 
	       env.put("jmx.remote.credentials", credentials);
	 
					
			JMXConnector jmxc = JMXConnectorFactory.connect(url, env);
			
			
			
			return jmxc;
	}
}
