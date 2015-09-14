package Push_Message_Demo;
  
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.http.IGtPush;
  
public class AliasFunction {
   static String appId = "b03c5cfef65ed30108f0a3fd82c3f6b4";
   static String appkey = "110000";
   static String mastersecret = "a02a76119b20d4e31620d7597a3b4f35";
   static String CID = "3e170b169630706f82baf94c8a2b8923";
   static String host = "http://sdk.open.api.igexin.com/serviceex";
  
   public static void main(String[] args) throws Exception {
	   System.out.println("RUNNNNN");
      IGtPush push = new IGtPush(host, appkey, mastersecret);
       
      SingleMessage message = new SingleMessage();
      message.setPushNetWorkType(0); //判断客户端是否wifi环境下推送。1为仅在wifi环境下推送，0为不限制网络环境。
   }
}