package net.booksnap.domain.copy.repository;

import net.booksnap.domain.copy.Copy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CopyRepository extends JpaRepository<Copy, Long> {
     List<Copy> findAllByBookId(Long bookId);
    // List<Copy> findByStatus(Status status);
}
