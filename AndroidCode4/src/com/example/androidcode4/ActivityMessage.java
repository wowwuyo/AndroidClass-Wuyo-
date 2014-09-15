package com.example.androidcode4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;

public class ActivityMessage extends Activity {
	
	TextView tv1;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_message);
		
		tv1 = (TextView)findViewById(R.id.textView1);
		
		String text = getIntent().getStringExtra("text");
		
		tv1.setText(text);
		
		
	}
	
	private void WriteFile(String text){
		try {
			FileOutputStream fos = openFileOutput("history.txt", Context.MODE_APPEND);
			fos.write(text.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
