package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Admin;


// Serviceで定義されたロジックに基づいて流れてきたデータの感じを上手い具合に汲み取って
// 直接DBと会話する。
public interface AdminRepository extends JpaRepository<Admin, Long> {
	List<Admin> findAll();

	Optional<Admin> findByEmail(String email);
}