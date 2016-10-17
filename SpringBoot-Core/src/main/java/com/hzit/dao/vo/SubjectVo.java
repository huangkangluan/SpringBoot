package com.hzit.dao.vo;

/**
 * 
 * @author huang
 */
public class SubjectVo {
	/**
	 *  科目编号
	 */
	private Integer subjectNo;
	/**
	 *  科目名称
	 */
	private String subjectName;
	/**
	 *  课时数
	 */
	private Integer classHour;
	/**
	 *  所属年级
	 */
	private Integer gradeId;
	/**
	 * 科目编号
	 * @param subjectNo
	 */
	private String gradeName;

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public void setSubjectNo(Integer subjectNo){
		this.subjectNo = subjectNo;
	}
	
    /**
     * 科目编号
     * @return Integer
     */	
    public Integer getSubjectNo(){
    	return subjectNo;
    }
	/**
	 * 科目名称
	 * @param subjectName
	 */
	public void setSubjectName(String subjectName){
		this.subjectName = subjectName;
	}
	
    /**
     * 科目名称
     * @return String
     */	
    public String getSubjectName(){
    	return subjectName;
    }
	/**
	 * 课时数
	 * @param classHour
	 */
	public void setClassHour(Integer classHour){
		this.classHour = classHour;
	}
	
    /**
     * 课时数
     * @return Integer
     */	
    public Integer getClassHour(){
    	return classHour;
    }
	/**
	 * 所属年级
	 * @param gradeId
	 */
	public void setGradeId(Integer gradeId){
		this.gradeId = gradeId;
	}
	
    /**
     * 所属年级
     * @return Integer
     */	
    public Integer getGradeId(){
    	return gradeId;
    }
}