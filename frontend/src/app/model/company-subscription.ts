import {Company} from "./company";

export class CompanySubscription {

  subId: string;
  subName: string;
  subUrl: string;
  subPrice: number;
  subInformation: string;
  subMinAmountDays: number;
  company: Company;
  subImage: string;

  // category: Category;

  static cloneBase(subscription: CompanySubscription): CompanySubscription {
    let clonedSubscription = new CompanySubscription();
    clonedSubscription.subId = subscription.subId;
    clonedSubscription.subName = subscription.subName;
    clonedSubscription.subPrice = subscription.subPrice;
    clonedSubscription.subInformation = subscription.subInformation;
    clonedSubscription.subUrl = subscription.subUrl;
    clonedSubscription.subMinAmountDays = subscription.subMinAmountDays;
    clonedSubscription.company = Company.cloneBase(subscription.company);
    clonedSubscription.subImage = subscription.subImage;
    // clonedSubscription.category = Category.cloneBase(subscription.category);
    return clonedSubscription;
  }
}
