import {OrderStatus} from "./enums/order-status";
import {CompanySubscription} from "./company-subscription";

export class Order {

  orderId: string;
  orderStatus: OrderStatus;
  orderPriceInDay: number;
  orderStartDate: Date;
  orderEndDate: Date;
  subscription: CompanySubscription;
  billingAccountId: string;

}
