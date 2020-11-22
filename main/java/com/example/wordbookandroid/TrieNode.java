package com.example.wordbookandroid;

public class TrieNode {
	boolean isStr;
	String word;
	String meaning;
	double frequency;
	TrieNode[] nodes;
	TrieNode() {
		isStr = false;
		nodes = new TrieNode[28];
		meaning = "";
		frequency = 0;
	}
}
