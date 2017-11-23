package com.example.lucas.a20171122_examappandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class authentificationActivity extends AppCompatActivity {

    final String EXTRA_M_MME = "userGender";
    final String EXTRA_LASTNAME = "userLastName";
    final String EXTRA_FIRSTNAME = "userFirstName";
    final String EXTRA_BIRTHDAY = "userBirthday";
    final String EXTRA_EMAIL = "userEmail";
    final String EXTRA_ADRESSEPOSTALE = "userAdressePostale";
    final String EXTRA_COMMENTAIRE = "userCommentaire";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentification);

        //CREATE VARIABLE FROM VIEW'S ID
        //final RadioGroup radioGroup_M_Mme = (RadioGroup) findViewById(R.id.radioButton_Group);
        //final RadioButton radioButtonChecked_M_Mme = (RadioButton)findViewById(radioGroup_M_Mme.getCheckedRadioButtonId());
        final EditText editText_LastName = (EditText) findViewById(R.id.editText_LastName);
        final EditText editText_FirstName = (EditText) findViewById(R.id.editText_FirstName);
        final EditText editText_Birthday = (EditText) findViewById(R.id.editText_Birthday);
        final EditText editText_Email = (EditText) findViewById(R.id.editText_Email);
        final EditText editText_AdressePostale = (EditText) findViewById(R.id.editText_AdressePostale);
        final EditText editText_Commentaire = (EditText) findViewById(R.id.editText_Commentaire);

        final Button button_Validate = (Button) findViewById(R.id.button_Validate);

        //ON CLICK button_Validate
        button_Validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(authentificationActivity.this, Display_UsersData.class);
                //ADD ALL THE VALUE I WANT TO PASS IN DISPLAY_USERSDATA CLASS
                //intent.putExtra(EXTRA_M_MME, radioButtonChecked_M_Mme.getText());
                intent.putExtra(EXTRA_LASTNAME, editText_LastName.getText().toString());
                intent.putExtra(EXTRA_FIRSTNAME, editText_FirstName.getText().toString());
                intent.putExtra(EXTRA_BIRTHDAY, editText_Birthday.getText().toString());
                intent.putExtra(EXTRA_EMAIL, editText_Email.getText().toString());
                intent.putExtra(EXTRA_ADRESSEPOSTALE, editText_AdressePostale.getText().toString());
                intent.putExtra(EXTRA_COMMENTAIRE, editText_Commentaire.getText().toString());
                //GO TO THE RIGHT ACTIVITY
                startActivity(intent);
            }
        });

    }
}
