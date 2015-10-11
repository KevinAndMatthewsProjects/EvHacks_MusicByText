import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*; 

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.kevin.graphics.canvas.Bitmap;
import com.kevin.graphics.canvas.CanvasDisplay;
import com.twilio.sdk.*; 
import com.twilio.sdk.resource.factory.*; 
import com.twilio.sdk.resource.instance.*; 
import com.twilio.sdk.resource.list.*; 
 
public class Server { 
 // Find your Account Sid and Token at twilio.com/user/account 
 public static final String ACCOUNT_SID = "AC7d5b62c53015790d666b2d2b409ca67d"; 
 public static final String AUTH_TOKEN = "e09100bcfa655da417e69de0180d1be8"; 
 
 private static final String MyNumber = "+14088930826";
 
 private static boolean firstRun;
 private static Robot robot;
 
 public static void main(String[]args) throws Exception { 
	TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN); 
	
	firstRun = false;
	
	ArrayList<String> blackList = new ArrayList<String>();  // TODO SET BLACK LIST
	
	
	
	
	blackList.add("blacklist"); // INSER BLACK LISTs HERE
	blackList.add("+");
	
	
	
	
	MessageList list = client.getAccount().getMessages();
	 MessageFactory messageFactory = client.getAccount().getMessageFactory();
    ArrayList<String> text = new ArrayList<String>();
    
    for(Message message:list) {
    	if(message.getDirection().contains("inbound"))
    		text.add(message.getBody());
    }
    
    int preMessages = text.size();
 	int time = 5;
 	
 	ArrayList<String> songQ = new ArrayList<String>();
 	ArrayList<Integer> timeQ = new ArrayList<Integer>();
 	
  	robot = new Robot();
    while(true) {
    	list = client.getAccount().getMessages();
  
    	text.clear();
        for(Message message:list) {
        	if(message.getDirection().contains("inbound"))
        		text.add(message.getBody());
        }
        int newMessages = text.size();
       // System.out.println(newMessages);
        if(preMessages != newMessages) {
        	boolean passed = true;
        for(String s:blackList){
        	if(text.get(0).contains(s)) {
        		 	List<NameValuePair> params = new ArrayList<NameValuePair>();
        		    params.add(new BasicNameValuePair("Body", "Sorry, you requested song was blacklisted"));
        		    params.add(new BasicNameValuePair("To", MyNumber));
        		    params.add(new BasicNameValuePair("From", "+14089136865"));
        		 
        		    Message message = messageFactory.create(params);
        		    passed = false;
        		    break;
        	}
        	
        }
        
        if(searchVideo(text.get(0)) == null) {passed = false; }
        if(passed)  
        	if(!songQ.contains(text.get(0))) {
        	timeQ.add(getDuration(text.get(0)));
        	songQ.add(text.get(0));
        	if(!firstRun) {
        		YoutubePlay.run(searchVideo(text.get(0)));
        		bot();
        		
        		firstRun = true;
        	}
        	System.err.println("Added " + songQ.get(songQ.size() - 1) + " with time " + timeQ.get(timeQ.size() - 1));
        	} else {
        		System.out.println(text.get(0) + " was aldready found");
        	}
        }
        
        if(songQ.isEmpty()) {
        	System.out.println("No Songs Playing");
        	continue;
        	}
        
        if(timeQ.get(0) > 0) {
        	System.out.println("Playing song " + songQ.get(0) + " " + timeQ.get(0));
        	timeQ.set(0, timeQ.get(0) - 1);
        } else {
        	songQ.remove(0);
        	timeQ.remove(0);
        	YoutubePlay.run(searchVideo(text.get(0)));
        	bot();
        }
        
        //System.out.println(time);
        preMessages = newMessages;
        time = time - 1;
        Thread.sleep(10);
    	
    }
 
	
 }
 
 public static String searchVideo(String KevsString) throws Exception {
	 
	 	switch(KevsString) {
	 	
	 	case "Classic Man" :return "https://www.youtube.com/watch?v=nsiN0W15w0U";
	 	case "See You Again": return "https://www.youtube.com/watch?v=RgKAFK5djSk";
	 	case "Party Rock": return "https://www.youtube.com/watch?v=KQ6zr6kCPj8";
	 	}
	 	
	    String google = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";

	    String search = KevsString + "lyrics on screen";

	    String charset = "UTF-8";

	    URL url = new URL(google + URLEncoder.encode(search, charset));
	    Reader reader = new InputStreamReader(url.openStream(), charset);
	    GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);

	   try{
	  String out = results.getResponseData().getResults().get(0).getUrl();
	  if(out.contains("youtube"))
	  return (out);
	  else { 
	  System.err.println("Could not Find Song!");
	  return null;
	  }   
	   }catch(java.lang.IndexOutOfBoundsException e){ 

	  System.err.print("Could not Find Song!");
	  return null;
	   }
	}

 
 public static int getDuration(String song) {
	 return (int) (Math.random() * 10 + 10);
 }
 
 public static void bot() throws InterruptedException {

	 Thread.sleep(1000);
	
	robot.mouseMove(490, 752);
	 Thread.sleep(1000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
	Thread.sleep(1000);
	robot.mouseMove(601, 593);
	 Thread.sleep(1000);
	robot.mousePress(InputEvent.BUTTON1_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_MASK);
 }
 

}