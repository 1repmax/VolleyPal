package com.example.android.volleypal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    static final String TEAM_A_CURRENT_POINT_VALUE = "TeamACurrentPointValue";
    static final String TEAM_B_CURRENT_POINT_VALUE = "TeamBCurrentPointValue";
    static final String TEAM_A_CURRENT_SET_VALUE = "TeamACurrentSetValue";
    static final String TEAM_B_CURRENT_SET_VALUE = "TeamBCurrentSetValue";
    static final String TEAM_A_CURRENT_SUBS_VALUE = "TeamACurrentSubsValue";
    static final String TEAM_B_CURRENT_SUBS_VALUE = "TeamBCurrentSubsValue";
    static final String TEAM_A_CURRENT_TIMEOUTS_VALUE = "TeamACurrentTimeoutsValue";
    static final String TEAM_B_CURRENT_TIMEOUTS_VALUE = "TeamBCurrentTimeoutsValue";
    static final String BUTTON_STATE_A = "buttonStateSubsA";
    static final String BUTTON_STATE_B = "buttonStateSubsB";
    static final String BUTTON_TIMEOUT_STATE_A = "buttonTimeoutStateA";
    static final String BUTTON_TIMEOUT_STATE_B = "buttonTimeoutStateB";
    static final String BUTTON_POINTS_A_STATE = "buttonPointsAState";
    static final String BUTTON_POINTS_B_STATE = "buttonPointsBState";
    static final String WINNER_TEAM = "winnerTeam";
    //Define all the Buttons used in the application
    public Button addSubsTeamA;
    public Button addSubsTeamB;
    public Button addTimeoutTeamA;
    public Button addTimeoutTeamB;
    public Button addPointsTeamA;
    public Button addPointsTeamB;
    public Button resetButton;
    //Define all the TextViews used in the application.
    TextView winnerView;
    TextView displayTimeoutsTeamBView;
    TextView displayTimeoutsTeamAView;
    TextView displayPointsTeamBView;
    TextView displaySetsTeamBView;
    TextView displayPointsTeamAView;
    TextView displaySetsTeamAView;
    TextView displaySubsTeamAView;
    TextView displaySubsTeamBView;
    //Define and initialize all the integers used in the application.
    int setsTeamA = 0;
    int setsTeamB = 0;
    int pointsTeamA = 0;
    int pointsTeamB = 0;
    int subsTeamA = 0;
    int subsTeamB = 0;
    int timeoutsTeamA = 0;
    int timeoutsTeamB = 0;
    int pointsToWin = 25;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        //Saves all the numbers in textviews
        savedInstanceState.putInt(TEAM_A_CURRENT_POINT_VALUE, pointsTeamA);
        savedInstanceState.putInt(TEAM_B_CURRENT_POINT_VALUE, pointsTeamB);
        savedInstanceState.putInt(TEAM_A_CURRENT_SET_VALUE, setsTeamA);
        savedInstanceState.putInt(TEAM_B_CURRENT_SET_VALUE, setsTeamB);
        savedInstanceState.putInt(TEAM_A_CURRENT_SUBS_VALUE, subsTeamA);
        savedInstanceState.putInt(TEAM_B_CURRENT_SUBS_VALUE, subsTeamB);
        savedInstanceState.putInt(TEAM_A_CURRENT_TIMEOUTS_VALUE, timeoutsTeamA);
        savedInstanceState.putInt(TEAM_B_CURRENT_TIMEOUTS_VALUE, timeoutsTeamB);
        savedInstanceState.putBoolean(BUTTON_STATE_A, addSubsTeamA.isEnabled());
        savedInstanceState.putBoolean(BUTTON_STATE_B, addSubsTeamB.isEnabled());
        savedInstanceState.putBoolean(BUTTON_TIMEOUT_STATE_A, addTimeoutTeamA.isEnabled());
        savedInstanceState.putBoolean(BUTTON_TIMEOUT_STATE_B, addTimeoutTeamB.isEnabled());
        savedInstanceState.putBoolean(BUTTON_POINTS_A_STATE, addPointsTeamA.isEnabled());
        savedInstanceState.putBoolean(BUTTON_POINTS_B_STATE, addPointsTeamB.isEnabled());
        savedInstanceState.putString(WINNER_TEAM, this.winnerView.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        //Restore information to integers and textviews
        pointsTeamA = savedInstanceState.getInt(TEAM_A_CURRENT_POINT_VALUE);
        pointsTeamB = savedInstanceState.getInt(TEAM_B_CURRENT_POINT_VALUE);
        setsTeamA = savedInstanceState.getInt(TEAM_A_CURRENT_SET_VALUE);
        setsTeamB = savedInstanceState.getInt(TEAM_B_CURRENT_SET_VALUE);
        subsTeamA = savedInstanceState.getInt(TEAM_A_CURRENT_SUBS_VALUE);
        subsTeamB = savedInstanceState.getInt(TEAM_B_CURRENT_SUBS_VALUE);
        timeoutsTeamA = savedInstanceState.getInt(TEAM_A_CURRENT_TIMEOUTS_VALUE);
        timeoutsTeamB = savedInstanceState.getInt(TEAM_B_CURRENT_TIMEOUTS_VALUE);
        String winner = savedInstanceState.getString(WINNER_TEAM);
        winnerView.setText(winner);

        //Get values of booleans of buttons states and pass it to Buttons when activity is restored
        boolean stateSubsButtonA = savedInstanceState.getBoolean(BUTTON_STATE_A);
        addSubsTeamA.setEnabled(stateSubsButtonA);
        boolean stateSubsButtonB = savedInstanceState.getBoolean(BUTTON_STATE_B);
        addSubsTeamB.setEnabled(stateSubsButtonB);
        boolean stateTimeoutTeamA = savedInstanceState.getBoolean(BUTTON_TIMEOUT_STATE_A);
        addTimeoutTeamA.setEnabled(stateTimeoutTeamA);
        boolean stateTimeoutTeamB = savedInstanceState.getBoolean(BUTTON_TIMEOUT_STATE_B);
        addTimeoutTeamB.setEnabled(stateTimeoutTeamB);
        boolean statePointsButtonA = savedInstanceState.getBoolean(BUTTON_POINTS_A_STATE);
        addPointsTeamA.setEnabled(statePointsButtonA);
        boolean statePointsButtonB = savedInstanceState.getBoolean(BUTTON_POINTS_B_STATE);
        addPointsTeamB.setEnabled(statePointsButtonB);


        //Pass restored values to the TextViews.
        displaySetsTeamA(setsTeamA);
        displaySetsTeamB(setsTeamB);
        displayPointsTeamA(pointsTeamA);
        displayPointsTeamB(pointsTeamB);
        displayTimeoutsTeamA(timeoutsTeamA);
        displayTimeoutsTeamB(timeoutsTeamB);
        displaySubsTeamA(subsTeamA);
        displaySubsTeamB(subsTeamB);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // define Button addPointTeamA, addPointTeamB, addSubsTeamA, addSubsTeamB, addTimeoutTeamA, addTimeoutTeamB, resetButton;
        addPointsTeamA = findViewById(R.id.add_point_team_a);
        addPointsTeamB = findViewById(R.id.add_point_team_b);
        addSubsTeamA = findViewById(R.id.add_subs_team_a);
        addSubsTeamB = findViewById(R.id.add_subs_team_b);
        addTimeoutTeamA = findViewById(R.id.add_timeout_team_a);
        addTimeoutTeamB = findViewById(R.id.add_timeout_team_b);
        resetButton = findViewById(R.id.reset_button);
        winnerView = findViewById(R.id.winning_team_text);
        displaySetsTeamAView = findViewById(R.id.team_sets_a);
        displaySetsTeamBView = findViewById(R.id.team_sets_b);
        displayPointsTeamAView = findViewById(R.id.points_view_team_a);
        displayPointsTeamBView = findViewById(R.id.points_view_team_b);
        displaySubsTeamAView = findViewById(R.id.subs_view_team_a);
        displaySubsTeamBView = findViewById(R.id.subs_view_team_b);
        displayTimeoutsTeamBView = findViewById(R.id.timeouts_view_team_b);
        displayTimeoutsTeamAView = findViewById(R.id.timeouts_view_team_a);


        //Set state of buttons at the start of the activity
        addPointsTeamA.setEnabled(true);
        addPointsTeamB.setEnabled(true);
        addSubsTeamA.setEnabled(true);
        addSubsTeamB.setEnabled(true);
        addTimeoutTeamA.setEnabled(true);
        addTimeoutTeamB.setEnabled(true);
        resetButton.setEnabled(true);

        //Add OnClickListener that increases point count of team A by 1 when clicked. When team reaches
        //25 points then point and sub count is reset and sub button is enabled. If team wins 3 sets then
        //it wins the game all the buttons are disabled, except Reset.
        addPointsTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pointsTeamA = pointsTeamA + 1;
                displayPointsTeamA(pointsTeamA);
                if (pointsTeamA >= pointsToWin && ((pointsTeamA - pointsTeamB) >= 2)) {
                    setsTeamA = setsTeamA + 1;
                    displaySetsTeamA(setsTeamA);
                    resetPointsAndSubs();
                    addSubsTeamB.setEnabled(true);
                    addSubsTeamA.setEnabled(true);
                    displayPointsTeamA(pointsTeamA);
                    displayPointsTeamB(pointsTeamB);
                    displaySubsTeamA(subsTeamA);
                    displaySubsTeamB(subsTeamB);
                }
                tieBreak();
                if (setsTeamA == 3) {
                    displayWinner("Team Russia won with a score of " + setsTeamA + " vs " + setsTeamB + ".");
                    addPointsTeamA.setEnabled(false);
                    addPointsTeamB.setEnabled(false);
                    addSubsTeamA.setEnabled(false);
                    addSubsTeamB.setEnabled(false);
                    addTimeoutTeamA.setEnabled(false);
                    addTimeoutTeamB.setEnabled(false);
                    resetButton.setEnabled(true);
                }
            }
        });

        //Add OnClickListener that increases point count of team B by 1 when clicked. When team reaches
        //25 points then point and sub count is reset and sub button is enabled.
        addPointsTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pointsTeamB = pointsTeamB + 1;
                displayPointsTeamB(pointsTeamB);
                if (pointsTeamB >= pointsToWin && ((pointsTeamB - pointsTeamA) >= 2)) {
                    setsTeamB = setsTeamB + 1;
                    displaySetsTeamB(setsTeamB);
                    addSubsTeamB.setEnabled(true);
                    addSubsTeamA.setEnabled(true);
                    resetPointsAndSubs();
                    displayPointsTeamA(pointsTeamA);
                    displayPointsTeamB(pointsTeamB);
                    displaySubsTeamA(subsTeamA);
                    displaySubsTeamB(subsTeamB);
                }
                tieBreak();
                if (setsTeamB == 3) {
                    displayWinner("Team Latvia won with a score of " + setsTeamB + " vs " + setsTeamA + ".");
                    addPointsTeamA.setEnabled(false);
                    addPointsTeamB.setEnabled(false);
                    addSubsTeamA.setEnabled(false);
                    addSubsTeamB.setEnabled(false);
                    addTimeoutTeamA.setEnabled(false);
                    addTimeoutTeamB.setEnabled(false);
                    resetButton.setEnabled(true);
                }
            }
        });
