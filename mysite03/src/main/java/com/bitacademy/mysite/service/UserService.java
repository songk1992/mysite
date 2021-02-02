package com.bitacademy.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.mysite.repository.UserRepository;
import com.bitacademy.mysite.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public boolean join(UserVo vo) {
		
		System.out.println("B" + vo);
		int count = userRepository.insert(vo);
		System.out.println(vo);
		return count == 1;
	}

	public UserVo getUser(UserVo vo) {
		return userRepository.findByEmailAndPassword(vo);
	}

	public UserVo getUser(Long no) {
		return userRepository.findByNo(no);
	}

	public boolean updateUser(UserVo vo) {
		
		return (userRepository.update(vo) == 1);
		
	}

	public boolean existsEmail(String email) {
		UserVo userVo = userRepository.findByEmail(email);
		return userVo != null;
	}
	
	
}