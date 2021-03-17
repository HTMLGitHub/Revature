import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TigersComponent } from './tigers/tigers.component';
import { DashboardComponent} from './dashboard/dashboard.component';
import { TigerDetailComponent } from './tiger-detail/tiger-detail.component';

const routes: Routes = 
[
  {path: 'everySingleTiger', component: TigersComponent}, //localhost:4200/cats --> my TigersComponent
  //the conon represents a placeholder for a NUMBER that will be injcted later
  {path: 'detail/:id', component: TigerDetailComponent},
  {path: '', component: DashboardComponent}, //this is going to be my default "home" page
  {path:'', redirectTo: '/dashboard', pathMatch: 'full'},
  //this is a wildcard path that allows us to catch garbage endpoint
  {path:'**', redirectTo: '/dashboard'}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule] //the 'exports' keyword makes this RouterModule 'public' and accessable to the rest of hte project
})
export class AppRoutingModule { }
