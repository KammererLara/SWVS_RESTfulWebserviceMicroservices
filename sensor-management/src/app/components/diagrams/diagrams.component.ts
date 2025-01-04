import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ChartConfiguration } from 'chart.js';
import { CommonModule } from '@angular/common';
import { NgChartsModule } from 'ng2-charts';

interface Measurement {
  timestamp: string;
  temperature: number;
  humidity: number;
}

@Component({
  selector: 'app-diagrams',
  standalone: true,
  imports: [CommonModule, NgChartsModule],
  templateUrl: './diagrams.component.html',
  styleUrls: ['./diagrams.component.css']
})
export class DiagramsComponent implements OnInit {
  temperatureChartData: ChartConfiguration<'line'>['data'] = {
    datasets: [],
    labels: []
  };

  humidityChartData: ChartConfiguration<'line'>['data'] = {
    datasets: [],
    labels: []
  };

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get<Measurement[]>('http://localhost:8081/measurementApi/measurements').subscribe(
      (data: Measurement[]) => {
        const timestamps = data.map((item) => item.timestamp);
        const temperatures = data.map((item) => item.temperature);
        const humidities = data.map((item) => item.humidity);

        this.temperatureChartData.labels = timestamps;
        this.temperatureChartData.datasets = [
          { data: temperatures, label: 'Temperature', borderColor: 'red', fill: false }
        ];

        this.humidityChartData.labels = timestamps;
        this.humidityChartData.datasets = [
          { data: humidities, label: 'Humidity', borderColor: 'blue', fill: false }
        ];
      },
      (error) => {
        console.error('Fehler beim Abrufen der Messwerte:', error);
      }
    );
  }
}
