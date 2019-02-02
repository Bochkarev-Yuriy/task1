package ru.bootkamp.task1.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.bootkamp.task1.event.FindFileEvent;

/**
 * @author Yuriy Bochkarev
 * @since 02.02.2019.
 */

@Component
public class FindFileListener implements ApplicationListener<FindFileEvent> {

    @Override
    public void onApplicationEvent(FindFileEvent event) {
        System.out.println("Received spring custom event - " + event.getMessage());
    }
}
