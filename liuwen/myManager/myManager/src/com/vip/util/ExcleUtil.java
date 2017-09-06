package com.vip.util;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Excel导出通用工具类
 * 
 * @author Wen
 * 
 */
public class ExcleUtil {
	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public  static void excelExport(List<String> list,List<List<Object>> datas){
		//表名
		String ExcleName = "Demo";
		//创建webbook,对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		//在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("表1");
		//在sheet中添加表头第0行
		HSSFRow row = sheet.createRow(0);
		//创建单元格,设置表头,表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		HSSFCell cell;
		for(int i=0;i<list.size();i++){
			cell = row.createCell(i);
			cell.setCellValue(list.get(i));
		}
		for(int i=0;i<datas.size();i++){
			row = sheet.createRow(i+1);
			for(int j=0;j<list.size();j++){
				cell = row.createCell(j);
				cell.setCellValue(datas.get(i).get(j).toString());
			}
		}
		//导出数据
		try{
			//路径从配置文件中获取
			FileOutputStream fos = new FileOutputStream("C:/Users/Liu/Desktop/ExcelUtil/"+ExcleName+".xls");
			wb.write(fos);
			fos.close();
		}catch (Exception e) {
			System.out.println("111");
			e.getStackTrace();
		}
	}

}
