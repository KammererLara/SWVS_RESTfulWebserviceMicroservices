import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'sensor-management';

  sensors = [
      { _id: '1', name: 'Temperature Sensor', type: 'Temperature', description: 'Measures room temperature' },
      { _id: '2', name: 'Humidity Sensor', type: 'Humidity', description: 'Measures air humidity' },
      { _id: '3', name: 'Pressure Sensor', type: 'Pressure', description: 'Measures air pressure' }
    ];

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
