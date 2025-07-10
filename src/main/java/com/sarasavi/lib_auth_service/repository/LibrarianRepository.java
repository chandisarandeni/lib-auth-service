package com.sarasavi.lib_auth_service.repository;

import com.sarasavi.lib_auth_service.entity.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {
}
