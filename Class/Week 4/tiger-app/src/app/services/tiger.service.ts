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


  //1. Create a save button in the html template tiger-detail component -- CHECK

  //2. Create a method in the tiger-detail.ts file which calls on an update method in the tiger-service

  

  //3. Create an update method in hte service
  /*PUT method to update a resource in DB*/
  updateTiger(tiger?: Tiger):Observable<any>
  {
    //We are updating our resource with the cat object we pass through
    return this.http.put(this.tigerUrl, tiger)
    .pipe
    (
      tap(_=>this.log(`updated tiger id=${tiger?.id}`)), //this is not totally necessary, but good for logging
      //prossing and error handling
      catchError(this.handleError<any>('updateTiger'))
    );
  }

  /**POST METHOD */
  addTiger(tiger:Tiger):Observable<any>
  {
    return this.http.post(this.tigerUrl, tiger)
    .pipe
    (
      tap(_=>this.log(`added tiger id=${tiger.id}`)), //this is not totally necessary, but good for logging
      //prossing and error handling
      catchError(this.handleError<any>('addTiger'))
    );
  }

  /**DELETE METHOD */
  deleteTiger(tiger:Tiger | number):Observable<Tiger>
  //were checking 'did we pass in a number (id) or a tiger?'
  {
    const id = (typeof tiger ==='number') ? tiger : tiger.id;

    const url = `${this.tigerUrl}/${id}`;

    return this.http.delete<Tiger>(url)
    .pipe
    (
      tap(_=>this.log(`deleted tiger id=${id}`)), //this is not totally necessary, but good for logging
      //prossing and error handling
      catchError(this.handleError<any>('addTiger'))
    );;
  }

  /*
  SEARCH TIGERS! --> GET tigers whose name contains search terms
  */

  searchTigers(term:string):Observable<Tiger[]>
  {
    //if no serach term exists, we send back an empty array
    if(!term.trim()){return of([]);}

    return this.http.get<Tiger[]>(`${this.tigerUrl}/?name=${term}`);
  }

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
