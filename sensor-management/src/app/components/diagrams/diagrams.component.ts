import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-diagrams',
  standalone: false,
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
