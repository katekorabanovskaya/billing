import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {CompanySubscription} from "../../../../model/company-subscription";

@Component({
  selector: 'app-subscription-form',
  templateUrl: './subscription-form.component.html',
  styleUrls: ['./subscription-form.component.css']
})
export class SubscriptionFormComponent implements OnInit {

  @Input()
  public subscription: CompanySubscription;

  constructor() { }

  ngOnInit() {
  }

  @Output() onClickDetails: EventEmitter<void> = new EventEmitter();

   clickDetails(): void {
     this.onClickDetails.emit();
   }

}
