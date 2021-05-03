package com.example.todolist.entities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TaskStatusConverter implements AttributeConverter<TaskStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TaskStatus category) {
        if (category == null) {
            return null;
        }
        return category.getCode();
    }

    @Override
    public TaskStatus convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }

        return Stream.of(TaskStatus.values())
                .filter(c -> c.getCode() == code)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
