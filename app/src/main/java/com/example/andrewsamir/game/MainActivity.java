package com.example.andrewsamir.game;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;

    boolean bo=false;
    long myIntValue;
    boolean back=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if(sp.getInt("your_int_key",0)>30000)
            ;
        else {

            editor.putInt("your_int_key", 30000);

            editor.commit();
        }




        b1=(Button)findViewById(R.id.B1);
        b2=(Button)findViewById(R.id.B2);
        b3=(Button)findViewById(R.id.B3);
        b4=(Button)findViewById(R.id.B4);
        b5=(Button)findViewById(R.id.B5);
        b6=(Button)findViewById(R.id.B6);
        b7=(Button)findViewById(R.id.B7);
        b8=(Button)findViewById(R.id.B8);
        b9=(Button)findViewById(R.id.B9);

        b2.setEnabled(false);
        b3.setEnabled(false);

        b4.setEnabled(false);

        b5.setEnabled(false);

        b6.setEnabled(false);

        b7.setEnabled(false);

        b8.setEnabled(false);

        b9.setEnabled(false);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startup("A group of students volunteered to finish a construction work in 25 days. 1 of the students did not come and the work could be finished in 35 days. The original number of students in the group were",
                        "25", "32", "35", "37", "35",R.id.B1,R.id.B2);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startup("The number, whose 7% is 42, is",
                        "300", "400", "500", "600", "600",R.id.B2,R.id.B3);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startup("Twelve men take 6 hours to finish a piece of work. After the 12 men have worked for 1 hour, the contractor decides to call in 8 more men. How many more hours would 20 men take to complete the remaining work?",
                        "2","3","4","5","3",R.id.B3,R.id.B4);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startup(" A’s mother is twice as old as A’s brother. A is 6 years younger than his brother but 4 years older than his sister. If A’s sister is 15 his mother’s age is:",
                        "40","45","42","50","50",R.id.B4,R.id.B5);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startup("If 12 years are added to 2/3 age of Rani, she will be three years older than today. What is Rani’s present age?",
                        "25","26","27","28","27",R.id.B5,R.id.B6);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startup("Three families, P, Q and R, share 480 kg of rice, Q receives twice as much rice as P and R receives half as much rice as Q. How much rice does family Q gets?",
                        "220 kg","230 kg","240 kg","250 kg","240 kg",R.id.B6,R.id.B7);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startup("Nasir read 60 pages of a book on the first day. This was 20% more than the number of pages he read on the second day. Given that he read 1/6 of the book on the.second day, find the number of pages in the book he had read.",
                        "300","290","325","345","300",R.id.B7,R.id.B8);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startup(" A can do a piece of work in 10 days and B can do it in 15 days. The number of days required by them to finish it, working together is:",
                        "8","7","6","4","6",R.id.B8,R.id.B9);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startup("Which is the greatest number?",
                        "1/4 of 236"," 1/16 of 1028","1/9 of 504 "," 1/3 of 741"," 1/3 of 741",R.id.B9,R.id.B1);
            }
        });

    }

    public void startup (String Q,String C1,String C2,String C3,String C4, final String Answer,int ID,int nextID){

        bo=false;
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.question);



        final Button button= (Button) findViewById(ID);
        final Button nextbutton= (Button) findViewById(nextID);
        TextView t=(TextView)dialog.findViewById(R.id.msg);
        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);

        t.setText("If You Choose a Wrong Answer The Application will Pause for "+sp.getInt("your_int_key", 30000)/1000+" Seconds");
        TextView text = (TextView) dialog.findViewById(R.id.textViewQuestion);
        text.setText(Q);

        final RadioGroup radioGroup=(RadioGroup) dialog.findViewById(R.id.ID);

        RadioButton r1=(RadioButton)dialog.findViewById(R.id.q1);
        r1.setText(C1);
        RadioButton r2=(RadioButton)dialog.findViewById(R.id.q2);
        r2.setText(C2);

        RadioButton r3=(RadioButton)dialog.findViewById(R.id.q3);
        r3.setText(C3);

        RadioButton r4=(RadioButton)dialog.findViewById(R.id.q4);
        r4.setText(C4);


        Button cancel = (Button) dialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Button done=(Button)dialog.findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    int selcted = radioGroup.getCheckedRadioButtonId();

                    RadioButton radioButton = (RadioButton) dialog.findViewById(selcted);

                    if (radioButton.getText().equals(Answer)) {
                        bo = true;
                        button.setVisibility(View.INVISIBLE);
                        if(!nextbutton.equals(0))
                        nextbutton.setEnabled(true);
                        dialog.dismiss();
                    }
                    else {
                        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);

                         myIntValue = sp.getInt("your_int_key", 30000);
                        SharedPreferences.Editor editor = sp.edit();

                        editor.putInt("your_int_key", sp.getInt("your_int_key", 30000)+30000);

                        editor.commit();
                        dialog.dismiss();

                        Timer();
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this,"you should choose an answer before press DONE ..",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }


            }
        });

        dialog.show();

    }


    public void Timer(){

        back=false;
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.timer);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        final TextView text = (TextView) dialog.findViewById(R.id.textViewTimer);

        new CountDownTimer( myIntValue,1000) {


            public void onTick(long millisUntilFinished) {
                text.setText(millisUntilFinished / 1000+"");
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                back=true;
                dialog.dismiss();
            }

        }.start();

        dialog.show();

    }

    }
