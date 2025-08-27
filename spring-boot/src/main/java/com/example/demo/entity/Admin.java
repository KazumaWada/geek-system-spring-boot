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
	
//	@OneToOne
//	@JoinColumn(name = "shop_id")// テーブルを明記せずにshop_idだけで、usersテーブルのSQLを参照して自動で認識してくれている。
//	private Long shopId;

	@Column(name = "shop_id")
	private Integer shopId; // DBはintだから、long(bigint)にすると、整合性が取れない。
	
	//役職
	@Column(name = "position", nullable = false)
	private String position;
	
//	@OneToOne
//	@JoinColumn(name = "role_id")// テーブルを明記せずにshop_idだけで、usersテーブルのSQLを参照して自動で認識してくれている。
//	private Role role;
	
	@Column(name = "last_name", nullable = false)
	private String lastName; //lastnameではなくてDBカラムと統一したほうがいい。
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "phone_number", nullable = false)
	private Long phoneNumber;
	
	@Column(name = "age", nullable = false)
	private Integer age;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	
}










