package com.java96.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java96.dto.Criteria;
import com.java96.dto.ReplyDTO;
import com.java96.mapper.ReplyMapper;
import com.java96.mapper.TodoMapper;
@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper mapper; 
	
	@Autowired
	private TodoMapper todoMapper; 
	
	@Transactional
	@Override
	public void register(ReplyDTO dto) {
		
		mapper.create(dto);
		todoMapper.updateReplyCnt(dto.getTno());
		
	}
	@Override
	public ReplyDTO get(Integer rno) {
		// TODO Auto-generated method stub
		return mapper.read(rno) ; 
	}
	@Override
	public void remove(Integer rno) {
		// TODO Auto-generated method stub
		mapper.delete(rno);
	}
	@Override
	public void update(ReplyDTO dto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<ReplyDTO> listPage(Criteria cri) {
		
		return mapper.list(cri) ; 
	}

}
