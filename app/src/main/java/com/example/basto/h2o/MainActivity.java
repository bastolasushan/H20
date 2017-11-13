package com.example.basto.h2o;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikhaellopez.circularfillableloaders.CircularFillableLoaders;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    CircularFillableLoaders circularFillableLoaders;
    ImageView bubble;
    int waterlevel=0;
    int defaultprogress=145;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int levelwater;

        bubble= (ImageView)findViewById(R.id.finalbuble);
        btn1= (Button) findViewById(R.id.btn1);
        btn2= (Button) findViewById(R.id.btn2);
        circularFillableLoaders= (CircularFillableLoaders)findViewById(R.id.circularFillableLoaders);
        final TextView textView = (TextView)findViewById(R.id.textView2);
        final TextView textView3 = (TextView)findViewById(R.id.textView3);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                waterlevel++;
                defaultprogress=defaultprogress-18;
                circularFillableLoaders.setProgress(defaultprogress);
                if(waterlevel>=8){
                    btn1.setEnabled(false);
                    btn1.setVisibility(View.INVISIBLE);
                    btn2.setVisibility(View.INVISIBLE);

                    animate();
                    text1fadein();
                    text2fadein();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                waterlevel = waterlevel+2;
                defaultprogress =defaultprogress-36;
                circularFillableLoaders.setProgress(defaultprogress);
                if(waterlevel>=8){
                    btn2.setEnabled(false);
                    btn1.setVisibility(View.INVISIBLE);
                    btn2.setVisibility(View.INVISIBLE);


                    animate();
                    text1fadein();
                    text2fadein();
                }

            }
        });




    }
    public void animate(){
        Animation bottomUp = AnimationUtils.loadAnimation(this,
                R.anim.bottom_up);
        ImageView bubble = (ImageView)findViewById(R.id.finalbuble);
        bubble.startAnimation(bottomUp);
        bubble.setVisibility(View.VISIBLE);
    }
    public void text1fadein(){
        Animation bottomUp = AnimationUtils.loadAnimation(this,
                R.anim.bottom_up);
        TextView textView= (TextView)findViewById(R.id.textView2);
        textView.startAnimation(bottomUp);
        textView.setVisibility(View.VISIBLE);
    }
    public void text2fadein(){
        Animation bottomUp = AnimationUtils.loadAnimation(this,
                R.anim.bottom_up);
        TextView textView2= (TextView)findViewById(R.id.textView3);
        textView2.startAnimation(bottomUp);
        textView2.setVisibility(View.VISIBLE);
    }
}
