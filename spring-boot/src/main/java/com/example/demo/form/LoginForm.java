package com.example.demo.form;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
// Serializableをimportする。
public class LoginForm implements Serializable {
	// HTMLからformで送信される時に、ここで定義した全てのカラムが選択されていないと、バインドされずにエラーになる。
	// だから、HTMLのformごとに新しいform.javaを作成する必要がある。
	
	@NotBlank
	@Email
	private String email;
	
	private String role;
//
//	@NotBlank
//	private String password; // これってspring securityで自動的にやってくれるっけ？
}
