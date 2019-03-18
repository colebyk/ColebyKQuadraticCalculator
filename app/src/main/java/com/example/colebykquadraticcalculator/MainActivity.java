package com.example.colebykquadraticcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    double coords1[] = new double[2];
    double coords2[] = new double[2];
    double coords3[] = new double[2];

    private double[] getCoords1(EditText coord1, EditText coord2) {
        coords1[0] = Double.parseDouble(coord1.getText().toString());
        coords1[1] = Double.parseDouble(coord2.getText().toString());
        return coords1;
    }

    private double[] getCoords2(EditText coord1, EditText coord2) {
        coords2[0] = Double.parseDouble(coord1.getText().toString());
        coords2[1] = Double.parseDouble(coord2.getText().toString());
        return coords2;
    }

    private double[] getCoords3(EditText coord1, EditText coord2) {
        coords3[0] = Double.parseDouble(coord1.getText().toString());
        coords3[1] = Double.parseDouble(coord2.getText().toString());
        return coords3;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcBtn = (Button) findViewById(R.id.calcBtn);

        final EditText x1EditText = (EditText) findViewById(R.id.x1EditText);
        final EditText x2EditText = (EditText) findViewById(R.id.x2EditText);
        final EditText y1EditText = (EditText) findViewById(R.id.y1EditText);
        final EditText y2EditText = (EditText) findViewById(R.id.y2EditText);
        final EditText x3EditText = (EditText) findViewById(R.id.x3EditText);
        final EditText y3EditText = (EditText) findViewById(R.id.y3EditText);

        final TextView aResultTextView = (TextView) findViewById(R.id.aResultTextView);
        final TextView bResultTextView = (TextView) findViewById(R.id.bResultTextView);
        final TextView cResultTextView = (TextView) findViewById(R.id.cResultTextView);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coords1 = getCoords1(x1EditText,y1EditText);
                coords2 = getCoords2(x2EditText,y2EditText);
                coords3 = getCoords3(x3EditText,y3EditText);



                double numerator = coords1[0] * (coords3[1] - coords2[1]) + coords2[0] * (coords1[1] - coords3[1]) + coords3[0] * (coords2[1] - coords1[1]);
                double denominator = (coords1[0] - coords2[0]) * (coords1[0] - coords3[0]) * (coords2[0] - coords3[0]);

                double a = numerator/denominator;


                double b = (coords2[1] - coords1[1]) / (coords2[0] - coords1[0]) - a * (coords1[0] + coords2[0]);


                double c = coords1[1] - (a * (Math.pow(coords1[0], 2))) - (b * coords1[0]);

                aResultTextView.setText(a + "");
                bResultTextView.setText(b + "");
                cResultTextView.setText(c + "");
            }
        });

    }
}


