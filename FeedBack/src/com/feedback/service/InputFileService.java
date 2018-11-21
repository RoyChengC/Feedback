package com.feedback.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.feedback.dao.InputFileMapper;
import com.feedback.domain.TeacherIn;
import com.feedback.domain.TeacherOut;
import com.feedback.domain.TeacherSchool;
import com.feedback.state.TeacherQueryState;
import com.feedback.util.WebUtil;

@Service
@Scope("singleton")
public class InputFileService {
	@Resource
	private InputFileMapper inputFileDao;
	
	public void inputTeacherInfo(MultipartFile file, String path) {
		
		try {
			System.out.println(path);
			FileInputStream fileInputStream = new FileInputStream(path);
			BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
			XSSFWorkbook workbook = new XSSFWorkbook(bufferedInputStream);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int lastRowIndex = sheet.getLastRowNum();
			int columnNum = sheet.getRow(0).getPhysicalNumberOfCells();
			Map<String, Object> map = new HashMap<>();
			
			// teacherin
			if (columnNum == 19) {
				for (int i = 1; i <= lastRowIndex; i++) {
					XSSFRow row = sheet.getRow(i);
					if (row == null) break;
					
					row.getCell(0).setCellType(CellType.STRING);
					map.put("tino", row.getCell(0).getStringCellValue());
					
					map.put("tipsw", row.getCell(0).getStringCellValue());
					map.put("tiname", row.getCell(1).getStringCellValue());
					row.getCell(2).setCellType(CellType.STRING);
					map.put("title", row.getCell(2).getStringCellValue());
					map.put("tiprofession", row.getCell(3).getStringCellValue());
					map.put("tischolar", row.getCell(4).getStringCellValue());
					map.put("ticome", row.getCell(5).getStringCellValue());
					map.put("birthyear", row.getCell(6).getDateCellValue());
					map.put("tischool", row.getCell(7).getStringCellValue());
					map.put("tioversea", row.getCell(8).getStringCellValue());
					map.put("tibackground", row.getCell(9).getStringCellValue());
					map.put("tiwork", row.getCell(10).getStringCellValue());
					map.put("tiscpaper", row.getCell(11).getNumericCellValue());
					map.put("titeapaper", row.getCell(12).getNumericCellValue());
					map.put("tipatent", row.getCell(13).getNumericCellValue());
					map.put("tisoft", row.getCell(14).getNumericCellValue());
					map.put("tisp", row.getCell(15).getNumericCellValue());
					map.put("tiprize", row.getCell(16).getStringCellValue());
					map.put("tireward", row.getCell(17).getStringCellValue());
					map.put("tiarch", row.getCell(18).getStringCellValue());
					map.put("ico", "无");
					
					inputFileDao.inputTeacherIn(map);
				}
			} else if (columnNum == 12) {
				// teacherout
				for (int i = 1; i <= lastRowIndex; i++) {
					XSSFRow row = sheet.getRow(i);
					if (row == null) break;
					
					row.getCell(0).setCellType(CellType.STRING);
					map.put("tono", row.getCell(0).getStringCellValue());
					
					map.put("toname", row.getCell(1).getStringCellValue());
					map.put("toinstitution", row.getCell(2).getStringCellValue());
					map.put("totype", row.getCell(3).getStringCellValue());
					map.put("toprofession", row.getCell(4).getStringCellValue());
					map.put("toscholar", row.getCell(5).getStringCellValue());
					map.put("toyear", row.getCell(6).getStringCellValue());
					map.put("toschool", row.getCell(7).getStringCellValue());
					map.put("totech", row.getCell(8).getStringCellValue());
					map.put("towork", row.getCell(9).getStringCellValue());
					map.put("tolicense", row.getCell(10).getStringCellValue());
					row.getCell(11).setCellType(CellType.STRING);
					map.put("totel", row.getCell(11).getStringCellValue());
					map.put("topsw", row.getCell(0).getStringCellValue());
					map.put("ico", "无");
					
					inputFileDao.inputTeacherOut(map);
				}
				
			} else if (columnNum == 20) {
				// teacherschool
				for (int i = 1; i <= lastRowIndex; i++) {
					XSSFRow row = sheet.getRow(i);
					if (row == null) break;
					
					row.getCell(0).setCellType(CellType.STRING);
					map.put("tsno", row.getCell(0).getStringCellValue());
					
					map.put("tsname", row.getCell(1).getStringCellValue());
					map.put("tstype", row.getCell(2).getStringCellValue());
					map.put("tsprofession", row.getCell(3).getStringCellValue());
					map.put("tsdepartment", row.getCell(4).getStringCellValue());
					map.put("tsscholar", row.getCell(5).getStringCellValue());
					map.put("birthyear", row.getCell(6).getDateCellValue());
					map.put("tsschool", row.getCell(7).getStringCellValue());
					map.put("tsoversea", row.getCell(8).getStringCellValue());
					map.put("tsbackground", row.getCell(9).getStringCellValue());
					map.put("tswork", row.getCell(10).getStringCellValue());
					map.put("tsscpaper", row.getCell(11).getNumericCellValue());
					map.put("tspatent", row.getCell(12).getNumericCellValue());
					map.put("tssoft", row.getCell(13).getNumericCellValue());
					map.put("tssp", row.getCell(14).getNumericCellValue());
					map.put("tsteapaper", row.getCell(15).getNumericCellValue());
					map.put("tsprize", row.getCell(16).getStringCellValue());
					map.put("tsreward", row.getCell(17).getStringCellValue());
					map.put("tsarch", row.getCell(18).getStringCellValue());
					row.getCell(19).setCellType(CellType.STRING);
					map.put("tstel", row.getCell(19).getStringCellValue());
					map.put("tspsw", row.getCell(0).getStringCellValue());
					map.put("ico", "无");
					
					inputFileDao.inputTeacherSchool(map);
				}
				
			}
			
			bufferedInputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<TeacherIn> getTeacherIn(TeacherQueryState state) {
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", state.getCurPage() * WebUtil.MAX_PAGE_LINES);
		map.put("rowCount", WebUtil.MAX_PAGE_LINES);
		List<TeacherIn> list = inputFileDao.getTeacherIn(map);
		return list;
	}
	
	public List<TeacherOut> getTeacherOut(TeacherQueryState state) {
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", state.getCurPage() * WebUtil.MAX_PAGE_LINES);
		map.put("rowCount", WebUtil.MAX_PAGE_LINES);
		List<TeacherOut> list = inputFileDao.getTeacherOut(map);
		return list;
	}
	
	public List<TeacherSchool> getTeacherSchool(TeacherQueryState state) {
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", state.getCurPage() * WebUtil.MAX_PAGE_LINES);
		map.put("rowCount", WebUtil.MAX_PAGE_LINES);
		List<TeacherSchool> list = inputFileDao.getTeacherSchool(map);
		return list;
	}
	
	public int getTILastPage(TeacherQueryState state) {
		int count = inputFileDao.queryTIMaxCount();
		int maxPage = (count + WebUtil.MAX_PAGE_LINES - 1) / WebUtil.MAX_PAGE_LINES;
		int lastPage = (maxPage > 0) ? maxPage - 1 : 0;
		return lastPage;
	}

	public int getTOLastPage(TeacherQueryState teacherOutState) {
		int count = inputFileDao.queryTOMaxCount();
		int maxPage = (count + WebUtil.MAX_PAGE_LINES - 1) / WebUtil.MAX_PAGE_LINES;
		int lastPage = (maxPage > 0) ? maxPage - 1 : 0;
		return lastPage;
	}

	public int getTSLastPage(TeacherQueryState teacherSchoolState) {
		int count = inputFileDao.queryTSMaxCount();
		int maxPage = (count + WebUtil.MAX_PAGE_LINES - 1) / WebUtil.MAX_PAGE_LINES;
		int lastPage = (maxPage > 0) ? maxPage - 1 : 0;
		return lastPage;
	}

	public List<TeacherIn> getTeacherInByPage(TeacherQueryState tiState, String page) {
		int curPage = tiState.getCurPage();
		switch (page) {
		case "0":
			curPage = 0;
			break;
		case "prev":
			if (curPage > 0) curPage--;
			break;
		case "next":
			if (curPage < tiState.getLastPage()) curPage++;
			break;
		default:
			curPage = tiState.getLastPage();
			break;
		}
		tiState.setCurPage(curPage);
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", tiState.getCurPage() * WebUtil.MAX_PAGE_LINES);
		map.put("rowCount", WebUtil.MAX_PAGE_LINES);
		
		List<TeacherIn> list = inputFileDao.getTeacherIn(map);
		return list;
	}

	public List<TeacherSchool> getTeacherSchoolByPage(TeacherQueryState tsState, String page) {
		int curPage = tsState.getCurPage();
		switch (page) {
		case "0":
			curPage = 0;
			break;
		case "prev":
			if (curPage > 0) curPage--;
			break;
		case "next":
			if (curPage < tsState.getLastPage()) curPage++;
			break;
		default:
			curPage = tsState.getLastPage();
			break;
		}
		tsState.setCurPage(curPage);
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", tsState.getCurPage() * WebUtil.MAX_PAGE_LINES);
		map.put("rowCount", WebUtil.MAX_PAGE_LINES);
		
		List<TeacherSchool> list = inputFileDao.getTeacherSchool(map);
		return list;
	}

	public List<TeacherOut> getTeacherOutByPage(TeacherQueryState toState, String page) {
		int curPage = toState.getCurPage();
		switch (page) {
		case "0":
			curPage = 0;
			break;
		case "prev":
			if (curPage > 0) curPage--;
			break;
		case "next":
			if (curPage < toState.getLastPage()) curPage++;
			break;
		default:
			curPage = toState.getLastPage();
			break;
		}
		toState.setCurPage(curPage);
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", toState.getCurPage() * WebUtil.MAX_PAGE_LINES);
		map.put("rowCount", WebUtil.MAX_PAGE_LINES);
		
		List<TeacherOut> list = inputFileDao.getTeacherOut(map);
		return list;
	}

	public void inputStudentInfo(MultipartFile file, String path) {
		
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
			XSSFWorkbook workbook = new XSSFWorkbook(bufferedInputStream);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int lastRowIndex = sheet.getLastRowNum();
			int columnNum = sheet.getRow(0).getPhysicalNumberOfCells();
			Map<String, Object> map = new HashMap<>();
			
			for (int i = 1; i <= lastRowIndex; i++) {
				XSSFRow row = sheet.getRow(i);
				if (row == null) break;
			
				row.getCell(0).setCellType(CellType.STRING);
				map.put("sno", row.getCell(0).getStringCellValue());
				map.put("sname", row.getCell(1).getStringCellValue());
				map.put("cnname", row.getCell(2).getStringCellValue());
				map.put("spsw", row.getCell(0).getStringCellValue());
				map.put("ice", "无");
				map.put("status", 0);
				
				inputFileDao.inputStudentInfo(map);
			}
			bufferedInputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}	
}
