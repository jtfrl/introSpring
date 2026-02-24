package com.ajax.Qrcode.controller;

import com.ajax.QrCodeGeneratorService;
import com.ajax.Qrcode.service.QrCodeGeneratorService;


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
