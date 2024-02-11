package org.example.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.example.model.Ticket;
import org.example.model.User;
import org.example.utils.Data;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private static List<User> users = Data.createUsers();

	public User findById(int uid) {
		return users.stream().filter(user -> user.getUid() == uid).findFirst().orElse(null);
	}

	public List<User> find(User fuser) {
		Predicate<User> condition = user -> true;
		if (fuser == null || fuser.getUid() == 0) {
			return users.stream().collect(Collectors.toList());
		}
		if (fuser.getEmail() != null) {
			condition = condition.and(user -> fuser.getEmail().equals(user.getEmail()));
		}
		if (fuser.getFname() != null) {
			condition = condition.and(user -> fuser.getFname().equals(user.getFname()));
		}
		if (fuser.getLname() != null) {
			condition = condition.and(user -> fuser.getLname().equals(user.getLname()));
		}
		return users.stream().filter(condition::test).collect(Collectors.toList());
	}

	public User create(String fname, String lname, String email) {
		if (fname == null || lname == null || email == null) {
			return null;
		}
		User user = new User(fname, lname, email);
		users.add(user);
		return user;
	}
}
