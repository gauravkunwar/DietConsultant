package gaurav.dietconsultant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.exp; //Naive Bayes
import static java.lang.Math.sqrt; //Naive Bayes


public class CalculateCalorie extends AppCompatActivity {

    RadioGroup radioGenderGroup, radioActivityGroup;
    RadioButton radioGenderButton, radioActivityButton;
    EditText raw_age,raw_height,raw_weight;
    double age, height, weight, bmr_temp, bmr_final;
    Button Calculate;
    TextView text;
    int temp, disease_value;
    CheckBox Diabetes, Pressure;
    int weight_category;

    //for Naive Bayes
    double ow_output, nw_output, uw_output ;
    double mean_ht_ow,mean_ht_nw,mean_ht_uw,var_ht_ow,var_ht_nw,var_ht_uw,mean_wt_ow,mean_wt_nw,mean_wt_uw,var_wt_ow,var_wt_nw,var_wt_uw;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calorie_calculate);

        raw_age=(EditText) findViewById(R.id.age);
        raw_height=(EditText) findViewById(R.id.height);
        raw_weight=(EditText) findViewById(R.id.weight);
        text=(TextView) findViewById(R.id.toptext); //should be removed from final code
        Calculate=(Button) findViewById(R.id.calculate_button);
        radioGenderGroup=(RadioGroup) findViewById(R.id.radioGender);
        radioActivityGroup = (RadioGroup) findViewById(R.id.radioActivity);
        Diabetes=(CheckBox) findViewById(R.id.checkBox);
        Pressure=(CheckBox) findViewById(R.id.checkBox2);


        /***Feeding Naive Bayes with sample (mean and variance calculation too) ***/

        //height samples of overweight
        double [] height_ow=new double[4];
        height_ow[0]=152.4;
        height_ow[1]=162.6;
        height_ow[2]=172.7;
        height_ow[3]=182.8;

        //weight samples of overweight
        double [] weight_ow =new double[4];
        weight_ow[0]= 68;
        weight_ow[1]=90.7;
        weight_ow[2]=81.6;
        weight_ow[3]=104.3;

        //height samples of normalweight
        double [] height_nw=new double[4];
        height_nw[0]=152.4;
        height_nw[1]=162.6;
        height_nw[2]=172.7;
        height_nw[3]=182.8;

        //weight samples of normalweight
        double [] weight_nw = new double[4];
        weight_nw[0] = 49.8;
        weight_nw[1] = 58.9;
        weight_nw[2] = 68;
        weight_nw[3] = 81.6;

        //height samples of underweight
        double [] height_uw=new double[4];
        height_uw[0]=152.4;
        height_uw[1]=162.6;
        height_uw[2]=172.7;
        height_uw[3]=182.8;

        //weight samples of underweight
        double [] weight_uw = new double[4];
        weight_uw[0] = 40.8;
        weight_uw[1] = 45.3;
        weight_uw[2] = 49.8;
        weight_uw[3] = 50;

        /*****************************mean and variance of height***************************************/

        //mean of height (overweight)
        mean_ht_ow = (height_ow[0]+height_ow[1]+height_ow[2]+height_ow[3])/4;

        //mean of height (normalweight)
        mean_ht_nw = (height_nw[0]+height_nw[1]+height_nw[2]+height_nw[3])/4;

        //mean of height (underweight)
        mean_ht_uw = (height_uw[0]+height_uw[1]+height_uw[2]+height_uw[3])/4;

        //to calculate variance of height (overweight)
        var_ht_ow=(((height_ow[0]-mean_ht_ow)*(height_ow[0]-mean_ht_ow))+
                ((height_ow[1]-mean_ht_ow)*(height_ow[1]-mean_ht_ow))+
                ((height_ow[2]-mean_ht_ow)*(height_ow[2]-mean_ht_ow))+
                ((height_ow[3]-mean_ht_ow)*(height_ow[3]-mean_ht_ow)))/3;

        //to calculate variance of height (normalweight)
        var_ht_nw=(((height_nw[0]-mean_ht_nw)*(height_nw[0]-mean_ht_nw))+
                ((height_nw[1]-mean_ht_nw)*(height_nw[1]-mean_ht_nw))+
                ((height_nw[2]-mean_ht_nw)*(height_nw[2]-mean_ht_nw))+
                ((height_nw[3]-mean_ht_nw)*(height_nw[3]-mean_ht_nw)))/3;

        //to calculate variance of height (underweight)
        var_ht_uw=(((height_uw[0]-mean_ht_uw)*(height_uw[0]-mean_ht_uw))+
                ((height_uw[1]-mean_ht_uw)*(height_uw[1]-mean_ht_uw))+
                ((height_uw[2]-mean_ht_uw)*(height_uw[2]-mean_ht_uw))+
                ((height_uw[3]-mean_ht_uw)*(height_uw[3]-mean_ht_uw)))/3;


        /*******************************mean and variance of weight*****************************************/

        //mean of weight (overweight)
        mean_wt_ow = (weight_ow[0]+weight_ow[1]+weight_ow[2]+weight_ow[3])/4;

        //mean of weight (normalweight)
        mean_wt_nw = (weight_nw[0]+weight_nw[1]+weight_nw[2]+weight_nw[3])/4;

        //mean of weight (overweight)
        mean_wt_uw = (weight_uw[0]+weight_uw[1]+weight_uw[2]+weight_uw[3])/4;

        //to calculate variance of weight (overweight)
        var_wt_ow=(((weight_ow[0]-mean_wt_ow)*(weight_ow[0]-mean_wt_ow))+
                ((weight_ow[1]-mean_wt_ow)*(weight_ow[1]-mean_wt_ow))+
                ((weight_ow[2]-mean_wt_ow)*(weight_ow[2]-mean_wt_ow))+
                ((weight_ow[3]-mean_wt_ow)*(weight_ow[3]-mean_wt_ow)))/3;

        //to calculate variance of weight (normalweight)
        var_wt_nw=(((weight_nw[0]-mean_wt_nw)*(weight_nw[0]-mean_wt_nw))+
                ((weight_nw[1]-mean_wt_nw)*(weight_nw[1]-mean_wt_nw))+
                ((weight_nw[2]-mean_wt_nw)*(weight_nw[2]-mean_wt_nw))+
                ((weight_nw[3]-mean_wt_nw)*(weight_nw[3]-mean_wt_nw)))/3;

        //to calculate variance of weight (underweight)
        var_wt_uw=(((weight_uw[0]-mean_wt_uw)*(weight_uw[0]-mean_wt_uw))+
                ((weight_uw[1]-mean_wt_uw)*(weight_uw[1]-mean_wt_uw))+
                ((weight_uw[2]-mean_wt_uw)*(weight_uw[2]-mean_wt_uw))+
                ((weight_uw[3]-mean_wt_uw)*(weight_uw[3]-mean_wt_uw)))/3;

        /***************************(when height = 172 and weight = 64)***********************************/

