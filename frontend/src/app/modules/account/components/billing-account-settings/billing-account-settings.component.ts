import {Component, Input, OnDestroy, OnInit, TemplateRef} from '@angular/core';
import {BillingAccount} from "../../../../model/billing-account";
import {BillingAccountService} from "../../../../services/billing-account.service";
import {Subscription} from "rxjs";
import {BsModalRef, BsModalService} from "ngx-bootstrap";

@Component({
  selector: 'app-billing-account-settings',
  templateUrl: './billing-account-settings.component.html',
  styleUrls: ['./billing-account-settings.component.css']
})
export class BillingAccountSettingsComponent implements OnInit, OnDestroy {

  @Input()
  public billingAccounts: BillingAccount[];

  public account: string = '';
  public topUpSum: number = 0;
  public baNumber: string = '';

  private subscriptions: Subscription[] = [];

  @Input()
  private accountId: string;
  private modalRef: BsModalRef;

  constructor(private billingAccountService: BillingAccountService,
              private modalService: BsModalService) {
  }

  ngOnInit() {

  }


  public getAccount(ba: BillingAccount): void {
    this.account = ba.baAccount + '';
  }

  public topUp(): void {
    //TODO:
  }

  public updateBillings(): void {
    this.loadBillings();
  }

  public openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
  }

  public closeModal(): void {
    this.modalRef.hide();
    this.updateBillings();
  }

  public createBilling(): void {
    let ba: BillingAccount = new BillingAccount();
    ba.accountId = this.accountId;
    ba.baNumber = this.baNumber;

    this.subscriptions.push(
      this.billingAccountService.saveBillingAccount(ba).subscribe(data => {
          this.billingAccounts.push(data);
          this.closeModal();
        },
        error1 => {
          alert('error');
          console.log(error1);
          this.closeModal();
        })
    );
  }

  private loadBillings(): void {
    this.subscriptions.push(
      this.billingAccountService.getBillingAccountByUser(this.accountId).subscribe(data => {
          this.billingAccounts = data as BillingAccount[];
        },
        error1 => {
          console.log(error1);
        })
    );
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(
      subscription => subscription.unsubscribe()
    );
  }
}
