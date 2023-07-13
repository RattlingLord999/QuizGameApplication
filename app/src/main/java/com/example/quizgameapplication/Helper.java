package com.example.quizgameapplication.;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Helper extends Fragment {

    public Helper() {
        // Required empty public constructor
    }

    TextView t;
    public static Helper newInstance() {
        return new Helper();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_result, container, false);

        t = view.findViewById(R.id.neroo);

        DBHelper dbHelper = new DBHelper(getContext());
        Score recentScores = dbHelper.getRecentScores();

        if (recentScores != null) {
            int gainScore = recentScores.getGainScore();
            int totalScore = recentScores.getTotalScore();
            int wrongAnswers = totalScore - gainScore;

            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append("Correct: ").append(gainScore).append("\n");
            stringBuilder.append("Total: ").append(totalScore).append("\n");
            stringBuilder.append("Wrong: ").append(wrongAnswers).append("\n\n");

            if (wrongAnswers < 3) {
                stringBuilder.append("Status: Excellent").append("\n");
            } else if (wrongAnswers < 6) {
                stringBuilder.append("Status: Good").append("\n");
            } else if (wrongAnswers < 9) {
                stringBuilder.append("Status: Poor").append("\n");
            } else {
                stringBuilder.append("Status: Bad").append("\n");
            }

            t.setText(stringBuilder.toString());

        } else {
            t.setText("You have not given the quiz!");
        }

        return view;
    }

}
