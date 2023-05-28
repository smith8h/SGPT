package smith.lib.tools.chatgpt;

import android.app.Activity;
import androidx.annotation.NonNull;
import smith.lib.net.SConnect;
import smith.lib.net.SConnectCallBack;
import smith.lib.net.SResponse;
import java.util.HashMap;
import java.util.Map;

public class SGPT {
    
    private String apiKey;
	private ChatCallBack callback;
	private Activity activity;
    
	@NonNull
	public static SGPT setup(Activity activity, String token) {
		SGPT sgpt = new SGPT();
	    sgpt.apiKey = token;
		sgpt.activity = activity;
		return sgpt;
    }
	
	public SGPT callback(ChatCallBack chatcallback) {
		this.callback = chatcallback;
		return this;
	}

	public void chat(String message) {
		SConnect.with(activity)
				.params(new HashMap<String, Object>() {{
					put("prompt", message);
					put("max_tokens", 4000);
					put("temperature", 0.95);
				}}, SConnect.PARAM)
				.url("https://api.openai.com/v1/engines/text-davinci-003/completions")
				.headers(new HashMap<String, Object>() {{
					put("Authorization", "Bearer " + apiKey);
					put("Content-Type", "application/json");
				}})
				.callback(new SConnectCallBack() {
					@Override
					public void onSuccess(SResponse response, String tag, Map<String, Object> responseHeaders) {
						SResponse.Map map = response.getMap();
						if (map.hasKey("error")) {
							callback.onFailure("INVALID_REQUEST_ERROR: " + map.getMap("error").getString("message"));
						} else {
							String rMessage = map.getArray("choices").getMap(0).getString("text");
							callback.onResponse(rMessage.replaceAll("(?m)^[ \t]*\r?\n", ""));
						}
					}

					@Override
					public void onFailure(SResponse response, String tag) {
						callback.onFailure(response.toString());
					}
				})
				.post();
	}
}
