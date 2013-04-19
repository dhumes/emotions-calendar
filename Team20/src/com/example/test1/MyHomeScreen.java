package com.example.test1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyHomeScreen extends Activity {

	public static String[] months = {"Jan",
		"Feb",
		"Mar",
		"Apr",
		"May",
		"Jun",
		"Jul",
		"Aug",
		"Sep",
		"Oct",
		"Nov",
		"Dec",
	};
	
	public static int month;
	public static int day;
	public static int year;
	public static String menu_type;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homescreenlayout);

	};

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
	
	@Override
    public void onCreateContextMenu(ContextMenu menu, View view, 
    ContextMenuInfo menuInfo) 
    {
         super.onCreateContextMenu(menu, view, menuInfo);
         if (view == (Button) findViewById(R.id.bday)){
        	 menu.setHeaderTitle("Select Day");
        	 menu_type = "day";
        	 CreateDayMenu(menu);
         }
         if (view == (Button) findViewById(R.id.bmonth)){
        	 menu.setHeaderTitle("Select Month");
        	 menu_type = "month";
        	 CreateMonthMenu(menu);
         }
         if (view == (Button) findViewById(R.id.start_year)){
        	 menu.setHeaderTitle("Select Year");
        	 menu_type = "year";
        	 CreateYearMenu(menu);
         }
    }

	private void CreateDayMenu(Menu menu)
	{
		menu.setQwertyMode(true);
		int num_days;
		switch(month){
		case 1:
			num_days = 28;
			break;
		case 3:
			num_days = 30;
			break;
		case 5:
			num_days = 30;
			break;
		case 8:
			num_days = 30;
			break;
		case 10:
			num_days = 30;
			break;
		default:
			num_days = 31;
			break;
		}
		for (int i = 1; i<=num_days; ++i){
			menu.add(0,i,i,Integer.toString(i));
		}
	}
	
	private void CreateMonthMenu(Menu menu)
    {
    	 menu.setQwertyMode(true);
    	 for (int i = 0; i<12; ++i){
    		 menu.add(0,i,i,months[i]);
    	 }
     }
	
	private void CreateYearMenu(Menu menu){
		menu.setQwertyMode(true);
		for (int i = 0; i<5; ++i){
			menu.add(0,i,i,Integer.toString(year-i));
		}
	}
	
	@Override
    public boolean onContextItemSelected(MenuItem item)
    {    
    	
        return MenuChoice(item);    
    }
	
	private boolean MenuChoice(MenuItem item)
    {       
    	if (menu_type=="day"){
    		Button bday = (Button) findViewById(R.id.bday);
    		bday.setText(item.getTitle());
    	}
    	
    	if (menu_type == "month"){
        		Button bmonth = (Button) findViewById(R.id.bmonth);
        		bmonth.setText(item.getTitle());
    		}
    	
    	if (menu_type == "year"){
        		Button byear = (Button) findViewById(R.id.byear);
        		byear.setText(item.getTitle());
    		}
        return false;
    }

}
