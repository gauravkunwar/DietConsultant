package gaurav.dietconsultant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;


public class AvoidRiskofDiabetes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avoidrisk);
        // 1. pass context and data to the custom adapter
        MyAdapter adapter = new MyAdapter(this, generateData());

        // 2. Get ListView from avoidrisk.xml
        ListView listView = (ListView) findViewById(R.id.listview);

        // 3. setListAdapter
        listView.setAdapter(adapter);
    }

    private ArrayList<Item> generateData(){
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Manage your Weight","excess body fat, particulary if stored around the abdomen,can increase the body's resistance to the hormone insulin."));
        items.add(new Item("Reduce intake of high-sugar foods","slowly reduce the sugar in your diet a little at a time to give your taste buds time to adjust ."));
        items.add(new Item("Exercise regularly","Moderate physical activity on most days of the week helps manage weight " +
                ",reduce blood glucose levels and may also improve blood pressure and cholesterol."));
        items.add(new Item("Choose the right fats","Add some healthy fats in your diet ." +
                "Fat slows down the digestive process ,meaning blood sugar levels don't spike as quickly." +
                "That doesn't mean you should reach for the donuts,though."));
        items.add(new Item("Follow a plant-based ,low Calorie Diet","Eat a balanced,healthy diet.Reduce the amount of fat in your diet ," +
                "especially saturated and trans fats.Eat more fruits,vegetables and high-fiber foods.Cut back on salt."));
        items.add(new Item("Be Active","Move your body .Physical inactivity raises the risk of diabetes.Exercise renders cells more sensitive to insulin."));
        items.add(new Item("Sleep Well","Chronic sleep deprivation and poor quality sleep increase the risk for diabetes and obesity."));
        items.add(new Item("Control your Blood Pressure","Most people can do this with regular exercise, " +
                "a balanced diet and by keeping a healthy weight.In some cases,you might need medication prescribed by your doctor." +
                ""));
        return items;
    }

}