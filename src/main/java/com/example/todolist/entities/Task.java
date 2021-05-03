package com.example.todolist.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_TASK")
public class Task implements Serializable {

    private static final long serialVersionUID = -8725525066784793727L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "STATUS")
    private TaskStatus status;
    @Column(name = "DATE_CREATE")
    private LocalDateTime creationDate;
    @Column(name = "DATE_UPDATE")
    private LocalDateTime updateDate;
    @ManyToOne
    private User user;

}
