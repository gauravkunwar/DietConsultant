package gaurav.dietconsultant;

/**
 * Created by kunwar on 7/1/17.
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class GeneralTipsofBloodPressure extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generaltips);
        // 1. pass context and data to the custom adapter
        MyAdapter adapter = new MyAdapter(this, generateData());

        // 2. Get ListView from activity_main.xml
        ListView listView = (ListView) findViewById(R.id.listview);

        // 3. setListAdapter
        listView.setAdapter(adapter);
    }

    private ArrayList<Item> generateData(){
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Follow Balanced Diet Plan","Follow a frequent small meal diet pattern." +
                "Eat at an interval of two hours so that your blood sugar levels don't drop down." +
                "And Consume healthy home cooked food"));
        items.add(new Item("Engaged in Active lifestyle","Doing more physical activities can helps in controlling diabetes," +
                "but the greater benfit comes from a fitness program."));
        items.add(new Item("Do Regular Exercise","Include at least 30-45 minutes workout in everyday be it yoga,brisk wall," +
                "or any other activity"));
        items.add(new Item("Add More Fibers in your diet","Include more fiber in your diet eg.Green leafy vegetables," +
                "whole grain pulses,husked pluses etc."));
        items.add(new Item("Drink plenty of water","Drink plenty of water and other drinks like lemon water," +
                "green tea,herbal tea etc.and keep yourself hydrated."));
        items.add(new Item("Use low Salty Food","Avoid excess salt and salty products,high level of salt leads to" +
                "high blood pressure problems. " +
                "and include garlic,black pepper powder,roasted cumin seed powder mint,lemon juices to enhance the taste"));
        items.add(new Item("Things to avoid By BloodPressure Patients","Tobacco,Smoking,Avoid Canned food," +
                "Packaged fooditem,Malted beverages,Cold drinks, fruit juice drinks,Avoid Excess Salt,Avoid Alcohol"));

        return items;
    }

}