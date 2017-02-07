package com.application.rachelbagwell.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.*;
import android.widget.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.media.MediaPlayer;



public class MainActivity extends AppCompatActivity {
    private Button Random;
    private Button Button4;
    private Button Go;
    private MediaPlayer mpE;
    private MediaPlayer mpF;
    private MediaPlayer mpFSharp;
    private MediaPlayer mpG;
    private MediaPlayer mpA;
    private MediaPlayer mpB;
    private MediaPlayer mpCSharp;
    private MediaPlayer mpD;
    private MediaPlayer mpHighE;
    private MediaPlayer mpHighFSharp;

    private final int WHOLE_NOTE = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mpE = MediaPlayer.create(this, R.raw.scalee);
        mpF = MediaPlayer.create(this, R.raw.scalef);
        mpFSharp = MediaPlayer.create(this, R.raw.scalefs);
        mpG = MediaPlayer.create(this, R.raw.scaleg);
        mpA = MediaPlayer.create(this, R.raw.scalea);
        mpB = MediaPlayer.create(this, R.raw.scaleb);
        mpCSharp = MediaPlayer.create(this, R.raw.scalecs);
        mpD = MediaPlayer.create(this, R.raw.scaled);
        mpHighE = MediaPlayer.create(this, R.raw.scalehighe);
        mpHighFSharp = MediaPlayer.create(this, R.raw.scalehighfs);


        RelativeLayout currentLayout = (RelativeLayout) findViewById(R.id.activity_main);
        currentLayout.setBackgroundColor(Color.BLACK);

