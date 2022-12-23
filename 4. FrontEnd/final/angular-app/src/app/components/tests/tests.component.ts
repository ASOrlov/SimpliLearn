import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ComponentExchangeService } from 'src/app/services/component-exchange.service';
import { RecieveTestService } from 'src/app/services/recieve-test.service';

@Component({
  selector: 'tests',
  templateUrl: './tests.component.html',
  styleUrls: ['./tests.component.css']
})
export class TestsComponent{


constructor(private recieveTestService:RecieveTestService
  ,private router: Router
  ,private componentExchangeService:ComponentExchangeService
  ){

}

onSubmit():void{
  {
    this.recieveTestService.getQuestions().subscribe((data)=>{
      this.componentExchangeService.setCurrentTest(data);
      this.router.navigateByUrl('question');
    })

  }

}


}
