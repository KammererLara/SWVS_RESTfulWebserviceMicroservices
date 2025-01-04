import { Routes } from '@angular/router';
import { SensorsComponent } from './components/sensors/sensors.component';
import { SensorEditDialogComponent } from './components/sensor-edit-dialog/sensor-edit-dialog.component';
import { MeasurementsComponent } from './components/measurements/measurements.component';
import { DiagramsComponent } from './components/diagrams/diagrams.component';

export const appRoutes: Routes = [
  { path: '', redirectTo: '/sensors', pathMatch: 'full' },
  { path: 'sensors', component: SensorsComponent },
  { path: 'sensors/edit/:id', component: SensorEditDialogComponent },
  { path: 'measurements', component: MeasurementsComponent },
  { path: 'diagrams', component: DiagramsComponent }
];
