import { Component, OnInit } from '@angular/core';
import { MeasurementService } from '../../services/measurement.service';
import { Measurement } from '../../models/measurement.model';

@Component({
  selector: 'app-measurements',
  templateUrl: './measurements.component.html',
  styleUrls: ['./measurements.component.css']
})
export class MeasurementsComponent implements OnInit {
  measurements: Measurement[] = [];

  constructor(private measurementService: MeasurementService) {}

  ngOnInit(): void {
    this.loadMeasurements();
  }

  loadMeasurements(): void {
    this.measurementService.getMeasurements().subscribe(data => {
      this.measurements = data;
    });
  }

  addMeasurement(): void {
    const newMeasurement: Measurement = { _id: '', sensorId: '1', value: Math.random() * 100, timestamp: new Date().toISOString() };
    this.measurementService.addMeasurement(newMeasurement).subscribe(() => {
      this.loadMeasurements();
    });
  }
}
