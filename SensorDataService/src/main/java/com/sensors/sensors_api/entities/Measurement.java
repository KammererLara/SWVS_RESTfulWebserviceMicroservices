package com.sensors.sensors_api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;

    @Column(nullable = false)
    private Timestamp timestamp;
    private Double temperature;
    private Double humidity;

    // Getter und Setter
//    public int getId() { return id; }
//    public void setId(int id) { this.id = id; }
//    public Sensor getSensor() { return sensor; }
//    public void setSensor(Sensor sensor) { this.sensor = sensor; }
//    public Timestamp getTimestamp() { return timestamp; }
//    public void setTimestamp(Timestamp timestamp) { this.timestamp = timestamp; }
//    public Double getTemperature() { return temperature; }
//    public void setTemperature(Double temperature) { this.temperature = temperature; }
//    public Double getHumidity() { return humidity; }
//    public void setHumidity(Double humidity) { this.humidity = humidity; }
}
