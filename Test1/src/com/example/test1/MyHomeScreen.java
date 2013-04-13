package com.example.test1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyHomeScreen extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		setContentView(R.layout.homescreenlayout);
		
		Button toPage1 = (Button) findViewById(R.id.toPage1);
		Button toPage = (Button) findViewById(R.id.toPage2);
		toPage1.setText("Go to page 1");
		toPage1.setOnClickListener(new OnClickListener(){
			public void onClick(View v)
			{
				Intent nextIntent = new Intent(MyHomeScreen.this, MainActivity.class);
				MyHomeScreen.this.startActivity(nextIntent);
			}
		});
		
		
		
	}
	
	protected void onStart()
	{
		super.onStart();
	}
	
	
	protected void onRestart()
	{
		super.onRestart();
	}
	
	protected void onStop()
	{
		super.onStop();
	}
	protected void onResume()
	{
		super.onResume();
	}
	
	protected void onDestroy()
	{
		super.onDestroy();
	}

}
