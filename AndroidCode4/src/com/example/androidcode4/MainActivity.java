package com.example.androidcode4;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.*;
import android.view.View.OnKeyListener;
import android.widget.*;


public class MainActivity extends ActionBarActivity {

	Button btn;
	EditText txtE1;
	CheckBox chkbox;
	SeekBar sb;
	Editor editor;
	private SharedPreferences sp;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       btn = (Button)findViewById(R.id.button1);
       txtE1 = (EditText)findViewById(R.id.editText1);
       chkbox = (CheckBox)findViewById(R.id.checkBox1);
       sb = (SeekBar)findViewById(R.id.seekBar1);
       
       //-----------------------
       sp = getSharedPreferences("settings",Context.MODE_PRIVATE);
       editor = sp.edit();
       /*sp = getActivity().getSharedPreferences("settings.txt",
				Context.MODE_PRIVATE);*/
      
      //-----------------------
       
       btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("debug", "click from button1");
				sendText("1");
			}
		});
       
       txtE1.setOnKeyListener(new OnKeyListener(){
       
		@Override
		public boolean onKey(View v, int keyCode, KeyEvent event) {
			Log.d("debug", "keyCode: " + keyCode);
			String str = txtE1.getText().toString();
			editor.putString("text", str);
			editor.commit();
			
			if (keyCode == KeyEvent.KEYCODE_ENTER
					&& event.getAction() == KeyEvent.ACTION_DOWN) {
				sendText("9981");
			}
			txtE1.setText(sp.getString("text", "Null"));
			//editText.setText(sp.getString("text", ""));
			//checkBox.setChecked(sp.getBoolean("checkbox", false));
			return false;
		}
    	   
       });
        
    }
    
    public void clkButton(View v){
    	Log.d("debug", "click from button2");
    	sendText("2");
    }

    public void sendText(String bNum){
    	String str = txtE1.getText().toString();
    	int val = sb.getProgress();
    	if(chkbox.isChecked()){
    		str = "*******";
    	}
    	//Toast.makeText(this, str+" from "+bNum, Toast.LENGTH_LONG).show();
    	Toast.makeText(this, str+" from "+bNum+" >> "+val, Toast.LENGTH_SHORT).show();
    	
    	txtE1.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
