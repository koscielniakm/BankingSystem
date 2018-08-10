package bs.model.services.security;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpGetter {
	
	public static String getIp() {
        String ipAddress = "";
		InetAddress inetAddress = null;
		try {
			inetAddress = InetAddress.getLocalHost();
			ipAddress = inetAddress.toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ipAddress;
	}
	
}
