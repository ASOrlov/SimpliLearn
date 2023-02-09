//cannot make a call, but receive a call or can make calls, but cannot receive calls, or neither make nor receive calls

export class TypeOfProblem{
    id:number | undefined;
    name:string| undefined;
    fullname:string|undefined;

    constructor(id:number,name:string, fullname:string){
        this.id=id;
        this.name=name;
        this.fullname=fullname;
    }
}