package com.frontend.fe.util;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import au.com.bytecode.opencsv.CSVReader;

public class DataProviders {

	@DataProvider(name = "CSV")
	public static Iterator<Object[]> csvDataProvider(Method m) {

		String csvFilePath = buildCsvFilePath(m);
		CSVReader reader = null;

		List<Object[]> lines = null;
		try {
			reader = new CSVReader(new FileReader(csvFilePath));

			String[] line = null;
			lines = new ArrayList<>();

			while ((line = reader.readNext()) != null) {
				lines.add(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lines.iterator();
	}

	private static String buildCsvFilePath(Method m) {
		String testDataFolderName = "src/test/java/resources/test-data";
		String fileExtension = ".csv";
		String fileSeparator = File.separator;
		String className = m.getDeclaringClass().getSimpleName().toLowerCase();
		String methodName = m.getName();

		return testDataFolderName + fileSeparator + className + fileSeparator + methodName + fileExtension;
	}

}
