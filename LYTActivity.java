package com.example.layoutt;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class LYTActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lyt);
		RelativeLayout lyt=new RelativeLayout(this);
		RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(this, null);
		Button btn1=new Button(this);
		btn1.setText("Button 1");
		btn1.setId(100);
		Button btn2=new Button(this);
		btn2.setText("Button 2");
		btn2.setId(50);
		RelativeLayout.LayoutParams param1=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.MATCH_PARENT);
		param1.addRule(RelativeLayout.BELOW,100);
		btn2.setLayoutParams(param1);
		lyt.addView(btn1);
		lyt.addView(btn2);
		setContentView(lyt);
		}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lyt, menu);
		return true;
	}

}
