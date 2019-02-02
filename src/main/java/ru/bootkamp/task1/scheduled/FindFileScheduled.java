package ru.bootkamp.task1.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.bootkamp.task1.adapter.FileAdapter;
import ru.bootkamp.task1.service.FileBlackAndWhiteService;
import ru.bootkamp.task1.service.FileService;
import ru.bootkamp.task1.service.FindFileService;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Yuriy Bochkarev
 * @since 02.02.2019.
 */

@Component
public class FindFileScheduled {

    @Value("${file.source.directory}")
    private String fileSourceDirectory;

    @Value("${file.processed.directory}")
    private String fileProcessedDirectory;

    @Value("${file.old.directory}")
    private String fileOldDirectory;

    private final FileService fileService;
    private final FileAdapter fileAdapter;
    private final FindFileService findFileService;
    private final FileBlackAndWhiteService fileBlackAndWhiteService;

    @Autowired
    public FindFileScheduled(FileService fileService, FileAdapter fileAdapter, FindFileService findFileService, FileBlackAndWhiteService fileBlackAndWhiteService) {
        this.fileService = fileService;
        this.fileAdapter = fileAdapter;
        this.findFileService = findFileService;
        this.fileBlackAndWhiteService = fileBlackAndWhiteService;
    }

    @Scheduled(cron = "${find.file.scheduled}")
    private void execute() {
        List<File> sourceFiles = findFileService.findFileByDirectory(fileSourceDirectory);

        for (File file : sourceFiles) {
            try {
                File processingFile = fileBlackAndWhiteService.processingFile(file);
                fileService.saveFile(fileAdapter.fileToFileEntity(processingFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
