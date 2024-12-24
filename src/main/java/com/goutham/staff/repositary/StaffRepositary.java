package com.goutham.staff.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goutham.staff.entity.Staff;

@Repository
public interface StaffRepositary extends JpaRepository<Staff, Long> {

}
