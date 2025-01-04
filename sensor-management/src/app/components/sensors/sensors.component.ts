import { Component, OnInit } from '@angular/core';
import { SensorService } from '../../services/sensor.service';
import { Sensor } from '../../models/sensor.model';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';


@Component({
  selector: 'app-sensors',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './sensors.component.html',
  styleUrls: ['./sensors.component.css']
})
export class SensorsComponent implements OnInit {
  sensors: Sensor[] = [];

  constructor(private sensorService : SensorService ) {}

  ngOnInit(): void {
    this.sensorService.getAllSensors().subscribe((data: Sensor[]) => {
      this.sensors = data;
    });
  }
}
