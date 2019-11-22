package com.readFile.java;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Reader {

	public static Map<String, Integer> isSeenBefore;
	public static String[] arrOfWords;
	public static String everything = "";

	public static void readDataFromFile(String text) {

		BufferedReader br;

		try {

			br = new BufferedReader(new FileReader("src.data/file.txt"));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}

			everything = sb.toString();
			arrOfWords = everything.split(" ");
			isSeenBefore(arrOfWords);
			pickTheWord(text);

			br.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void isSeenBefore(String[] array) {

		isSeenBefore = new HashMap<String, Integer>();

		for (String singleWord : array) {

			if (!singleWord.isEmpty()) {

				String w = singleWord.trim();

				if (isSeenBefore.containsKey(w)) {
					isSeenBefore.put(w, isSeenBefore.get(w) + 1);
				} else {
					isSeenBefore.put(w, 1);
				}
			}

		}

	}

	public static void pickTheWord(String userInputText) {

		Set<String> keySet = isSeenBefore.keySet();

		if (userInputText.equalsIgnoreCase("all")) {

			for (String key : keySet) {
				System.out.println(

						"Word " + key.toUpperCase() + " been seen in a file : " + isSeenBefore.get(key) + " times");

			}

		} else if (userInputText.equalsIgnoreCase("stop")) {

			System.out.println("Thank you!");
		}

		else {

			if (isSeenBefore.containsKey(userInputText)) {
				System.out.println(
						"Word " + userInputText.toUpperCase() + " been seen in a file : " + isSeenBefore.get(userInputText) + " times");

			} else {
				System.out.println(
						"Word " + userInputText.toUpperCase() + " been seen in a file : " + isSeenBefore.get(userInputText) + " times");

			}

		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String text = "";

		System.out.println("Hello and welcome to the FILE_READER" + "\n");

		System.out.println("Please choose one of the following options:" + "\n");

		System.out.println(
				"If you would like to see how many times all word appears up in a file: ---------> Please type ALL and hit enter");

		System.out.println(
				"If you would like to see how many times a word appears up in a file: ----------> Please choose the word and hit enter");

		System.out.println("If you done: ---------> Please type STOP");

		do {

			text = sc.nextLine();

			readDataFromFile(text);

		} while (!text.equalsIgnoreCase("stop"));

	}

}