//On click adds a sub for Team A. If subs are equal to 6, then disable the button
        addSubsTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subsTeamA = subsTeamA + 1;
                displaySubsTeamA(subsTeamA);
                if (subsTeamA == 6) {
                    addSubsTeamA.setEnabled(false);
                }
            }
        });
//On click adds a sub for Team B. If subs are equal to 6, then disable the button
        addSubsTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subsTeamB = subsTeamB + 1;
                displaySubsTeamB(subsTeamB);
                if (subsTeamB == 6) {
                    addSubsTeamB.setEnabled(false);
                }
            }
        });
//On click adds a timeout for Team A. If timeouts are equal to 2, then disable the button
        addTimeoutTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeoutsTeamA = timeoutsTeamA + 1;
                displayTimeoutsTeamA(timeoutsTeamA);
                if (timeoutsTeamA == 2) {
                    addTimeoutTeamA.setEnabled(false);
                }
            }
        });
//On click adds a timeout for Team B. If timeouts are equal to 2, then disable the button
        addTimeoutTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeoutsTeamB = timeoutsTeamB + 1;
                displayTimeoutsTeamB(timeoutsTeamB);
                if (timeoutsTeamB == 2) {
                    addTimeoutTeamB.setEnabled(false);
                }
            }
        });

//Resets all TextViews and Points to win to default
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pointsTeamA = 0;
                pointsTeamB = 0;
                displayPointsTeamA(pointsTeamA);
                displayPointsTeamB(pointsTeamB);
                subsTeamA = 0;
                subsTeamB = 0;
                displaySubsTeamA(subsTeamA);
                displaySubsTeamB(subsTeamB);
                timeoutsTeamA = 0;
                timeoutsTeamB = 0;
                displayTimeoutsTeamA(timeoutsTeamA);
                displayTimeoutsTeamB(timeoutsTeamB);
                setsTeamA = 0;
                setsTeamB = 0;
                displaySetsTeamA(setsTeamA);
                displaySetsTeamB(setsTeamB);
                displayWinner("");
                pointsToWin = 25;
                addPointsTeamA.setEnabled(true);
                addPointsTeamB.setEnabled(true);
                addSubsTeamA.setEnabled(true);
                addSubsTeamB.setEnabled(true);
                addTimeoutTeamA.setEnabled(true);
                addTimeoutTeamB.setEnabled(true);
                resetButton.setEnabled(true);

            }
        });
    }

    public void resetPointsAndSubs() {
        pointsTeamA = 0;
        pointsTeamB = 0;
        subsTeamA = 0;
        subsTeamB = 0;
    }

    public void tieBreak() {
        if (setsTeamA + setsTeamB >= 4) {
            pointsToWin = 15;
        }
    }

    /**
     * Displays the sets for Team A.
     */
    public void displaySetsTeamA(int score) {
        displaySetsTeamAView.setText(String.valueOf(score));
    }

    /**
     * Displays the points for Team A.
     */
    public void displayPointsTeamA(int score) {
        displayPointsTeamAView.setText(String.valueOf(score));
    }


    /**
     * Displays the amount of substitutions for Team A.
     */
    public void displaySubsTeamA(int subs) {
        displaySubsTeamAView.setText(String.valueOf(subs));
    }


    /**
     * Displays the timeouts for Team A.
     */
    public void displayTimeoutsTeamA(int timeouts) {
        displayTimeoutsTeamAView.setText(String.valueOf(timeouts));
    }

    /**
     * Displays the sets for Team B.
     */
    public void displaySetsTeamB(int score) {
        displaySetsTeamBView.setText(String.valueOf(score));
    }

    /**
     * Displays the given for Team B.
     */
    public void displayPointsTeamB(int score) {
        displayPointsTeamBView.setText(String.valueOf(score));
    }

    /**
     * Displays the amount of substitutions for Team B.
     */
    public void displaySubsTeamB(int subs) {
        displaySubsTeamBView.setText(String.valueOf(subs));
    }

    /**
     * Displays the timeouts for Team B.
     */
    public void displayTimeoutsTeamB(int timeouts) {
        displayTimeoutsTeamBView.setText(String.valueOf(timeouts));
    }

    public void displayWinner(String winner) {
        winnerView.setText(winner);
    }
}
