package com.example.demo.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.services.Servcice;
import com.example.demo.users.Itens;
import com.example.demo.users.Search;
import com.example.demo.users.Users;


@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	public Servcice server;
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	@GetMapping("/home")
	public String homepage(Model model)
	{
		model.addAttribute("lists", server.getallitem());
		return "newform";
	}
	
	@GetMapping("/saveform")
	public String saveform()
	{
		return "saveform";
	}
	
	@PostMapping("/saveuser")
	public String sveUser(@ModelAttribute Users user)
	{
		server.saveUser(user);
		return "home";
	}
	
	@PostMapping("/getuser")
	public String getuser(@ModelAttribute Users user, Model model)
	{
		model.addAttribute("lists", server.getallitem());
		return server.getUser(user);
	}
	
	@GetMapping("/getsaveitempage")
	public String getsaveitempage()
	{
		return "saveitems";
	}
	@PostMapping("/saveitem")
	public String saveitem(@ModelAttribute Itens items, Model model)
	{
		server.saveItem(items);
		model.addAttribute("lists", server.getallitem());
		 return "newform";
	}
	
	@PostMapping("/search")
	public String searchitem(@ModelAttribute Search keyword,  Model model)
	{
		model.addAttribute("lists", server.searchitem(keyword.getKeyword()));
		return "newform";
	}
	
	@GetMapping("/whishlist/{id}")
	public String saveitem(@PathVariable Integer id, Model model)
	{
		 server.saveBucket(id,0);
		 model.addAttribute("lists", server.getallitem());
		 return "newform";
	}
	
	@GetMapping("/ordereditems/{id}")
	public String orderitem(@PathVariable Integer id,Model model)
	{
		 server.saveBucket(id,1);
		 model.addAttribute("lists", server.getallitem());
		 return "newform";
	}
	
	@GetMapping("/myitems")
	public String myitem(Model model)
	{
		model.addAttribute("myitem", server.myitem());
		return "myitems";
	}
	
	@GetMapping("/logout")
	public String logout()
	{
		server.logout();
		return "home";
	}
}
