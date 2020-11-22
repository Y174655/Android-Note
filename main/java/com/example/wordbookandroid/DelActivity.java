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
public class DelActivity extends Activity{

	private EditText delword;	
	private Button delok;
	private Button delcancle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_del);
		
		delok=(Button)findViewById(R.id.buttondelok);
		delcancle=(Button)findViewById(R.id.buttondelcancle);
		delword =(EditText)findViewById(R.id.editTextdelword);
	
		delok.setOnClickListener(new deloklistenter());
		delcancle.setOnClickListener(new delcanclelistenter());
	}
	class deloklistenter  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String tempword = delword.getText().toString();	
			if(Wordbook.tt.if_find(tempword))
			{
			Wordbook.tt.remove(tempword);
			Toast.makeText(DelActivity.this, "ɾ���ɹ�", Toast.LENGTH_SHORT).show();
			}
			else
				Toast.makeText(DelActivity.this, "�õ��ʲ�����", Toast.LENGTH_SHORT).show();	
			
		}
    	
    }
	class delcanclelistenter  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			finish();	
			
		}
    	
    }

}
