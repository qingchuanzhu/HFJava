import java.io.*;
import java.net.*;

class DailyAdviceServer {
	String[] adviceList = {"Take smaller bites"};

	void go(){
		try {
			ServerSocket serverSock = new ServerSocket(4242);

			while (true) {
				Socket sock = serverSock.accept();
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = adviceList[0];
				writer.println(advice);
				writer.close();
			}
		} catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	}
}