package ru.bootkamp.task1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bootkamp.task1.entity.FileEntity;
import ru.bootkamp.task1.repository.FileRepository;
import ru.bootkamp.task1.service.FileService;

/**
 * @author Yuriy Bochkarev
 * @since 02.02.2019.
 */

@Service
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public void saveFile(FileEntity file) {
        fileRepository.save(file);
    }
}
