import { TigerService } from '../services/tiger.service';
import { Tiger } from "../tiger";
import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-tiger-search',
  templateUrl: './tiger-search.component.html',
  styleUrls: ['./tiger-search.component.css']
})
export class TigerSearchComponent implements OnInit {

  tigers$?: Observable<Tiger[]>
  private searchTerms = new Subject<string>();
  //A 'Subject' from RXJS --> it is both a source of observable values and an obersvable itself
  //you can subscribe to a Subject


  constructor(private tigerService: TigerService) { }

  ngOnInit(): void 
  {
    //1. set 'tigers$' observable equal to our search terms
    this.tigers$ = this.searchTerms
    .pipe
    (
      //wait 300 ms after each keystroke before considering the term
      debounceTime(300),
      //this method ignores a term if it's the SAME as our previously entered term
      distinctUntilChanged(),
      //switch to a new search obsrvable each time teh term changes
      switchMap((term:string)=>this.tigerService.searchTigers(term))
    );
  }

  search(term:string): void
  {
    this.searchTerms.next(term);

  }
  

}
