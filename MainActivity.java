package com.example.table;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity{
ListView lv;
RelativeLayout rl;
    @Override  
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         
        rl=new RelativeLayout(this);
        lv=new ListView(this);
       RelativeLayout.LayoutParams param=new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT); 
        lv.setLayoutParams(param);
        rl.setLayoutParams(param);
        //setContentView(R.layout.activity_main);
        setContentView(rl);
        
        String games[]=new String[]{"football","netball","volleyball","hockey"};
        ArrayAdapter<String>adp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,games);
        lv.setAdapter(adp);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
