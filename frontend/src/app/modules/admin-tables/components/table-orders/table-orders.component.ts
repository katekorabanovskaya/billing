import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";

import {Order} from "../../../../model/order";
import {OrderService} from "../../../../services/order.service";
import {OrderStatus} from "../../../../model/enums/order-status";

@Component({
  selector: 'app-table-orders',
  templateUrl: './table-orders.component.html',
  styleUrls: ['./table-orders.component.css']
})
export class TableOrdersComponent implements OnInit, OnDestroy {

  public orders: Order[] = [];
  public currentOrder: Order = new Order();

  private subscriptions: Subscription[] = [];

  constructor(private orderService: OrderService) {
  }

  ngOnInit() {
    this.loadOrders();
  }

  public updateOrders(): void {
    this.loadOrders();
  }

  public suspendOrder(order: Order): void {
    if (order.orderStatus == OrderStatus.ACTIVE) {
      //TODO: cloneBase
      order.orderStatus = OrderStatus.SUSPENDED;

      this.subscriptions.push(
        this.orderService.saveOrder(order).subscribe(data => {
          this.loadOrders();
        })
      )
    }
  }

  private loadOrders(): void {
    this.subscriptions.push(
      this.orderService.getAllOrders().subscribe(orders => {
        this.orders = orders as Order[];
      })
    );
  }

  ngOnDestroy() {
    this.subscriptions.forEach(
      subscription => subscription.unsubscribe()
    );
  }
}
