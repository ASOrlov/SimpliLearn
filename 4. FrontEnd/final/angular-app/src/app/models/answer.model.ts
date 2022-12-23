import { Deserializable } from "./deserializable.model";

export class Answer implements Deserializable{

    questionText:string|undefined;
    answerText:string|undefined;
    isCorrect:boolean|undefined;

    deserialize(input: any) {
        Object.assign(this, input);
        return this;
      }
    constructor(questionText?:string, answerText?:string, isCorrect?:boolean){
        this.questionText=questionText;
        this.answerText=answerText;
        this.isCorrect=isCorrect;
    }

}