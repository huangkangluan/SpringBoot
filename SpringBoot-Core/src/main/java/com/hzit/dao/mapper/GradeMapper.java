package com.hzit.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.hzit.dao.entity.Grade;
import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.Pageable;

public interface GradeMapper {

	void insertGrade(Grade grade);

	void deleteGradeByGradeId(Integer gradeId);

	void updateGrade(Grade grade);

	Page<Grade> searchGradeByParams(@Param("map") Map<String, String> map, Pageable pageable);

	List<Grade> searchGradeByParams(@Param("map") Map<String, String> map);

} 
