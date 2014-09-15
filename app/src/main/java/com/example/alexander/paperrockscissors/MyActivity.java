package com.example.alexander.paperrockscissors;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;


public class MyActivity extends Activity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

        String pChoice = "";
        String cChoice = "";
        Random rand = new Random();
        private TextView resultText;
        private ImageButton scissors, paper, rock;
        private Button play, reset;
        int compChoice = 0;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_my);

            Initialize();
        }

        private void Initialize() {

            resultText = (TextView) findViewById(R.id.resultText);
            rock = (ImageButton) findViewById(R.id.rock_button);
            paper = (ImageButton) findViewById(R.id.paper_button);
            scissors = (ImageButton) findViewById(R.id.scissors_button);

            play.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    play();
                }
            });
            reset.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    pChoice = "";
                    cChoice = "";
                    play.setEnabled(false);
                    reset.setEnabled(true);
                    scissors.setEnabled(true);
                    paper.setEnabled(true);
                    rock.setEnabled(true);
                    resultText.setText("");
                }
            });
            scissors.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    pChoice = "S";
                    play.setEnabled(true);
                }
            });

            paper.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    pChoice = "P";
                    play.setEnabled(true);
                }
            });

            rock.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    pChoice = "R";
                    play.setEnabled(true);
                }
            });

        }

        public void play() {
            compChoice = rand.nextInt(2);

            if (compChoice == 0) {
                cChoice = "R";

            } else if (compChoice == 1) {
                cChoice = "P";

            } else if (compChoice == 2) {
                cChoice = "S";

            }
            check();
        }

        public void check() {
            if (pChoice == "R") //Rock
            {
                if (cChoice == "R")
                    resultText.setText("Draw");

                else if (cChoice == "P")
                    resultText.setText("You Lose");

                else if (cChoice == "S")
                    resultText.setText("You Win");
            } else if (pChoice == "P") //Paper
            {
                if (cChoice == "R")
                    resultText.setText("You Win");

                else if (cChoice == "P")
                    resultText.setText("Draw");

                else if (cChoice == "S")
                    resultText.setText("You Lose");

            } else if (pChoice == "S") //Scissors
            {
                if (cChoice == "R")
                    resultText.setText("You Lose");

                else if (cChoice == "P")
                    resultText.setText("You Win");

                else if (cChoice == "S")
                    resultText.setText("Draw");

            }

            gameOver();
        }

        public void gameOver() {
            play.setEnabled(false);
            scissors.setEnabled(false);
            rock.setEnabled(false);
            paper.setEnabled(false);
            reset.setEnabled(true);
        }

}

