import {Component, OnDestroy, OnInit} from '@angular/core';
import {BsModalRef} from "ngx-bootstrap";
import {CompanySubscription} from "../../../../model/company-subscription";
import {CompanySubscriptionService} from "../../../../services/company-subscription.service";
import {Subscription} from "rxjs";
import {Company} from "../../../../model/company";

@Component({
  selector: 'app-subscription-modal',
  templateUrl: './subscription-modal.component.html',
  styleUrls: ['./subscription-modal.component.css']
})
export class SubscriptionModalComponent implements OnInit, OnDestroy {

  public currentSubscription: CompanySubscription; // in
  public isEditableMode: boolean; // in
  public company: Company; // in

  private subscriptions: Subscription[] = [];

  constructor(private modalRef: BsModalRef,
              private subscriptionService: CompanySubscriptionService) {
  }

  ngOnInit() {
  }

  public closeModal(): void {
    this.modalRef.hide();
  }

  public saveCompanySubscription(): void {
    this.currentSubscription.company = this.company;
    this.subscriptions.push(
      this.subscriptionService.saveCompanySubscription(this.currentSubscription).subscribe(() => {
        this.closeModal();
      })
    );
  }

  // public deleteCompanySubscription(companySubscriptionId: string): void {
  //   this.subscriptions.push(
  //     this.subscriptionService.deleteCompanySubscription(companySubscriptionId).subscribe(() => {
  //       this.closeModal();
  //     })
  //   );
  // }

  ngOnDestroy(): void {
    this.subscriptions.forEach(
      subscription => subscription.unsubscribe()
    );
  }
}
