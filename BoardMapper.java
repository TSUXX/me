package com.del.test_project_1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.del.test_project_1.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	@Insert("""
			insert into board(id, title, contents, date) values(#{id},#{title},#{contents},now()) 
			""")
	@Options (useGeneratedKeys = true, keyProperty = "index")
	public int postBoard(BoardDTO boardDTO);
	
	
	@Select("""
			select * from board order by index desc;
			""")
	public List<BoardDTO> getList();
}

