import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TigersComponent } from './tigers/tigers.component';

import { FormsModule } from "@angular/forms";
import { TigerDetailComponent } from './tiger-detail/tiger-detail.component';
import { MessagesComponent } from './messages/messages.component';
import { DashboardComponent } from './dashboard/dashboard.component';

//The AppModel stores metadata about our entire application
//For example, if we want to use teh 2 way property binding feature of the FormsModule,
//we need to imort it in our AppModule
@NgModule({
  declarations: [
    AppComponent,
    TigersComponent,
    TigerDetailComponent,
    MessagesComponent,
    DashboardComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
