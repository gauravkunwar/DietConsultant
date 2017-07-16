package gaurav.dietconsultant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by kunwar on 6/30/17.
 */

public class Tips extends AppCompatActivity {

    Button back_button;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tips);

        back_button=(Button)findViewById(R.id.button);


        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tips.this.finish();
                //  dialog.cancel(); // only dialog box is terminated.
            }
        });

    }
}
