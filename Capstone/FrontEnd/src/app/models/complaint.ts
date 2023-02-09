import { Status } from "./status";
import { TypeOfProblem } from "./typeofproblem";
import { User } from "./user";

export class Complaint{
    customer:User | undefined | null;
    manager:User| undefined;
    engineer:User| undefined;

    status:Status| undefined;
    description:string| undefined;
    typeOfProblem:TypeOfProblem|undefined;
    feedback:string| undefined;

    constructor(customer?:User, 
        description?:string,
        typeOfProblem?:TypeOfProblem, 
        status?:Status,
        feedback?:string,
        engineer?:User, 
        manager?:User
        ){

            this.description=description;
            this.status=status;
            this.feedback=feedback;
            this.typeOfProblem=typeOfProblem;
            this.customer=customer;
            this.engineer=engineer;
            this.manager=manager;
    }




}