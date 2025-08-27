package com.example.demo.form;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

//Formの入れ物にすぎないから、ここでusers,shopsテーブルを明記したり、認識させる必要はない。
// controllerがこの箱を受け取ってentityへ渡る時に初めてどのテーブルかが認識される。
@Data
// タイムリーフのbindと同じ文字列を記入。
public class SignupForm implements Serializable {
	
	@NotNull
	private Integer shop_id; // ユーザーにはnameを送信してもらうが、idで識別することで、データ量を減らせる。
	
	@NotNull
	private String position;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	@Email
	private String email;
	
	@NotNull
	private Long phoneNumber;
	
	@NotNull
	private Integer age;
	
	@NotBlank
	private String password;
	
	}