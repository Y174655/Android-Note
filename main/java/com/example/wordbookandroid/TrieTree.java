package com.example.wordbookandroid;

import java.io.*;

public class TrieTree {
	private TrieNode root;
	public TrieTree() {
		root = new TrieNode();
	}
	public TrieTree(String filename) {
		root = new TrieNode();
		File file = new File("/sdcard/ebook/"+filename);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			String tempword = null;
			String tempfrequency = null;
			String tempmean = null;
			while ((tempString = reader.readLine()) != null) {
				tempString = tempString.substring(tempString.indexOf(",") + 1,tempString.length());
				tempword = tempString.substring(0,tempString.indexOf(","));
				tempString = tempString.substring(tempString.indexOf(",") + 1,tempString.length());
				tempfrequency = tempString.substring(0,tempString.indexOf(","));
				tempString = tempString.substring(tempString.indexOf(",") + 1,tempString.length());
				tempmean = tempString;
				insert(tempword,tempmean,Double.parseDouble(tempfrequency));
			}
			reader.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}
	public void readfile(String filename)
	{
		File file = new File("/sdcard/ebook/"+filename);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			String tempword = null;
			String tempfrequency = null;
			String tempmean = null;
			while ((tempString = reader.readLine()) != null) {
				tempString = tempString.toLowerCase();
				tempString = tempString.substring(tempString.indexOf(",") + 1,tempString.length());
				tempword = tempString.substring(0,tempString.indexOf(","));
				tempString = tempString.substring(tempString.indexOf(",") + 1,tempString.length());
				tempfrequency = tempString.substring(0,tempString.indexOf(","));
				tempString = tempString.substring(tempString.indexOf(",") + 1,tempString.length());
				tempmean = tempString;
				insert(tempword,tempmean,Double.parseDouble(tempfrequency));
			}
			reader.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}
	public void depth_traversal_fileprint(String filename)
	{
		TrieNode t = root;
		FileOutputStream fos = null;
		BufferedWriter bw = null;
		try {
			File file = new File("/sdcard/ebook/"+filename);
			fos = new FileOutputStream(file);
			bw = new BufferedWriter(new OutputStreamWriter(fos));
			depth_traversal_Print(bw, t);
		}
		catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		finally {
			try {
				if (bw != null)
					bw.close();
				if (fos != null)
					fos.close();
			}
			catch (IOException ie) {
			}
		}
	}
	private void depth_traversal_Print(BufferedWriter bw, TrieNode t) throws IOException {
		for(int i = 0; i < 28; i++) {
			if(t != null)
				depth_traversal_Print(bw, t.nodes[i]);
		}
		if(t != null && t.isStr==true)
			bw.write(t.word+","+t.frequency+","+t.meaning+"\r\n");
	}
	public void breadth_traversal_fileprint(String filename)
	{
		TrieNode t = root;
		FileOutputStream fos = null;
		BufferedWriter bw = null;
		try {
			File file = new File("/sdcard/ebook/"+filename);
			fos = new FileOutputStream(file);
			bw = new BufferedWriter(new OutputStreamWriter(fos));
			breadth_traversal_Print(bw, t);
		}
		catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		finally {
			try {
				if (bw != null)
					bw.close();
				if (fos != null)
					fos.close();
			}
			catch (IOException ie) {
			}
		}
	}
	private void breadth_traversal_Print(BufferedWriter bw, TrieNode t) throws IOException {
		if(t != null && t.isStr==true)
			bw.write(t.word+","+t.frequency+","+t.meaning+"\r\n");
		for(int i = 0; i < 28; i++) {
			if(t != null)
				breadth_traversal_Print(bw, t.nodes[i]);
		}
	}
	public void insert(String str, String mean) {
		TrieNode t = root;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '.') {
				if(t.nodes[26] == null) 
					t.nodes[26] = new TrieNode();
				t = t.nodes[26];
			}
			else if(str.charAt(i) == '-') {
				if(t.nodes[27] == null) 
					t.nodes[27] = new TrieNode();
				t = t.nodes[27];
			}
			else {
				if(t.nodes[str.toLowerCase().charAt(i) - 'a'] == null) 
					t.nodes[str.toLowerCase().charAt(i) - 'a'] = new TrieNode();
				t = t.nodes[str.toLowerCase().charAt(i) - 'a'];
			}
		}
		t.isStr = true;
		t.word = str;
		t.meaning += mean;
	}
	public void insert(String str, String mean, double frequency) {
		TrieNode t = root;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '.') {
				if(t.nodes[26] == null) 
					t.nodes[26] = new TrieNode();
				t = t.nodes[26];
			}
			else if(str.charAt(i) == '-') {
				if(t.nodes[27] == null) 
					t.nodes[27] = new TrieNode();
				t = t.nodes[27];
			}
			else {
				if(t.nodes[str.toLowerCase().charAt(i) - 'a'] == null) 
					t.nodes[str.toLowerCase().charAt(i) - 'a'] = new TrieNode();
				t = t.nodes[str.toLowerCase().charAt(i) - 'a'];
			}
		}
		t.isStr = true;
		t.meaning += mean;
		t.word = str;
		t.frequency = frequency;
	}
	public void remove(String str) {
		TrieNode t  =root;
		str = str.toLowerCase();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '.') {
				if(t.nodes[26] == null)
					t.nodes[26] = new TrieNode();
				t = t.nodes[26];
			}
			else if(str.charAt(i) == '-') {
				if(t.nodes[27] == null) 
					t.nodes[27] = new TrieNode();
				t = t.nodes[27];
			}
			else {
				if(t.nodes[str.toLowerCase().charAt(i) - 'a'] == null) {
					TrieNode node = new TrieNode();
					t.nodes[str.toLowerCase().charAt(i) - 'a'] = node;}
				t = t.nodes[str.toLowerCase().charAt(i) - 'a'];
			}
		}
		t.meaning = "";
		t.frequency = 0;
		t.isStr = false;
	}
	public boolean revise(String str , String mean)
	{
		TrieNode t = root;
		int i;
		for (i = 0; i < str.length() && t != null; i++) {
			if(str.charAt(i) == '.') 
				t = t.nodes[26];
			else if(str.charAt(i) == '-') 
				t = t.nodes[27];
			else
				t = t.nodes[str.toLowerCase().charAt(i) - 'a'];
		}
		if (t != null && t.isStr == true)
		{
			t.meaning = mean;
			return true;
		}
		else
			return false;
	}
	public String find(String str) {
		TrieNode t = root;
		int i;
		for (i = 0; i < str.length() && t != null; i++) {
			if(str.charAt(i) == '.') 
				t = t.nodes[26];
			else if(str.charAt(i) == '-') 
				t = t.nodes[27];
			else
				t = t.nodes[str.toLowerCase().charAt(i) - 'a'];
		}
		if( t != null && t.isStr == true) {
			t.frequency++;
			return t.meaning;
		}
		else
			return "Î´ÕÒµ½¸Ã´Ê";
	}
	public boolean if_find(String str) {
		TrieNode t = root;
		int i;
		for (i = 0; i < str.length() && t != null; i++) {
			if(str.charAt(i) == '.') 
				t = t.nodes[26];
			else if(str.charAt(i) == '-') 
				t = t.nodes[27];
			else
				t = t.nodes[str.toLowerCase().charAt(i) - 'a'];
		}
		if( t != null && t.isStr == true) {
			t.frequency++;
			return true;
		}
		return false;
	}
}
