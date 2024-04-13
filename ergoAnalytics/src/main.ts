import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module'; // Import the root module of your application


platformBrowserDynamic().bootstrapModule(AppModule) // Bootstrap the AppModule
  .catch(err => console.error(err)); // Catch any errors during bootstrap process
