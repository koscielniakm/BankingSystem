package bs.model.services.security;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.persistence.NoResultException;

public class IpGetter {
	
	public static String getIp() {
		try
		{
			InetAddress inetAddress = InetAddress.getLocalHost();
			String ipAddress = inetAddress.getHostAddress().toString();
			return ipAddress;
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
			throw new NoResultException();
		}
	}
	
}
