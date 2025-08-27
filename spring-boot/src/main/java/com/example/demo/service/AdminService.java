package com.example.demo.service;

import com.example.demo.form.LoginForm;
import com.example.demo.form.SignupForm;

// ここでimplのSQLロジックを呼び出す。
public interface AdminService {
	void saveAdmin(SignupForm signupForm);
	void getAdmin(LoginForm loginForm);
}