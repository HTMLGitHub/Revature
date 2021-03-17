import { Injectable } from '@angular/core';

@Injectable({//I will be injecting this service (this Dependency ) into my MessagesComponent
  providedIn: 'root'
})
export class MessageService {

  //we give it one property -- a string of messages
  messages:string[]=[];

  constructor() { }

  //this message adds a msg to our messages property (whiis is a string array)
  add(msg: string)
  {
    this.messages.push(msg);
  }

  //this method is calle din our TigerService.getTigers()
  //so that we can see everytime 

  //this clears our fake cache
  clear()
  {
    this.messages=[];
  }
}
