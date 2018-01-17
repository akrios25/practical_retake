package nyc.c4q.practicalretake;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private static final String SHARED_PREFS_KEY = "sharedPrefsKey";
    private EditText emailInput;
    private EditText passwordInput;
    private CheckBox checkBoxSave;
    private Button buttonSubmit;
    private SharedPreferences login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailInput = findViewById(R.id.edit_text_email);
        passwordInput = findViewById(R.id.edit_text_password);
        checkBoxSave = findViewById(R.id.checkbox_save);
        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        buttonSubmit = findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = login.edit();
                String checkUser = "user@aol.com";
                String checkPassword = "password1234";

                if (checkBoxSave.isChecked()) {
                    editor.putString("email", emailInput.getText().toString());
                    editor.putString("password", passwordInput.getText().toString());
                    editor.putBoolean("isChecked", checkBoxSave.isChecked());
                    editor.commit();
                } else {
                    editor.putBoolean("isChecked", checkBoxSave.isChecked());
                    editor.commit();
                }
                if (emailInput.getText().toString().contains(checkUser) && passwordInput.getText().toString().contains(checkPassword)) {
                    Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                    intent.putExtra("currentUser", emailInput.getText().toString());
                    startActivity(intent);
                }
            }
        });
        if (login.getBoolean("isChecked", false)) {
            emailInput.setText(login.getString("username", null));
            passwordInput.setText(login.getString("password", null));
            checkBoxSave.setChecked(login.getBoolean("isChecked", false));
        }
    }
}
