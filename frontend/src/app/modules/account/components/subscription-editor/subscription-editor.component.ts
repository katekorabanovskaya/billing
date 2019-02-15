import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {Subscription} from "rxjs/internal/Subscription";

import {BsModalService} from "ngx-bootstrap";

import {CompanySubscription} from "../../../../model/company-subscription";
import {CompanySubscriptionService} from "../../../../services/company-subscription.service";
import {SubscriptionModalComponent} from "../subscription-modal/subscription-modal.component";
import {Company} from "../../../../model/company";

@Component({
  selector: 'app-subscription-editor',
  templateUrl: './subscription-editor.component.html',
  styleUrls: ['./subscription-editor.component.css']
})
export class SubscriptionEditorComponent implements OnInit, OnDestroy {

  public companySubscriptions: CompanySubscription[] = [];

  public isEditableMode: boolean = false;

  private subscriptions: Subscription[] = [];

  @Input()
  private company: Company;

  constructor(private modalService: BsModalService,
              private subscriptionService: CompanySubscriptionService) {
  }

  ngOnInit() {
    this.loadSubscriptions();
  }

  public openSubscriptionModal(companySubscription?: CompanySubscription): void {
    let subscription;

    if (companySubscription) {
      this.isEditableMode = true;
      subscription = CompanySubscription.cloneBase(companySubscription);
    }
    else {
      this.isEditableMode = false;
      subscription = new CompanySubscription();
    }

    const initialState = {
      company: this.company,
      currentSubscription: subscription,
      isEditableMode: this.isEditableMode,
    };
    this.modalService.show(SubscriptionModalComponent, {initialState})
  }

  public updateCompanySubscriptions(): void {
    this.loadSubscriptions();
  }

  private loadSubscriptions(): void {
    if(this.company) {
      this.subscriptions.push(
        this.subscriptionService.getCompanySubscriptionByUser(this.company.companyId).subscribe(subs => {
          this.companySubscriptions = subs as CompanySubscription[];
        })
      );
    }
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(
      subscription => subscription.unsubscribe()
    );
  }
}
