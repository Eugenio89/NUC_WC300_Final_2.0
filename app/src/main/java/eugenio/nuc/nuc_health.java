package eugenio.nuc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;


public class nuc_health extends AppCompatActivity {


    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;


    EditText altura;
    EditText peso;
    EditText edad;
    TextView bmi_result;
    TextView bmr_result;
    TextView tdee_result;
    Button calculate_button;

    double height, weight, age, bmi, bmr, tdee;





    public void onRadioButtonClicked(View view) {
        //Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        //Check which radio button was clicked
        switch (view.getId()) {

            case R.id.radio_male:
                if (checked)
                    //male formula
                    altura = (EditText)findViewById(R.id.altura);
                    peso = (EditText)findViewById(R.id.peso);
                    edad = (EditText)findViewById(R.id.edad);
                    height = Double.parseDouble(altura.getText().toString());
                    weight = Double.parseDouble(peso.getText().toString());
                    age = Double.parseDouble(edad.getText().toString());
                    bmr = (10 * weight) + (6.25 * height*100) - (5 * age) + 5;
                    //66 + (6.23 * weight) + (12.7 * height) - (6.76 * age);

                break;

            case R.id.radio_female:
                if (checked)
                    //female formula
                    altura = (EditText)findViewById(R.id.altura);
                    peso = (EditText)findViewById(R.id.peso);
                    edad = (EditText)findViewById(R.id.edad);
                    height = Double.parseDouble(altura.getText().toString());
                    weight = Double.parseDouble(peso.getText().toString());
                    age = Double.parseDouble(edad.getText().toString());
                    bmr = (10 * weight) + (6.25 * height*100) - (5 * age) - 161;
                    //665 + (4.35 * weight) + (4.7 * height) - (4.7 * age);
                    //
                break;
        }


    }













    public void onRadioButtonClickedAF(View view) {
        //Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        //Check which radio button was clicked
        switch (view.getId()) {

            case R.id.Sedentary:
                if (checked)
                    //male formula
                    altura = (EditText)findViewById(R.id.altura);
                    peso = (EditText)findViewById(R.id.peso);
                    edad = (EditText)findViewById(R.id.edad);
                    height = Double.parseDouble(altura.getText().toString());
                    weight = Double.parseDouble(peso.getText().toString());
                    age = Double.parseDouble(edad.getText().toString());
                    tdee = bmr * 1.2;
                break;

            case R.id.LightlyActive:
                if (checked)
                    //female formula
                    altura = (EditText)findViewById(R.id.altura);
                    peso = (EditText)findViewById(R.id.peso);
                    edad = (EditText)findViewById(R.id.edad);
                    height = Double.parseDouble(altura.getText().toString());
                    weight = Double.parseDouble(peso.getText().toString());
                    age = Double.parseDouble(edad.getText().toString());
                    tdee = bmr * 1.375;
                break;

            case R.id.ModeratelyActive:
                if (checked)
                    //female formula
                    altura = (EditText)findViewById(R.id.altura);
                peso = (EditText)findViewById(R.id.peso);
                edad = (EditText)findViewById(R.id.edad);
                height = Double.parseDouble(altura.getText().toString());
                weight = Double.parseDouble(peso.getText().toString());
                age = Double.parseDouble(edad.getText().toString());
                tdee = bmr * 1.55;
                break;

            case R.id.VeryActive:
                if (checked)
                    //female formula
                    altura = (EditText)findViewById(R.id.altura);
                peso = (EditText)findViewById(R.id.peso);
                edad = (EditText)findViewById(R.id.edad);
                height = Double.parseDouble(altura.getText().toString());
                weight = Double.parseDouble(peso.getText().toString());
                age = Double.parseDouble(edad.getText().toString());
                tdee = bmr * 1.725;
                break;

            case R.id.ExtremelyActive:
                if (checked)
                    //female formula
                    altura = (EditText)findViewById(R.id.altura);
                peso = (EditText)findViewById(R.id.peso);
                edad = (EditText)findViewById(R.id.edad);
                height = Double.parseDouble(altura.getText().toString());
                weight = Double.parseDouble(peso.getText().toString());
                age = Double.parseDouble(edad.getText().toString());
                tdee = bmr * 1.9;
                break;
        }
    }






