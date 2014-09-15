package com.example.androidcode4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.app.Activity;

public class ActivityMessage extends Activity {
	
	//TextView tv1;
	ListView lv1;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_message);
		
		//tv1 = (TextView)findViewById(R.id.textView1);
		lv1 = (ListView)findViewById(R.id.listView1);
		String text = getIntent().getStringExtra("text");
		
		//tv1.setText(text);
		
		 WriteFile(text);
		 
		 //tv1.setText(ReadFile());
		 String data = ReadFile();
		 ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data.split("\n"));
		 lv1.setAdapter(aa);
	}
	
	private void WriteFile(String text){
		try {
			text += "\n";
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
	
	private String ReadFile(){
		String retStr;
		try {
			FileInputStream fis = openFileInput("history.txt");
			byte[] data = new byte[1024];
			fis.read(data);
			fis.close();
			return new String(data);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
