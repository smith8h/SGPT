package smith.lib.tools.chatgpt;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import java.io.IOException;

public class SGPT {
    
    private String apiKey;
    
	public SGPT(String apiKey) {
	    this.apiKey = apiKey;
    }
	
	public void chat(String text, ChatCallBack chatcallback) {
		JSONObject params = new JSONObject();
		try{
			params.put("prompt", text);
			params.put("max_tokens", 4000);
			params.put("temperature", 0.95);
		}catch(Exception e){}
		
		Request req = new Request.Builder()
		.url("https://api.openai.com/v1/engines/text-davinci-003/completions")
		.header("Authorization", "Bearer " + apiKey)
		.header("Content-Type", "application/json")
		.post(RequestBody.create(MediaType.parse("application/json"), params.toString()))
		.build();
		
        OkHttpClient client = new OkHttpClient();
		client.newCall(req).enqueue(new Callback() {
            @Override public void onResponse(Call call, Response response) throws IOException {
			    String responseBody = response.body().string();
                chatcallback.onResponse(parseResponse(responseBody));
            }
            
            @Override public void onFailure(Call call, IOException e) {
		    	chatcallback.onFailure("Something went wrong!");
	    	}
        });
	}
	
	private String parseResponse(String responseBody){
		String text = responseBody;
		try {
			text = ((new JSONObject(responseBody)).getJSONArray("choices")).getJSONObject(0).getString("text");
		} catch (Exception e) {}
		return text.replaceAll("(?m)^[ \t]*\r?\n","");
	}
    
    public interface ChatCallBack {
        public void onResponse(String response);
        public void onFailure(String message);
    }
}
