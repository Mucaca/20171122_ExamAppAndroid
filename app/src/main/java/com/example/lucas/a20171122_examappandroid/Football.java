package com.example.lucas.a20171122_examappandroid;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Football extends AppCompatActivity {

    final String EXTRA_USERSDATA = "userFirstLastName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football);

        String string_UserName = "";
        final TextView textView_DisplayUsersData = (TextView) findViewById(R.id.textView_UsersData);

        final Button button_Accueil = (Button) findViewById(R.id.button_Accueil);
        final Button button_Back = (Button) findViewById(R.id.button_back);

        Intent intent_ExtraUserName = getIntent();

        if (intent_ExtraUserName != null)
        {
            string_UserName = intent_ExtraUserName.getStringExtra(EXTRA_USERSDATA);
            textView_DisplayUsersData.setText(string_UserName);
            textView_DisplayUsersData.setTextColor(ContextCompat.getColor(this, R.color.colorUserNameRed));
        }

        //ON CLICK GO TO ACCUEIL
        button_Accueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Football.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //ON CLICK GO BACK
        button_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Football.this, DisplaySports.class);
                intent.putExtra(EXTRA_USERSDATA, textView_DisplayUsersData.getText().toString());
                startActivity(intent);
            }
        });
    }
}
