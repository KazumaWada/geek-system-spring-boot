package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

// DBの形をアプリケーションように落とし込んだファイル
//Controllerで定義したModelの変数からここに到達する

@Entity
@Data
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class) //日時の自動入力用
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "last_name", nullable = false)
	private String last_name; //lastnameではなくてDBカラムと統一したほうがいい。
	
	@Column(name = "first_name", nullable = false)
	private String first_name;
	
	@Column(name = "position", nullable = false)
	private Integer position;
	
	@Column(name = "age", nullable = false)
	private Integer age;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "role", nullable = false)
	private String roles;
}










