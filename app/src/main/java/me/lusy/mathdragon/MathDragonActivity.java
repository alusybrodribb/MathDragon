package me.lusy.mathdragon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MathDragonActivity extends AppCompatActivity {

    private MathGame mQuestion;
    private TextView mQuestionTextView;
    private RadioButton mAnswerA;
    private RadioButton mAnswerB;
    private RadioButton mAnswerC;
    private RadioGroup mAnswerGroup;
    private Button mSubmitButton;
    private TableLayout mTableLayout;
    private RadioButton mCheckedButton;
    private TextView mQuestionsAnswered;
    private TextView mQuestionsCorrect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_dragon);
        mQuestion = new MathGame();
        mQuestion.run();
        mQuestionTextView = (TextView) findViewById(R.id.questionTextView);
        mAnswerA = (RadioButton) findViewById(R.id.answer1);
        mAnswerB = (RadioButton) findViewById(R.id.answer2);
        mAnswerC = (RadioButton) findViewById(R.id.answer3);
        mQuestionTextView.setText(mQuestion.getQuestion());
        mAnswerA.setText(mQuestion.answerAsString(0));
        mAnswerB.setText(mQuestion.answerAsString(1));
        mAnswerC.setText(mQuestion.answerAsString(2));
        mAnswerGroup = (RadioGroup) findViewById(R.id.answerGroup);
        mSubmitButton = (Button) findViewById(R.id.submitButton);
        mQuestionsAnswered = (TextView) findViewById(R.id.questionsAnswered);
        mQuestionsCorrect = (TextView) findViewById(R.id.questionsCorrect);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = mAnswerGroup.getCheckedRadioButtonId();

                mCheckedButton = (RadioButton) findViewById(selectedId);
                String answer = mCheckedButton.getText().toString();
                Toast.makeText(MathDragonActivity.this, mQuestion.correctAnswer(answer), Toast.LENGTH_SHORT).show();
                mQuestion.run();
                mQuestionsAnswered.setText(mQuestion.getQuestionsAnswered());
                mQuestionsCorrect.setText(mQuestion.getCorrectAnswers());
                mQuestionTextView.setText(mQuestion.getQuestion());
                mAnswerA.setText(mQuestion.answerAsString(0));
                mAnswerB.setText(mQuestion.answerAsString(1));
                mAnswerC.setText(mQuestion.answerAsString(2));
            }
        };

        mSubmitButton.setOnClickListener(listener);
    }
}
