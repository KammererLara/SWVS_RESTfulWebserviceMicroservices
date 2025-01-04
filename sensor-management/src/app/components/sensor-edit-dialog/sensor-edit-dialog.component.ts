import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sensor-edit-dialog',
  standalone: false,
  templateUrl: './sensor-edit-dialog.component.html',
  styleUrls: ['./sensor-edit-dialog.component.css']
})
export class SensorEditDialogComponent {
  sensorForm: FormGroup; 

  constructor(private fb: FormBuilder, private http: HttpClient, private router: Router) {
    this.sensorForm = this.fb.group({
      id: [null],
      name: [''],
      location: [''],
      type: [''],
      active: [true]
    });
  }

  onSubmit() {
    const sensor = this.sensorForm.value;
    if (sensor.id) {
      this.http.put('http://localhost:8080/sensorApi/updateSensor', sensor).subscribe(() => this.router.navigate(['/sensors']));
    } else {
      this.http.post('http://localhost:8080/sensorApi/createSensor', sensor).subscribe(() => this.router.navigate(['/sensors']));
    }
  }
}
