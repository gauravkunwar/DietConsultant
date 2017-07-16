package gaurav.dietconsultant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DisplayCalorie extends AppCompatActivity {
    Button food_list;
    TextView output,weight_cat,info;
    int calorie_final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calorie_display);

        food_list=(Button) findViewById(R.id.food_list);
        output = (TextView) findViewById (R.id.calorie_output);
        weight_cat =(TextView) findViewById(R.id.category_weight);
        info= (TextView) findViewById(R.id.information);


        //to handle calorie output
        Bundle bundle2 = new Bundle();
        bundle2 = getIntent().getExtras();
        final int calorie = bundle2.getInt("key"); //calorie is received
        final int disease = bundle2.getInt("key1"); // disease identity is received
        final int weight_category = bundle2.getInt("key2");
//        Intent i =getIntent();
//        int number = i.getIntExtra("key",0);



        // for information
        if (weight_category==1){
            weight_cat.setText("Under weight.");
            info.setText("In order to increase your weight slowly and safely,");
            calorie_final=calorie+200;
        }
        else if(weight_category==2){
            weight_cat.setText("of Normal weight.");
            info.setText("In order to maintain your current weight,");
            calorie_final=calorie;
        }
        else if (weight_category==3){
            weight_cat.setText("Over Weight.");
            info.setText("In order to decrease your weight slowly and safely,");
            calorie_final=calorie-200;
        }

        output.setText(""+calorie_final);


        //to handle button
        food_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (disease ==1){
                    Intent intentboth = new Intent(DisplayCalorie.this, BothList.class);
                    startActivity(intentboth);

                }
                else if(disease==2){
                    Intent intentdiabetes = new Intent(DisplayCalorie.this, DiabetesList.class);
                    startActivity(intentdiabetes);

                }
                else if (disease ==3){
                    Intent intentpressure = new Intent(DisplayCalorie.this, BloodPressureList.class);
                    startActivity(intentpressure);

                }
                else {
//                    Intent intentnone = new Intent(DisplayCalorie.this, FoodList.class);
//                    startActivity(intentnone);
                    setContentView(R.layout.food_list_heart);
                }
            }
        });
    }
    //for menu on top
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu2,menu);
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

        if (name==R.id.back){
            DisplayCalorie.this.finish();
        }
        return true;
    }
}
