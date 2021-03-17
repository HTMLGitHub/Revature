import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TigerService } from '../services/tiger.service';
//import { CallTracker } from 'node:assert';
import { Tiger } from "../tiger";
@Component({
  selector: 'app-tiger-detail',
  templateUrl: './tiger-detail.component.html',
  styleUrls: ['./tiger-detail.component.css']
})
export class TigerDetailComponent implements OnInit
{

  //we use the '@Input' decorator to specity that this particular property
  //can be input from another source
  //@Input() tiger?: Tiger;

  //we use the '@Input' decorator to specity that this particular property
  //can be input from another source
  //@Input() tiger?: Tiger;
  tiger!: Tiger;


  constructor(private tigerService: TigerService, private route: ActivatedRoute, private location: Location) { }

  ngOnInit(): void 
  {
    //when the component 
  }

  //this method will extract the cat by grabbing the id from the parameter
  //then calling the tigerService and finding that tiger witin  the mock DB
  getTiger():void
  {

  }

}
