package excelUtil;


import excelUtil.excelDataObj.AutoTransformation;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.*;

/**
 * Created by fangiming on 2017/9/27.
 */
public class ParseWorkBook {

    private static Logger logger=Logger.getLogger(ParseWorkBook.class);

    public static Map<Integer,Map<Integer,List<String>>> getExcelSheetRowData(Workbook workbook){
       Map<Integer,Map<Integer,List<String>>> result=new HashMap<Integer,Map<Integer,List<String>>>();
        int sheetNum=workbook.getNumberOfSheets();
        for (int i = 0; i < sheetNum; ++i) {
            result.put(i, parseSheet(workbook.getSheetAt(i)));
        }
        return result;
    }


    public  static <T> List<T> getExcelRowData(Workbook workbook,Class<T> klass){
        List<T> result=new ArrayList();
        Map<Integer,Map<Integer,List<String>>> sheetData=getExcelSheetRowData(workbook);
        for(Integer sheetNum : sheetData.keySet()){
            for(Integer rowNum : sheetData.get(sheetNum).keySet()){
                if(rowNum==0)       //首行标题过滤
                    continue;
                try{
                    T target=klass.newInstance();
                    ((AutoTransformation)target).autoTransformation(sheetData.get(sheetNum).get(rowNum));
                    result.add(target);
                }catch(Exception e){
                    e.printStackTrace();
                    logger.error("List<String> Transformation object error "+e);
                }
            }
        }
        return result;
    }

    private static Map<Integer,List<String>> parseSheet(Sheet sheet){
        int rowNum=0;
        Map<Integer,List<String>> result=new HashMap<Integer,List<String>>();
        for (Row row : sheet) {
            result.put(rowNum, parseRow(row));
            rowNum++;
        }
        return result;
    }

    private static List<String> parseRow(Row row) {
        List<String> rst=new ArrayList<String>();
        Cell cell;
        Iterator<Cell> iterator = row.iterator();
        while (iterator.hasNext()) {
            cell = iterator.next();
            cell.setCellType(1);
            rst.add(cell.getStringCellValue());
        }
        return rst;
    }
}