        Go = (Button) findViewById(R.id.Go);
        Random = (Button) findViewById(R.id.Random);


    }


    //RANDOM CIRCLE GENERATOR

    public void Random(View v) {

        Log.e("My Activity", "Random Button clicked");

        final ImageView imgCircle1 = (ImageView) findViewById(R.id.imgCircle1);
        final ImageView imgCircle2 = (ImageView) findViewById(R.id.imgCircle2);
        final ImageView imgCircle3 = (ImageView) findViewById(R.id.imgCircle3);

        final Animation animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        final Animation animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        Bitmap bmp = Bitmap.createBitmap(2000, 2000, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paintRandom = new Paint();


        Log.e("My Activity", "Random Button Clicked");

        float randomRadius = (float) (Math.random() * 500);
        float randomX = (float) (Math.random() * 2000);
        float randomY = (float) (Math.random() * 2000);


        int max = 255;

        int red = (int) (max * Math.random());
        int green = (int) (max * Math.random());
        int blue = (int) (max * Math.random());


        //OUTER LAYER CIRCLE

        paintRandom.setColor(Color.argb(255, red, green, blue));
        paintRandom.setStyle(Paint.Style.FILL_AND_STROKE);

        canvas.drawCircle(randomX, randomY, randomRadius, paintRandom);
        imgCircle1.setImageBitmap(bmp);

        imgCircle1.startAnimation(animationFadeIn);
        animationFadeIn.setDuration(5000);

        imgCircle1.startAnimation(animationFadeOut);
        animationFadeOut.setDuration(3000);
        imgCircle1.setVisibility(View.INVISIBLE);


        //SECOND LAYER OF CIRCLE


        int r = (int) (max * Math.random());
        int g = (int) (max * Math.random());
        int b = (int) (max * Math.random());

        paintRandom.setColor(Color.argb(255, r, g, b));
        paintRandom.setStyle(Paint.Style.FILL_AND_STROKE);

        canvas.drawCircle(randomX, randomY, randomRadius / 2, paintRandom);
        imgCircle2.setImageBitmap(bmp);

        animationFadeIn.setDuration(5000);
        imgCircle2.startAnimation(animationFadeIn);

        animationFadeIn.setDuration(3000);
        imgCircle2.startAnimation(animationFadeOut);
        imgCircle2.setVisibility(View.INVISIBLE);


        //INNERMOST LAYER OF CIRCLE

        int R = (int) (max * Math.random());
        int G = (int) (max * Math.random());
        int B = (int) (max * Math.random());

        paintRandom.setColor(Color.argb(255, R, G, B));
        paintRandom.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(randomX, randomY, randomRadius / 6, paintRandom);
        imgCircle3.setImageBitmap(bmp);

        imgCircle3.startAnimation(animationFadeIn);
        animationFadeIn.setDuration(5000);
        imgCircle3.startAnimation(animationFadeOut);
        animationFadeOut.setDuration(3000);
        imgCircle3.setVisibility(View.INVISIBLE);


    }


    // AMOUNT OF CIRCLES AS PER REQUEST

    public void Go(View v) {


        Log.e("My Activity", "Go Button Clicked");

        final EditText editText = (EditText) findViewById(R.id.editText);
        final ImageView imgCircle1 = (ImageView) findViewById(R.id.imgCircle1);
        final ImageView imgCircle2 = (ImageView) findViewById(R.id.imgCircle2);
        final ImageView imgCircle3 = (ImageView) findViewById(R.id.imgCircle3);

        final Animation animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        final Animation animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        Bitmap bmp = Bitmap.createBitmap(2000, 2000, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paintRandom = new Paint();

        int i;
        int max = 255;
        int amount = Math.round(Float.valueOf(editText.getText().toString()));


        for (i = 0; i < amount; i++) {

            float randomRadius = (float) (Math.random() * 500);
            float randomX = (float) (Math.random() * 2000);
            float randomY = (float) (Math.random() * 2000);


            //OUTER LAYER OF CIRCLE


            int red = (int) (max * Math.random());
            int green = (int) (max * Math.random());
            int blue = (int) (max * Math.random());


            paintRandom.setColor(Color.argb(255, red, green, blue));
            paintRandom.setStyle(Paint.Style.FILL_AND_STROKE);

            canvas.drawCircle(randomX, randomY, randomRadius, paintRandom);
            imgCircle1.setImageBitmap(bmp);

            imgCircle1.startAnimation(animationFadeIn);
            animationFadeIn.setDuration(5000);

            imgCircle1.startAnimation(animationFadeOut);
            animationFadeOut.setDuration(3000);
            imgCircle1.setVisibility(View.INVISIBLE);


            //SECOND LAYER OF CIRCLE


            int r = (int) (max * Math.random());
            int g = (int) (max * Math.random());
            int b = (int) (max * Math.random());

            paintRandom.setColor(Color.argb(255, r, g, b));
            paintRandom.setStyle(Paint.Style.FILL_AND_STROKE);

            canvas.drawCircle(randomX, randomY, randomRadius / 2, paintRandom);
            imgCircle2.setImageBitmap(bmp);

            animationFadeIn.setDuration(5000);
            imgCircle2.startAnimation(animationFadeIn);

            animationFadeIn.setDuration(3000);
            imgCircle2.startAnimation(animationFadeOut);
            imgCircle2.setVisibility(View.INVISIBLE);


            //INNERMOST LAYER OF CIRCLE

            int R = (int) (max * Math.random());
            int G = (int) (max * Math.random());
            int B = (int) (max * Math.random());

            paintRandom.setColor(Color.argb(255, R, G, B));
            paintRandom.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(randomX, randomY, randomRadius / 6, paintRandom);
            imgCircle3.setImageBitmap(bmp);

            imgCircle3.startAnimation(animationFadeIn);
            animationFadeIn.setDuration(5000);
            imgCircle3.startAnimation(animationFadeOut);
            animationFadeOut.setDuration(3000);
            imgCircle3.setVisibility(View.INVISIBLE);


        }
    }


    private void delayPlaying(int delay) throws InterruptedException {

        try {

            Thread.sleep(delay);

        } catch (InterruptedException e) {

            Log.e("My Activity", "Audio playback interrupted");

        }

    }

    //     PLAYS NOTE AND CREATES CIRCLE AFTER EACH NOTE

    public void onChallenge4ButtonClick(View v) {

        Log.e("My Activity", "Challenge 4 Button clicked");
        MediaPlayer[] notes = {mpE, mpFSharp, mpG, mpA, mpB, mpCSharp, mpD, mpE};
        int i;

        try {


            for (i = 0; i < notes.length; i++) {

                notes[i].seekTo(0);
                notes[i].start();
                Random(v);
                delayPlaying(WHOLE_NOTE / 2);
            }


        } catch (InterruptedException e) {

            e.printStackTrace();

        }
    }
}





