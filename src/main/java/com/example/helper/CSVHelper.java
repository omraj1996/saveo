package com.example.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.Medicine;

@Component
public class CSVHelper {
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "c_name", "c_batch_no", "d_expiry_date", "n_balance_qty", "c_packaging",
			"c_unique_code", "c_schemes", "n_mrp", "c_manufacturer", "hsn_code" };

	public static boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<Medicine> csvToMedicines(InputStream is)  {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			List<Medicine> medicines = new ArrayList<Medicine>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				Medicine medicine = new Medicine(
						csvRecord.get("c_name"),
			            csvRecord.get("c_batch_no"),
			            csvRecord.get("d_expiry_date"),
			            csvRecord.get("n_balance_qty"),
			            csvRecord.get("c_packaging"),
			            Long.parseLong(csvRecord.get("c_unique_code")),
			            csvRecord.get("c_schemes"),
			            Double.parseDouble(csvRecord.get("n_mrp")),
			            csvRecord.get("c_manufacturer"),
			            csvRecord.get("hsn_code")
						
				);

				medicines.add(medicine);
			}

			return medicines;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}

}