package com.example.demo.controler;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author lyf
 * @Date 2019/10/19 12:51 下午
 * @Description:
 */
@RestController
@RequestMapping("/deptV")
public class TestController {
    @RequestMapping(value = "/export/pdf2")
    public void downloadRequisitionPDF2(final ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<TableEntity> tableEntities = new ArrayList<>();
        //手输
        for(int i=0;i<3;i++) {
            TableEntity tableEntity = new TableEntity();
            tableEntity.setPRINT_DEPT_NAME("科室名称"+i);
            tableEntity.setPATIENT_NAME("h34234");
            tableEntity.setPATIENT_ID("123123");
            tableEntities.add(tableEntity);
        }
//        for(RecPrintReserveEntity t:recPrintReserveEntities){
//            TableEntity tableEntity = new TableEntity();
//            tableEntity.setPrint_dept_name(t.getPrintDeptName());
//            tableEntity.setPatient_name(t.getPatientName());
//            tableEntity.setPatient_id(t.getPatientId());
//            tableEntities.add(tableEntity);
//        }
        //模拟数据源
        JRDataSource jrDataSource = new JRBeanCollectionDataSource(tableEntities);

        HashMap<String, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("ireport", "其他参数测试");
        //此处demo直接使用的磁盘绝对路径了,实际生产老实取文件路径
        File reporeFile = new File("C:\\Users\\Administrator\\Desktop\\report2.jasper");
//        JasperHelper.showPdf("导出测试.pdf", reporeFile.getPath(), request, response, objectHashMap, jrDataSource);
//        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.150.52:1521/emrdemo", "medqc", "medqc");
//  JasperHelper.showPdf("导出测试.pdf", reporeFile.getPath(), request, response, objectHashMap, connection);
        JasperHelper.showPdf("导出测试.pdf", reporeFile.getPath(), request, response, objectHashMap, jrDataSource);
    }

    @RequestMapping(value = "/life")
    public String downloadRequisitionPDF2() {
        return "鸡掰郎";
    }
}
