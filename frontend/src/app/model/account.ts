import {BillingAccount} from "./billing-account";
import {Company} from "./company";
import {User} from "./user";

export class Account {
  accountId: string;
  username: string;
  lastName: string;
  firstName: string;
  birthdayDate: Date;
  registrationDate: string;
  user: User;
  company: Company;
  billingAccounts: BillingAccount[];
}
