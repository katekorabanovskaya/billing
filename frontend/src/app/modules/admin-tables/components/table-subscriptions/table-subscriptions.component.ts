import {Component, OnDestroy, OnInit} from '@angular/core';
import {CompanySubscription} from "../../../../model/company-subscription";
import {Subscription} from "rxjs";
import {CompanySubscriptionService} from "../../../../services/company-subscription.service";

@Component({
  selector: 'app-table-subscriptions',
  templateUrl: './table-subscriptions.component.html',
  styleUrls: ['./table-subscriptions.component.css']
})
export class TableSubscriptionsComponent implements OnInit, OnDestroy {

  public companySubscriptions: CompanySubscription[] = [];

  public currentSubscription: CompanySubscription = new CompanySubscription();

  private subscriptions: Subscription[] = [];

  constructor(private companySubscriptionService: CompanySubscriptionService) {
  }

  ngOnInit() {
    this.loadSubscriptions();
  }

  public updateSubscription(): void {
    this.loadSubscriptions();
  }

  public deleteSubscription(subId: string): void {
    this.subscriptions.push(
      this.companySubscriptionService.deleteCompanySubscription(subId).subscribe(() => {
        this.updateSubscription();
      })
    );
    this.refreshSubscription();
  }

  private refreshSubscription() {
    this.currentSubscription = new CompanySubscription();
  }


  private loadSubscriptions(): void {
    this.subscriptions.push(
      this.companySubscriptionService.getAllCompanySubscriptions().subscribe(subs => {
        this.companySubscriptions = subs as CompanySubscription[];
      })
    )
  }

  ngOnDestroy() {
    this.subscriptions.forEach(
      subscription => subscription.unsubscribe()
    );
  }
}
