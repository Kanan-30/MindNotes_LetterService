package org.example.letters_service.repository;

import org.example.letters_service.model.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LetterRepository extends JpaRepository<Letter, Long> {
    List<Letter> findByCategory(String category); // ✅ Updated to use String
}
