package com.example.wordbookandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuActive extends Activity{
	private Button insert;
	private Button del;
	private Button search;
	private Button change;
	private Button outfile;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		Intent intent = getIntent();
		String filename = intent.getStringExtra("filename");
		  
		 Wordbook.tt=new HashTable(filename);
		insert = (Button)findViewById(R.id.buttoninsert);
		del = (Button) findViewById(R.id.buttondel);
		search = (Button)findViewById(R.id.buttonsearch);
		change =(Button)findViewById(R.id.buttonchange);
		outfile=(Button)findViewById(R.id.buttonout);
		insert.setOnClickListener(new Insertlistener());
		del.setOnClickListener(new Dellistener());
		search.setOnClickListener(new Searchlistener());
		change.setOnClickListener(new Changelistener());
		outfile.setOnClickListener(new Outlistener());
		
	}
	class Insertlistener  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Intent intent = new Intent();			
    		intent.setClass(MenuActive.this, InsertActivity.class);
    		MenuActive.this.startActivity(intent);
		
		}
    	
    }
	class Dellistener  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Intent intent = new Intent();    		   		
    		intent.setClass(MenuActive.this, DelActivity.class);
    		MenuActive.this.startActivity(intent);
		
		}
    	
    }
	class Searchlistener  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Intent intent = new Intent();    		   		
    		intent.setClass(MenuActive.this, SearchActivity.class);
    		MenuActive.this.startActivity(intent);
		
		}
    	
    }
	class Changelistener  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Intent intent = new Intent();    		   		
    		intent.setClass(MenuActive.this, ChangeActivity.class);
    		MenuActive.this.startActivity(intent);
		
		}
    	
    }
	class Outlistener  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub			
			Intent intent = new Intent();    		   		
    		intent.setClass(MenuActive.this, Gameactivity.class);
    		MenuActive.this.startActivity(intent);
		
		
		}
    	
    }


}