//        mean_ht=167.625;
//        var_ht=171.03;
//        mean_wt_ow=86.15;
//        mean_wt_nw=64.57;
//        mean_wt_uw=46.47;
//        var_wt_ow= 233.41;
//        var_wt_nw=184.02;
//        var_wt_uw=19.01;

        /*************** End of sample provided to Naive Bayes classifier*************************/

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //to ensure null data is not entered
                try {
                    age = Integer.parseInt(raw_age.getText().toString());
                    height = Integer.parseInt(raw_height.getText().toString());
                    weight = Integer.parseInt(raw_weight.getText().toString());
                } catch (Exception e) {
//                    Toast.makeText(CalculateCalorie.this, "Input cannot be empty.", Toast.LENGTH_LONG).show();

                }

                //to enure data entered is not zero
                if (age > 0 && age <99 && height > 0 && weight > 0 ) {
                    //following code deals with gender
                    int genderID = radioGenderGroup.getCheckedRadioButtonId();
                    radioGenderButton = (RadioButton) findViewById(genderID);

                    //calculation of BMR (temp)
                    if (genderID == 2131492969) {
                        bmr_temp = 66.5 + (13.75 * weight) + (5.003 * height) - (6.755 * age);
                        //   text.setText("Male. BMR is : " + bmr);//should be removed from final code
                    } else if (genderID == 2131492970) {
                        bmr_temp = 655.1 + (9.563 * weight) + (1.850 * height) - (4.676 * age);
                        //   text.setText("Female. BMR is : " + bmr);//should be removed from final code

                    }

                    //following code deals with activity level and calculates calorie recommended
                    int activityID = radioActivityGroup.getCheckedRadioButtonId();
                    radioActivityButton = (RadioButton) findViewById(activityID);

                    if (activityID == 2131492972) { // for low activity
                        bmr_final = bmr_temp * 1.375;
                    } else if (activityID == 2131492973) { //for moderate activity
                        bmr_final = bmr_temp * 1.55;
                    } else if (activityID == 2131492974) { //for high activity
                        bmr_final = bmr_temp * 1.725;
                    }

                    //following code deals with checkboxes (disease)
                    //1 means both, 2 means diabetes, 3 means pressure, 4 means no disease

                    if (Diabetes.isChecked()==true && Pressure.isChecked()==true){
                        disease_value =1;
                    }
                    else if (Diabetes.isChecked()==true){
                        disease_value =2;

                    }
                    else if (Pressure.isChecked()==true){
                        disease_value =3;

                    }
                    else
                    {
                        disease_value =4;

                    }


//                    /*********************code for calculating BMI of a person***********************/
//
//                    double bmi_height = height/100;
//                    double bmi_height2 = bmi_height*bmi_height;
//                    double bmi= weight/bmi_height2;
//
//                    int bmi_final = (int)bmi;
//                    if (bmi_final<19){
//                        //under weight
//                        weight_category=1;
//                    }
//
//                    else if(bmi_final>18 && bmi<26){
//                        //normal weight
//                        weight_category=2;
//                    }
//
//                    else if (bmi_final>25){
//                        //overweight
//                        weight_category=3;
//                    }
                    /**********************end of code for calculating BMI of a person*********************/


                    /*******************************Naive Bayes Calculation Code******************************/

                /*for over weight*/
                    double ow_height = 1 / sqrt(2 * (22 / 7) * var_ht_ow) * exp(-((height - mean_ht_ow) * (height - mean_ht_ow)) / (2 * var_ht_ow));
                    double ow_weight = 1 / sqrt(2 * (22 / 7) * var_wt_ow) * exp(-((weight - mean_wt_ow) * (weight - mean_wt_ow)) / (2 * var_wt_ow));
                    ow_output = ow_height*ow_weight;

                /*for normal weight*/
                    double nw_height = 1 / sqrt(2 * (22 / 7) * var_ht_nw) * exp(-((height - mean_ht_nw) * (height - mean_ht_nw)) / (2 * var_ht_nw));
                    double nw_weight = 1 / sqrt(2 * (22 / 7) * var_wt_nw) * exp(-((weight - mean_wt_nw) * (weight - mean_wt_nw)) / (2 * var_wt_nw));
                    nw_output = nw_height*nw_weight;

                /*for under weight*/
                    double uw_height = 1 / sqrt(2 * (22 / 7) * var_ht_uw) * exp(-((height - mean_ht_uw) * (height - mean_ht_uw)) / (2 * var_ht_uw));
                    double uw_weight = 1 / sqrt(2 * (22 / 7) * var_wt_uw) * exp(-((weight - mean_wt_uw) * (weight - mean_wt_uw)) / (2 * var_wt_uw));
                    uw_output = uw_height*uw_weight;


                    if(uw_output>nw_output && uw_output>ow_output){
                        //under weight
                        weight_category=1;
                    }

                    else if(nw_output>ow_output && nw_output>uw_output){
                        //normal weight
                        weight_category=2;
                    }

                    else if(ow_output>nw_output && ow_output>uw_output){
                        //overweight
                        weight_category=3;
                    }


                    /*****************************Naive Bayes code end***************************/


                    temp = (int) bmr_final;//final calorie calulated
                    //  text.setText("We recommend you to have "+temp+" calories per day");


                    //following code passes value to another activity
                    Intent i = new Intent(CalculateCalorie.this, DisplayCalorie.class);
                    Bundle bundle = new Bundle();//creates a bundle
                    bundle.putInt("key",temp); // puts the calorie calculated inside the bundle
                    bundle.putInt("key1", disease_value); // puts the disease identity inside the bundle
                    bundle.putInt("key2",weight_category); //puts weight category inside the bundle
                    i.putExtras(bundle); // sends bundle through the intent called
//                    i.putExtra("key", temp);
                    startActivity(i); // intent gets initialized
                } else{
                    Toast.makeText(CalculateCalorie.this, "Input invalid or null.", Toast.LENGTH_LONG).show();
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
            CalculateCalorie.this.finish();
        }
        return true;
    }
}
