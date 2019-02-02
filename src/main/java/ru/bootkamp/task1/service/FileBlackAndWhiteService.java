package ru.bootkamp.task1.service;

import java.io.File;
import java.io.IOException;

/**
 * @author Yuriy Bochkarev
 * @since 02.02.2019.
 */

public interface FileBlackAndWhiteService {

    File processingFile(File file) throws IOException;
}
