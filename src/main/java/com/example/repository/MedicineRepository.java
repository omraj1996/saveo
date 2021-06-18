package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
	Optional<Medicine> findById(Long id);

	List<Medicine> findByNameContaining(String searchValue);

}
