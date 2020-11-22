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
import android.widget.Toast;
public class ChangeActivity extends Activity{
	private EditText changeword;
	private EditText changemean;
	private Button changeok;
	private Button changecancle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change);
		
		changeok=(Button)findViewById(R.id.buttonchangeok);
		changecancle=(Button)findViewById(R.id.buttonchangecancle);
		changeword =(EditText)findViewById(R.id.editTextchangeword);
		changemean =(EditText)findViewById(R.id.editTextchangemean);
		changeok.setOnClickListener(new changeoklistenter());
		changecancle.setOnClickListener(new changecanclelistenter());
	}
	class changeoklistenter  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String tempword = changeword.getText().toString();
			String tempmean = changemean.getText().toString();
			if(Wordbook.tt.if_find(tempword))
			{
			Wordbook.tt.revise(tempword, tempmean);
			Toast.makeText(ChangeActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
			}
			else
				Toast.makeText(ChangeActivity.this, "该单词不存在", Toast.LENGTH_SHORT).show();
	
	
			
		}
    	
    }
	class changecanclelistenter  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();	
			
		}
    	
    }

}
