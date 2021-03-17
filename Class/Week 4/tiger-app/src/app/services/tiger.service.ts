import { Injectable } from '@angular/core';
import { TIGERS } from '../mock-tigers';
import {Tiger} from '../tiger';
import {Observable, of} from 'rxjs';
import { LoggerService } from './logger.service';
import { MessageService } from './message.service';

@Injectable({
  providedIn: 'root'
})
export class TigerService {

  constructor(private logger: LoggerService, private messageService: MessageService) { }

getTigers():Observable<Tiger[]>
{
  const tigers = of(TIGERS); //what we pass to the 'of()' method is our data source.
  //we return an observable called tigers

  //lets log how many tigers we fecth (log the size of the array fetched)
  //subscribe takes a callback ..this is the function that we appley to the data we fetch from the observable
  tigers.subscribe(retrievedData=>
    {
      this.logger.log(`We returned ${retrievedData.length} tigers inside the TigerService.`);
    });

  this.messageService.add("In tiger service: tigers have been fetched...not easily!!");
  return tigers;
}

//this is the old synchronous way
  //getTigers(): Tiger[]
  //{
  //  return TIGERS;
  //}
}
