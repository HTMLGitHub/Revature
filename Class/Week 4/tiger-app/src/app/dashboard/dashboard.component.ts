import { Component, OnInit } from '@angular/core';
import { TigerService } from '../services/tiger.service';
import { Tiger } from '../tiger';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  //I need to inject a dependency which fetches data for me
  constructor(private tigerService: TigerService) { }

  //whenever the component is loaded/initialized, getTopTigers will be called and we have
  //an array of the top 4 Tigers
  ngOnInit(): void 
  {
    this.getTopTigers();
  }

  topTigers: Tiger[] = [];

  //this method will set our topTigers property to the top 4 tigers on th elist of all tigers
  getTopTigers():void
  {
    //allTigers represents all of the returned from the getTigers() method in the TigerService
    //we use the slice() method which will return the first 4 elements within
    this.tigerService.getTigers().subscribe(allTigers=>this.topTigers = allTigers.slice(0, 4));
  }
}
