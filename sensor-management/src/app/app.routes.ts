import { Routes } from '@angular/router';
import { SensorsComponent } from './components/sensors/sensors.component';
import { MeasurementsComponent } from './components/measurements/measurements.component';

export const routes: Routes = [
  { path: '', redirectTo: 'sensors', pathMatch: 'full' },
  { path: 'sensors', component: SensorsComponent },
  { path: 'measurements', component: MeasurementsComponent }
];
