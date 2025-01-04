import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-diagrams',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './diagrams.component.html',
  styleUrls: ['./diagrams.component.css']
})
export class DiagramsComponent implements OnInit {
  temperatureData = [];
  humidityData = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.http.get('http://localhost:8080/measurementApi/chartData').subscribe((data: any) => {
      this.temperatureData = data.temperature;
      this.humidityData = data.humidity;
    });
  }
}
