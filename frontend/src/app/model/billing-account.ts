import {Order} from "./order";

export class BillingAccount {
  baId: string;
  baNumber: string;
  accountId: string;
  orders: Order[];
  baAccount: number;
}
