import { Role } from "./role";

export class User{
    
    id:number|undefined;

    login:string|undefined;
    password:string|undefined;
    role:Role|undefined;

    name:string|undefined;
    address:string|undefined;
    pinCode:string|undefined;

    phoneNumber:string|undefined;
    token: string|undefined;

    constructor(
        id?:number,
        login?:string,
        password?:string,
        role?:Role,
        name?:string,
        address?:string, 
        pinCode?:string,
        phoneNumber?:string,
        token?:string){

            this.id=id;
            this.login=login;
            this.password=password;
            this.role=role;
            this.name=name;
            this.address=address;
            this.pinCode=pinCode;
            this.phoneNumber=phoneNumber;
            this.token=token;
            

    }

}