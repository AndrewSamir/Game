package com.example.andrewsamir.game;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.B1);
        b2=(Button)findViewById(R.id.B2);
        b3=(Button)findViewById(R.id.B3);
        b4=(Button)findViewById(R.id.B4);
        b5=(Button)findViewById(R.id.B5);
        b6=(Button)findViewById(R.id.B6);
        b7=(Button)findViewById(R.id.B7);
        b8=(Button)findViewById(R.id.B8);
        b9=(Button)findViewById(R.id.B9);

        HashMap hashMap=new HashMap();
        ArrayList<String> arrayList=new ArrayList<>();
        hashMap.put("1",arrayList);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startup();
            }
        });

    }

    public void startup (){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.question);

      //   dialog.setTitle("Title...       te");

        // set the custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.textViewQuestion);
        text.setText("Android custom dialog example!");

        RadioButton r1=(RadioButton)dialog.findViewById(R.id.q1);
        r1.setText("tesssssst");

        Button cancel = (Button) dialog.findViewById(R.id.cancel);
        // if button is clicked, close the custom dialog
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
