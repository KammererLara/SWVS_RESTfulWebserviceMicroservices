import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-sensors',
  imports: [CommonModule],
  templateUrl: './sensors.component.html',
  styleUrls: ['./sensors.component.css']
})
export class SensorsComponent implements OnInit {
  // Mock-Daten
  sensors = [
    { _id: '1', name: 'Temperature Sensor', type: 'Temperature', description: 'Measures room temperature' },
    { _id: '2', name: 'Humidity Sensor', type: 'Humidity', description: 'Measures air humidity' },
    { _id: '3', name: 'Pressure Sensor', type: 'Pressure', description: 'Measures air pressure' }
  ];

  constructor() {}

  ngOnInit(): void {
    console.log('Mock-Daten:', this.sensors);
  }

// Methode, um einen neuen Mock-Sensor hinzuzufügen
  addMockSensor(): void {
    const newSensor = {
      _id: (this.sensors.length + 1).toString(),
      name: `Mock Sensor ${this.sensors.length + 1}`,
      type: 'Mock Type',
      description: 'This is a mock sensor'
    };
    this.sensors.push(newSensor);
  }
}
