package os_sdk_java;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.IQueryResult;
import com.gexin.rp.sdk.http.IGtPush;

public class GetPushMessageResultDemo {
	//?‚¨åº”ç”¨?š„mastersecret
	private static final String MASTERSECRET = "";
	//?‚¨åº”ç”¨?š„appkey
	private static final String APPKEY = "";
	//è¦æŸ¥è¯¢çš„taskId
	private static final String APPID = "";

	
	private static final String TASKID = "";
	
	static String host ="http://sdk.open.api.igexin.com/apiex.htm";
	public static void main(String[] args) {
//		System.setProperty("gexin_get_domain_flag","true");
//		System.setProperty("gexin_default_domainurl","http://172.16.13.135:80/apiex.htm");
		IGtPush push = new IGtPush(host,APPKEY, MASTERSECRET);
//		System.out.println(push.getPushResult(TASKID).getResponse());
//		IPushResult result=push.getPushResult(TASKID);
//		String msgTotal =result.getResponse().get("msgTotal").toString();
//		String clickNum=result.getResponse().get("clickNum").toString();
//		String msgProcess =result.getResponse().get("msgProcess").toString();
//		System.out.println("?»ä¸‹?‘?•°:"+msgTotal+"|?‚¹?‡»?•°:"+clickNum+"|ä¸‹å‘?š„æ¶ˆæ¯?»æ•°:"+msgProcess);
		
		IQueryResult result = push.queryAppUserDataByDate(APPID, "20150525");
		Map<String, Object> data = (Map<String, Object>)result.getResponse().get("data");
		System.out.println(result.getResponse().toString());
		
		  System.out.println("?–°?”¨?ˆ·æ³¨å†Œ?»æ•°:"+data.get("newRegistCount"));
		  System.out.println("?”¨?ˆ·æ³¨å†Œ?»æ•°:"+data.get("registTotalCount"));
		  System.out.println("æ´»è·ƒ?”¨?ˆ·?•°:"+data.get("activeCount"));
		  System.out.println("?œ¨çº¿ç”¨?ˆ·?•°:"+data.get("onlineCount"));
		
//		IQueryResult result1 = push.queryAppPushDataByDate(APPID, "20150525");
//		Map<String, Object> data1 = (Map<String, Object>)result1.getResponse().get("data");
//		System.out.println(data);
//		System.out.println("?‘?æ?»æ•°:"+data1.get("sendCount"));
//		System.out.println("?œ¨çº¿ä¸‹?‘?•°:"+data1.get("sendOnlineCount"));
//		System.out.println("?¥?”¶?»æ•°:"+data1.get("receiveCount"));
//		System.out.println("å±•ç¤º?»æ•°:"+data1.get("showCount"));
//		System.out.println("?‚¹?‡»?»æ•°:"+data1.get("clickCount"));
		
		
		
		

		
	}

}

