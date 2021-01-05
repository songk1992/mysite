package com.bitacademy.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.mysite.repository.GuestbookRepository;
import com.bitacademy.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {

	@Autowired
	private GuestbookRepository guestbookRepository;

	public List<GuestbookVo> getMessageList() {
		return guestbookRepository.findAll();
	}

	public void writeMessage(GuestbookVo vo) {
		
		System.out.println("B" + vo);
		
		guestbookRepository.insert(vo);
		
		Long no = vo.getNo();
		System.out.println("A" + vo);
	}

	public void deleteMessage(GuestbookVo vo) {
		guestbookRepository.delete(vo);
	}
}