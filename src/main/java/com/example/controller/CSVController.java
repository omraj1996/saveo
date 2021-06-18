package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.dao.Purchase;
import com.example.dao.PurchaseResponse;
import com.example.helper.CSVHelper;
import com.example.message.ResponseMessage;
import com.example.model.Medicine;
import com.example.service.CSVService;
import com.example.service.CheckoutService;


@CrossOrigin("http://localhost:8080")
@Controller
@RequestMapping("/api")
public class CSVController {

	@Autowired
	CSVService fileService;
	
	@Autowired
	private CheckoutService checkoutService;

	@PostMapping("/uploadCSV")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";

		if (CSVHelper.hasCSVFormat(file)) {
			try {
				fileService.save(file);

				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}

		message = "Please upload a csv file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}

	@GetMapping("/medicines")
	public ResponseEntity<List<Medicine>> getAllMedicine() {
		try {
			List<Medicine> medicines = fileService.getAllMedicine();

			if (medicines.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(medicines, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/serachMedicine/{medicine}")
	public ResponseEntity<List<Medicine>> searchMedicine(@PathVariable String medicine) {
		try {
			List<Medicine> medicines = fileService.searchMedicine(medicine);

			if (medicines.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(medicines, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getMedicineDetails/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) {
		try {
			Medicine medicine = fileService.getMedicineById(id);
			return new ResponseEntity<>(medicine, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/placeorder")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }

}