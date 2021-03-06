package com.example.test1;



import android.app.ActionBar;
import android.app.Activity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;

 
import android.content.Intent;
import android.text.Editable;
import android.util.Log;
import android.view.MenuInflater;
import android.view.SubMenu;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import 	android.view.LayoutInflater;
public class welcomeMenu extends Activity { 
    /** Called when the activity is first created. */
	final Context context = this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen); 
        

        
        /*Button new_user = (Button) findViewById(R.id.newUser);
        new_user.setOnClickListener(new OnClickListener(){
        	public void onClick(View arg0) {
        		
    			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
    				context);
    			LayoutInflater inflater = getLayoutInflater();

     
    			// set dialog message
    			alertDialogBuilder
    				.setMessage("Change Name")
    				.setCancelable(false);

    			
    			
    			alertDialogBuilder.setView(inflater.inflate(R.layout.alert_dialog_box, null));     
    			// create alert dialog
    			
    			alertDialogBuilder.setNeutralButton("Okay",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						EditText new_name = (EditText) findViewById(R.id.new_name);
						dialog.cancel();
						//String a  = new_name.getText().toString().trim();
						if (new_name == null){
							name = " hoiahsohjsaodjo";//+ new_name.getText().toString();
						}
					}});
    			AlertDialog alertDialog = alertDialogBuilder.create();
     
   
    				// show it
    			alertDialog.show();
    			}
    		}); 
        Button select_user = (Button) findViewById(R.id.selectUser);       
        select_user.setOnCreateContextMenuListener(this);*/
        SharedPreferences name = getSharedPreferences("UserInfo", 0);
    	EditText username = (EditText) findViewById(R.id.nameinput);
    	username.setText(name.getString("Name", "User"));

        Button weekly= (Button) findViewById(R.id.weekly);
        weekly.setOnClickListener(new OnClickListener(){
        public void onClick(View arg0) {
            SharedPreferences name = getSharedPreferences("UserInfo", 0);
            SharedPreferences.Editor editor = name.edit();
        	EditText username = (EditText) findViewById(R.id.nameinput);
        	editor.putString("Name",username.getText().toString());
        	editor.commit();
        	
        	Intent weekly_intent = new Intent(welcomeMenu.this, MyHomeScreen.class);
        	welcomeMenu.this.startActivity(weekly_intent);
        }});
        
        Button today = (Button) findViewById(R.id.today);
        today.setOnClickListener(new OnClickListener(){
        public void onClick(View arg0) {
            SharedPreferences name = getSharedPreferences("UserInfo", 0);
            SharedPreferences.Editor editor = name.edit();
        	EditText username = (EditText) findViewById(R.id.nameinput);
        	editor.putString("Name",username.getText().toString());
        	editor.commit();
        	
        	Intent today_intent = new Intent(welcomeMenu.this, TodayPage.class);
          	welcomeMenu.this.startActivity(today_intent);
        }});
        
        Button stats = (Button) findViewById(R.id.stats);
        stats.setOnClickListener(new OnClickListener(){
        	public void onClick(View arg0){
                SharedPreferences name = getSharedPreferences("UserInfo", 0);
                SharedPreferences.Editor editor = name.edit();
            	EditText username = (EditText) findViewById(R.id.nameinput);
            	editor.putString("Name",username.getText().toString());
            	editor.commit();
            	
            	Intent nextIntent = new Intent(welcomeMenu.this, ConfigureStats.class);
            	welcomeMenu.this.startActivity(nextIntent);
        	}
        });
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
      case R.id.Today:
    	Intent today_intent = new Intent(welcomeMenu.this, TodayPage.class);
      	welcomeMenu.this.startActivity(today_intent);
        break;
      case R.id.Weekly:
    	Intent weekly_intent = new Intent(welcomeMenu.this, MyHomeScreen.class);
    	welcomeMenu.this.startActivity(weekly_intent);
    	break;
      case R.id.Stats:
      	Intent stats_intent = new Intent(welcomeMenu.this, ConfigureStats.class);
        welcomeMenu.this.startActivity(stats_intent);
        break;
      default:
        break;
      }
      return true;
    }
    
    
}


