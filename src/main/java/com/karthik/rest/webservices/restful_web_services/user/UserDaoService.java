package com.karthik.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> list = new ArrayList<>();
    private static int count = 0;
	
	static {
		
		list.add(new User(++count,"Adam",LocalDate.now().minusYears(30)));
		list.add(new User(++count,"Eve",LocalDate.now().minusYears(25)));
		list.add(new User(++count,"Fork",LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll() {
		return list;
	}

	public User findById(int id) {
		
		 return list.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
	}

	public User save(User user){
		
	    user.setId(++count);
		list.add(user);
		return user;
	}

	public void deleteById(Integer id) {
		
		User user1 = list.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
		list.remove(user1);
		
	}

}
