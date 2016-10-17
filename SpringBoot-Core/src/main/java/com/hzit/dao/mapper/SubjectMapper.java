package com.hzit.dao.mapper;

import java.util.List;
import java.util.Map;

import com.hzit.dao.vo.SubjectVo;
import org.apache.ibatis.annotations.Param;
import com.hzit.dao.entity.Subject;
import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.Pageable;

public interface SubjectMapper {

	void insertSubject(Subject subject);

	int deleteSubjectBySubjectNo(Integer subjectNo);

	int updateSubject(Subject subject);

	Page<SubjectVo> searchSubjectByParams(@Param("map") Map<String, String> map, Pageable pageable);

	List<SubjectVo> searchSubjectByParams(@Param("map") Map<String, String> map);

} 
