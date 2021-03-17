import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoggerService {

  constructor() { }

  log(msg:any)
  {
    console.log(msg);
  }

  error(error:any)
  {
    console.log(error);
  }
  
  warn(warn:any)
  {
    console.log(warn);
  }
}
