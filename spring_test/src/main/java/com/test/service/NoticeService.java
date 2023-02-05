package com.test.service;

import java.util.HashMap;
import java.util.List;

import com.test.dto.NoticeDTO;

public interface NoticeService {
	public List<NoticeDTO> list() throws Exception;
	public int write(NoticeDTO dto) throws Exception;
	public NoticeDTO findByNo(int no) throws Exception;
	public int update(NoticeDTO dto) throws Exception;
	public int delete(NoticeDTO dto) throws Exception;
	public List<NoticeDTO> findBySearch(HashMap<String, String> map) throws Exception;
	public int increaseCnt(NoticeDTO dto) throws Exception;
}
