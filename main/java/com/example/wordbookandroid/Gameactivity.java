package com.example.wordbookandroid;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wordbookandroid.Gameactivity.game1;
import com.example.wordbookandroid.Gameactivity.game2;
import com.example.wordbookandroid.Gameactivity.game3;
import com.example.wordbookandroid.Gameactivity.game4;
import com.example.wordbookandroid.Gameactivity.game5;

public class Gameactivity extends Activity{
	private Button b1;
	private Button b2;
	private Button b3;
	private Button b4;
	private Button b5;
	private Button b6;
	private TextView q1;
	private TextView sco;
	private ReciteNode node=Wordbook.tt.getReciteNode();
	private HashTable ct = new HashTable();
	private int number=0;
	private Random a =new Random();
	private int nt=0;
	private int ft=0;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_game);

		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		b3=(Button)findViewById(R.id.button3);
		b4=(Button)findViewById(R.id.button4);
		b5=(Button)findViewById(R.id.button5);
		b6=(Button)findViewById(R.id.button6);
		q1=(TextView)findViewById(R.id.gameword);
		sco=(TextView)findViewById(R.id.score);
		b1.setOnClickListener(new game1());
		b2.setOnClickListener(new game2());
		b3.setOnClickListener(new game3());
		b4.setOnClickListener(new game4());
		b5.setOnClickListener(new game5());
		b6.setOnClickListener(new game6());
		

		sco.setText("正确/错误："+nt+"/"+ft);
		q1.setText(node.word);

		number = (int)(a.nextDouble()*4);
		switch(number)
		{
		case 0:
			b1.setText(node.wrongmeaning[3]);
			b2.setText(node.wrongmeaning[1]);
			b3.setText(node.wrongmeaning[2]);
			b4.setText(node.wrongmeaning[0]);
			break;
		case 1:

			b2.setText(node.wrongmeaning[3]);
			b1.setText(node.wrongmeaning[1]);
			b3.setText(node.wrongmeaning[2]);
			b4.setText(node.wrongmeaning[0]);
			break;
		case 2:

			b3.setText(node.wrongmeaning[3]);
			b2.setText(node.wrongmeaning[1]);
			b1.setText(node.wrongmeaning[2]);
			b4.setText(node.wrongmeaning[0]);
			break;
		case 3:

			b4.setText(node.wrongmeaning[3]);
			b2.setText(node.wrongmeaning[1]);
			b3.setText(node.wrongmeaning[2]);
			b1.setText(node.wrongmeaning[0]);
			break;

		}

	}
	public void next (){
		node=Wordbook.tt.getReciteNode();
		q1.setText(node.word);

		number = (int)(a.nextDouble()*4);
		switch(number)
		{
		case 0:
			b1.setText(node.wrongmeaning[3]);
			b2.setText(node.wrongmeaning[1]);
			b3.setText(node.wrongmeaning[2]);
			b4.setText(node.wrongmeaning[0]);
			break;
		case 1:

			b2.setText(node.wrongmeaning[3]);
			b1.setText(node.wrongmeaning[1]);
			b3.setText(node.wrongmeaning[2]);
			b4.setText(node.wrongmeaning[0]);
			break;
		case 2:

			b3.setText(node.wrongmeaning[3]);
			b2.setText(node.wrongmeaning[1]);
			b1.setText(node.wrongmeaning[2]);
			b4.setText(node.wrongmeaning[0]);
			break;
		case 3:

			b4.setText(node.wrongmeaning[3]);
			b2.setText(node.wrongmeaning[1]);
			b3.setText(node.wrongmeaning[2]);
			b1.setText(node.wrongmeaning[0]);
			break;

		}

	}


	class game1  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(number==0)
			{
				Toast.makeText(Gameactivity.this, "回答正确", Toast.LENGTH_SHORT).show();
				nt++;
				next();
			}
			else
			{
				Toast.makeText(Gameactivity.this, "回答错误", Toast.LENGTH_SHORT).show();
				ft++;
				ct.insert(node.word, node.wrongmeaning[3]);
			}
			sco.setText("正确/错误："+nt+"/"+ft);

		}

	}
	class game2  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(number==1)
			{
				Toast.makeText(Gameactivity.this, "回答正确", Toast.LENGTH_SHORT).show();
				nt++;
				next();
			}
			else
			{
				Toast.makeText(Gameactivity.this, "回答错误", Toast.LENGTH_SHORT).show();
				ft++;
				ct.insert(node.word, node.wrongmeaning[3]);
			}
			sco.setText("正确/错误："+nt+"/"+ft);

		}

	}
	class game3  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(number==2)
			{
				Toast.makeText(Gameactivity.this, "回答正确", Toast.LENGTH_SHORT).show();
				nt++;
				next();
			}
			else
			{
				Toast.makeText(Gameactivity.this, "回答错误", Toast.LENGTH_SHORT).show();
				ft++;
				ct.insert(node.word, node.wrongmeaning[3]);
			}
			sco.setText("正确/错误："+nt+"/"+ft);

		}

	}
	class game4  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(number==3)
			{
				Toast.makeText(Gameactivity.this, "回答正确", Toast.LENGTH_SHORT).show();
				nt++;
				next();
			}
			else
			{
				Toast.makeText(Gameactivity.this, "回答错误", Toast.LENGTH_SHORT).show();
				ft++;
				ct.insert(node.word, node.wrongmeaning[3]);
			}
			sco.setText("正确/错误："+nt+"/"+ft);

		}

	}
	class game5  implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			node=Wordbook.tt.getReciteNode();
			q1.setText(node.word);

			number = (int)(a.nextDouble()*4);
			switch(number)
			{
			case 0:
				b1.setText(node.wrongmeaning[3]);
				b2.setText(node.wrongmeaning[1]);
				b3.setText(node.wrongmeaning[2]);
				b4.setText(node.wrongmeaning[0]);
				break;
			case 1:

				b2.setText(node.wrongmeaning[3]);
				b1.setText(node.wrongmeaning[1]);
				b3.setText(node.wrongmeaning[2]);
				b4.setText(node.wrongmeaning[0]);
				break;
			case 2:

				b3.setText(node.wrongmeaning[3]);
				b2.setText(node.wrongmeaning[1]);
				b1.setText(node.wrongmeaning[2]);
				b4.setText(node.wrongmeaning[0]);
				break;
			case 3:

				b4.setText(node.wrongmeaning[3]);
				b2.setText(node.wrongmeaning[1]);
				b3.setText(node.wrongmeaning[2]);
				b1.setText(node.wrongmeaning[0]);
				break;

			}


		}

	}
	class game6 implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ct.fileprint("错题。txt");
			Toast.makeText(Gameactivity.this, "输出成功", Toast.LENGTH_SHORT).show();
	}



}
}
