import { Status } from "../models/status";

export const environment = {
    production: false,
    apiUrl: 'http://localhost:8081'
};

export const statusRaised = new Status(1,"Raised");
export const statusAssigned = new Status(2,"Assigned");
export const engineerAccesseableStatusesId:number[]=[3,4,5];

export const administratorRole:string='ADMINISTRATOR';
export const managerRole:string='MANAGER';
export const customerRole:string='CUSTOMER';
export const engineerRole:string='ENGINEER';