package com.example.d2a.superkontak;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAddContact_onClick(View view){
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

        EditText mNamaAwal = (EditText) findViewById(R.id.txtNamaAwal);
        EditText mNamaAkhir = (EditText) findViewById(R.id.txtNamaAkhir);
        EditText mAEmail = (EditText) findViewById(R.id.txtAEmail);
        EditText mTelepon = (EditText) findViewById(R.id.txtTelepon);

        intent
                .putExtra(ContactsContract.Intents.Insert.EMAIL, mAEmail.getText())
                .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                .putExtra(ContactsContract.Intents.Insert.PHONE, mTelepon.getText())
                .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
                .putExtra(ContactsContract.Intents.Insert.NAME,mNamaAwal.getText()+ " " + mNamaAkhir.getText())
        ;

        startActivity(intent);
    }
}
