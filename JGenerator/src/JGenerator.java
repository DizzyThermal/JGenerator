import java.io.IOException;

public class JGenerator 
{
	private static final String IP			= "192.168.1.100";
	private static final String PORT		= "8080";
	private static final String URL			= IP + ":" + PORT;

	private static final int DURATION		= 30;

	private static final int UNKNOWN_TYPE	= -1;
	private static final int NPS			= 0;
	private static final int NPP			= 1;
	private static final int PWP			= 2;
	private static final int PWOP			= 3;

	public static void main(String[] args) throws IOException 
	{
		if(args.length != 1)
			printUsage();
		else
		{
			int connType = determineConnectionType(args[0]);
			if(connType == UNKNOWN_TYPE)
				printUsage();
			else
				generateTraffic(connType);
		}
	}
	
	public static void generateTraffic(int connType)
	{
		// Plop Code Here
	}
	
	public static void printUsage()
	{
		System.out.println("Usage: java JGenerator <mode>");
		System.out.println("          Modes:");
		System.out.println("             -nps (Non-Persistent Serial)");
		System.out.println("             -npp (Non-Persistent Parallel)");
		System.out.println("             -pwp (Persistent with Pipe)");
		System.out.println("             -pwop (Persistent without Pipe)");
	}
	
	public static int determineConnectionType(String arg)
	{
		if(arg.equals("nps"))
			return NPS;
		else if(arg.equals("npp"))
			return NPP;
		else if(arg.equals("pwp"))
			return PWP;
		else if(arg.equals("pwop"))
			return PWOP;
		else
			return UNKNOWN_TYPE;
	}
}