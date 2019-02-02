package ru.bootkamp.task1.service;

import java.io.File;
import java.util.List;

/**
 * @author Yuriy Bochkarev
 * @since 02.02.2019.
 */

public interface FindFileService {

    List<File> findFileByDirectory(String directory);
}
