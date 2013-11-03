package com.fionchou.phone;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button = (Button) this.findViewById(R.id.button);
		button.setOnClickListener(new ButtonClickListener()); 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private final class ButtonClickListener implements View.OnClickListener{
		@Override
		public void onClick(View button) {
			EditText mobileText = (EditText) findViewById(R.id.phoneNumb);
			String phoneNumb = mobileText.getText().toString();
			Intent intent = new Intent();
			intent.setAction("android.intent.action.CALL");
			intent.setData(Uri.parse("tel:"+phoneNumb));
			
			startActivity(intent);
			
		}
		
	}

}
