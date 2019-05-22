package com.notbytes.barcodereader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;
import com.notbytes.barcode_reader.BarcodeReaderActivity;
import com.notbytes.barcode_reader.BarcodeReaderFragment;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, BarcodeReaderFragment.BarcodeReaderListener {
    private static final int BARCODE_READER_ACTIVITY_REQUEST = 1208;
    String xmlUID, xmlName, xmlMobile, xmlBY, xmlGender, xmlNext, xmlLocation, xmlDistrict, xmlState, xmlPC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_activity).setOnClickListener(this);
        findViewById(R.id.btn_manual).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //main activity on scanning the barcode
            case R.id.btn_activity:
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
                Fragment fragmentById = supportFragmentManager.findFragmentById(R.id.fm_container);
                if (fragmentById != null) {
                    fragmentTransaction.remove(fragmentById);
                }
                fragmentTransaction.commitAllowingStateLoss();
                launchBarCodeActivity();
                break;

             //manual entry activity
            case R.id.btn_manual:
                launchManualEntryForm();
                break;
        }
    }


    private void launchManualEntryForm() {
        Intent ManualEntryForm = new Intent(this, ManualEntryActivity.class);
        startActivity(ManualEntryForm);
    }

    private void launchBarCodeActivity() {
        Intent launchIntent = BarcodeReaderActivity.getLaunchIntent(this, true, true);
        startActivityForResult(launchIntent, BARCODE_READER_ACTIVITY_REQUEST);
    }

    @Override

    //activities on result
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != Activity.RESULT_OK) {
            Toast.makeText(this, "error in  scanning", Toast.LENGTH_SHORT).show();
            return;
        }

        //functions if the QR code is read successfully
        if (requestCode == BARCODE_READER_ACTIVITY_REQUEST && data != null) {
            Barcode barcode = data.getParcelableExtra(BarcodeReaderActivity.KEY_CAPTURED_BARCODE);

            byte[] bytes = barcode.rawValue.getBytes();
            String result = new String(bytes);
            InputStream inputStream = new ByteArrayInputStream(result.getBytes(Charset.forName("UTF-8")));
            try {
                //reading the relevant xml file
                XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
                XmlPullParser myParser = xmlFactoryObject.newPullParser();
                myParser.setInput(inputStream, null);
                int event = myParser.getEventType();
                while (event != XmlPullParser.END_DOCUMENT)  {
                    //extracting the values to local variables
                    xmlUID = myParser.getAttributeValue(null,"uid");
                    xmlName = myParser.getAttributeValue(null,"name");
                    xmlMobile = myParser.getAttributeValue(null,"mobile");
                    xmlBY = myParser.getAttributeValue(null,"yob");
                    xmlGender = myParser.getAttributeValue(null,"gender");
                    xmlNext = myParser.getAttributeValue(null,"co");
                    xmlLocation = myParser.getAttributeValue(null,"vtc");
                    xmlDistrict = myParser.getAttributeValue(null,"dist");
                    xmlState = myParser.getAttributeValue(null,"state");
                    xmlPC = myParser.getAttributeValue(null,"pc");
                    try {
                        event = myParser.next();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (XmlPullParserException e) {
                e.printStackTrace();}

                // passing the values to results view activity
            Intent intent = new Intent(this, ResultViewActivity.class);
            intent.putExtra("xmlUID",xmlUID);
            intent.putExtra("xmlName",xmlName);
            intent.putExtra("xmlMobile",xmlMobile);
            intent.putExtra("xmlBY",xmlBY);
            intent.putExtra("xmlGender",xmlGender);
            intent.putExtra("xmlNext",xmlNext);
            intent.putExtra("xmlLocation",xmlLocation);
            intent.putExtra("xmlDistrict",xmlDistrict);
            intent.putExtra("xmlState",xmlState);
            intent.putExtra("xmlPC",xmlPC);
            startActivity(intent);

            Log.d("myTag"," uid: "+xmlUID);
            Log.d("myTag"," name: "+xmlName);
            Log.d("myTag"," mobile: "+xmlMobile);
            Log.d("myTag"," by: "+xmlBY);
            Log.d("myTag"," gender: "+xmlGender);
            Log.d("myTag"," father/husband: "+xmlNext);
            Log.d("myTag"," location: "+xmlLocation);
            Log.d("myTag"," district: "+xmlDistrict);
            Log.d("myTag"," state: "+xmlState);
            Log.d("myTag"," pc: "+xmlPC);
        }

    }

    @Override
    public void onScanned(Barcode barcode) {
    }

    @Override
    public void onScannedMultiple(List<Barcode> barcodes) {

    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    @Override
    public void onScanError(String errorMessage) {
        Toast.makeText(this, "Scanning error!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCameraPermissionDenied() {
        Toast.makeText(this, "Camera permission denied!", Toast.LENGTH_LONG).show();
    }
}
