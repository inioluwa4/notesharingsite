import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from '../components/home/home.component';
import { LoginComponent } from '../components/login/login.component';
import { FindNotesLobbyComponent } from '../components/find-notes-lobby/find-notes-lobby.component';
import { ShareNotesComponent } from '../components/share-notes/share-notes.component';

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
    component: LoginComponent
  },
  {
    path: 'notesharing',
    component: HomeComponent
  },
  {
    path: 'notesharing/find',
    component: FindNotesLobbyComponent
  },
  {
    path: 'notesharing/share',
    component: ShareNotesComponent
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
