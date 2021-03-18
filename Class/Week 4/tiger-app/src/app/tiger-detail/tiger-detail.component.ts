import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TigerService } from '../services/tiger.service';
import { Tiger } from "../tiger";
import {Location} from "@angular/common";

@Component({
  selector: 'app-tiger-detail',
  templateUrl: './tiger-detail.component.html',
  styleUrls: ['./tiger-detail.component.css']
})
export class TigerDetailComponent implements OnInit
{

  //we use the '@Input' decorator to specity that this particular property
  //can be input from another source
  
  //we use the '@Input' decorator to specity that this particular property
  //can be input from another source
  tiger?: Tiger;
  //the '?' her represents a safe navigation operator

  tigers: Tiger[] = [];
  constructor(private tigerService: TigerService, private route: ActivatedRoute, private location: Location) { }

  ngOnInit(): void 
  {
    //when the component  is initialized, well need ot set the cat property
    this.getTiger();
  }

  //this method will extract the cat by grabbing the id from the parameter
  //then calling the tigerService and finding that tiger witin  the mock DB

  //must make sure that the service method is the service method is running type <any>
  getTiger():void
  {
    //we must extract the id from the paremter of the route i.e. "detail/':id'"
    
    const id = Number(this.route.snapshot.paramMap.get('id'));

    this.tigerService.getTiger(id).subscribe(tiger => this.tiger = tiger);
  }

  /**
   * save() method which calls on an updateTiger method in the service (we will then build the updateTiger method in hte service)
   */

  save(): void
  {
    this.tigerService.updateTiger(this.tiger).subscribe(()=>this.goBack());
  }

  goBack(): void
  {
    this.location.back();
  }
  
  xingGetTiger(): void
  {
    this.route.params.subscribe(params => 
      {
        console.log(params);

        let id: string = params.id;

        //all cat
        this.tigerService.getTigers().subscribe(data=>
          {
            this.tigers= data;

            for(let i: number = 0; i <this.tigers.length; i++)
            {
              if(this.tigers[i].id == Number(id))
              {
                this.tiger = this.tigers[i];
              }
            }
          })
      })
  }

}
