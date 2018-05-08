/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.paythepiper;

import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.paythepiper.R;
import org.w3c.dom.Text;

import static android.icu.text.NumberFormat.*;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int rand = (int)(Math.random()*100);
    int price = 0;

    LinearLayout bg;
    TextView priceTextView;
    TextView random;
    Button button1;
    Button button2;
    Button button5;
    Button button10;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        priceTextView = (TextView) findViewById(R.id.price_text_view);
        random = (TextView) findViewById(R.id.random);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button5 = (Button) findViewById(R.id.button5);
        button10 = (Button) findViewById(R.id.button10);
        reset = (Button) findViewById(R.id.reset);
        bg = (LinearLayout) findViewById(R.id.bg);
        display(rand);
        displayPrice(price);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void button1fn(View view)
    {
        price = price + 1;
        displayPrice(price);
    }

    public void button2fn(View view)
    {

        price = price + 2;
        displayPrice(price);
    }

    public void button5fn(View view) {
        price = price + 5;
        displayPrice(price);
    }
    public void button10fn(View view)
    {
        price = price + 10;
        displayPrice(price);
    }
    public void resetfn(View view)
    {
        price = 0;
        displayPrice(price);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {

        priceTextView.setText(getCurrencyInstance().format(number)+" ");
        if(price==rand)
            bg.setBackgroundColor(Color.RED);
        else
            bg.setBackgroundColor(Color.WHITE);
    }

    private void display(int number)
    {
        random.setText(getCurrencyInstance().format(number)+" ");
    }

    /**
     * This method displays the given quantity value on the screen.
     */
}