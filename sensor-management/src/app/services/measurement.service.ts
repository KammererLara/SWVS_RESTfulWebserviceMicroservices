import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MeasurementService {
  private apiUrl = 'http://localhost:8081/measurementApi';

  constructor(private http: HttpClient) {}

  getAllMeasurements(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/measurements`);
  }

  createMeasurement(measurement: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/createMeasurement`, measurement);
  }

  updateMeasurement(measurement: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/measurement`, measurement);
  }

  deleteMeasurement(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/measurement/${id}`);
  }
}