    RadioGroup radioGroup;
    RadioButton radioButtonMale;
    RadioButton radioButtonFemale;

    RadioButton radioButtonSedentary;
    RadioButton radioButtonLightlyActive;
    RadioButton radioButtonModeratelyActive;
    RadioButton radioButtonVeryActive;
    RadioButton radioButtonExtremelyActive;





    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nuc_health);


        //Variables

        altura = (EditText)findViewById(R.id.altura);
        peso = (EditText)findViewById(R.id.peso);
        edad = (EditText)findViewById(R.id.edad);
        bmi_result = (TextView)findViewById(R.id.bmi_result);
        calculate_button = (Button) findViewById(R.id.calculate_button);


        radioGroup = (RadioGroup) findViewById(R.id.radioSexGroup);
        radioButtonMale = (RadioButton) findViewById(R.id.radio_male);
        radioButtonFemale = (RadioButton) findViewById(R.id.radio_female);

        radioButtonSedentary = (RadioButton) findViewById(R.id.Sedentary);
        radioButtonLightlyActive = (RadioButton) findViewById(R.id.LightlyActive);
        radioButtonModeratelyActive = (RadioButton) findViewById(R.id.ModeratelyActive);
        radioButtonVeryActive = (RadioButton) findViewById(R.id.VeryActive);
        radioButtonExtremelyActive = (RadioButton) findViewById(R.id.ExtremelyActive);

        loadSavedPreferences();


    //Boton para ir a la Actividad Basic Juices

        final Button button = findViewById(R.id.button_go_juices);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //codigo
                    startActivity(new Intent(nuc_health.this, BasicJuices.class));
            }
        });





        //Acciones cuando se presiona el boton de calcular

        calculate_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                //Aqui van las operaciones

                height = Double.parseDouble(altura.getText().toString());
                weight = Double.parseDouble(peso.getText().toString());
                bmi = weight / (height * height);


                savePreferences("storedHeight", altura.getText().toString());
                savePreferences("storedWeight", peso.getText().toString());
                savePreferences("storedAge", edad.getText().toString());

                savePreferences("Male_Value", radioButtonMale.isChecked());
                savePreferences("Female_Value", radioButtonFemale.isChecked());

                savePreferences("Sede", radioButtonSedentary.isChecked());
                savePreferences("Ligh", radioButtonLightlyActive.isChecked());
                savePreferences("Mode", radioButtonModeratelyActive.isChecked());
                savePreferences("Very", radioButtonVeryActive.isChecked());
                savePreferences("Extr", radioButtonExtremelyActive.isChecked());



                //Show Double with Decimal Format BMI
                bmi_result.setText(new DecimalFormat("##.##").format(bmi));


                //Show Double to String BMR
                final TextView txtValue = (TextView) findViewById(R.id.bmr_result);
                txtValue.setText(Double.toString(bmr));


                //Show Double to String TDEE
                final TextView txtValue2 = (TextView) findViewById(R.id.tdee_result);
                txtValue2.setText(Double.toString(tdee));


                //Recommendacion basada en BMI

                if (bmi <= 15) {
                    TextView tv = (TextView) findViewById(R.id.bmi_type);
                    tv.setText("Very Severely Underweight");

                    TextView tv1 = (TextView) findViewById(R.id.recommendation);
                    tv1.setText("Orange Juice \nGrape Juice ");
                } else if (bmi > 15 && bmi <= 16) {
                    TextView tv = (TextView) findViewById(R.id.bmi_type);
                    tv.setText("Severely Underweight");

                    TextView tv1 = (TextView) findViewById(R.id.recommendation);
                    tv1.setText("Carrot and Celery Juice \nPurple Cabbage Juice ");
                } else if (bmi > 16 && bmi <= 18.5) {
                    TextView tv = (TextView) findViewById(R.id.bmi_type);
                    tv.setText("Underweight");

                    TextView tv1 = (TextView) findViewById(R.id.recommendation);
                    tv1.setText("Cabbage Juice \nDetox Green Juice \nTangy Tomato ");
                } else if (bmi > 18.5 && bmi <= 25) {
                    TextView tv = (TextView) findViewById(R.id.bmi_type);
                    tv.setText("Normal (Healthy Weight)");

                    TextView tv1 = (TextView) findViewById(R.id.recommendation);
                    tv1.setText("Celeb Celery Juice \nPear Juice \nBaby Spinach Juice \nCarrot Juice ");
                } else if (bmi > 25 && bmi <= 30) {
                    TextView tv = (TextView) findViewById(R.id.bmi_type);
                    tv.setText("Overweight");

                    TextView tv1 = (TextView) findViewById(R.id.recommendation);
                    tv1.setText("Bell Pepper Juice \n Apple Juice \n Wheatgrass Juice ");
                } else if (bmi > 30 && bmi <= 35) {
                    TextView tv = (TextView) findViewById(R.id.bmi_type);
                    tv.setText("Moderately Obese");

                    TextView tv1 = (TextView) findViewById(R.id.recommendation);
                    tv1.setText("Spinach Juice \nMultivitamin Juice \n Pomegranate Juice ");
                } else if (bmi > 35 && bmi <= 40) {
                    TextView tv = (TextView) findViewById(R.id.bmi_type);
                    tv.setText("Severely Obese");

                    TextView tv1 = (TextView) findViewById(R.id.recommendation);
                    tv1.setText("Dreamy Carrot Juice \n Kale Juice ");
                } else {
                    TextView tv = (TextView) findViewById(R.id.bmi_type);
                    tv.setText("Very Severely Obese");

                    TextView tv1 = (TextView) findViewById(R.id.recommendation);
                    tv1.setText("Celery Juice \nTomato Juice ");
                }
            }

        });














    }



    //**********************************************************************************************
    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        boolean radioButtonMaleValue = sharedPreferences.getBoolean("Male_Value", false);
        boolean radioButtonFemaleValue = sharedPreferences.getBoolean("Female_Value", false);

        boolean radioButtonSedentaryValue = sharedPreferences.getBoolean("Sede", false);
        boolean radioButtonLightValue = sharedPreferences.getBoolean("Ligh", false);
        boolean radioButtonModeratelyValue = sharedPreferences.getBoolean("Mode", false);
        boolean radioButtonVeryValue = sharedPreferences.getBoolean("Very", false);
        boolean radioButtonExtremelyValue = sharedPreferences.getBoolean("Extr", false);

        String altura1 = sharedPreferences.getString("storedHeight", "Height (m)");
        altura.setText(altura1);

        String peso1 = sharedPreferences.getString("storedWeight", "Weight (Kg)");
        peso.setText(peso1);

        String edad1 = sharedPreferences.getString("storedAge", "Age (Years)");
        edad.setText(edad1);

        if (radioButtonMaleValue) {
            radioButtonMale.setChecked(true); //revisaras esto
        } else {
            radioButtonMale.setChecked(false);
        }

        if (radioButtonFemaleValue) {
            radioButtonFemale.setChecked(true); //revisaras esto
        } else {
            radioButtonFemale.setChecked(false);
        }





        if (radioButtonSedentaryValue) {
            radioButtonSedentary.setChecked(true); //revisaras esto
        } else {
            radioButtonSedentary.setChecked(false);
        }

        if (radioButtonLightValue) {
            radioButtonLightlyActive.setChecked(true); //revisaras esto
        } else {
            radioButtonLightlyActive.setChecked(false);
        }

        if (radioButtonModeratelyValue) {
            radioButtonModeratelyActive.setChecked(true); //revisaras esto
        } else {
            radioButtonModeratelyActive.setChecked(false);
        }

        if (radioButtonVeryValue) {
            radioButtonVeryActive.setChecked(true); //revisaras esto
        } else {
            radioButtonVeryActive.setChecked(false);
        }

        if (radioButtonExtremelyValue) {
            radioButtonExtremelyActive.setChecked(true); //revisaras esto
        } else {
            radioButtonExtremelyActive.setChecked(false);
        }


    }



//***********************************************************************************************

    private void savePreferences(String key, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }



    private void savePreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
















}
