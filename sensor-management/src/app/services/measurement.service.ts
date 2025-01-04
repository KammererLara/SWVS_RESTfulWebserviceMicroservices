import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Measurement } from '../models/measurement.model';

@Injectable({
  providedIn: 'root'
})
export class MeasurementService {
  private apiUrl = 'http://localhost:8081/measurementApi';

  constructor(private http: HttpClient) {}

  getAllMeasurements(): Observable<Measurement[]> {
    return this.http.get<Measurement[]>(`${this.apiUrl}/measurements`);
  }

  createMeasurement(measurement: Measurement): Observable<Measurement> {
    return this.http.post<Measurement>(`${this.apiUrl}/createMeasurement`, measurement);
  }
  
  updateMeasurement(measurement: Measurement): Observable<Measurement> {
    return this.http.put<Measurement>(`${this.apiUrl}/measurement`, measurement);
  }

  deleteMeasurement(id: number): Observable<Measurement> {
    return this.http.delete<Measurement>(`${this.apiUrl}/measurement/${id}`);
  }
}
