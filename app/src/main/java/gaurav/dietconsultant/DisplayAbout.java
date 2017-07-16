package gaurav.dietconsultant;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class DisplayAbout extends AppCompatActivity {
    Button back_from_about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.about);

        back_from_about=(Button)findViewById(R.id.go_back);

      //  final Dialog dialog = new Dialog(DisplayAbout.this);
        //dialog.setContentView(R.layout.about);

        //dialog.show();

        back_from_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayAbout.this.finish();
                //  dialog.cancel(); // only dialog box is terminated.
            }
        });


    }
}
