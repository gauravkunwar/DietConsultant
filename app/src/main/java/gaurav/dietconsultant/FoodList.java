package gaurav.dietconsultant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

// only later i knew that it was unnecessary to create this class but why to delete now :D
public class FoodList extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);
    }
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
                FoodList.this.finish();
            }
            return true;
        }
    }