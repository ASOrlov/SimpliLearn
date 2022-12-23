import { AnswerOption } from "./answer-option.model";
import {Deserializable} from "./deserializable.model";

export class Question implements Deserializable {
    textOfQuestion: string | undefined;
    answerOptions: AnswerOption[] | undefined;

    deserialize(input: any) {
        Object.assign(this, input);
        this.answerOptions = input.answerOptions.map((answerOption: any) => new AnswerOption().deserialize(answerOption));
        return this;
      }
    
    constructor (textOfQuestion?: string, answerOptions?: AnswerOption[]) {
        this.textOfQuestion = textOfQuestion;
        this.answerOptions = answerOptions;
    }
}