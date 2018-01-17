package nyc.c4q.practicalretake;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LoopActivity extends AppCompatActivity {
    private TextView display;
    private EditText startingLoopInput;
    private Button ctr_Button;
    private Button login_Button;
    private String userInput;
    private int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);

        display = findViewById(R.id.text_view);
        startingLoopInput = findViewById(R.id.edit_text);

        ctr_Button = findViewById(R.id.button_view);
        ctr_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput = startingLoopInput.getText().toString();
                if (startingLoopInput.getText().toString().isEmpty()) {
                    startingLoopInput.setError("Enter a Number");
                    startingLoopInput.requestFocus();
                } else {
                    number = Integer.parseInt(userInput);
                    AsyncTaskLoop pc = new AsyncTaskLoop();
                    pc.execute(number);
                }
            }
        });

        login_Button = findViewById(R.id.button_login);
        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(LoopActivity.this, LoginActivity.class);
                startActivity(loginActivity);
            }
        });
        login_Button.setVisibility(View.INVISIBLE);
    }
    private class AsyncTaskLoop extends AsyncTask<Integer, Integer, Integer> {

        private List<Integer> loopList = new ArrayList<>();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loopList.clear();
            display.setText("loop commence");
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            for (int i = number; i < 10000; i++) {
                loopList.add(i);
                publishProgress(loopList.size());
            }
            return loopList.size();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            display.setText("Loops so Far: " + values[0]);
            login_Button.setVisibility(View.INVISIBLE);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            display.setText("Loops completed: " + integer);
            login_Button.setVisibility(View.VISIBLE);
        }
    }
}



