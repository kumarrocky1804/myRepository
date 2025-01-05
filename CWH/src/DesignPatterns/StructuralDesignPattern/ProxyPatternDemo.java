package DesignPatterns.StructuralDesignPattern;
/* Proxy Pattern is used as a wrappper to cover the main object's complexities
 * Link - https://www.geeksforgeeks.org/proxy-design-pattern/
 * 
 * Below is an example of proxy pattern
 *  - Main diiference in structure of decorator, proxy and adapter pattern is that proxy provides
 *  same alternate interface, decorator provides enhanced interface and adapter provides different 
 *  interface
 *  
 *  Structural Design Pattern
 */

interface internet
{
	public void connectTo(String url) throws Exception;
}

class RealInternet implements internet
{
	@Override
	public void connectTo(String url)
	{
		System.out.println("connected to  - " + url);
	}
}

// implements same internet interface
class ProxyInternet implements internet 
{
	private static String[] blockedSiteList = 
		{"xxx.com", "abc.com", "naughtySites.com"};
	
	@Override
	public void connectTo(String url) throws Exception
	{
		for(String blockedSite: blockedSiteList)
		{
			if(url.equalsIgnoreCase(blockedSite))
				throw new Exception("Access denied to this site - " + url);
		}
		
		new RealInternet().connectTo(url);		
	}
}

public class ProxyPatternDemo 
{
	public static void main(String[] args) {
		internet net = new ProxyInternet();
		try {
			net.connectTo("geeksFORGeeks.com");
			net.connectTo("xxx.com");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
