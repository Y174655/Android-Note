package com.example.wordbookandroid;
import com.example.wordbookandroid.InsertActivity.insertcanclelistenter;
import com.example.wordbookandroid.InsertActivity.insertoklistenter;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class SearchActivity extends Activity{
	private Button searchok;
	private Button searchcancle;
	private EditText searchword;
	private TextView searchmean;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		searchok=(Button)findViewById(R.id.buttonsearchok);
		searchcancle=(Button)findViewById(R.id.buttonsearchcancle);
		searchword =(EditText)findViewById(R.id.editTextsearchword);
		searchmean =(TextView)findViewById(R.id.Textsearchtmean);
		searchok.setOnClickListener(new searchoklistenter());
		searchcancle.setOnClickListener(new searchcanclelistenter());
	}
	class searchoklistenter  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String tempword = searchword.getText().toString();
			String tempmean =Wordbook.tt.find(tempword);		
			searchmean.setText(tempmean);	
			
		}
    	
    }
	class searchcanclelistenter  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();	
			
		}
    	
    }

}