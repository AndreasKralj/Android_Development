package com.example.testviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;





public class MainActivity extends AppCompatActivity {
    int firstClick = -1;
    int secondClick = -1;
    int thirdClick = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        System.out.println("\nClick values: " + firstClick + " " + secondClick + " " + thirdClick + "\n");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                //This is new

                System.out.println("\nClick values: " + firstClick + " " + secondClick + " " + thirdClick + "\n");

                //Set clicks upon start
                //If the first click is not set, go ahead and set it.
                System.out.println("\nGot to the clicking stuff!\n");
                if(firstClick < 0) {
                    System.out.println("\nGot here too!\n");
                    firstClick = position;
                }
                else if(secondClick < 0 && firstClick >= 0) {
                    secondClick = position;
                }
                else if(thirdClick < 0 && secondClick >= 0 && firstClick >= 0) {
                    thirdClick = position;
                }
                else {
                    //Do nothing
                }
                //Check if clicks are set
                if(firstClick >= 0 && secondClick >= 0 && thirdClick >= 0) {
                    //Addition
                    System.out.println("\nGot here!\n");
                    if(secondClick == 0) {
                        Toast.makeText(MainActivity.this, "" + (firstClick + thirdClick),
                                Toast.LENGTH_SHORT).show();
                    }
                    //Multiplication
                    else if(secondClick == 1) {
                        Toast.makeText(MainActivity.this, "" + (firstClick * thirdClick),
                                Toast.LENGTH_SHORT).show();
                    }
                    //Subtraction
                    else if(secondClick == 2) {
                        Toast.makeText(MainActivity.this, "" + (firstClick - thirdClick),
                                Toast.LENGTH_SHORT).show();
                    }
                }
                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
