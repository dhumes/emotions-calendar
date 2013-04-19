package com.example.test1;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.app.Activity;
import android.content.Intent;

public class Set_Emotions extends Activity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.set_emotions);
		
		OnClickListener toTodayPage = new OnClickListener(){
			public void onClick(View v)
			{
				//Intent nextIntent = new Intent(Set_Emotions.this, TodayPage.class);
				Intent i = getIntent();
				int b = 0;
				switch(v.getId())
				{
				case(R.id.happy):
					b = 1;
				break;
				case(R.id.setSad):
					b = 2;
				break;
				case(R.id.setAngry):
					b = 3;
				break;
				case(R.id.setShy):
					b = 4;
				break;
				case(R.id.setSick):
					b = 5;
				break;
				case(R.id.setExcited):
					b = 6;
				break;
				
				}
				i.putExtra("emotionSelected", b);
				setResult(RESULT_OK, i);
				finish();
			}
		};
		//sets all listeners
         findViewById(R.id.happy).setOnClickListener(toTodayPage);
		 findViewById(R.id.setSad).setOnClickListener(toTodayPage);
		 findViewById(R.id.setExcited).setOnClickListener(toTodayPage);
		 findViewById(R.id.setAngry).setOnClickListener(toTodayPage);
		 findViewById(R.id.setSick).setOnClickListener(toTodayPage);
		 findViewById(R.id.setShy).setOnClickListener(toTodayPage);
	}
	
	
	
	
	
}
