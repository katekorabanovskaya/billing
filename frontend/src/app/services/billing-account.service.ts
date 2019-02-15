import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {BillingAccount} from "../model/billing-account";

@Injectable({
  providedIn: 'root'
})
export class BillingAccountService {

  private url: string = 'api/billing-accounts';

  constructor(private http: HttpClient) {
  }

  getAllBillingAccounts(): Observable<BillingAccount[]> {
    return this.http.get<BillingAccount[]>(this.url);
  }

  getBillingAccount(accountId: string): Observable<BillingAccount> {
    return this.http.get<BillingAccount>(this.url + '/' + accountId);
  }

  saveBillingAccount(account: BillingAccount): Observable<BillingAccount> {
    return this.http.post<BillingAccount>(this.url, account);
  }

  deleteBillingAccount(accountId: string): Observable<void> {
    return this.http.delete<void>(this.url + '/' + accountId);
  }

  getBillingAccountByUser(userId: string): Observable<BillingAccount[]> {
    return this.http.get<BillingAccount[]>(this.url + '/user/' + userId);
  }
}
