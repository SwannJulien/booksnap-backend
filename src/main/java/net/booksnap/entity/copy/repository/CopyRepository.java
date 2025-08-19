package net.booksnap.entity.copy.repository;

import net.booksnap.entity.copy.Copy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CopyRepository extends JpaRepository<Copy, Long> {

    // Additional query methods can be defined here if needed
    // For example, to find copies by book ID or status:
    // List<Copy> findByBookId(Long bookId);
    // List<Copy> findByStatus(Status status);
}
