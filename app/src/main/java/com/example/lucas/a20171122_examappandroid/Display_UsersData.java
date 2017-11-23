package com.example.lucas.a20171122_examappandroid;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Display_UsersData extends AppCompatActivity {

    final String EXTRA_M_MME = "userGender";
    final String EXTRA_LASTNAME = "userLastName";
    final String EXTRA_FIRSTNAME = "userFirstName";
    final String EXTRA_USERSDATA = "userFirstLastName";
    final String EXTRA_BIRTHDAY = "userBirthday";
    final String EXTRA_EMAIL = "userEmail";
    final String EXTRA_ADRESSEPOSTALE = "userAdressePostale";
    final String EXTRA_COMMENTAIRE = "userCommentaire";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__users_data);

        //DECLARATION OF THE OBJECTS FROM VIEWS
        final Button button_Accueil = (Button) findViewById(R.id.button_Accueil);
        final TextView textView_DisplayUsersData = (TextView) findViewById(R.id.textView_DisplayUsersData);
        String string_dataFromAuthentification = "";
        String string_UserName = "";
        final Button button_Sports = (Button) findViewById(R.id.button_Sports);
        //Get Intent from Authentification Activity
        final Intent intent_FromAuthentification = getIntent();
        final TextView test = new TextView(this);
        final TextView textView_UserName = (TextView) findViewById(R.id.textView_UsersData);

        if (intent_FromAuthentification != null)
        {
            string_dataFromAuthentification = /*intent_FromAuthentification.getStringExtra(EXTRA_M_MME) + "\n" +*/ intent_FromAuthentification.getStringExtra(EXTRA_LASTNAME) + "\n" + intent_FromAuthentification.getStringExtra(EXTRA_FIRSTNAME)+ "\n" + intent_FromAuthentification.getStringExtra(EXTRA_BIRTHDAY)+ "\n" + intent_FromAuthentification.getStringExtra(EXTRA_EMAIL)+ "\n" + intent_FromAuthentification.getStringExtra(EXTRA_ADRESSEPOSTALE)+ "\n" + intent_FromAuthentification.getStringExtra(EXTRA_COMMENTAIRE);
            textView_DisplayUsersData.setText(string_dataFromAuthentification);
            string_UserName = intent_FromAuthentification.getStringExtra(EXTRA_FIRSTNAME) + " " + intent_FromAuthentification.getStringExtra(EXTRA_LASTNAME);
            textView_UserName.setText(string_UserName);
            textView_UserName.setTextColor(ContextCompat.getColor(this, R.color.colorUserNameRed));
        }


        //ON CLICK button_Acceuil
        button_Accueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Display_UsersData.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //ON CLICK button_Sports
        button_Sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Display_UsersData.this, DisplaySports.class);
                intent.putExtra(EXTRA_USERSDATA, textView_UserName.getText().toString());

                startActivity(intent);
            }
        });

    }
}
