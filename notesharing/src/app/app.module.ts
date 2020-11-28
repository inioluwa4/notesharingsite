import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { UrlService } from './services/url.service';
import { FindNotesLobbyComponent } from './components/find-notes-lobby/find-notes-lobby.component';
import { ShareNotesComponent } from './components/share-notes/share-notes.component';
// import { UploadService } from './services/upload.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    SidebarComponent,
    FindNotesLobbyComponent,
    ShareNotesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    // MDBBootstrapModule.forRoot()


  ],
  providers: [
    UrlService
    // UploadService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
