package ru.bootkamp.task1.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.bootkamp.task1.service.FileBlackAndWhiteService;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Yuriy Bochkarev
 * @since 02.02.2019.
 */

@Service
public class FileBlackAndWhiteServiceImpl implements FileBlackAndWhiteService {

    @Value("${file.processed.directory}")
    private String fileProcessedDirectory;

    @Value("${file.old.directory}")
    private String fileOldDirectory;

    public File processingFile(File file) throws IOException {
        BufferedImage orginalImage = ImageIO.read(file);
        BufferedImage blackAndWhiteImg = new BufferedImage(
                orginalImage.getWidth(), orginalImage.getHeight(),
                BufferedImage.TYPE_BYTE_BINARY);
        Graphics2D graphics = blackAndWhiteImg.createGraphics();
        graphics.drawImage(orginalImage, 0, 0, null);
        File processedFile = new File(fileProcessedDirectory + file.getName());
        ImageIO.write(blackAndWhiteImg, "bmp", processedFile);
        file.renameTo(new File(fileOldDirectory + file.getName()));
        return processedFile;

    }
}
