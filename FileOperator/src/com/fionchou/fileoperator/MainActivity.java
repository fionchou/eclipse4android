package com.fionchou.fileoperator;

import java.io.IOException;

import com.fionchou.fileoperator.service.FileService;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button fileSaveButton = (Button) this.findViewById(R.id.file_save_button);
		Button fileReadButton = (Button) this.findViewById(R.id.file_read_button);

		fileSaveButton.setOnClickListener(new ButtonClickListener());
		fileReadButton.setOnClickListener(new ButtonClickListener());
	}

	private final class ButtonClickListener implements View.OnClickListener{

		@Override
		public void onClick(View button) {
			
			if(R.id.file_save_button == button.getId()){
			
				EditText fileName = (EditText) findViewById(R.id.file_name);
				String fileNameText = fileName.getText().toString();
				EditText fileContent = (EditText) findViewById(R.id.file_content);
				String fileContentText = fileContent.getText().toString();
				
				FileService fileService = new FileService(getApplicationContext());
				try {
					fileService.saveFile(fileNameText,fileContentText);
					Toast.makeText(getApplicationContext(), R.string.file_save_success, Toast.LENGTH_LONG).show();
				} catch (IOException e) {
					e.printStackTrace();
					Toast.makeText(getApplicationContext(), R.string.file_save_fail, Toast.LENGTH_LONG).show();
				}
			}else if(R.id.file_read_button == button.getId()){
				EditText fileName = (EditText) findViewById(R.id.read_file_name);
				String fileNameText = fileName.getText().toString();
				EditText fileContent = (EditText) findViewById(R.id.read_file_content);
				
				FileService fileService = new FileService(getApplicationContext());
				try {
					String fileContentText = fileService.readFile(fileNameText);
					fileContent.setText(fileContentText);
					Toast.makeText(getApplicationContext(), R.string.file_read_success, Toast.LENGTH_LONG).show();
				} catch (IOException e) {
					e.printStackTrace();
					Toast.makeText(getApplicationContext(), R.string.file_read_fail, Toast.LENGTH_LONG).show();
				}
			}


		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
