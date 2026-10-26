package com.ecommerce.ecommercewebsite.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommercewebsite.Exception.InvalidDetailsException;
import com.ecommerce.ecommercewebsite.Exception.UserAlreadyExsistException;
import com.ecommerce.ecommercewebsite.entity.User;
import com.ecommerce.ecommercewebsite.repository.UserRepository;

@Service
public class UserService {
    @Autowired
	private UserRepository repository;
	//create user
    public User createUser(User user) {
    	Optional<User> opt=repository.findUserByEmail(user.getEmail());
    	if(opt.isPresent())
    		throw new UserAlreadyExsistException();
    	else
    		return repository.save(user);
    }
	//login
    public User LoginUser(String email , String password) {
    	Optional<User> opt=repository.findUserByEmail(email);
    	if(opt.isPresent()) {
    		User user=opt.get();
    		if(user.getPassword().equals(password))
    			return user;
    	}
		throw new InvalidDetailsException();
    }
    
}
