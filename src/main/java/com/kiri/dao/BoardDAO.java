package com.kiri.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kiri.dto.BoardDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession session;

	// ���� �� �� ���� ��������
	public List<BoardDTO> selectBoardList(String user_email) throws Exception{
		return session.selectList("myPageMapper.selectBoardList",user_email);
	}	
	
	// ��ü �Խñ� ���� ��������
	public List<Map<String,Object>> selectTotalBoardList(String user_email) throws Exception{
		return session.selectList("myPageMapper.selectTotalBoardList",user_email);
	}
	
	// �Ϲ� �Խ��� ���� �̾ƿ���
	public int selectBoardCount(String user_email) throws Exception{
		return session.selectOne("myPageMapper.selectBoardCount",user_email);
	}	
	
	// �Ϲ� �Խ��� ����
	public int boardDelete(int seq_board) throws Exception{
		return session.delete("myPageMapper.boardDelete",seq_board);
	}
	
	// �˻����� �Ϲݱ� ���� ��������
	public List<BoardDTO> genalSearchList(String category, String keyword,String user_email) throws Exception{
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("category", category);
		map.put("keyword", keyword);
		map.put("user_email", user_email);
		
		System.out.println(map);
		return session.selectList("myPageMapper.genalSearchList",map);
	}
}
