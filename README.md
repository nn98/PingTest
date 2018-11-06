# PingTest
6202 pc On/OffLine check

## PingTest to check public desktops status(on/off)by using IP address.  
## imperfection code. (by restrictions on networks, or just local ethernet error.)  

```java
public class PingTest {
	public static void main(String[] args) {

		String basicIp="192.168.61.";	//Target Desktops IP. incomplete.
		String basicPc="pc-";			    //pc ID. pc1~pc42.
		int indivisualIp=111;
		String t=basicIp+Integer.toString(indivisualIp);
		String[] addressTmp=new String[42]; //IP address array.
		String[] addressName=new String[42];//ID array.
		for(int i=0;i<42;i++) {
			addressTmp[i]=basicIp+Integer.toString(indivisualIp); //IP address complete, save to array.
			addressName[i]=basicPc+Integer.toString(i+1);         //complete PC id.
			indivisualIp++;
		}
		while (true) {
			for(int i=0;i<addressTmp.length;i++) {
				try {
					Thread.sleep(1000);
					InetAddress targetIp = InetAddress.getByName(addressTmp[i]);
					boolean value=targetIp.isReachable(3000);         //check targets on/off or network connect/disconnect
					if(value) { //on or connected
						System.out.println(addressTmp[i]+"-"+addressName[i]+"=>onLinePC");  //notice.
					} else {    //of or disconneted
						System.out.println(addressTmp[i]+"-"+addressName[i]+"=>offLinePC"); //notice.
					}
				}
				catch (Exception e) { //didnt implements error situation.
				}
			}
		}
	}
}
```
