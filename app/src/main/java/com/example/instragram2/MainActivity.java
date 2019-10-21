package com.example.instragram2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
private Button SaveButton;
private EditText edtName,edtpunchSpeed,edtpunchPower,edtkickSpeed,edtkickPower;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SaveButton=findViewById(R.id.buttonSavedI);

        edtName=findViewById(R.id.NameId);
        edtpunchSpeed=findViewById(R.id.punchSpeed);
        edtpunchPower=findViewById(R.id.punchPowerid);
        edtkickSpeed=findViewById(R.id.kickSpeedId);
        edtkickPower=findViewById(R.id.kickpowerId);

        SaveButton.setOnClickListener(MainActivity.this) ;

    }


    @Override
    public void onClick(View v) {
        final ParseObject kickBoxer = new ParseObject("KickBoxer");

        kickBoxer.put("name", edtName.getText().toString());
        kickBoxer.put("punch_speed", Integer.parseInt(edtpunchSpeed.getText().toString()));
        kickBoxer.put("punch_Power", Integer.parseInt(edtpunchPower.getText().toString()));
        kickBoxer.put("Kick_speed", Integer.parseInt(edtkickSpeed.getText().toString()));
        kickBoxer.put("Kick_Power", Integer.parseInt(edtkickPower.getText().toString()));
        kickBoxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(MainActivity.this,
                            kickBoxer.get("name")+ " \n"+kickBoxer.get("punch_speed")+" \n"+
                                    kickBoxer.get("punch_Power")+" \n"+
                                    kickBoxer.get("Kick_speed")+" \n"+
                                    kickBoxer.get("Kick_Power")
                            , Toast.LENGTH_SHORT).show();
                }
else
                Toast.makeText(MainActivity.this, e.getMessage()+"", Toast.LENGTH_LONG).show();
            }
        });
    }
}
