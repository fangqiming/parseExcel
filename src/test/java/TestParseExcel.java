import excelUtil.ParseWorkBook;
import excelUtil.WorkBookFactory;
import excelUtil.excelDataObj.InboundGoods;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by fangiming on 2017/9/27.
 */
public class TestParseExcel {

    @Test
    public void TestParseExcel(){
        System.out.println(new Date().getTime());
        String path="D:\\测试批量导入.xlsx";
        Workbook workbook= WorkBookFactory.createWorkBook(new File(path));
        List<InboundGoods> obj= ParseWorkBook.getExcelRowData(workbook, InboundGoods.class);
        System.out.println(obj);
        System.out.println(new Date().getTime());
    }
}
