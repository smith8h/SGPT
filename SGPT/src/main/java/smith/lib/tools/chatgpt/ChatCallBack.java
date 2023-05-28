package smith.lib.tools.chatgpt;

public interface ChatCallBack {
    public void onResponse(String response);
    public void onFailure(String message);
}
