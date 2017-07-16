package gaurav.dietconsultant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DiabetesList extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disease);
        listView = (ListView) findViewById(R.id.list);
        String[] values = new String[]{"Foods For Beating Diabetes", "Worst Food For Diabetes",
                "Avoid Risk of Diabetes", "General Tips" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), FoodsForBeatingDiabetes.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), WorstFoodForDiabetes.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(),AvoidRiskofDiabetes.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), GeneralTipsofDiabetes.class);
                    startActivityForResult(myIntent, 0);
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
            DiabetesList.this.finish();
        }
        return true;
    }
}