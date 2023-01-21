package smith.test; 

import android.os.Bundle; 
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import smith.lib.tools.chatgpt.SGPT;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
    
    public void chat(View v) {
        EditText et = findViewById(R.id.et);
        
        String apiKey = "get it from https://beta.openai.com/account/api-keys";
        SGPT chat = new SGPT(apiKey);
        
        chat.chat(et.getText().toString(), new SGPT.ChatCallBack() {
            @Override public void onResponse(String response) {
                TextView tv = findViewById(R.id.tv);
                tv.setText(response);
            }
            
            @Override public void onFailure(String message) {
                TextView tv = findViewById(R.id.tv);
                tv.setText(message);
            }
        });
    }
}
