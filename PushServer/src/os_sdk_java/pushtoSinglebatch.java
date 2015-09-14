package os_sdk_java;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.transform.Templates;

import com.gexin.rp.sdk.base.IBatch;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.base.uitls.ApnsUtils;
import com.gexin.rp.sdk.base.uitls.StackTraceUtil;
import com.gexin.rp.sdk.exceptions.PushSingleException;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.NotyPopLoadTemplate;
import com.gexin.rp.sdk.template.PopupTransmissionTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;

public class pushtoSinglebatch {

	// ------------设置应用?��?��---------------
	static String appId = "";
	static String appkey = "";
	static String master = "";
	static String CID = "";

	public static void main(String[] args) throws Exception {

		// System.setProperty("gexin.rp.sdk.http.proxyHost",
		// "192.168.1.227:808");

		System.setProperty("gexin_pushSingleBatch_needAsync", "false");

		String host = "http://sdk.open.api.igexin.com/apiex.htm";
		IGtPush push = new IGtPush(host,appkey, master);
		IBatch Batch = push.getBatch();

//		 TransmissionTemplate template = TransmissionTemplateDemo();
		LinkTemplate template = linkTemplateDemo();
		// NotificationTemplate template = NotificationTemplateDemo();
		// NotyPopLoadTemplate template =NotyPopLoadTemplateDemo();

		SingleMessage message = new SingleMessage();
		message.setOffline(true);
		message.setOfflineExpireTime(2 * 1000 * 3600);
		message.setData(template);
//		message.setPushNetWorkType(1); //

		List<Target> targets = new ArrayList<Target>();
		
		Target target1 = new Target();
		target1.setAppId(appId);
		target1.setClientId(CID);
		Batch.add(message, target1);

		try {
			String result = Batch.submit().getResponse().toString();
			System.out.println(result);
		} catch (Exception e) {
			IPushResult ret =Batch.retry();

			System.out.println("异常�?" + ret.getResponse().toString());
		}
	}

	public static void sf(long time) {
		Date date = new Date(time);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sf.format(date));

	}

	public static PopupTransmissionTemplate PopupTransmissionTemplateDemo() {
		PopupTransmissionTemplate template = new PopupTransmissionTemplate();
		template.setAppId(appId);
		template.setAppkey(appkey);
		template.setText("");
		template.setTitle("");
		template.setImg("");
		template.setConfirmButtonText("");
		template.setCancelButtonText("");
		template.setTransmissionContent("111");
		template.setTransmissionType(1);

		return template;
	}

	public static TransmissionTemplate TransmissionTemplateDemo()
			throws Exception {
		TransmissionTemplate template = new TransmissionTemplate();
		template.setAppId(appId);
		template.setAppkey(appkey);
		template.setTransmissionType(1);
		template.setTransmissionContent("OS-TOSingle");
		// template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");
		// template.setPushInfo("", 1, "", "", "", "", "", "");
		// template.getPushInfo().toString().getBytes().length;
		// template.getPushInfo()
		return template;
	}

	public static LinkTemplate linkTemplateDemo() throws Exception {
		LinkTemplate template = new LinkTemplate();
		template.setAppId(appId);
		template.setAppkey(appkey);
		template.setTitle("?���?");
		template.setText("?��?��");
		template.setLogo("text.png");
		// template.setLogoUrl("");
		// template.setIsRing(true);
		// template.setIsVibrate(true);
		// template.setIsClearable(true);
		template.setUrl("http://www.baidu.com");
		// template.setPushInfo("actionLocKey", 1, "message", "sound","payload",
		// "locKey", "locArgs", "launchImage");
		return template;
	}

	public static NotificationTemplate NotificationTemplateDemo()
			throws Exception {
		NotificationTemplate template = new NotificationTemplate();
		template.setAppId(appId);
		template.setAppkey(appkey);
		template.setTitle("");
		template.setText("");
		template.setLogo("icon.png");
		// template.setLogoUrl("");
		// template.setIsRing(true);
		// template.setIsVibrate(true);
		// template.setIsClearable(true);
		template.setTransmissionType(1);
		template.setTransmissionContent("dddd");
		// template.setPushInfo("actionLocKey", 2, "message", "sound",
		// "payload", "locKey", "locArgs", "launchImage");
		return template;
	}

	public static NotyPopLoadTemplate NotyPopLoadTemplateDemo() {
		NotyPopLoadTemplate template = new NotyPopLoadTemplate();
		// 设置?�传应用?��appie与appkey
		template.setAppId(appId);
		template.setAppkey(appkey);
		// 设置?�知?��题与?�知?���?
		template.setNotyTitle("");
		template.setNotyContent("");
		// template.setLogoUrl("");
		// 设置?�知?��题图?��
		template.setNotyIcon("text.png");
		// 设置?��?��?��声，清除，震?��?��?���?
		// template.setBelled(false);
		// template.setVibrationed(false);
		// template.setCleared(true);

		// 设置弹框?��题和?��题内�?
		template.setPopTitle("");
		template.setPopContent("");
		// 设置弹框?��容图?��
		template.setPopImage("http://www-igexin.qiniudn.com/wp-content/uploads/2013/08/logo_getui1.png");
		template.setPopButton1("");
		template.setPopButton2("");

		// 设置下载?���?
		template.setLoadTitle("下载?���?");
		template.setLoadIcon("file://icon.png");
		template.setLoadUrl("http://gdown.baidu.com/data/wisegame/c95836e06c224f51/weixinxinqing_5.apk");
		template.setActived(true);
		template.setAutoInstall(true);
		template.setAndroidMark("");
		return template;
	}
}