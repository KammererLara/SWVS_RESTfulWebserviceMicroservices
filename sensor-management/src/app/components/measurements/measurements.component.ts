import { Component, OnInit } from '@angular/core';
import { MeasurementService } from '../../services/measurement.service';
import { Measurement } from '../../models/measurement.model';


@Component({
  selector: 'app-measurements',
  standalone: false,
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
