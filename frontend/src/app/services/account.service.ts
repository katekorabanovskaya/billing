import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Account} from "../model/account";

@Injectable({
  providedIn: 'root'
})
export class AccountService {
  private url: string = '/api/accounts';

  constructor(private http: HttpClient) {
  }

  getAllAccounts(): Observable<Account[]> {
    return this.http.get<Account[]>(this.url);
  }

  getAccountByLogin(accountLogin: string): Observable<Account> {
    return this.http.get<Account>(this.url + '/login/' + accountLogin);
  }

  saveAccount(account: Account): Observable<Account> {
    return this.http.post<Account>(this.url + '/registration', account);
  }

  deleteAccount(accountId: string): Observable<void> {
    return this.http.delete<void>(this.url + '/' + accountId);
  }
}
