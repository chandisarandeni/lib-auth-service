package com.sarasavi.lib_auth_service.repository;

import com.sarasavi.lib_auth_service.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
