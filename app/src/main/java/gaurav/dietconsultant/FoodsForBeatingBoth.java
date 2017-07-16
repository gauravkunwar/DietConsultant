package gaurav.dietconsultant;

/**
 * Created by kunwar on 7/1/17.
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;


public class FoodsForBeatingBoth extends AppCompatActivity {

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
        items.add(new Item("Berries","Berries are full of fiber and antioxisants." +
                "The red and blue varieties also contain natural plant compounds called anthocyanins."));
        items.add(new Item("Avocados","Avocados are known for their heart-healthy monounsaturated fat content" +
                "When substituting these fats for saturated fat,they can improve cholesterol levels,decreasing your risk of heart disease."));
        items.add(new Item("Barley","Choosing this grain instead of white rice can reduce the rise in blood sugar after a meal by almost 70% and keep " +
                "your blood sugar lower and steadier for hours."));
        items.add(new Item("Broccoli","This dark green vegetable's vitamin A power promotes healthy vision,teeth,bones,and skin." +
                "It is also in folate and fiber,all with minimal calories and carbs."));
        items.add(new Item("Carrots","Cooked or raw ,carrots are a healthy addition to any meal plan." +
                "While cooked carrots have the rich texture of starchy vegetables,such as potatoes,they are classified as non starchy " +
                "veggies because they don't contain a lot carbohydrate."));
        items.add(new Item("Citrus Fruit","Grapefruit,oranges,lemons and limes." +
                "pick your favourites and get part of your daily dose of soluble fiber and vitamin c ."));
        items.add(new Item("Cranberries","These are best known for helping to prevent urinary tract" +
                " infections,cranberries-with their abundant phytonutients,including anthocyanins- may be especially beneficial in a diabetic meal plan."));
        items.add(new Item("Eggs","Eggs are another excellent ,inexpensive source of high-quality protein.so high,in fact," +
                "that egg protein is the gold standard nutritionists use to rank all other protein."));
        items.add(new Item("Fish ","Salmon is a favorite in this category.Stay awake from the breaded and deep fat fried variety ."));
        items.add(new Item("Milk and Yogurt","Both are rich protein and calcium which studies show may help people " +
                "lose weight.And diets that include plenty of Diary may fight insulin resistance,a core problem behind diabetes."));

        return items;
    }
}

