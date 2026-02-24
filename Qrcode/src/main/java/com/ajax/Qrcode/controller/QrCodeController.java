package com.ajax.Qrcode.controller;
//package com.ajax.Qrcode;
//package com.ajax.Qrcode.service;

//import com.ajax.QrCodeGeneratorService; 
import com.ajax.Qrcode.service.QrCodeGeneratorService; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController; 
// os três imports anteriores cuidam dos annotations principais desse arquivo .java
import org.springframework.web.bind.annotation.*; 


@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeGeneratorService qrCodeGeneratorService;

    public QrCodeController(QrCodeGeneratorService qrCodeGeneratorService){
        this.qrCodeGeneratorService=qrCodeGeneratorService;
    }

    @GetMapping
    public ResponseEntity<String> generator(@RequestParam String text){
        try{
            String path=this.qrCodeGeneratorService.generateAndSaveQrCode(text);
            return ResponseEntity.ok("QR gerado com sucesso! Caminho: "+ path);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("ERRO: falha em gerar QR code: "+e.getMessage());
        }

    }
    
}
