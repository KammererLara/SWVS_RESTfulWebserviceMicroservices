import { Component, OnInit } from '@angular/core';
import { MeasurementService } from '../../services/measurement.service';
import { Measurement } from '../../models/measurement.model';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-measurements',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './measurements.component.html',
  styleUrls: ['./measurements.component.css']
})
export class MeasurementsComponent implements OnInit {
  measurements: Measurement[] = [];

  constructor(private measurementService: MeasurementService) {}

  ngOnInit(): void {
    this.measurementService.getAllMeasurements().subscribe(
      (data: Measurement[]) => {
        console.log('Empfangene Daten:', data); // Debug-Ausgabe
        this.measurements = data;
      },
      (error) => {
        console.error('Fehler beim Laden der Daten:', error);
      }
    );
  }
}
