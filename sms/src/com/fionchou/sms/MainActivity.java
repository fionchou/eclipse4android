package com.fionchou.sms;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText phone_number;
	private EditText sms_content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		phone_number = (EditText) this.findViewById(R.id.phone_number);
		sms_content = (EditText) this.findViewById(R.id.sms_content);
		
		Button sendsms_button =(Button) this.findViewById(R.id.sendsms_button);
		
		sendsms_button.setOnClickListener(new ButtonClickListener());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private final class ButtonClickListener implements View.OnClickListener{
		@Override
		public void onClick(View sendsms_button) {
			String phoneNumber = phone_number.getText().toString();
			String smsContent = sms_content.getText().toString();
			
			SmsManager smsManager = SmsManager.getDefault();
			
			ArrayList<String> smsContents = smsManager.divideMessage(smsContent);
			
			for(String  smsContentText: smsContents){
				smsManager.sendTextMessage(phoneNumber, null, smsContentText, null, null);
			}
			
			Toast.makeText(getApplicationContext(), R.string.sendsms_success_toast, Toast.LENGTH_LONG).show();
		}
	}

	public EditText getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(EditText phone_number) {
		this.phone_number = phone_number;
	}

	public EditText getSms_content() {
		return sms_content;
	}

	public void setSms_content(EditText sms_content) {
		this.sms_content = sms_content;
	}
	
	

}
