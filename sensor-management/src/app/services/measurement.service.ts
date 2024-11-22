import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Measurement } from '../models/measurement.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MeasurementService {
  private apiUrl = `${environment.apiUrl}/measurements`;

  constructor(private http: HttpClient) {}

  getMeasurements(): Observable<Measurement[]> {
    return this.http.get<Measurement[]>(this.apiUrl);
  }

  addMeasurement(measurement: Measurement): Observable<Measurement> {
    return this.http.post<Measurement>(this.apiUrl, measurement);
  }
}
