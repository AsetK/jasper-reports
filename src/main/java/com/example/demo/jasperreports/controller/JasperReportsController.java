package com.example.demo.jasperreports.controller;

import com.example.demo.jasperreports.entity.Person;
import com.example.demo.jasperreports.repository.PersonRepository;
import com.example.demo.jasperreports.service.PDFReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class JasperReportsController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PDFReportService pdfReportService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/pdfreport")
    public String reportPDF() throws FileNotFoundException, JRException {
//        https://www.youtube.com/watch?v=pc4lfKm8NLY
        pdfReportService.createReportAsPDFFileOnDisk();
        return "PDF Report Created";
    }

    @GetMapping(value = "/pdfreport2", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody byte[] reportPDF2() throws FileNotFoundException, JRException {
        return pdfReportService.createReportAsPDFBytesInMemory();
    }
}
