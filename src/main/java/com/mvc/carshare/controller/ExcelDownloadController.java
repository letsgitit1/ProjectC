package com.mvc.carshare.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mvc.carshare.service.CSPaymentService;
import com.mvc.carshare.vo.CPaymentDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ExcelDownloadController {
	
	private final CSPaymentService cPaymentService;

    @GetMapping("/download")
    public void downloadExcel(HttpServletResponse response, String getList, String fileName) throws IOException {
        
    	List<CPaymentDTO> dailyList = null;
    	
    	switch (getList) {
		case "dailyList":
				dailyList = cPaymentService.getDaily();
			break;
		case "weeksList":
				dailyList = cPaymentService.getWeeks();
			break;
		case "monthsList":
				dailyList = cPaymentService.getMonths();	
			break;
		case "yearsList":
				dailyList = cPaymentService.getYears();
			break;
		default:
			break;
		}
    	
        // 엑셀 파일 생성
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("sheet 1");
        
        // 테이블 헤더 생성
        Row headerRow = sheet.createRow(0);
        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("날짜");
        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("매출");
        Cell headerCell3 = headerRow.createCell(2);
        headerCell3.setCellValue("이익");
        
        int rowNum = 1;
        for (CPaymentDTO list : dailyList) {
	    	// 데이터 출력
        	int cell = 0;
        	
	        Row row = sheet.createRow(rowNum++);
	        Cell cell1 = row.createCell(cell++);
	        cell1.setCellValue(list.getPayment_date());
	        Cell cell2 = row.createCell(cell++);
	        cell2.setCellValue(list.getPrice());
	        Cell cell3 = row.createCell(cell++);
	        cell3.setCellValue(list.getProfit());
    	}
        
        // 엑셀 파일을 바이트 배열로 변환
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        workbook.write(bos);
        byte[] bytes = bos.toByteArray();
        
        // HTTP 응답 헤더 설정
        
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName +".xlsx\"");
        response.setContentLength(bytes.length);
        
        // HTTP 응답 바디에 바이트 배열 쓰기
        response.getOutputStream().write(bytes);
    }
}
