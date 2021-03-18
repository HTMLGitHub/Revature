import { Injectable } from '@angular/core';
import {InMemoryDbService} from 'angular-in-memory-web-api';
import {Tiger} from '../tiger';

//This file will take over the functionality of the mock-tigers.ts file.....
@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService
{

  constructor() { }

  createDb()
  {
    const tigers = 
    [
      {id: 11, name: 'Fluffy'},
      {id: 12, name: 'Spot'},
      {id: 13, name: 'Mr. Fluffy'},
      {id: 14, name: 'Mrs. Fluffy'},
      {id: 15, name: 'Finn'},
      {id: 16, name: 'Cassar'},
      {id: 17, name: 'Mr Fluff & Stuff'},
      {id: 18, name: 'Brutus'},
      {id: 19, name: 'Artemis'},
      {id: 20, name: 'Nico'}
    ];
    return {tigers};
  }

  //We are creating this method so taht a tiger always has an ID
  //IF the tigers array is empty, the method below, returns the initial number (11)
  //IF the tigers array is not empty, the method will return the highest id + 1
  genId(tigers: Tiger[]):number
  {
    //this is a ternary operaotr (a shorthand way of writign an if/else statement)
    return tigers.length>0? Math.max(...tigers.map(tiger => tiger.id)) + 1: 11;
  }
}
