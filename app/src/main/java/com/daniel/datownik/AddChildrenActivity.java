package com.daniel.datownik;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.daniel.datownik.db.ChildrensDAO;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddChildrenActivity extends AppCompatActivity {

    @BindView(R.id.et_nameChild)
    EditText childName;
    @BindView(R.id.btn_saveChild)
    Button save;
    @BindView(R.id.btn_back)
    Button back;
    @BindView(R.id.btn_qrCode)
    Button qrCodeScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_children);
        ButterKnife.bind(this);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {

            if (resultCode == RESULT_OK) {
                String contents = data.getStringExtra("SCAN_RESULT");
                Toast toast = Toast.makeText(getApplicationContext(),contents,Toast.LENGTH_LONG);
                toast.show();
            }
            if(resultCode == RESULT_CANCELED){
                //handle cancel
            }
        }
    }

    @OnClick(R.id.btn_qrCode)
    public void qrScanner(){
        try {

            Intent intent = new Intent("com.google.zxing.client.android.SCAN");
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE"); // "PRODUCT_MODE for bar codes

            startActivityForResult(intent, 0);

        } catch (Exception e) {

            Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
            Intent marketIntent = new Intent(Intent.ACTION_VIEW,marketUri);
            startActivity(marketIntent);

        }
    }

    @OnClick(R.id.btn_saveChild)
    public void saveChild(){
        String childNameString = childName.getText().toString();
        ChildrensDAO childrensDAO = new ChildrensDAO(this);
        childrensDAO.insertChild(childNameString);
    }
}
