package com.example.android.chessscoreclock;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.CountDownTimer;


import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    double scorePlayerA = 0;
    double scorePlayerB = 0;
    double previousScorePlayerA = 0;
    double previousScorePlayerB = 0;
    double win = 1;
    double draw = 0.5;
    int move = 0;
    int counter;
    int minutesLeftA = 0;
    int secondsLeftA = 0;
    int minutesLeftB = 0;
    int secondsLeftB = 0;


    CountDownTimer mCountDownTimerA;
    CountDownTimer mCountDownTimerB;

    long mTimeLeftA;
    long mTimeLeftB;
    Button mPlayerA;
    Button mPlayerB;
    boolean buttonStartA = false;
    boolean buttonStartB = false;
    boolean gameOverFlag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);

        counter = 0;
        mTimeLeftA = (minutesLeftA * 60 + secondsLeftA) * 1000;

        mTimeLeftB = (minutesLeftB * 60 + secondsLeftB) * 1000;

    }


    public void myResetButton(View v) {
        scorePlayerA = 0;
        scorePlayerB = 0;
        counter = 0;
        displayMove(counter);
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);
        mTimeLeftA = 0;
        //updateTimerA();
        mTimeLeftB = 0;
        //updateTimerB();

    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForPlayerA(double score) {
        TextView mTimeView = (TextView) findViewById(R.id.player_a_score);
        mTimeView.setText(String.valueOf(score));
    }

    public void displayForPlayerB(double score) {
        TextView mTimeView = (TextView) findViewById(R.id.player_b_score);
        mTimeView.setText(String.valueOf(score));
    }


    public void incrementTimeSecB(View view) {


        if (secondsLeftB < 59) {
            secondsLeftB += 1;
            displaySecondsPlayerB(secondsLeftB);
            mTimeLeftA = (minutesLeftA * 60 + secondsLeftA) * 1000;
            ;
            mTimeLeftB = (minutesLeftB * 60 + secondsLeftB) * 1000;
            ;
        }


    }

    public void decrementTimeSecB(View view) {

        if (secondsLeftB > 0) {
            secondsLeftB -= 1;
            displaySecondsPlayerB(secondsLeftB);
            mTimeLeftA = (minutesLeftA * 60 + secondsLeftA) * 1000;
            ;
            mTimeLeftB = (minutesLeftB * 60 + secondsLeftB) * 1000;
            ;
        }
    }


    public void incrementTimeMinutesB(View view) {

        if (minutesLeftB < 119) {
            minutesLeftB += 1;
            displayMinutesPlayerB(minutesLeftB);
            mTimeLeftA = (minutesLeftA * 60 + secondsLeftA) * 1000;
            ;
            mTimeLeftB = (minutesLeftB * 60 + secondsLeftB) * 1000;
            ;
        }

    }


    public void decrementTimeMinutesB(View view) {

        if (minutesLeftB > 0) {
            minutesLeftB -= 1;
            displayMinutesPlayerB(minutesLeftB);
            mTimeLeftA = (minutesLeftA * 60 + secondsLeftA) * 1000;
            ;
            mTimeLeftB = (minutesLeftB * 60 + secondsLeftB) * 1000;
            ;
        }


    }


    public void decrementTimeMinutesA(View view) {

        if (minutesLeftA > 0) {
            minutesLeftA -= 1;
            displayMinutesPlayerA(minutesLeftA);
            mTimeLeftA = (minutesLeftA * 60 + secondsLeftA) * 1000;
            ;
            mTimeLeftB = (minutesLeftB * 60 + secondsLeftB) * 1000;
            ;
        }

    }

    public void incrementTimeMinutesA(View view) {

        if (minutesLeftA < 119) {
            minutesLeftA += 1;
            displayMinutesPlayerA(minutesLeftA);
            mTimeLeftA = (minutesLeftA * 60 + secondsLeftA) * 1000;
            ;
            mTimeLeftB = (minutesLeftB * 60 + secondsLeftB) * 1000;
            ;
        }

    }

    public void decrementTimeSecA(View view) {

        if (secondsLeftA > 0) {
            secondsLeftA -= 1;
            displaySecondsPlayerA(secondsLeftA);
            mTimeLeftA = (minutesLeftA * 60 + secondsLeftA) * 1000;
            ;
            mTimeLeftB = (minutesLeftB * 60 + secondsLeftB) * 1000;
            ;
        }

    }

    public void incrementTimeSecA(View view) {
        if (secondsLeftA < 59) {
            secondsLeftA += 1;
            displaySecondsPlayerA(secondsLeftA);
            mTimeLeftA = (minutesLeftA * 60 + secondsLeftA) * 1000;
            ;
            mTimeLeftB = (minutesLeftB * 60 + secondsLeftB) * 1000;
            ;
        }


    }

    public void cancelLastChange(View view) {
        //update all variables to last saved state

        scorePlayerA = previousScorePlayerA;
        scorePlayerB = previousScorePlayerB;

        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);


    }

    public void addToScoreB(View view) {

        previousScorePlayerA = scorePlayerA;
        previousScorePlayerB = scorePlayerB;
        scorePlayerB += win;

        displayForPlayerB(scorePlayerB);

    }

    public void incrementForDraw(View view) {

        previousScorePlayerA = scorePlayerA;
        previousScorePlayerB = scorePlayerB;
        scorePlayerA += draw;
        scorePlayerB += draw;

        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);

    }

    public void addToScoreA(View view) {

        previousScorePlayerA = scorePlayerA;
        previousScorePlayerB = scorePlayerB;

        scorePlayerA += win;

        displayForPlayerA(scorePlayerA);


    }

    public void launchBoard(View view) {

        LinearLayout mIntro = (LinearLayout) findViewById(R.id.my_intro);
        mIntro.setVisibility(view.GONE);
        LinearLayout mPreBoard = findViewById(R.id.pre_board);
        mPreBoard.setVisibility(view.VISIBLE);
    }

    public void decrementWin(View view) {

        if (win > 0) {
            win -= 1;
            displayWin(win);
        }

    }

    private void displayWin(double myWin) {
        TextView mWin = (TextView) findViewById(R.id.current_win);
        mWin.setText(String.valueOf(myWin));
    }

    public void incrementWin(View view) {


        win += 1;
        displayWin(win);

    }


    private void displayDraw(double myDraw) {
        TextView mDraw = (TextView) findViewById(R.id.current_draw);
        mDraw.setText(String.valueOf(myDraw));
    }

    public void decrementDraw(View view) {
        if (draw > 0) {
            draw -= 0.5;
            displayDraw(draw);
        }

    }

    public void incrementDraw(View view) {
        draw += 0.5;
        displayDraw(draw);
    }

    public void showButtonsTimer(View view) {

        LinearLayout mSetTimer = (LinearLayout) findViewById(R.id.set_timer);
        mSetTimer.setVisibility(view.GONE);
        LinearLayout mButtonsTimer = (LinearLayout) findViewById(R.id.buttons_of_timer);
        mButtonsTimer.setVisibility(view.VISIBLE);

    }

    public void displaySecondsPlayerB(int secs) {

        TextView mSecB = (TextView) findViewById(R.id.current_time_sec_b);
        mSecB.setText(String.valueOf(secs));
    }

    public void displaySecondsPlayerA(int secs) {

        TextView mSecB = (TextView) findViewById(R.id.current_time_sec_a);
        mSecB.setText(String.valueOf(secs));
    }

    public void displayMinutesPlayerA(int score) {
        TextView mTimeView = (TextView) findViewById(R.id.current_time_minutes_a);
        mTimeView.setText(String.valueOf(score));
    }


    public void displayMinutesPlayerB(int score) {
        TextView mTimeView = (TextView) findViewById(R.id.current_time_minutes_b);
        mTimeView.setText(String.valueOf(score));
    }

    public void decrementNumMoves(View view) {


        if (move > 0) {
            move--;
            displayMove(move);
        }
    }

    public void displayMove(int move) {

        TextView mMoveView = (TextView) findViewById(R.id.current_move);
        mMoveView.setText(String.valueOf(move));

    }

    public void incrementNumMoves(View view) {


        if (move < 999) {
            move++;
            displayMove(move);
        }
    }

    /**
     * public void playClock(View view) {
     * view.setVisibility(view.INVISIBLE);
     * Button mPause=findViewById(R.id.button_pause_clock);
     * mPause.setVisibility(view.VISIBLE);
     * Button mStop=findViewById(R.id.button_stop_clock);
     * mStop.setVisibility(view.INVISIBLE);
     * <p>
     * buttonStartA=false;
     * buttonStartB=true;
     * <p>
     * mPlayerA=findViewById(R.id.button_player_a);
     * mPlayerA.setBackgroundResource(R.color.my_green);
     * //start timer for player A
     * <p>
     * <p>
     * <p>
     * mCountDownTimerA= new CountDownTimer(mTimeLeftA, 1000) {
     * <p>
     * public void onTick(long millisUntilFinished) {
     * <p>
     * mTimeLeftA=millisUntilFinished;
     * updateTimerA();
     * <p>
     * }
     * //mTimerIsRunning=true;
     * <p>
     * public void onFinish() {
     * mPlayerA.setText("Timer Over!");
     * //update scoring board
     * }
     * }.start();
     * <p>
     * <p>
     * }
     **/
    private void updateTimerA() {
        int minutesA = (int) ((mTimeLeftA / 1000) / 60);
        int secondsA = (int) ((mTimeLeftA / 1000) % 60);
        String timeLeftFormattedA = String.format(Locale.getDefault(), "%02d:%02d", minutesA, secondsA);
        mPlayerA.setText(timeLeftFormattedA);
    }

    public void updateTimerB() {
        int minutesB = (int) ((mTimeLeftB / 1000) / 60);
        int secondsB = (int) ((mTimeLeftB / 1000) % 60);
        String timeLeftFormattedB = String.format(Locale.getDefault(), "%02d:%02d", minutesB, secondsB);
        mPlayerB.setText(timeLeftFormattedB);
    }


    public void startViewTimer(View view) {

        LinearLayout mPreBoard = (LinearLayout) findViewById(R.id.pre_board);
        mPreBoard.setVisibility(view.INVISIBLE);
        LinearLayout mClock = (LinearLayout) findViewById(R.id.my_clock);
        mClock.setVisibility(view.VISIBLE);
        mPlayerA = findViewById(R.id.button_player_a);
        mPlayerB = findViewById(R.id.button_player_b);

        updateTimerA();
        updateTimerB();


    }

    public void pauseClock(View view) {
        Button mPause = findViewById(R.id.button_pause_clock);
        mPause.setVisibility(view.INVISIBLE);
        Button mPlay = findViewById(R.id.button_play_clock);
        mPlay.setVisibility(view.VISIBLE);
        Button mStop = findViewById(R.id.button_stop_clock);
        mStop.setVisibility(view.VISIBLE);


        if (buttonStartA) {
            buttonStartA = false;
            mCountDownTimerA.cancel();

        } else {
            buttonStartA = true;
        }


        if (buttonStartB) {
            buttonStartB = false;
            mCountDownTimerB.cancel();

        } else {
            buttonStartB = true;
        }


        //Button mPlayerA=findViewById(R.id.button_player_a);
        //mPlayerA.setBackgroundResource(R.color.my_grey);
        //Button mPlayerB=findViewById(R.id.button_player_b);
        //mPlayerB.setBackgroundResource(R.color.my_grey);

        //stop all countCountDown


    }

    public void stopClock(View view) {
        displayMove(counter / 2);
        if (gameOverFlag) {

            LinearLayout mClok = (LinearLayout) findViewById(R.id.my_clock);
            mClok.setVisibility(view.INVISIBLE);
            LinearLayout mPreBoard = (LinearLayout) findViewById(R.id.pre_board);
            mPreBoard.setVisibility(view.VISIBLE);

        } else {

            LinearLayout mClok = (LinearLayout) findViewById(R.id.my_clock);
            mClok.setVisibility(view.INVISIBLE);
            LinearLayout mPreBoard = (LinearLayout) findViewById(R.id.pre_board);
            mPreBoard.setVisibility(view.INVISIBLE);
            LinearLayout mAfterClockStop = findViewById(R.id.after_clock_stop);
            mAfterClockStop.setVisibility(view.VISIBLE);
            gameOverFlag = false;

        }


    }


    public void cancelStopClock(View view) {

        LinearLayout mAfterClockStop = findViewById(R.id.after_clock_stop);
        mAfterClockStop.setVisibility(View.INVISIBLE);
        LinearLayout mClok = (LinearLayout) findViewById(R.id.my_clock);
        mClok.setVisibility(View.VISIBLE);
        /**
         if(buttonStartA){
         buttonStartA=false;
         mCountDownTimerA.cancel();
         }

         if(buttonStartB){
         buttonStartB=false;
         mCountDownTimerB.cancel();
         }
         **/
    }

    public void stopClockA(View view) {


        if (buttonStartA) {
            mCountDownTimerA.cancel();
        }


        if (counter == 0) {
            buttonStartA = true;
        }

        if (buttonStartA) {

            Button mPause = findViewById(R.id.button_pause_clock);
            mPause.setVisibility(view.VISIBLE);

            Button mPlay = findViewById(R.id.button_play_clock);
            mPlay.setVisibility(view.INVISIBLE);

            Button mStop = findViewById(R.id.button_stop_clock);
            mStop.setVisibility(view.INVISIBLE);


            buttonStartA = false;


            mPlayerA = findViewById(R.id.button_player_a);
            mPlayerA.setBackgroundResource(R.color.my_grey);

            mPlayerB = findViewById(R.id.button_player_b);
            mPlayerB.setBackgroundResource(R.color.my_green);


            mCountDownTimerB = new CountDownTimer(mTimeLeftB, 1000) {

                public void onTick(long millisUntilFinished) {

                    mTimeLeftB = millisUntilFinished;
                    updateTimerB();
                    buttonStartB = true;

                }


                public void onFinish() {
                    mPlayerB.setText("Over");
                    //mCountDownTimerA.cancel();
                    previousScorePlayerA = scorePlayerA;
                    previousScorePlayerB = scorePlayerB;
                    scorePlayerA += win;

                    displayForPlayerA(scorePlayerA);
                    gameOverFlag = true;
                    buttonStartB = false;
                    Button mStop = findViewById(R.id.button_stop_clock);
                    mStop.setVisibility(View.VISIBLE);
                    Button mPause = findViewById(R.id.button_pause_clock);
                    mPause.setVisibility(View.INVISIBLE);

                    //update scoring board
                }
            }.start();
            counter++;
        }


    }

    public void stopClockB(View view) {


        if (buttonStartB) {
            mCountDownTimerB.cancel();
        }

        if (counter == 0) {
            buttonStartB = true;
        }

        if (buttonStartB && mTimeLeftA > 0) {

            Button mPause = findViewById(R.id.button_pause_clock);
            mPause.setVisibility(view.VISIBLE);

            Button mPlay = findViewById(R.id.button_play_clock);
            mPlay.setVisibility(view.INVISIBLE);

            Button mStop = findViewById(R.id.button_stop_clock);
            mStop.setVisibility(view.INVISIBLE);


            buttonStartB = false;


            mPlayerB = findViewById(R.id.button_player_b);
            mPlayerB.setBackgroundResource(R.color.my_grey);

            mPlayerA = findViewById(R.id.button_player_a);
            mPlayerA.setBackgroundResource(R.color.my_green);

            mCountDownTimerA = new CountDownTimer(mTimeLeftA, 1000) {

                public void onTick(long millisUntilFinished) {

                    mTimeLeftA = millisUntilFinished;
                    updateTimerA();
                    buttonStartA = true;

                }
                //mTimerIsRunning=true;

                public void onFinish() {
                    mPlayerA.setText("Over");
                    //mCountDownTimerB.cancel();

                    previousScorePlayerA = scorePlayerA;
                    previousScorePlayerB = scorePlayerB;
                    scorePlayerB += win;

                    displayForPlayerB(scorePlayerB);
                    gameOverFlag = true;
                    buttonStartA = false;
                    Button mStop = findViewById(R.id.button_stop_clock);
                    mStop.setVisibility(View.VISIBLE);
                    Button mPause = findViewById(R.id.button_pause_clock);
                    mPause.setVisibility(View.INVISIBLE);

                    //update scoring board
                }
            }.start();
            counter++;
        }


    }

    public void returnToScoringBoard(View view) {

        LinearLayout mAfterClockStop = findViewById(R.id.after_clock_stop);
        mAfterClockStop.setVisibility(View.INVISIBLE);
        LinearLayout mPreBoard = (LinearLayout) findViewById(R.id.pre_board);
        mPreBoard.setVisibility(View.VISIBLE);

    }
}
