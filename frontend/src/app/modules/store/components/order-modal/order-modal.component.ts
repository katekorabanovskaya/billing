import {Component, OnDestroy, OnInit} from '@angular/core';
import {Order} from "../../../../model/order";
import {BillingAccount} from "../../../../model/billing-account";
import {CompanySubscription} from "../../../../model/company-subscription";
import {Subscription} from "rxjs";
import {OrderService} from "../../../../services/order.service";
import {BsModalRef} from "ngx-bootstrap";

@Component({
  selector: 'app-order-modal',
  templateUrl: './order-modal.component.html',
  styleUrls: ['./order-modal.component.css']
})
export class OrderModalComponent implements OnInit, OnDestroy {

  public currentSubscription: CompanySubscription; // in

  public order: Order = new Order();
  public billingAccounts: BillingAccount[]; // in
  public currentBillingAccount: BillingAccount;

  public today: Date;

  public minStartDate: Date;

  private subscriptions: Subscription[] = [];
  private dayInMillisec: number = 1000 * 24 * 60 * 60;
  constructor(
    private orderService: OrderService,
    public modalRef: BsModalRef
  ) {
  }

  ngOnInit() {
    this.currentBillingAccount = this.billingAccounts.length > 0 ? this.billingAccounts[0] : undefined;

    this.order.subscription = this.currentSubscription;
    this.minStartDate = new Date(new Date().valueOf() +
      this.dayInMillisec * this.order.subscription.subMinAmountDays);

    this.order.orderEndDate = new Date(this.minStartDate.valueOf());
    this.today = new Date();
  }

  public closeModal(): void {
    this.modalRef.hide();
  }

  public subscribe(): void {
    if (this.currentBillingAccount) {
      this.order.billingAccountId = this.currentBillingAccount.baId;

      this.subscriptions.push(
        this.orderService.saveOrder(this.order).subscribe(() => {
          this.closeModal();
          alert('Success');
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
