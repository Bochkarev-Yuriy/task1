package ru.bootkamp.task1.adapter.impl;

import org.springframework.stereotype.Component;
import ru.bootkamp.task1.adapter.FileAdapter;
import ru.bootkamp.task1.entity.FileEntity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author Yuriy Bochkarev
 * @since 02.02.2019.
 */

@Component
public class FileAdapterImpl implements FileAdapter {

    public FileEntity fileToFileEntity(File file) throws IOException {
        FileEntity entity = new FileEntity();
        entity.setName(file.getName());
        entity.setFile(Files.readAllBytes(file.toPath()));
        return entity;
    }
}
