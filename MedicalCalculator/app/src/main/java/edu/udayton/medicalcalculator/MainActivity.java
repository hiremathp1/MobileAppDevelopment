package edu.udayton.medicalcalculator;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends Activity {
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private Button btnDisplay;
    double usdollar = 1.0, resultConverted, bycurrency;
    EditText txtDollars;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDollars = (EditText) findViewById(R.id.txtDollars);
        txtResult = (TextView) findViewById(R.id.txtResult);
        addListenerOnButton();

    }

    public void addListenerOnButton() {

        radioSexGroup = (RadioGroup) findViewById(R.id.radGroup);
        btnDisplay = (Button) findViewById(R.id.btnConvert);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioSexGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(MainActivity.this,
                        radioSexButton.getText(), Toast.LENGTH_SHORT).show();
                String strradio = radioSexButton.getText().toString();
                try {
                    usdollar = Double.parseDouble(txtDollars.getText().toString());

                    if (strradio.equals("Convert Dollars to Euro")) {
                        bycurrency = 0.89;
                        resultConverted = (usdollar * bycurrency);
                        txtResult.setText(new DecimalFormat("##.##").format(resultConverted) + "Euro");

                    } else if (strradio.equals("Convert Dollars to Mexican pesos")) {
                        bycurrency = 19.17;
                        resultConverted = (usdollar * bycurrency);
                        txtResult.setText(new DecimalFormat("##.##").format(resultConverted) + "Mexican peso");
                    } else if (strradio.equals("Convert Dollars to Canadian Dollars")) {
                        bycurrency = 1.33;
                        resultConverted = (usdollar * bycurrency);
                        txtResult.setText(new DecimalFormat("##.##").format(resultConverted) + "Canadian Dollars");

                    }
                }catch (Exception e){
//                    txtResult.setTextColor(Color.RED);
                    txtResult.setText("Please enter dollar!");
                }

            }

        });

    }
}