package nyc.c4q.practicalretake;

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
    private Button checkLoop;
    private Button next;
    private String userInput;
    private int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);
    }

    private class AsyncTaskLoop extends AsyncTask<Integer, Integer, Integer> {

        private List<Integer> loopList = new ArrayList<>();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loopList.clear();
            display.setText("loop commence");
            next.setVisibility(View.INVISIBLE);
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
            next.setVisibility(View.INVISIBLE);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            display.setText("Loops completed: " + integer);
            next.setVisibility(View.VISIBLE);
        }
    }
}
