package com.example.wordbookandroid;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class InsertActivity extends Activity{
	private EditText insertword;
	private EditText insertmean;
	private Button insertok;
	private Button insertcancle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insert);
		
		insertok=(Button)findViewById(R.id.buttoninsertok);
		insertcancle=(Button)findViewById(R.id.buttoninsertcancle);
		insertword =(EditText)findViewById(R.id.editTextinsertword);
		insertmean =(EditText)findViewById(R.id.editTextinsertmean);
		insertok.setOnClickListener(new insertoklistenter());
		insertcancle.setOnClickListener(new insertcanclelistenter());
	}
	class insertoklistenter  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String tempword = insertword.getText().toString();
			String tempmean = insertmean.getText().toString();
			if(!(Wordbook.tt.if_find(tempword)))
			{
			Wordbook.tt.insert(tempword, tempmean);
			Toast.makeText(InsertActivity.this, "插入成功", Toast.LENGTH_SHORT).show();
			}
			else
				Toast.makeText(InsertActivity.this, "该单词已存在", Toast.LENGTH_SHORT).show();
			
		}
    	
    }
	class insertcanclelistenter  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();	
			
		}
    	
    }

}
