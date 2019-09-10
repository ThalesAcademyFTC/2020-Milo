package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

public class BuildUtil {

    private String version;
    private HardwareMap map;

    public BuildUtil(HardwareMap map) {
        this.map = map;
    }

    public String getVersion() {
        if (version != null) return version;
        try {
            File file = new File(map.appContext.getPackageCodePath());
            FileInputStream input = new FileInputStream(file);
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int data = input.read();
            while (data != -1) {
                buffer.write(data);
                data = input.read();
            }
            MessageDigest digest = MessageDigest.getInstance("SHA1");
            return digest.digest(buffer.toByteArray()).toString();
        }
        catch (Throwable e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
