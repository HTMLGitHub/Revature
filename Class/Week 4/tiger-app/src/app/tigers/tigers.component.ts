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

  getAllTigers():void
  {
    this.tigerService.getTigers().subscribe(retrivedTigers=>this.tigers = retrivedTigers);
  }

  add(name:string):void
  {
    name=name.trim();

    if(!name){return;}

    this.tigerService.addTiger({name} as Tiger).subscribe(tiger=>{this.tigers.push(tiger)});
  }

  delete(tiger: Tiger): void
  {
    //validation logic to remove it from teh displayed list
    this.tigers = this.tigers.filter(t => t !== tiger); //we're using filter() method to say, only the cats that 
    //are not equal to the tiger passed through can stay

    this.tigerService.deleteTiger(tiger).subscribe();
  }
}