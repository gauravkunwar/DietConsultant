package gaurav.dietconsultant;

/**
 * Created by kunwar on 7/1/17.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class WorstFoodForBoth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.worstfood);
        // 1. pass context and data to the custom adapter
        MyAdapter adapter = new MyAdapter(this, generateData());

        // 2. Get ListView from activity_main.xml
        ListView listView = (ListView) findViewById(R.id.listview);

        // 3. setListAdapter
        listView.setAdapter(adapter);
    }

    private ArrayList<Item> generateData(){
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("Candy","Not only do high-sugar foods like candy,cookies,syrup,and soda lack nutritional value, " +
                "but these low-quality carbohydrates also cause a dramatic spike in blood sugar levels can contribute to weight gain ," +
                "both of which can worsen diabetes complications."));
        items.add(new Item("White Rice","Eating white rice can raise blood glucose significantly," +
                "especially if eaten often or in large quantities.White rice and pasta can cause blood sugar spikes similar to that of sugar."));
        items.add(new Item("Coffee Drinks","Coffees that are laced with syrup,sugar,whipped cream," +
                "and other toppings can have as many calories and fat grams as a milkshake,making them a poor choice for those with diabetes."));
        items.add(new Item("Fruit Juice ","while fiber-rich whole fruits are considered healthy carbohydrates for people with diabetes," +
                "fruit juice is another story." +
                "people with diabetes should avoid drinking juices.Fruit juice contains more nutrition than soda" +
                " and other sugary drinks,but the problem is that juices have concentrated amounts of fruit sugar and therefore cause your blood sugar to shoot up."));
        items.add(new Item("Bananas and melons","All fresh fruit is packed with vitamins and fiber," +
                "making them a healthy part of any diet." +
                "However ,some fruits contain more sugar."));
        items.add(new Item("Dried Fruit","Although dried fruit contains fiber and manu nutrients,the dehydration process causes " +
                "fruits natural sugar to ge super-concentrated.skip the dried fruit and instead stick with fresh fruit options," +
                "such as grapefruit,cantaloupe,strawberries,and peaches."));
        items.add(new Item("Full-Fat Diary ","Saturated fats in diary products can raise your \"bad\"(LDL) cholesterol levels and increase your risk of heart diseaes." +
                "But saturated fats may cause yet another serious problem for people with diabetes." +
                "Avoid diary products mad with whole milk,such as cream.full-fat yogurt,ice cream,cream cheese,and other full-fat cheeses."));
        items.add(new Item("Chinese food","the biggest offenders include fried entrees such as orange chicken  " +
                "and sweet and sour dishes,which contain breading and are served swimming in a sugary sauce."));
        items.add(new Item("Packaged Snacks and Baked Goods","Aside from all the sugar ,junky white flour,sodium," +
                "and preservatives they contain,packaged snacks and baked goods like chips,pretzels,crackers,cookies,dounuts," +
                "and snack cakes often have trans fats."));
        return items;
    }

}