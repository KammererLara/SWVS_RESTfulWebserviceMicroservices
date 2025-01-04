import { bootstrapApplication } from '@angular/platform-browser';
import { HttpClient, provideHttpClient } from '@angular/common/http';
import { provideRouter } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { appRoutes } from './app/app.routes';
import { AppComponent } from './app/app.component';
import { importProvidersFrom } from '@angular/core';

bootstrapApplication(AppComponent, {
  providers: [
    provideHttpClient(),
    provideRouter(appRoutes),
    importProvidersFrom(ReactiveFormsModule),
  ],
}).then(() => {
  // Test: HttpClient im Hauptthread
  const http = new HttpClient({} as any); // Dummy-Injector
  console.log(http);
}).catch(err => console.error(err));
