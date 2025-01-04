import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sensor } from '../models/sensor.model';

@Injectable({
  providedIn: 'root'
})

export class SensorService {
  private apiUrl = '/sensorApi';

  constructor(private http: HttpClient) {}

  getAllSensors(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/sensors`);
  }

  createSensor(sensor: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/createSensor`, sensor);
  }

  updateSensor(sensor: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/sensor`, sensor);
  }

  deleteSensor(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/sensor/${id}`);
  }
}
