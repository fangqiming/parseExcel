package excelUtil;


import exception.FileTypeNotSupportException;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by fangiming on 2017/9/27.
 */
public class WorkBookFactory {

    private static Logger logger=Logger.getLogger(WorkBookFactory.class);

//   此处为整合Spring文件上传的部分
//    public static Workbook createWorkBook(CommonsMultipartFile file){
//        try{
//            return initWorkBook(file.getOriginalFilename(),file.getInputStream());
//        }catch(IOException e) {
//            logger.error("parse excel error,fileName="+file.getOriginalFilename()+e);
//            System.out.println(e);
//        }
//        return null;
//    }

    public static Workbook createWorkBook(File file){
        try{
            return initWorkBook(file.getName(),new FileInputStream(file));
        }catch(IOException e) {
            logger.error("parse excel error,fileName="+file.getName()+e);
            System.out.println(e);
        }
        return null;
    }

    private static final String oldVersion_Suf=".xls";

    private static final String newVersion_Suf=".xlsx";

    private static Workbook initWorkBook(String fileName,InputStream is)throws IOException {
        Workbook workbook;
        if (fileName.endsWith(oldVersion_Suf)) {
            workbook = new HSSFWorkbook(is);
        } else if (fileName.endsWith(newVersion_Suf)) {
            workbook = new XSSFWorkbook(is);
        }else{
            throw new FileTypeNotSupportException(fileName);
        }
        return workbook;
    }


}
