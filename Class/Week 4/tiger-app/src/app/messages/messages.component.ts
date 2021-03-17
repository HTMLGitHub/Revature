import { Component, OnInit } from '@angular/core';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

//we are making this service public because we will bind it to the template (html page...aka skeleton)
constructor(public messageService: MessageService) { }

  ngOnInit(): void 
  {
  }

  

}
