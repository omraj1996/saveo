package com.example.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.exception.ResourceNotFoundException;
import com.example.helper.CSVHelper;
import com.example.model.Medicine;
import com.example.repository.MedicineRepository;

@Service
public class CSVService {
	@Autowired
	MedicineRepository repository;

	public void save(MultipartFile file)  {
		try {
			List<Medicine> medicines = CSVHelper.csvToMedicines(file.getInputStream());
			repository.saveAll(medicines);
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}

	public List<Medicine> getAllMedicine() {
		return repository.findAll();
	}

	public List<Medicine> searchMedicine(String medicine) {
		//Medicine med= repository.findOne();
		//String likePattern = "%"+medicine+"%";
		return repository.findByNameContaining(medicine);
	}

	public Medicine getMedicineById(Long id) {
		return repository.findById(id)
	              .orElseThrow(() -> new ResourceNotFoundException("Medicine", "id", id));
	}
}