package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.form.LoginForm;
import com.example.demo.repository.AdminRepository;

// implでSQLから取得したいデータのロジックを書いて、Serviceで呼び出す。
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
    private AdminRepository adminRepository;
	
	// NOTE: @Overrideを使うことで、このメソッドが実際にインターフェースに呼び出されて実行される際のメソッドとの整合性を保つ。
	// これがなかったらメソッドのスペルミスでもコンパイルされるから、開発者が混乱する。
	@Override
	public void getAdmin(LoginForm loginForm) {
		Admin admin = new Admin();
		admin.setEmail(loginForm.getEmail());
		admin.setRoles(loginForm.getRole());
	}
	
	 //@Override
	 // ここ最初から入っているAdminの場合は、これ使わない。
	 // 後でAdminの新規登録の時にこれを使う。
//	public void saveAdmin(LoginForm adminForm) {
//		Admin admin = new Admin();
//		
//        admin.setLastName(adminForm.getLastName());
//        admin.setFirstName(adminForm.getFirstName());
//        admin.setEmail(adminForm.getEmail());
//        admin.setPassword(adminForm.getPassword());
//        
//        adminRepository.save(admin);
//	}

}
