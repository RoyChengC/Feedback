package com.feedback.dao;

import java.util.List;
import java.util.Map;

import com.feedback.domain.TeacherIn;
import com.feedback.domain.TeacherOut;
import com.feedback.domain.TeacherSchool;
import com.feedback.state.TeacherQueryState;

public interface InputFileMapper {

	public void inputTeacherIn(Map<String, Object> map);
	public void inputTeacherOut(Map<String, Object> map);
	public void inputTeacherSchool(Map<String, Object> map);
	public List<TeacherIn> getTeacherIn(Map<String, Object> map);
	public List<TeacherOut> getTeacherOut(Map<String, Object> map);
	public List<TeacherSchool> getTeacherSchool(Map<String, Object> map);
	public int queryTIMaxCount();
	public int queryTOMaxCount();
	public int queryTSMaxCount();
	public void inputStudentInfo(Map<String, Object> map);
}
