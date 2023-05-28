package smith.test; 

import android.os.Bundle; 
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import smith.lib.tools.chatgpt.ChatCallBack;
import smith.lib.tools.chatgpt.SGPT;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
    
    public void chat(View v) {
        EditText et = findViewById(R.id.et);
        TextView tv = findViewById(R.id.tv);
        
        String token = "sk-GtB....sckMfP0X"; // get it from https://beta.openai.com/account/api-keys";
        SGPT.setup(this, token)
                .callback(new ChatCallBack() {
                    @Override
                    public void onResponse(String response) {
                        tv.setText(response);
                    }

                    @Override
                    public void onFailure(String message) {
                        tv.setText(message);
                    }
                })
                .chat("Hi I'm Hussein Smith the developer of this api that i'm talking with you from.");
    }
}
