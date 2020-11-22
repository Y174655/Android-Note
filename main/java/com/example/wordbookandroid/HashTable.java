package com.example.wordbookandroid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HashTable {
	List<List<HashNode>> hashTable = new ArrayList<List<HashNode>>();
	public HashTable() {
		for(int i = 0; i < 28; i++) {
			hashTable.add(new ArrayList<HashNode>());
		}
	}
	public HashTable(String filename) {
		for(int i = 0; i < 28; i++) {
			hashTable.add(new ArrayList<HashNode>());
		}
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
				insert(new HashNode(tempword, tempmean, Integer.parseInt(tempfrequency)));
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
	public void readfile(String filename) {
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
				insert(new HashNode(tempword, tempmean, Integer.parseInt(tempfrequency)));
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
	public void fileprint(String filename)
	{
		FileOutputStream fos = null;
		BufferedWriter bw = null;
		try {
			File file = new File("/sdcard/ebook/"+filename);
			fos = new FileOutputStream(file);
			bw = new BufferedWriter(new OutputStreamWriter(fos));
			for(int i = 0; i < 28; i++) {
				Print(bw, hashTable.get(i));
			}
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
	private void Print(BufferedWriter bw, List<HashNode> tempList) throws IOException {
		if(!tempList.isEmpty()) {
			for(int i = 0; i < tempList.size(); i++) {
				bw.write(tempList.get(i).word+","+tempList.get(i).frequency+","+tempList.get(i).meaning+"\r\n");
			}	
		}
	}
	private void insert(HashNode hashNode) {
		if(hashNode.word.charAt(0) == ' ')
			hashTable.get(26).add(hashNode);
		else if(hashNode.word.charAt(0) == '-')
			hashTable.get(27).add(hashNode);
		else
			hashTable.get(hashNode.word.toLowerCase().charAt(0) - 'a').add(hashNode);
	}
	public void insert(String str, String mean, double frequency) {
		insert(new HashNode(str, mean, frequency));
	}
	public void insert(String str, String mean) {
		insert(new HashNode(str, mean, 0));
	}
	public void remove(String str) {
		if(str.charAt(0) == ' ') {
			for(int i = 0; i < hashTable.get(26).size(); i++) {
				if(hashTable.get(26).get(i).word.equals(str)) {
					hashTable.get(26).remove(i);
				}
			}
		}
		else if(str.charAt(0) == '-') {
			for(int i = 0; i < hashTable.get(27).size(); i++) {
				if(hashTable.get(27).get(i).word.equals(str)) {
					hashTable.get(27).remove(i);
				}
			}
		}
		else {
			for(int i = 0; i < hashTable.get(str.toLowerCase().charAt(0) - 'a').size(); i++) {
				if(hashTable.get(str.toLowerCase().charAt(0) - 'a').get(i).word.equals(str)) {
					hashTable.get(str.toLowerCase().charAt(0) - 'a').remove(i);
				}
			}
		}
	}
	public boolean revise(String str , String mean) {
		if(str.charAt(0) == ' ') {
			for(int i = 0; i < hashTable.get(26).size(); i++) {
				if(hashTable.get(26).get(i).word.equals(str)) {
					hashTable.get(26).get(i).meaning = mean;
				}
			}
		}
		else if(str.charAt(0) == '-') {
			for(int i = 0; i < hashTable.get(27).size(); i++) {
				if(hashTable.get(27).get(i).word.equals(str)) {
					hashTable.get(27).get(i).meaning = mean;
				}
			}
		}
		else {
			for(int i = 0; i < hashTable.get(str.toLowerCase().charAt(0) - 'a').size(); i++) {
				if(hashTable.get(str.toLowerCase().charAt(0) - 'a').get(i).word.equals(str)) {
					hashTable.get(str.toLowerCase().charAt(0) - 'a').get(i).meaning = mean;
				}
			}
		}
		return false;
	}
	public String find(String str) {
		List<HashNode> templist;
		HashNode tempNode = null;
		if(str.charAt(0) == ' ') {
			templist = hashTable.get(26);
			for(int i = 0; i < templist.size(); i++) {
				if(templist.get(i).word.equals(str)) {
					tempNode = templist.get(i);
				}
			}
		}
		else if(str.charAt(0) == '-') {
			templist = hashTable.get(27);
			for(int i = 0; i < templist.size(); i++) {
				if(templist.get(i).word.equals(str)) {
					tempNode = templist.get(i);
				}
			}
		}
		else {
			templist = hashTable.get(str.toLowerCase().charAt(0) - 'a');
			for(int i = 0; i < templist.size(); i++) {
				if(templist.get(i).word.equals(str)) {
					tempNode = templist.get(i);
				}
			}
		}
		if(tempNode == null)
			return "Î´ÕÒµ½";
		else
			return tempNode.meaning;
	}
	public boolean if_find(String str) {
		List<HashNode> templist;
		if(str.charAt(0) == ' ') {
			templist = hashTable.get(26);
			for(int i = 0; i < templist.size(); i++) {
				if(templist.get(i).word.equals(str)) {
					return true;
				}
			}
		}
		else if(str.charAt(0) == '-') {
			templist = hashTable.get(27);
			for(int i = 0; i < templist.size(); i++) {
				if(templist.get(i).word.equals(str)) {
					return true;
				}
			}
		}
		else {
			templist = hashTable.get(str.toLowerCase().charAt(0) - 'a');
			for(int i = 0; i < templist.size(); i++) {
				if(templist.get(i).word.equals(str)) {
					return true;
				}
			}
		}
		return false;
	}
	public ReciteNode getReciteNode(){
		ReciteNode tempnode = new ReciteNode();
		Random r = new Random();
		int num1,num2;
		num1 = (int)(r.nextDouble() * 26);
		num2 = (int)(r.nextDouble() * hashTable.get(num1).size() - 1);
		tempnode.meaning = hashTable.get(num1).get(num2).meaning;
		tempnode.word = hashTable.get(num1).get(num2).word;
		tempnode.wrongmeaning[3] = hashTable.get(num1).get(num2).meaning;
		for(int i = 0; i < 3; i++) {
			tempnode.wrongmeaning[i] = Randommeanning();
		}
		return tempnode;
	}
	private String Randommeanning() {
		Random r = new Random();
		int num1,num2;
		num1 = (int)(r.nextDouble() * 26);
		num2 = (int)(r.nextDouble() * (hashTable.get(num1).size() - 1));
		return hashTable.get(num1).get(num2).meaning;
	}
}
