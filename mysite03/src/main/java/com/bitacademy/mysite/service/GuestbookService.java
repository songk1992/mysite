package com.bitacademy.mysite.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.mysite.repository.GuestbookRepository;
import com.bitacademy.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	private static final Log LOGGER = LogFactory.getLog(GuestbookService.class);

	@Autowired
	private GuestbookRepository guestbookRepository;

	public List<GuestbookVo> getMessageList() {
		return guestbookRepository.findAll();
	}

	public void writeMessage(GuestbookVo vo) {
		
		LOGGER.info("B" + vo);
		
		guestbookRepository.insert(vo);
		
		Long no = vo.getNo();
		LOGGER.info("A" + vo);
	}

	public boolean deleteMessage(GuestbookVo vo) {
		int count = guestbookRepository.delete(vo);
		return count == 1;
	}

	public List<GuestbookVo> getMessageList(Long startNo) {
		return guestbookRepository.findAll(startNo);
	}

	public boolean deleteMessage(Long no, String password) {
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(no);
		vo.setPassword(password);
		return deleteMessage(vo);
		// TODO Auto-generated method stub
		
	}
}