package ru.bootkamp.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bootkamp.task1.entity.FileEntity;

/**
 * @author Yuriy Bochkarev
 * @since 02.02.2019.
 */

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
