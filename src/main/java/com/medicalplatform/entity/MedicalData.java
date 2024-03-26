package com.medicalplatform.entity;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * 3D数据
 */
import javax.persistence.*;

import java.util.Date;
import java.util.Calendar;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

@Entity
@Table(name = "medical_data")
public class MedicalData implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dataId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String source;

    @Column(nullable = false)
    private String filePath;

    @Column(name = "upload_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp uploadTime;


    // Getters and setters

}
