import { Component, OnInit } from '@angular/core';
import {Tiger} from '../tiger';
import { TIGERS } from "../mock-tigers";
import { TigerService } from '../services/tiger.service';
import { MessageService} from '../services/message.service';

//the component decorator labels this class as a component and its metadata
@Component({
  selector: 'app-tigers',
  templateUrl: './tigers.component.html',
  styleUrls: ['./tigers.component.css']
})
export class TigersComponent implements OnInit 
{
 //this is a property 

tigers: Tiger[] = [];
//the '?' allows us to leave this propery as 'undefined'
selectedTiger?: Tiger; 



  constructor(private tigerService: TigerService, private messageService: MessageService)
  {

  } 

  //this is a liveCycle Hook, which means when the component is loaded and initalized, some methods will be created
  ngOnInit(): void 
  {
    this.getAllTigers();
  }

  //this method will be expressed in our html template (tiger.coponent.html)\
  //when we select a tiger, it gets assigned as a specific property (selectedTiger? property)
  onSelect(tiger: Tiger): void
  {
    this.selectedTiger = tiger;
    
    //everytime we click on a Tiger Item, we add to the messages inside the MessageService.
    //--> It will say "You click on a Tiger with the Id of {id}"
    this.messageService.add("Inside TigersComponent");
    this.messageService.add(`You clicked on Tiger: ${tiger.name} with ID: ${tiger.id}`);
  }
  //this method will retrieve all the tigers by using the Service that we've injected into this componet
  //currently this is a sycrhrounous 
  
  //getAllTigers():void
  //{
  //  this.tigers = this.tigerService.getTigers();
 //}

  getAllTigers():void
  {
    this.tigerService.getTigers().subscribe(retrivedTigers=>this.tigers = retrivedTigers);
  }
}