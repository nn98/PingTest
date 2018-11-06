package pingTest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;

public class PingTest2 {

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		Test t1=new Test(1);
		Test t2=new Test(2);

		t1.start();
		Thread.sleep(1000);
		t2.start();
	}
}
class Test extends Thread {
	String basicIp="192.168.62.";
	String basicPc="pc-";
	String[] addressTmp=new String[21];
	String[] addressName=new String[21];
	int indivisualIp=111;
	int confirm;
	Test(int i) {
		if(i==1) confirm=1;
		else if(i==2) {
			indivisualIp++;
			confirm=2;
		}
	}
	public void run() {
		String t=basicIp+Integer.toString(indivisualIp);
		for(int i=0;i<21;i++) {
			addressTmp[i]=basicIp+Integer.toString(indivisualIp);
			addressName[i]=basicPc+Integer.toString(confirm);
			confirm+=2;
			indivisualIp+=2;
		}
		while (true) {
			for(int i=0;i<addressTmp.length;i++) {
				try {
					Thread.sleep(1000);
					InetAddress targetIp = InetAddress.getByName(addressTmp[i]);
					boolean value=targetIp.isReachable(1000);
					if(value) {
						System.out.println(addressTmp[i]+"-"+addressName[i]+"=>onLinePC");
					} else {
						System.out.println(addressTmp[i]+"-"+addressName[i]+"=>offLinePC");
					}
				}
				catch (Exception e) {
				}
			}
		}
	}
}
