package ru.bootkamp.task1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.bootkamp.task1.event.FindFileEvent;
import ru.bootkamp.task1.service.FileService;
import ru.bootkamp.task1.service.FindFileService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Yuriy Bochkarev
 * @since 02.02.2019.
 */

@Service
public class FindFileServiceImpl implements FindFileService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public List<File> findFileByDirectory(String directory) {
        List<File> files = new ArrayList<>();
        for (File fileEntry : Objects.requireNonNull(new File(directory).listFiles())) {
            if (fileEntry.isDirectory()) {
                findFileByDirectory(fileEntry.getAbsolutePath());
            } else {
                files.add(new File(directory + fileEntry.getName()));
            }
        }
        applicationEventPublisher.publishEvent(new FindFileEvent(new FindFileServiceImpl(), "find files"));
        return files;
    }
}
