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
@Table(name = "roles")
@EntityListeners(AuditingEntityListener.class) //日時の自動入力用
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id")
	private Long id;
		
	@Column(name = "name", nullable = false)
	private String name; //lastnameではなくてDBカラムと統一したほうがいい。

}


