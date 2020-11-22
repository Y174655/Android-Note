package com.example.wordbookandroid;

public class HashNode {
	String word;
	String meaning;
	double frequency;
	public HashNode() {
		word = "";
		meaning = "";
		frequency = 0;
	}
	public HashNode(String word, String meaning)
	{
		this.word = word;
		this.meaning = meaning;
		this.frequency = 0;
	}
	public HashNode(String word, String meaning, double frequency)
	{
		this.word = word;
		this.meaning = meaning;
		this.frequency = frequency;
	}
}
