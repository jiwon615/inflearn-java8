package me.whiteship.java.stream;

import me.whiteship.java.optional.Progress;

import java.util.Optional;

public class OnlineClass {
    private Integer id;
    private String title;
    private boolean closed;

    public Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isClosed() {
        return closed;
    }

    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress);
    }
}
