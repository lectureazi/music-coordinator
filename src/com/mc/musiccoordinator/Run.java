package com.mc.musiccoordinator;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.mc.musiccoordinator.presentation.Menu;

import java.io.FileOutputStream;
import java.io.IOException;

public class Run {
    public static void main(String[] args)  {
        new Menu().main();
    }
}
