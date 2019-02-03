package ru.bootkamp.task1.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Yuriy Bochkarev
 * @since 02.02.2019.
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "file")
public class FileEntity {

    //    @Id
//    @TableGenerator(name = "file_entity_gen",
//            table = "sequences",
//            pkColumnName = "seq_name",
//            valueColumnName = "seq_count",
//            pkColumnValue = "file",
//            allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "file_entity_gen")
//    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column(name = "file_name")
    private String name;

    @Column(name = "file_data")
    private byte[] file;


}
