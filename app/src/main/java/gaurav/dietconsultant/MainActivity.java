package gaurav.dietconsultant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button calorie_intake, food_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calorie_intake=(Button) findViewById(R.id.calorie_intake_button);
        food_list=(Button) findViewById(R.id.food_list_button);

        calorie_intake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(MainActivity.this,CalculateCalorie.class);
                startActivity(intent1);
            }
        });

        food_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(MainActivity.this, FoodList.class);
                startActivity(intent1);
            }
        });
    }



    //for menu on top
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int name=item.getItemId();
        if(name==R.id.about_us){
            Intent intent = new Intent(getApplicationContext(),DisplayAbout.class);
            startActivity(intent);
        }

        if(name==R.id.tips){
            Intent intentx = new Intent(getApplicationContext(),Tips.class);
            startActivity(intentx);
        }

        if (name==R.id.exit){
            MainActivity.this.finish();
        }
        return true;
    }
}
