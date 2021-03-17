/**
 * What are interfaces in typescript?
 * Think of the role of Classes in Java. We are defining a custom type of Object
 * We use interfaces in TS to define the TYPES of properties that a particular object can have
 * we use interfaces to define the "shape" of an object
 * 
 */

import { TigerDetailComponent } from "./tiger-detail/tiger-detail.component"

//We are defining a custom 'Type'
export interface Tiger
{
    id: number;
    name: string;
}

