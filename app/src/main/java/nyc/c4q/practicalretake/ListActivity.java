package nyc.c4q.practicalretake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.practicalretake.controller.Number_Adapter;

public class ListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView email;
    private TextView num;
    private Number_Adapter numbersAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        email = findViewById(R.id.login_email);
        num = findViewById(R.id.numbers_text_view);

        Intent intent = getIntent();
        String user = intent.getStringExtra("currentUser");
        email.setText("You're now logged in as " + user + ".");

        List<Numbers> numbers = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            numbers.add(new Numbers(i));
        }

        recyclerView = findViewById(R.id.number_rv);
        numbersAdapter = new Number_Adapter(numbers);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setAdapter(numbersAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
