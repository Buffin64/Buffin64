package com.example.eventdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener{
Button btninner, btnimp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnimp=(Button)findViewById(R.id.btnimp);
		btnimp.setOnClickListener(this);
		
		btninner=(Button)findViewById(R.id.btninner);
		btninner.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplication(),"This is an inner class", Toast.LENGTH_LONG).show();
			
			}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
public void doclick(View v){
	Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
}

@Override
public void onClick(View arg0) {
	// TODO Auto-generated method stub
	Toast.makeText(getApplicationContext(), "This is an implemented class", Toast.LENGTH_LONG).show();
}
}
