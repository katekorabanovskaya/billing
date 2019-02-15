import {Component, Input, OnDestroy, OnInit, TemplateRef} from '@angular/core';
import {OrderStatus} from "../../../../model/enums/order-status";
import {Order} from "../../../../model/order";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs";
import {BillingAccount} from "../../../../model/billing-account";
import {BillingAccountService} from "../../../../services/billing-account.service";

@Component({
  selector: 'app-order-editor',
  templateUrl: './order-editor.component.html',
  styleUrls: ['./order-editor.component.css']
})
export class OrderEditorComponent implements OnInit, OnDestroy {

  public statuses: OrderStatus[] = [
    OrderStatus.ACTIVE,
    OrderStatus.SUSPENDED,
    OrderStatus.COMPLETED
  ];

  @Input()
  private billingAccounts: BillingAccount[];
  @Input()
  private accountId: string;

  public orders: Order[] = [];
  public statusOrders: Order[] = [];
  public currentOrder: Order = new Order();

  public modalRef: BsModalRef;

  private subscriptions: Subscription[] = [];

  constructor(private modalService: BsModalService,
              private baService: BillingAccountService) {
  }

  ngOnInit() {
    this.getOrders()
  }

  public closeModal(): void {
    this.modalRef.hide();
  }

  public openModal(template: TemplateRef<any>, order: Order): void {
    this.currentOrder = order;
    this.modalRef = this.modalService.show(template);
  }

  public setStatus(status: OrderStatus): void {
    this.statusOrders = [];
    this.orders.forEach(order => {
      if (order.orderStatus === status) {
        this.statusOrders.push(order);
      }
    });
  }

  public updateBillings(): void {
    this.loadBillings();
  }

  private getOrders(): void {
    this.orders = [];

    this.billingAccounts.forEach(ba => {
      ba.orders.forEach( order => {
        this.orders.push(order);
      })
    });

    this.setStatus(OrderStatus.ACTIVE);
  }

  private loadBillings() {
    this.subscriptions.push(
      this.baService.getBillingAccountByUser(this.accountId).subscribe(data => {
          this.billingAccounts = data as BillingAccount[];
          this.getOrders();
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
