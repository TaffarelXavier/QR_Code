package com.qr_code;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import javax.swing.JOptionPane;

class Create_QR {

    /**
     *
     * @param qrCodeData A informação
     * @param width 200
     * @param heigth 200
     * @return
     */
    public static String gerarQrCode(String qrCodeData, int width, int height) {
        try {
            String filePath = "D:\\Loja\\Licenciatura em Computação - IFTO\\2º PERÍODO\\QR_CODE\\QRCODE\\chillyfacts.png";

            String charset = "UTF-8"; // or "ISO-8859-1"

            Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<>();

            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

            BitMatrix matrix = new MultiFormatWriter().encode(
                    new String(qrCodeData.getBytes(charset), charset), BarcodeFormat.QR_CODE, width, height, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                    .lastIndexOf('.') + 1), new File(filePath));
            return "QR Code image created successfully!";
        } catch (Exception | ExceptionInInitializerError e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção", 1);
        }
        return null;
    }
}
