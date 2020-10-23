package com.example.demo.jasperreports.service;

import com.example.demo.jasperreports.entity.Person;
import com.example.demo.jasperreports.repository.PersonRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PDFReportService {

    @Autowired
    PersonRepository personRepository;

    public void createReportAsPDFFileOnDisk() throws FileNotFoundException, JRException {
        List<Person> personList = personRepository.findAll();
        JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(personList);

        File file = ResourceUtils.getFile("classpath:person_report.jrxml");
        JasperReport template = JasperCompileManager.compileReport(file.getAbsolutePath());
        Map<String, Object> params = new HashMap<>();
        params.put("createdBy", "AK");
        JasperPrint jasperPrint = JasperFillManager.fillReport(template, params, source);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\AK\\IdeaProjects\\jasper-reports\\src\\main\\resources\\person.pdf");
    }

    public byte[] createReportAsPDFBytesInMemory() throws FileNotFoundException, JRException {
        List<Person> personList = personRepository.findAll();
        JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(personList);

        File file = ResourceUtils.getFile("classpath:person_report.jrxml");
        JasperReport template = JasperCompileManager.compileReport(file.getAbsolutePath());
        Map<String, Object> params = new HashMap<>();
        params.put("createdBy", "AK");
        JasperPrint jasperPrint = JasperFillManager.fillReport(template, params, source);
        byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
        return bytes;
    }

}
