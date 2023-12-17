package com.selfpractic.repository;

import com.selfpractic.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, String> {
    // Additional custom methods can be declared here if needed
}