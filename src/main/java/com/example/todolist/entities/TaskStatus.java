package com.example.todolist.entities;

import lombok.Getter;

@Getter
public enum TaskStatus {
    PENDING(1),
    COMPLETED(2);

    private int code;

    TaskStatus(int code) {
        this.code = code;
    }

}
