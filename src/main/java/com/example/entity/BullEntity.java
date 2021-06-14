package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name="BulletinBoarder")
public class BullEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Date createDate;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String createUser;
}
