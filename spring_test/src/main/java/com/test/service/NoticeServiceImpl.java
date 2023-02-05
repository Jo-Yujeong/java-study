package com.test.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.NoticeDAO;
import com.test.dto.NoticeDTO;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	NoticeDAO dao;
	
	@Override
	public List<NoticeDTO> list() throws Exception {
		return dao.list();
	}

	@Override
	public int write(NoticeDTO dto) throws Exception {
		return dao.write(dto);
	}
	
	@Override
	public NoticeDTO findByNo(int no) throws Exception{
		return dao.findByNo(no);
	}

	@Override
	public int update(NoticeDTO dto) throws Exception {
		return dao.update(dto);
	}

	@Override
	public int delete(NoticeDTO dto) throws Exception {
		return dao.delete(dto);
	}

	@Override
	public List<NoticeDTO> findBySearch(HashMap<String, String> map) throws Exception {
		return dao.findBySearch(map);
	}

	@Override
	public int increaseCnt(NoticeDTO dto) throws Exception {
		return dao.increaseCnt(dto);
	}
}
