import { Component, OnInit } from '@angular/core';
import { SensorService } from '../../services/sensor.service';
import { Sensor } from '../../models/sensor.model';


@Component({
  selector: 'app-sensors',
  standalone: false,
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
