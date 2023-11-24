package Utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BitToImg {
     static public ImageIcon createImageIcon(byte[] imageData) {
        try {
            if (imageData != null) {
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageData));
                return new ImageIcon(image.getScaledInstance(500, 500, Image.SCALE_SMOOTH));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
