package com.example.test1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConfigureStats extends Activity {
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
	public static int month = 0;
	public static int day = 1;
	public static int year = 2013;
	public static String menu_type;
	public static boolean start_or_end = true;
	public static String period = "All";

	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stats_configure);
		
		
		Button start_day = (Button) findViewById(R.id.start_day);
		start_day.setText(Integer.toString(day));
	    registerForContextMenu(start_day);
	    
		Button start_month = (Button) findViewById(R.id.start_month);
		start_month.setText((months[month]));
	    registerForContextMenu(start_month);
	    
		Button start_year = (Button) findViewById(R.id.start_year);
		start_year.setText(Integer.toString(year));
	    registerForContextMenu(start_year);
	    
		Button end_day = (Button) findViewById(R.id.end_day);
		end_day.setText(Integer.toString(day));
	    registerForContextMenu(end_day);
	    
		Button end_month = (Button) findViewById(R.id.end_month);
		end_month.setText((months[month]));
	    registerForContextMenu(end_month);
	    
		Button end_year = (Button) findViewById(R.id.end_year);
		end_year.setText(Integer.toString(year));
	    registerForContextMenu(end_year);
	    
	    Button time = (Button) findViewById(R.id.time_of_day);
	    time.setText(period);
	    registerForContextMenu(time);

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
	
	public void CreateTimeMenu(Menu menu){
		menu.setQwertyMode(true);
		menu.add(0,0,0,"Morning");
		menu.add(0,1,1,"Afternoon");
		menu.add(0,2,2,"Night");
		menu.add(0,3,3,"All");
	}
 
    private boolean MenuChoice(MenuItem item)
    {       
    	
    	//return (String) item.getTitle();
    	if (menu_type=="day"){
    	day = item.getItemId();
    	String day_str = "";
    	switch (day){
    	case 1:
    		day_str = Integer.toString(day) + "st";
    		break;
    	case 2:
    		day_str = Integer.toString(day) + "nd";
    		break;
    	case 3:
    		day_str = Integer.toString(day) + "rd";
    		break;
    	default:
    		day_str = Integer.toString(day) + "th";
    		break;
    	}
    	if (start_or_end){
    	Button start_day = (Button) findViewById(R.id.start_day);
		start_day.setText(day_str);}
    	else{
    		Button end_day = (Button) findViewById(R.id.end_day);
    		end_day.setText(day_str);
    	}
    	}
    	
    	if (menu_type == "month"){
    		if(start_or_end){
    		Button start_month = (Button) findViewById(R.id.start_month);
    		start_month.setText(item.getTitle());}
    		else{
        		Button end_month = (Button) findViewById(R.id.end_month);
        		end_month.setText(item.getTitle());
    		}
    	}
    	
    	if (menu_type == "year"){
    		if(start_or_end){
    		Button start_year = (Button) findViewById(R.id.start_year);
    		start_year.setText(item.getTitle());}
    		else{
        		Button end_year = (Button) findViewById(R.id.end_year);
        		end_year.setText(item.getTitle());
    		}
    	}
    	
    	if(menu_type=="time"){
    		Button time = (Button) findViewById(R.id.time_of_day);
    		time.setText(item.getTitle());
    	}
        return false;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, 
    ContextMenuInfo menuInfo) 
    {
         super.onCreateContextMenu(menu, view, menuInfo);
         if (view == (Button) findViewById(R.id.start_day) || view == (Button) findViewById(R.id.end_day)){
        	 if(view == (Button) findViewById(R.id.end_day))
        		 start_or_end=false;
        	 menu.setHeaderTitle("Select Day");
        	 menu_type = "day";
        	 CreateDayMenu(menu);
         }
         if (view == (Button) findViewById(R.id.start_month) || view == (Button) findViewById(R.id.end_month)){
        	 if(view == (Button) findViewById(R.id.end_month))
        		 start_or_end=false;
        	 menu.setHeaderTitle("Select Month");
        	 menu_type = "month";
        	 CreateMonthMenu(menu);
         }
         if (view == (Button) findViewById(R.id.start_year) || view == (Button) findViewById(R.id.end_year)){
        	 if(view == (Button) findViewById(R.id.end_year))
        		 start_or_end=false;
        	 menu.setHeaderTitle("Select Year");
        	 menu_type = "year";
        	 CreateYearMenu(menu);
         }
         if(view==(Button) findViewById(R.id.time_of_day)){
        	 menu_type = "time";
        	 menu.setHeaderTitle("Select Time of Day");
        	 CreateTimeMenu(menu);
         }
    }
 
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {    
    	
        return MenuChoice(item);    
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.activity_bar, menu);
      return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
      switch (item.getItemId()) {
      /*case R.id.toPage2:
    	Intent page2_intent = new Intent(welcomeMenu.this, Page2.class);
      	welcomeMenu.this.startActivity(page2_intent);
        break;
      case R.id.mainactivity:
    	Intent mainactivity_intent = new Intent(welcomeMenu.this, MainActivity.class);
      	welcomeMenu.this.startActivity(mainactivity_intent);
        break;
      case R.id.homescreen:
    	Intent homescreen_intent = new Intent(welcomeMenu.this, MyHomeScreen.class);
    	welcomeMenu.this.startActivity(homescreen_intent);*/
      default:
        break;
      }
      return true;
    }
    
}