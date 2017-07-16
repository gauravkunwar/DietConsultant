package gaurav.dietconsultant;

/**
 * Created by kunwar on 7/1/17.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodsForBeatingBloodPressure extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodforbeating);
        // 1. pass context and data to the custom adapter
        MyAdapter adapter = new MyAdapter(this, generateData());

        // 2. Get ListView from activity_main.xml
        ListView listView = (ListView) findViewById(R.id.listview);

        // 3. setListAdapter
        listView.setAdapter(adapter);
    }

    private ArrayList<Item> generateData(){
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Apples","Because they offer so many health advantages,put these at the core of your diet." +
                "Apples are naturally low in calories,yet their high fiber content fills you up," +
                "battles bad cholesterol,and blunts blood-sugar swings."));
        items.add(new Item("Beans for Fiber","Incredibly high in fiber and protein,just a half cup of any type of" +
                " beans will provide about a third of your daily requirement of fiber" +
                " and as much protein as an ounce of meat.Whether you prefer kidney,pinto,navy,or black beans" +
                ",you can't find better nutrition than that provided by beans."));
        items.add(new Item("Dark Green Leafy Vegetables","Spinach,collards,kale-these powerhouse " +
                "foods are so low in calories and carbohydrate.you can't eat too much."));
        items.add(new Item("Avocados","Avocados are known for their heart-healthy monounsaturated fat content" +
                "When substituting these fats for saturated fat,they can improve cholesterol levels,decreasing your risk of heart disease."));
        items.add(new Item("Cranberries","These are best known for helping to prevent urinary tract" +
                " infections,cranberries-with their abundant phytonutients,including anthocyanins- may be especially beneficial in a diabetic meal plan."));
        items.add(new Item("Milk and Yogurt","Both are rich protein and calcium which studies show may help people " +
                "lose weight.And diets that include plenty of Diary may fight insulin resistance,a core problem behind diabetes."));

        return items;
    }
}
