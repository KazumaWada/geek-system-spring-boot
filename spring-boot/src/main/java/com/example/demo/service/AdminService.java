package com.example.demo.service;

import com.example.demo.form.LoginForm;

// ここでimplのSQLロジックを呼び出す。
public interface AdminService {
	void getAdmin(LoginForm loginForm);
}