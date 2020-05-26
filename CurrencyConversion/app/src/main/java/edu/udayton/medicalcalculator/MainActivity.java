package edu.udayton.medicalcalculator;

import android.app.Activity;
import android.graphics.Color;
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
    private RadioGroup rdGrpCurrency;
    private RadioButton rdchildCurrency;
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

            rdGrpCurrency = (RadioGroup) findViewById(R.id.radGroup);
            btnDisplay = (Button) findViewById(R.id.btnConvert);

            btnDisplay.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    try {
                        double edgetamt = Double.parseDouble(txtDollars.getText().toString());
                        if (edgetamt <= 100000) {

                            // get selected radio button from radioGroup
                            int selectedId = rdGrpCurrency.getCheckedRadioButtonId();

                            // find the radiobutton by returned id
                            rdchildCurrency = (RadioButton) findViewById(selectedId);

                            Toast.makeText(MainActivity.this,
                                    rdchildCurrency.getText(), Toast.LENGTH_SHORT).show();
                            String strradio = rdchildCurrency.getText().toString();
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
                            } catch (Exception e) {
//                    txtResult.setTextColor(Color.RED);
                                txtResult.setText("Please enter dollar!");
                            }
                        } else {
                            txtResult.setText("app only converts values below $ 100,000");
                            Toast.makeText(MainActivity.this, "app only converts values below $ 100,000", Toast.LENGTH_SHORT).show();
                        }
                    }catch (Exception ee){
                        txtResult.setText("Please enter dollar!");

                    }
                }

            });

    }
}