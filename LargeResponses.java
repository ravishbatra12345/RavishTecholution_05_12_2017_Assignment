package com.ravi.assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LargeResponses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fileName = sc.nextLine();
		sc.close();

		int minBytes = 5000;
		String delimiter = " ";
		String outFilePrefix = "bytes_";

		try {
			processFile(fileName, minBytes, delimiter, outFilePrefix);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void processFile(String fileName, int minBytes,
			String delimiter, String outFilePrefix) throws IOException {
		// Considering that the file is in the same path as that of this
		// program
		BufferedReader reader = null;
		PrintWriter writer = null;
		String currentLine = null;
		long size = 0;
		long sum = 0;
		int noOfRequests = 0;

		try {
			// Read File from "res" folder
			ClassLoader loader = LargeResponses.class.getClassLoader();
			reader = new BufferedReader(new FileReader(loader.getResource(
					fileName).getFile()));

			// *** If file must be read from an absolute path, comment above
			// code and uncomment below line. Code to create new file will also
			// change accordingly
			// reader = new BufferedReader(new FileReader(fileName));

			// Assuming that each line contains all the required fields from 1
			// to 7 (see doc). Also assuming that there are no breaks in-between
			// lines
			while ((currentLine = reader.readLine()) != null) {
				String[] parts = currentLine.split(delimiter);
				size = Long.parseLong(parts[parts.length - 1]);

				if (size > minBytes) {
					noOfRequests++;
					sum += size;
				}
			}

			// Create File and write to it
			// Create a file in project/current directory
			writer = new PrintWriter(outFilePrefix + fileName, "UTF-8");
			writer.println(noOfRequests);
			writer.println(sum);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (reader != null) {
				reader.close();
			}

			if (writer != null) {
				writer.close();
			}
		}
	}
}
