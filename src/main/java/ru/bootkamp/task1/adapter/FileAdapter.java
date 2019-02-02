package ru.bootkamp.task1.adapter;

import ru.bootkamp.task1.entity.FileEntity;

import java.io.File;
import java.io.IOException;

/**
 * @author Yuriy Bochkarev
 * @since 02.02.2019.
 */

public interface FileAdapter {

    FileEntity fileToFileEntity(File file) throws IOException;
}
