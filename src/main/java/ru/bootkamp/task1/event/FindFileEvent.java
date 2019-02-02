package ru.bootkamp.task1.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author Yuriy Bochkarev
 * @since 02.02.2019.
 */

@Getter
public class FindFileEvent extends ApplicationEvent {

    private String message;

    public FindFileEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}
