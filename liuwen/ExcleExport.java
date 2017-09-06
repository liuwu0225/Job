package demo;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcleExport {
	
	private static List<DemoEntity> getEntity(){
		List<DemoEntity> list = new ArrayList<DemoEntity>();
		DemoEntity entity1 = new DemoEntity("张三","21","北京","程序员","篮球");
		DemoEntity entity2 = new DemoEntity("李四","18","上海","学生","排球");
		DemoEntity entity3 = new DemoEntity("王五","24","广州","律师","足球");
		list.add(entity1);
		list.add(entity2);
		list.add(entity3);
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//表明
		String ExcleName = "Demo";
		//表头数据
		List<String> list = new ArrayList<String>();
		
		list.add("Object 1");
		list.add("Object 2");
		list.add("Object 3");
		list.add("Object 4");
		list.add("Object 5");
		
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
		//写入数据
		List<DemoEntity> data = ExcleExport.getEntity();
		for(int i=0;i<data.size();i++){
			row = sheet.createRow(i+1);
			DemoEntity demoEntity = data.get(i);
			List<String> dataList = new ArrayList<String>();
			dataList.add(demoEntity.getObject1());
			dataList.add(demoEntity.getObject2());
			dataList.add(demoEntity.getObject3());
			dataList.add(demoEntity.getObject4());
			dataList.add(demoEntity.getObject5());
			for(int j=0;j<list.size();j++){
				row.createCell(j).setCellValue(dataList.get(j));
			}
		}
		
		//导出数据
		try{
			FileOutputStream fos = new FileOutputStream("C:/Users/Liu/Desktop/ExcelUtil/"+ExcleName+".xls");
			wb.write(fos);
		}catch (Exception e) {
			System.out.println("111");
			e.getStackTrace();
		}
		
	}

}
