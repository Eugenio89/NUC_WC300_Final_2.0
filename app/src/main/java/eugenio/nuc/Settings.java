package eugenio.nuc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nordicsemi.nrfUARTv2.*;
import com.nordicsemi.nrfUARTv2.MainActivity;


public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void button_BL (View view){

        //Intent intent = new Intent(this, MainActivity.class); //LLama a la main de BL
        Intent intent = new Intent (this, MainActivity.class);

        startActivity(intent);
    }


}
