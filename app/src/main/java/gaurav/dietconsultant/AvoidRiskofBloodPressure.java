package gaurav.dietconsultant;

/**
 * Created by kunwar on 7/1/17.
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class AvoidRiskofBloodPressure extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avoidrisk);
        // 1. pass context and data to the custom adapter
        MyAdapter adapter = new MyAdapter(this, generateData());

        // 2. Get ListView from activity_main.xml
        ListView listView = (ListView) findViewById(R.id.listview);

        // 3. setListAdapter
        listView.setAdapter(adapter);
    }

    private ArrayList<Item> generateData(){
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Manage your Weight","excess body fat, particulary if stored around the abdomen,can increase the body's resistance to the hormone insulin."));
        items.add(new Item("Tomato Products","Whether it’s in the form of tomato juice, pasta sauce,or a puree,almost any canned or bottled tomato product contains a lot of sodium. A cup of tomato juice, for example, contains 650 milligrams."));
        items.add(new Item("Coffee","Whether you should abstain from coffee depends on how much you normally drink and how frequently. Coffee is capable of producing a spike in your blood pressure for a short period after drinking, but the effect wears off relatively quickly. In regular coffee drinkers, this effect is lessened or nonexistent as their bodies get used to the caffeine."));
        items.add(new Item("Pickles","Pickles are low calorie, which is great, but they are loaded with sodium.One medium pickle (about 5 inches long) can have around 570 mg of sodium. That’s over 1/3 of your sodium limit (2300 mg) for the day."));
        items.add(new Item("Fast Food French Fries","While many fast food chains are now frying their fries in trans fat free oil, not all of them are. Regardless, french fries still provide a large dose of fat and sodium. A medium serving of fries has about 19 grams of fat and 270 mg of sodium."));
        items.add(new Item("Sugar","Foods with extra calories and full of sugar cause you to gain weight.Obesity is a significant determinant for high blood pressure. The extra weight puts surplus strain on the heart and slows down the blood flow."));
        items.add(new Item("Alcohol","Alcohol consumption actively causes the blood pressure to elevate.It also damages the walls of the blood vessels, while simultaneously increases risks of further complications."));
        items.add(new Item("Red Meat","A healthy eating plan should include only a small amount (if any) of saturated or trans-fats.  Fatty foods are bad for both the heart and blood vessels.  Avoid red meat and fast food along with other fats that include hydrogenated oils."));
        items.add(new Item("Table Salt","Too much sodium does direct damage to the heart and arteries and raises blood pressure significantly."));
        return items;
    }
}