package com.example.wordbookandroid;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button cet4;
	private Button otherfile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		cet4=(Button)findViewById(R.id.buttoncet4);
		otherfile=(Button)findViewById(R.id.buttonotherfile);
		cet4.setOnClickListener(new ChooseCet4());
		otherfile.setOnClickListener(new ChooseOtherfile());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	class ChooseCet4  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String  filename = "CERT4(DOS).TXT";
			
    		Intent intent = new Intent();
    		intent.putExtra("filename", filename);    		
    		intent.setClass(MainActivity.this, MenuActive.class);
    		MainActivity.this.startActivity(intent);
			
		}
    	
    }
	class ChooseOtherfile  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String  filename = "CERT4(DOS).TXT";
			
    		Intent intent = new Intent();
    		intent.putExtra("filename", filename);    		
    		intent.setClass(MainActivity.this, MenuActive.class);
    		MainActivity.this.startActivity(intent);
			
		}
    	
    }

}
