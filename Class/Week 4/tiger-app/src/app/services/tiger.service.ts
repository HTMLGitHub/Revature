import { Injectable } from '@angular/core';
import { TIGERS } from '../mock-tigers';
import {Tiger} from '../tiger';
import {Observable, of} from 'rxjs';
import { LoggerService } from './logger.service';
import { MessageService } from './message.service';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import{catchError, map, refCount, tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TigerService
{

  //we are deinding a tigersUrl isn th eform of ':base/:colletionName'
  private tigerUrl = 'api/tigers'; //URL to web api

  constructor(
    private logger: LoggerService, 
    private messageService: MessageService,
    private http: HttpClient) { }
  
  private log(message:string)
  {
    this.messageService.add(`Tiger Service: ${message}`);
  }


  getTigers():Observable<Tiger[]>
  {
    return this.http.get<Tiger[]>(this.tigerUrl)
    .pipe
      (
        //tap allow us to DO something with the values we recieve withour changing them
        tap(_=>this.log(`fetched tigers!`)),
        catchError(this.handleError<Tiger[]>('getTigers', []))
      );

    //this is th e old say before HTTP
    /* const tigers = of(TIGERS); //what we pass to the 'of()' method is our data source.
    //we return an observable called tigers

    //lets log how many tigers we fecth (log the size of the array fetched)
    //subscribe takes a callback ..this is the function that we appley to the data we fetch from the observable
    tigers.subscribe(retrievedData=>
      {
        this.logger.log(`We returned ${retrievedData.length} tigers inside the TigerService.`);
      });

    this.messageService.add("In tiger service: tigers have been fetched...not easily!!");
    return tigers; */
  }

  //get Tiger by ID!! Were tackling a TODO

  /* GET a cat by its id. Will return a 404 if not found*/
  getTiger(id: number): Observable<Tiger>
  {
    //grab the entire collection of TIgers...then add a '/' adn the id of the cat was passed in
    const specificUrl = `${this.tigerUrl}/${id}`;
    return this.http.get<Tiger>(specificUrl)
    .pipe
    (
      tap(_=>this.log(`fetched tiger with id: ${id}`)), 
      catchError(this.handleError<Tiger>(`getTiger id=${id}`))
    )
  }
  //TODO: transform this to a method that utilizes  HTTPCLIENT services
  /* getTiger(id: number):Observable<Tiger|undefined>
  {
    this.messageService.add(`TigerService: fetched tiger with id: ${id}`);
    return of(TIGERS.find(tiger => tiger.id ===id));
  } */
/**
 * Handle an HTTP operation that fails with a customer error handler
 * @param operation - name of the operation that fails
 * @param result - optional value tha is returned as the OBSERVABLE result
 */
  private handleError<T>(operation = 'operation', result?: T)
  {
    return (error: any):Observable<T> =>
    {
      //TODO: send the error to a remote logging infrastructure
      this.logger.error(`WE ENCOUNTERED AN ERROR IN ${operation}`);
      console.error(error) //we'll just log to the console

      //TODO: better job of transformigng error for user consumption
      this.log(`${operation} failed: ${error.message}`);
      
      //we want to ensure that the app keeps reunning by ruturnign an empty result 
      return of(result as T);
    }
  }
}
