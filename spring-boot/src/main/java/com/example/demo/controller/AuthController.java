package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.LoginForm;

@Controller
public class AuthController {
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@GetMapping({"/login"})
	// ここでLoginFormのmodel,entityを変数Modelで突っ込む。
	public String login(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}
	
	@PostMapping("/login")
	// NOTE: @ModelAttribute: getリクエストでformに渡したModelにデータが入って返ってきたから、変数名は"loginForm"と揃える必要がある。
	public String login(@Validated @ModelAttribute("loginForm") LoginForm loginForm, BindingResult errorResult, HttpServletRequest request) {
     

		if(errorResult.hasErrors()) {
			return "home";
		}
       

		// 一旦ダミーでここのcontrollerに成功したら移動させるページに行って、そこにログインしたユーザーの名前を表示させてみる。
		//formのデータを表示したいから、sessionを書く必要があって、そのsessionをredirect先で使えるようにするため。
		//詳しく分かりたかったら、下の/contact/confirmで、contactFormのsessionデータがModelを返してviewに渡っているかどうか確かめてみるといい。
		HttpSession session = request.getSession();
		// ここでemailしか送信されていないデータをloginsuccessに渡していないから、emailしか表示されない。
		// だからここでDBの完全なカラムを渡す必要がある。別に渡さなくてもあっちでid参考にして取ってくればいいのかな？わからんけど。。
		session.setAttribute("loginForm", loginForm);
		
		return "redirect:/loginsuccess";
		// ↑"一旦ダミーでここのcontrollerに成功したら移動させるページに行って、そこにログインしたユーザーの名前を表示させてみる。"が終わったら、
		// 実際にTOPページへリダイレクトさせる。
		//Httpはconfirmとかしないから必要ないんじゃないかな？
		//return "home";//多分controller通ってidとかでユーザーを判断して表示するから、homeControllerのhome pathへredirectしたほうがいいかも。(←できるのかな？？)
	}
	
	@GetMapping({"/loginsuccess"})
		public String loginSuccess(Model model, HttpServletRequest request) {
		//セッションを取得
				HttpSession session = request.getSession();
				//contactFormに保存されたセッションデータを取得
				LoginForm loginForm = (LoginForm) session.getAttribute("loginForm");
				model.addAttribute("loginForm", loginForm);
			return "loginsuccess";
		}
	
	}


// 一番近い「送信ロジック」はこれかな。
//@GetMapping("/contact")
//public String contact(Model model) {
//
//	model.addAttribute("contactForm", new ContactForm());
//	return "contact";
//}
//

//@PostMapping("/contact")
//public String contact(@Validated @ModelAttribute("contactForm") ContactForm contactForm, BindingResult errorResult,
//		HttpServletRequest request) {
//	if (errorResult.hasErrors()) {
//		return "contact";
//	}
// redirect先でも、contactFormに入っているデータを使えるようにする。
//	HttpSession session = request.getSession();
//	session.setAttribute("contactForm", contactForm);
//
//	return "redirect:/contact/confirm";
//}





