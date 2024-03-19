package com.medicalplatform.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 渚相玉
 * @verion 2.6.5
 * @Session Study
 */
@Entity
@Table(name = "medical_device")
@Data
public class MedicalDevice {
    //id自动生成
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "name", nullable = false)
    private String devicename;

    @Column(name = "type", nullable = false)
    private String devicetype;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    public MedicalDevice(String id, String devicename, String devicetype, String description, String manufacturer) {
        this.id = id;
        this.devicename = devicename;
        this.devicetype = devicetype;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public MedicalDevice() {

    }
}
