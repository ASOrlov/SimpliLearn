import { Deserializable } from "./deserializable.model";

export class AnswerOption implements Deserializable{
    textOfAnswer:string|undefined;
    isCorrect:boolean|undefined;


    deserialize(input: any) {
        Object.assign(this, input);
        return this;
      }


    constructor(textOfAnswer?:string, isCorrect?:boolean){
        this.textOfAnswer=textOfAnswer;
        this.isCorrect=isCorrect; 
    }

}