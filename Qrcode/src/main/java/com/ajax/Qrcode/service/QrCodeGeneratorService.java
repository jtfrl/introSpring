package com.ajax;
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
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;


@Service
public class QrCodeGeneratorService {



    public String generateAndSaveQrCode(String text){
        String projectRoot=System.getProperty("user.dir");
        QRCodeWriter QRCodeWriter= new QRCodeWriter();

        BitMatrix bitMatrix=QRCodeWriter.encode(text, BarcodeFormat.QR_CODE, width->250, height->250);

        Path directory=Paths.get(projectRoot, "qrcodes");

        Files.createDirectories(directory);

        String fileName="qrcodes "+System.currentTimeMillis()+".png"; // monitora o tempo

        Path path=directory.resolve(fileName);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

        return path.toAbsolutePath().toString();
    }
}
