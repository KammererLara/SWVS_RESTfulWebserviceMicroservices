import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AppComponent } from './app/app.component';
import { SensorsComponent } from './app/components/sensors/sensors.component';
import { SensorEditDialogComponent } from './app/components/sensor-edit-dialog/sensor-edit-dialog.component';
import { MeasurementsComponent } from './app/components/measurements/measurements.component';
import { DiagramsComponent } from './app/components/diagrams/diagrams.component';
import { appRoutes } from './app/app.routes';


@NgModule({
  declarations: [
    AppComponent,
    SensorsComponent,
    SensorEditDialogComponent,
    MeasurementsComponent,
    DiagramsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(appRoutes),
    CommonModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
