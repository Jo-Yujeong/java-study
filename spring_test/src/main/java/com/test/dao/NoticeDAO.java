package com.test.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dto.NoticeDTO;

@Repository
public class NoticeDAO {
	@Autowired
	SqlSessionTemplate session;
	
	public List<NoticeDTO> list() throws Exception{
		return session.selectList("com.config.NoticeMapper.list");
	}
	
	public int write(NoticeDTO dto) throws Exception{
		return session.insert("com.config.NoticeMapper.write", dto);
	}
	
	public NoticeDTO findByNo(int no) throws Exception{
		return session.selectOne("com.config.NoticeMapper.findByNo", no);
	}
	
	public int update(NoticeDTO dto) throws Exception{
		return session.update("com.config.NoticeMapper.update", dto);
	}
	
	public int delete(NoticeDTO dto) throws Exception{
		return session.delete("com.config.NoticeMapper.delete", dto);
	}
	
	public List<NoticeDTO> findBySearch(HashMap<String, String> map) throws Exception{
		return session.selectList("com.config.NoticeMapper.findBySearch", map);
	}
	
	public int increaseCnt(NoticeDTO dto) throws Exception{
		return session.update("com.config.NoticeMapper.increaseCnt", dto);
	}
}
