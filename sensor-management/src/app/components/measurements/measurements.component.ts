import { Component, OnInit } from '@angular/core';
import { MeasurementService } from '../../services/measurement.service';
import { Measurement } from '../../models/measurement.model';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';


@Component({
  selector: 'app-measurements',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './measurements.component.html',
  styleUrls: ['./measurements.component.css']
})
export class MeasurementsComponent implements OnInit {
  measurements: Measurement[] = [];

  constructor(private measurementService : MeasurementService) {}

  ngOnInit(): void {
    this.measurementService.getAllMeasurements().subscribe((data: Measurement[]) => {
      this.measurements = data;
    });
  }
}
