import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from '../components/home/home.component';

// Routes tells the Router which view to display when a user clicks a
// link or pases a URL into the browser
const routes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: HomeComponent
  },
];

@NgModule({
  // forRoot() method supplies the service providers and directives needed for
  // routing and prrforms the initial navigation based on the browser URL
  imports: [RouterModule.forRoot(routes)],
  // AppRoutingModule exports RouterModule so it will be available throughout the
  // app
  exports: [RouterModule]
})

// AppRoutingModule imports RouterModule and Routes so the app can have
// routing functinality.
export class AppRoutingModule { }
