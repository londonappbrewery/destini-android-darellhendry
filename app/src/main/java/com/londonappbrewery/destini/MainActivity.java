package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private Button mTopButton;
    private Button mBottomButton;
    private TextView mStoryView;
    private int mPosition;

    private final int[] mStoryString = {
            R.string.T1_Story,
            R.string.T2_Story,
            R.string.T3_Story
    };
    private final int[] mEndString = {
            R.string.T4_End,
            R.string.T5_End,
            R.string.T6_End
    };
    private final int[] mTopAnswer = {
            R.string.T1_Ans1,
            R.string.T2_Ans1,
            R.string.T3_Ans1
    };
    private final int[] mBottomAnswer = {
            R.string.T1_Ans2,
            R.string.T2_Ans2,
            R.string.T3_Ans2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryView = (TextView) findViewById(R.id.storyTextView);
        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);

        mStoryView.setText(mStoryString[mPosition]);
        mTopButton.setText(mTopAnswer[mPosition]);
        mBottomButton.setText(mBottomAnswer[mPosition]);
        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        // True = Top Answer, False = Bottom Answer
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStory(mPosition, true);
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStory(mPosition, false);
            }
        });

    }
    private void updateStory(int currentPosition, boolean topOrBottom) {
        if (topOrBottom) {
            switch (currentPosition) {
                case 0:
                    mPosition = 2;
                    break;
                case 1:
                    mPosition = 2;
                    break;
                case 2:
                    // index 2 --> T6_End
                    mStoryView.setText(mEndString[2]);
                    mTopButton.setVisibility(View.GONE);
                    mBottomButton.setVisibility(View.GONE);
                    return;
            }
        } else {
            switch (currentPosition) {
                case 0:
                    mPosition = 1;
                    break;
                case 1:
                    mStoryView.setText(mEndString[0]);
                    mTopButton.setVisibility(View.GONE);
                    mBottomButton.setVisibility(View.GONE);
                    return;
                case 2:
                    mStoryView.setText(mEndString[1]);
                    mTopButton.setVisibility(View.GONE);
                    mBottomButton.setVisibility(View.GONE);
                    return;
            }
        }
        mStoryView.setText(mStoryString[mPosition]);
        mTopButton.setText(mTopAnswer[mPosition]);
        mBottomButton.setText(mBottomAnswer[mPosition]);
    }
}
