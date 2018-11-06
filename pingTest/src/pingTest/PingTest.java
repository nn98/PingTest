package pingTest;
import java.net.InetAddress;
public class PingTest {
	public static void main(String[] args) {

		String basicIp="192.168.61.";	//6202 ±âº» IP. 110(admin), 111~152;
		String basicPc="pc-";			//pc ID. pc1~pc42
		int indivisualIp=111;
		String t=basicIp+Integer.toString(indivisualIp);
		String[] addressTmp=new String[42];
		String[] addressName=new String[42];
		for(int i=0;i<42;i++) {
			addressTmp[i]=basicIp+Integer.toString(indivisualIp);
			addressName[i]=basicPc+Integer.toString(i+1);
			indivisualIp++;
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