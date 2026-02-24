//package com.ajax;
package com.ajax.Qrcode.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;


@Service
public class QrCodeGeneratorService {

    public String generateAndSaveQrCode(String text){

    try{
        String projectRoot=System.getProperty("user.dir");
        QRCodeWriter qrCodeWriter= new QRCodeWriter();

        int width=250;
        int height=250;
        BitMatrix bitMatrix=qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path directory=Paths.get(projectRoot, "qrcodes");

        Files.createDirectories(directory);

        String fileName="qrcodes "+System.currentTimeMillis()+".png"; // monitora o tempo

        Path path=directory.resolve(fileName);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

        return path.toAbsolutePath().toString();
    }catch (WriterException | IOException e){
        e.printStackTrace();
        return "ERRO: "+e.getMessage();
    }
    }
}
