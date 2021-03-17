import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent 
{
  //This class uses a component Directive to specify that it's a building block
  //the component.ts file stores properties, functions and metadata
  title = 'The Ultimate Tiger Application';
}
